package com.trolley;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.trolley.Exceptions.DownForMaintenanceException;
import com.trolley.Exceptions.InvalidServerConnectionException;
import com.trolley.Exceptions.TooManyRequestsException;
import com.trolley.types.supporting.HttpDeleteWithBody;
import com.trolley.Exceptions.InvalidStatusCodeException;
import com.trolley.Exceptions.NotFoundException;
import com.trolley.Exceptions.AuthorizationException;
import com.trolley.Exceptions.AuthenticationException;
import com.trolley.Exceptions.MalformedException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    /**
     * Get the HttpClient.
     * If you don't specify an HttpClient object, this method will create a new one.
     * If you did specify an HttpClient object in Configuration, that object will be used instead.
     * @return HttpClient
     */
    private HttpClient getHttpClient(){
        if(null != this.config.getHttpClient()){
            return this.config.getHttpClient();
        }else{
            return (HttpClient)HttpClients.createSystem();
        }
    }
    
    public String get(final String endpoint) throws Exception {
        final HttpClient httpclient = getHttpClient();
        final HttpGet httpGet = new HttpGet(this.config.getApiBase() + endpoint);

        httpGet.setHeaders(getHeaders("GET", endpoint, ""));

        // execute request
        final HttpResponse response = httpclient.execute((HttpUriRequest)httpGet);
        
        // process response
        return processResponse(response);
    }
    
    public String post(final String endpoint, final String body) throws Exception {
        final HttpClient httpclient = getHttpClient();
        final HttpPost httpPatch = new HttpPost(this.config.getApiBase() + endpoint);
        final StringEntity params = new StringEntity(body);
        httpPatch.setEntity((HttpEntity)params);

        httpPatch.setHeaders(getHeaders("POST", endpoint, body));

        // execute request
        final HttpResponse response = httpclient.execute((HttpUriRequest)httpPatch);
        
        // process response
        return processResponse(response);
    }
    
    public String post(final String endpoint) throws Exception {
        final HttpClient httpclient = getHttpClient();
        final HttpPost httpPatch = new HttpPost(this.config.getApiBase() + endpoint);
        final StringEntity params = new StringEntity("");
        httpPatch.setEntity((HttpEntity)params);

        httpPatch.setHeaders(getHeaders("POST", endpoint, ""));

        // execute request
        final HttpResponse response = httpclient.execute((HttpUriRequest)httpPatch);
        
        // process response
        return processResponse(response);
    }
    
    public String patch(final String endpoint, final String body) throws Exception {
        final HttpClient httpclient = getHttpClient();
        final HttpPatch httpPatch = new HttpPatch(this.config.getApiBase() + endpoint);
        final StringEntity params = new StringEntity(body);
        httpPatch.setEntity((HttpEntity)params);

        httpPatch.setHeaders(getHeaders("PATCH", endpoint, body));

        // execute request
        final HttpResponse response = httpclient.execute((HttpUriRequest)httpPatch);
        
        // process response
        return processResponse(response);
    }
    
    public String delete(final String endpoint) throws Exception {
        final HttpClient httpclient = getHttpClient();
        final HttpDelete httpDelete = new HttpDelete(this.config.getApiBase() + endpoint);
        httpDelete.setHeaders(getHeaders("DELETE", endpoint, ""));

        // execute request
        final HttpResponse response = httpclient.execute((HttpUriRequest)httpDelete);
        
        // process response
        return processResponse(response);
    }

    /**
     * Supports DELETE request with a body.
     * @param endpoint
     * @param body
     * @return
     * @throws Exception
     */
    public String delete(final String endpoint, final String body) throws Exception {
        final HttpClient httpclient = getHttpClient();
        final HttpDeleteWithBody httpDeleteWithBody = new HttpDeleteWithBody(this.config.getApiBase() + endpoint);
        final StringEntity params = new StringEntity(body);
        httpDeleteWithBody.setEntity((HttpEntity)params);


        httpDeleteWithBody.setHeaders(getHeaders("DELETE", endpoint, body));

        // execute request
        final HttpResponse response = httpclient.execute((HttpUriRequest)httpDeleteWithBody);
        
        // process response
        return processResponse(response);
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

    /**
     * Process and return the response received after the calls made with HttpClient.
     * @param response
     * @return
     * @throws Exception
     */
    String processResponse(HttpResponse response) throws Exception{
        String responseStr = "";
        try{
            final StringBuffer result = new StringBuffer();
            String line = "";
            final BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            responseStr = result.toString();
            final int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200) {
                this.throwStatusCodeException(responseCode, responseStr);
            }
        }catch (IOException e) {
            throw new UnexpectedException(responseStr);
        }

        return responseStr;
    }

    /**
     * Returns an array of type {@code Header} for different requests to use.
     * @param method
     * @param endpoint
     * @param body
     * @return
     */
    private Header[] getHeaders(String method, String endpoint, String body){
        final int timestamp = ((int)(System.currentTimeMillis() / 1000L));
        final String authorizarion = this.generateAuthorization(timestamp, method, endpoint, body);

        return new Header[]{
                new BasicHeader("Content-Type", "application/json"),
                new BasicHeader("X-PR-Timestamp", ""+timestamp),
                new BasicHeader("Authorization", authorizarion),
                new BasicHeader("Trolley-Source", trolleySourceString)
            };
    }
}
