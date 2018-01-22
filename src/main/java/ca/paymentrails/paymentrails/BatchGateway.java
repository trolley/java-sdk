package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidFieldException;

public class BatchGateway {
    Client client;

    public BatchGateway(Configuration config) {
        this.client = new Client(config);
    }

    public String find(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }

        //Client client = Client.create();

        String endPoint = "/v1/batches/" + batch_id;
        String response = this.client.get(endPoint);
        return response;
    }

    public String update(String batch_id, String body) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        //Client client = Client.create();
        String endPoint = "/v1/batches/" + batch_id;
        String response = this.client.patch(endPoint, body);
        return response;
    }

    public String delete(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }

        //Client client = Client.create();
        String endPoint = "/v1/batches/" + batch_id;
        String response = this.client.delete(endPoint);
        return response;
    }

    public String create(String body) throws Exception {
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        //Client client = Client.create();
        String endPoint = "/v1/batches/";
        String response = this.client.post(endPoint, body);
        return response;
    }

    public String generateQuote(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }

        //Client client = Client.create();
        String endPoint = "/v1/batches/" + batch_id + "/generate-quote";
        String response = this.client.post(endPoint);
        return response;
    }

    public String processBatch(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        //Client client = Client.create();
        String endPoint = "/v1/batches/" + batch_id + "/start-processing";
        String response = this.client.post(endPoint);
        return response;
    }

    public String query(int page, int pageSize, String message) throws Exception {
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
        String endPoint = "/v1/batches/?" + "&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        String response = this.client.get(endPoint);
        return response;
    }

    public String query(String message) throws Exception {
        return query(1, 10, message);
    }

    public String query() throws Exception {
        return query(1, 10, "");
    }

    public String query(int page, int pageNumber) throws Exception {
        return query(page, pageNumber, "");
    }

    public String summary(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null os empty");
        }
        //Client client = Client.create();

        String endPoint = "/v1/batches/" + batch_id + "/summary";
        String response = this.client.get(endPoint);
        return response;
    }

}