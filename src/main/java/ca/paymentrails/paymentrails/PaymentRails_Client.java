package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Jesse
 */
public class PaymentRails_Client {

    private String apiKey = "";
    private String apiBase = "";

    public PaymentRails_Client(String apiKey) {
        this.apiKey = apiKey;
        this.apiBase = PaymentRails_Configuration.getApiBase();
    }

    /**
     * Factory Method to create an instance of PaymentRails_Client
     *
     * @return PaymentRails_Client
     */
    public static PaymentRails_Client create() {
        return new PaymentRails_Client(PaymentRails_Configuration.getApiKey());
    }

    /**
     * Makes an HTTP GET request to the API
     *
     * @param endPoint
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public String get(String endPoint) throws InvalidStatusCodeException, InvalidConnectionException {
        String StringResponse = "";
        try {
            String url = apiBase + endPoint;

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("x-api-key", apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            int responseCode = con.getResponseCode();

            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            StringResponse = response.toString();
            if (responseCode != 200) {
                throw new InvalidStatusCodeException(StringResponse);
            }

        } catch (InvalidStatusCodeException e) {
            throw new InvalidStatusCodeException(StringResponse);
        }catch (IOException e){
            throw new InvalidConnectionException("Failed to connect to " + apiBase);
        }
        return StringResponse;
    }

    /**
     * Makes an HTTP POST request to the API
     *
     * @param endPoint
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public String post(String endPoint, String body) throws InvalidStatusCodeException, InvalidConnectionException {
        String StringResponse = "";
        try {
            String url = apiBase + endPoint;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("x-api-key", apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Send post request
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(body);
                wr.flush();
            }

            int responseCode = con.getResponseCode();

            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            StringResponse = response.toString();
            if (responseCode != 200) {
                throw new InvalidStatusCodeException(StringResponse);
            }

        } catch (InvalidStatusCodeException e) {
            throw new InvalidStatusCodeException(StringResponse);
        }catch (IOException e){
            throw new InvalidConnectionException("Failed to connect to " + apiBase);
        }
        
        return StringResponse;
    }

    /**
     * Makes an HTTP POST request to the API
     *
     * @param endPoint
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public String post(String endPoint) throws InvalidStatusCodeException, InvalidConnectionException {
        String StringResponse = "";
        try {
            String url = apiBase + endPoint;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("x-api-key", apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            int responseCode = con.getResponseCode();

            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            StringResponse = response.toString();
            if (responseCode != 200) {
                throw new InvalidStatusCodeException(StringResponse);
            }

        } catch (InvalidStatusCodeException e) {
            throw new InvalidStatusCodeException(StringResponse);
        }catch (IOException e){
            throw new InvalidConnectionException("Failed to connect to " + apiBase);
        }
        return StringResponse;
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
    public String patch(String endPoint, String body) throws InvalidStatusCodeException, InvalidConnectionException, InvalidConnectionException {
        String StringResponse = "";
        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpPatch httpPatch = new HttpPatch(apiBase + endPoint);
            StringEntity params = new StringEntity(body);
            params.setContentType("application/json");

            httpPatch.setEntity(params);
            httpPatch.addHeader("x-api-key", apiKey);

            HttpResponse response = httpclient.execute(httpPatch);
            StringBuffer result = new StringBuffer();
            String line = "";

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            StringResponse = result.toString();
            String resultCode = StringResponse.substring(6, 10);
            if (!resultCode.equals("true")) {
                throw new InvalidStatusCodeException(StringResponse);
            }

        } catch (InvalidStatusCodeException e) {
            throw new InvalidStatusCodeException(StringResponse);
        }catch (IOException e){
            throw new InvalidConnectionException("Failed to connect to " + apiBase);
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
    public String delete(String endPoint) throws InvalidStatusCodeException, InvalidConnectionException {
        String StringResponse = "";
        try {
            String url = apiBase + endPoint;

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("DELETE");

            //add request header
            con.setRequestProperty("x-api-key", apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            int responseCode = con.getResponseCode();
            //check response code

            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            StringResponse = response.toString();
            if (responseCode != 200) {
                throw new InvalidStatusCodeException(StringResponse);
            }

        } catch (InvalidStatusCodeException e) {
            throw new InvalidStatusCodeException(StringResponse);
        }catch (IOException e){
            throw new InvalidConnectionException("Failed to connect to " + apiBase);
        }
        return StringResponse;
    }

}
