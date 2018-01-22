package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidFieldException;

public class RecipientAccountGateway {

    Client client;

    public RecipientAccountGateway(Configuration config) {
        this.client = new Client(config);
    }

    public String findAll(String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        // Client client = Client.create();
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts";
        String response = this.client.get(endPoint);
        return response;
    }

    public String find(String recipient_id, String recipient_account_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts/" + recipient_account_id;
        String response = this.client.get(endPoint);
        return response;
    }

    public String create(String recipient_id, String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts";
        String response = this.client.post(endPoint,body);
        return response;
    }

    public String update(String recipient_id, String recipient_account_id, String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        //Client client = Client.create();
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts/" + recipient_account_id;
        String response = this.client.patch(endPoint, body);
        return response;
    }

    public String delete(String recipient_id, String recipient_account_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        //Client client = Client.create();
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts/" + recipient_account_id;
        String response = this.client.delete(endPoint);
        return response;
    }

}