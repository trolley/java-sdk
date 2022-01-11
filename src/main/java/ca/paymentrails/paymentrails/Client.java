package ca.paymentrails.paymentrails;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.UnexpectedException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import ca.paymentrails.Exceptions.*;

public class Client {

    private Configuration config;

    public Client(Configuration config) {
        this.config = config;
    }

    /**
     * Factory Method to create an instance of Client
     *
     * @return Client
     */
    public static Client create(Configuration config) {
        return new Client(config);
    }

    private String sendRequest(String method, String endPoint, String body) throws Exception {
        String StringResponse = "";
        HttpURLConnection con;
        try {
            String url = this.config.getApiBase() + endPoint;
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();

            int timeStamp = (int) (System.currentTimeMillis() / 1000L);
            String authorizarion = generateAuthorization(timeStamp, method, endPoint, body);

            con.setRequestMethod(method);

            con.setRequestProperty("X-PR-Timestamp", timeStamp + "");
            con.setRequestProperty("Authorization", authorizarion);
            con.setRequestProperty("Content-Type", "application/json");
            if (method == "POST" && body != "") {

                con.setDoOutput(true);
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.writeBytes(body);
                    wr.flush();
                }
            }
            int responseCode = con.getResponseCode();

            if (responseCode != 200) {
                throwStatusCodeException(responseCode, con.getResponseMessage());
            }
            StringBuffer response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                StringResponse = response.toString();
            } catch (IOException e) {
                throw new UnexpectedException(StringResponse);
            }

        } catch (IOException e) {
            throw new UnexpectedException(StringResponse);
        }
        return StringResponse;
    }

    private String sendRequest(String method, String endPoint) throws Exception {
        return sendRequest(method, endPoint, "");
    }

    /**
     * Makes an HTTP GET request to the API
     *
     * @param endPoint
     * @return The response
     * @throws Exception
     */
    public String get(String endPoint) throws Exception {
        return sendRequest("GET", endPoint);
    }

    /**
     * Makes an HTTP POST request to the API
     *
     * @param endPoint
     * @param body
     * @return The response
     * @throws Exception
     */
    public String post(String endPoint, String body) throws Exception {
        return sendRequest("POST", endPoint, body);
    }

    // public String post(String endPoint, Object body) throws Exception {
    //     String result = new ObjectMapper().writeValueAsString(body);

    //     return sendRequest("POST", endPoint, result);
    // }

    /**
     * Makes an HTTP POST request to the API
     *
     * @param endPoint
     * @return The response
     * @throws Exception
     */
    public String post(String endPoint) throws Exception {
        return sendRequest("POST", endPoint);
    }
    /**
     * Makes an HTTP PATCH request to the API
     *
     * @param endPoint
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public String patch(String endPoint, String body) throws Exception {
        String StringResponse = "";
        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpPatch httpPatch = new HttpPatch(this.config.getApiBase() + endPoint);
            StringEntity params = new StringEntity(body);

            int timeStamp = (int) (System.currentTimeMillis() / 1000L);
            String authorizarion = generateAuthorization(timeStamp, "PATCH", endPoint, body);

            params.setContentType("application/json");

            httpPatch.setEntity(params);
            httpPatch.addHeader("X-PR-Timestamp", timeStamp + "");
            httpPatch.addHeader("Authorization", authorizarion);

            HttpResponse response = httpclient.execute(httpPatch);
            StringBuffer result = new StringBuffer();
            String line = "";

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            StringResponse = result.toString();

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200) {
                throwStatusCodeException(responseCode, StringResponse);
            }

        } catch (IOException e) {
            throw new UnexpectedException(StringResponse);
        }
        return StringResponse;
    }

    /**
     * Makes an HTTP DELETE request to the API
     *
     * @param endPoint
     * @return The response
     * @throws InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public String delete(String endPoint) throws Exception {
        return sendRequest("DELETE", endPoint);
    }

    private void throwStatusCodeException(int statusCode, String message) throws Exception {
        switch (statusCode) {
        case 400:
            throw new MalformedException(message);
        case 401:
            throw new AuthenticationException(message);
        case 403:
            throw new AuthorizationException(message);
        case 404:
            throw new NotFoundException(statusCode + " " + message);
        case 406:
            throw new InvalidStatusCodeException(message);
        case 429:
            throw new TooManyRequestsException(message);
        case 500:
            throw new InvalidServerConnectionException(message);
        case 503:
            throw new DownForMaintenanceException(message);
        default:
            throw new ca.paymentrails.Exceptions.UnexpectedException(message);
        }
    }

    private String generateAuthorization(int timeStamp, String method, String endPoint, String body) {
        String message = timeStamp + "\n" + method + "\n" + endPoint + "\n" + body + "\n";
        try {
            String hash = hmacDigest(message, this.config.getPrivateKey(), "HmacSHA256");
            return "prsign " + this.config.getPublicKey() + ":" + hash;
        } catch (Exception e) {
            return "prsign 1:1";
        }

    }

    private String hmacDigest(String msg, String keyString, String algo) throws Exception {
        String digest = null;
        SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
        Mac mac = Mac.getInstance(algo);
        mac.init(key);

        byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

        StringBuffer hash = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
        digest = hash.toString();
        return digest;
    }
}
