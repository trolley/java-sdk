package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidFieldException;

public class PaymentGateway {
    Client client;

    public PaymentGateway(Configuration config) {
        this.client = new Client(config);
    }

    public String find(String payment_id, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = this.client.get(endPoint);
        return response;
    }

    public String create(String body, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        //Client client = Client.create();

        String endPoint = "/v1/batches/" + batch_id + "/payments";
        String response = this.client.post(endPoint, body);
        return response;
    }

    public String update(String payment_id, String body, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        //Client client = Client.create();

        String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = this.client.patch(endPoint, body);
        return response;
    }

    public String delete(String payment_id, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        //Client client = Client.create();

        String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = this.client.delete(endPoint);
        return response;
    }

    public String query(String batch_id, int page, int pageSize, String message) throws Exception {

        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (message == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        //Client client = Client.create();
        String endPoint = "/v1/batches/" + batch_id + "/payments/?" + "&search=" + message + "&page=" + page
                + "&pageSize=" + pageSize;
        String response = this.client.get(endPoint);
        return response;
    }

}