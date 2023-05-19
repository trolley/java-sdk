package com.trolley.trolley;

import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.trolley.Exceptions.DownForMaintenanceException;
import com.trolley.Exceptions.InvalidServerConnectionException;
import com.trolley.Exceptions.TooManyRequestsException;
import com.trolley.Exceptions.InvalidStatusCodeException;
import com.trolley.Exceptions.NotFoundException;
import com.trolley.Exceptions.AuthorizationException;
import com.trolley.Exceptions.AuthenticationException;
import com.trolley.Exceptions.MalformedException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client
{
    private Configuration config;
    private String trolleySourceString = "java-sdk_"+Version.MAJOR+"."+Version.MINOR+"."+Version.PATCH;
    
    public Client(final Configuration config) {
        this.config = config;
    }
    
    public static Client create(final Configuration config) {
        return new Client(config);
    }
    
    private String sendRequest(final String method, final String endPoint, final String body) throws Exception {
        String StringResponse = "";
        try {
            final String url = this.config.getApiBase() + endPoint;
            final URL obj = new URL(url);
            final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            final int timeStamp = (int)(System.currentTimeMillis() / 1000L);
            final String authorizarion = this.generateAuthorization(timeStamp, method, endPoint, body);
            con.setRequestMethod(method);
            con.setRequestProperty("X-PR-Timestamp", timeStamp + "");
            con.setRequestProperty("Authorization", authorizarion);
            con.setRequestProperty("Trolley-Source", trolleySourceString);
            con.setRequestProperty("Content-Type", "application/json");
            if (method == "POST" && body != "") {
                con.setDoOutput(true);
                final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                try {
                    wr.writeBytes(body);
                    wr.flush();
                    wr.close();
                }
                catch (Throwable t) {
                    try {
                        wr.close();
                    }
                    catch (Throwable exception) {
                        t.addSuppressed(exception);
                    }
                    throw t;
                }
            }
            final int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                this.throwStatusCodeException(responseCode, con.getResponseMessage());
            }
            try {
                final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                try {
                    final StringBuffer response = new StringBuffer();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    StringResponse = response.toString();
                    in.close();
                }
                catch (Throwable t2) {
                    try {
                        in.close();
                    }
                    catch (Throwable exception2) {
                        t2.addSuppressed(exception2);
                    }
                    throw t2;
                }
            }
            catch (IOException e) {
                throw new UnexpectedException(StringResponse);
            }
        }
        catch (IOException e2) {
            throw new UnexpectedException(StringResponse);
        }
        return StringResponse;
    }
    
    private String sendRequest(final String method, final String endPoint) throws Exception {
        return this.sendRequest(method, endPoint, "");
    }
    
    public String get(final String endPoint) throws Exception {
        return this.sendRequest("GET", endPoint);
    }
    
    public String post(final String endPoint, final String body) throws Exception {
        return this.sendRequest("POST", endPoint, body);
    }
    
    public String post(final String endPoint) throws Exception {
        return this.sendRequest("POST", endPoint);
    }
    
    public String patch(final String endPoint, final String body) throws Exception {
        String StringResponse = "";
        try {
            final HttpClient httpclient = (HttpClient)HttpClients.createDefault();
            final HttpPatch httpPatch = new HttpPatch(this.config.getApiBase() + endPoint);
            final StringEntity params = new StringEntity(body);
            final int timeStamp = (int)(System.currentTimeMillis() / 1000L);
            final String authorizarion = this.generateAuthorization(timeStamp, "PATCH", endPoint, body);
            params.setContentType("application/json");
            httpPatch.setEntity((HttpEntity)params);
            httpPatch.addHeader("X-PR-Timestamp", timeStamp + "");
            httpPatch.addHeader("Authorization", authorizarion);
            httpPatch.addHeader("Trolley-Source", trolleySourceString);
            final HttpResponse response = httpclient.execute((HttpUriRequest)httpPatch);
            final StringBuffer result = new StringBuffer();
            String line = "";
            final BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            StringResponse = result.toString();
            final int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200) {
                this.throwStatusCodeException(responseCode, StringResponse);
            }
        }
        catch (IOException e) {
            throw new UnexpectedException(StringResponse);
        }
        return StringResponse;
    }
    
    public String delete(final String endPoint) throws Exception {
        return this.sendRequest("DELETE", endPoint);
    }
    
    private void throwStatusCodeException(final int statusCode, final String message) throws Exception {
        switch (statusCode) {
            case 400: {
                throw new MalformedException(message);
            }
            case 401: {
                throw new AuthenticationException(message);
            }
            case 403: {
                throw new AuthorizationException(message);
            }
            case 404: {
                throw new NotFoundException(statusCode + " " + message);
            }
            case 406: {
                throw new InvalidStatusCodeException(message);
            }
            case 429: {
                throw new TooManyRequestsException(message);
            }
            case 500: {
                throw new InvalidServerConnectionException(message);
            }
            case 503: {
                throw new DownForMaintenanceException(message);
            }
            default: {
                throw new com.trolley.Exceptions.UnexpectedException(message);
            }
        }
    }
    
    private String generateAuthorization(final int timeStamp, final String method, final String endPoint, final String body) {
        final String message = timeStamp + "\n" + method + "\n" + endPoint + "\n" + body + "\n";
        try {
            final String hash = this.hmacDigest(message, this.config.getPrivateKey(), "HmacSHA256");
            return "prsign " + this.config.getPublicKey() + ":" + hash;
        }
        catch (Exception e) {
            return "prsign 1:1";
        }
    }
    
    private String hmacDigest(final String msg, final String keyString, final String algo) throws Exception {
        String digest = null;
        final SecretKeySpec key = new SecretKeySpec(keyString.getBytes("UTF-8"), algo);
        final Mac mac = Mac.getInstance(algo);
        mac.init(key);
        final byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));
        final StringBuffer hash = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            final String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
        digest = hash.toString();
        return digest;
    }
}
