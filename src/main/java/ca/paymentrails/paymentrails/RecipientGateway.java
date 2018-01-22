package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidFieldException;

public class RecipientGateway {

    Client client;

    public RecipientGateway(Configuration config) {
        this.client = new Client(config);
    }

    public String find(String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }

        String endPoint = "/v1/recipients/" + recipient_id;
        String response = this.client.get(endPoint);
        return response;
    }

    public String findLogs(String recipient_id) throws Exception {
        String endPoint = "/v1/recipients/" + recipient_id + "/logs";
        String response = this.client.get(endPoint);
        return response;
    }

    public String findPayments(String recipient_id) throws Exception {
        String endPoint = "/v1/recipients/" + recipient_id + "/payments";
        String response = this.client.get(endPoint);
        return response;
    }

    public String create(String body) throws Exception {
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }

        String endPoint = "/v1/recipients/";
        String response = this.client.post(endPoint, body);
        return response;
    }

    public String update(String recipient_id, String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }

        String endPoint = "/v1/recipients/" + recipient_id;
        String response = this.client.patch(endPoint, body);
        return response;
    }

    public String delete(String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }

        String endPoint = "/v1/recipients/" + recipient_id;
        String response = this.client.delete(endPoint);
        return response;
    }

    public String search(int page, int pageSize, String term) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }

        String endPoint = "/v1/recipients/?" + "&search=" + term + "&page=" + page + "&pageSize=" + pageSize;
        String response = this.client.get(endPoint);
        return response;
    }
}