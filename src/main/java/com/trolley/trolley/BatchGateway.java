package com.trolley.trolley;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;

/**
 * <p>BatchGateway class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class BatchGateway {
    Client client;

    /**
     * <p>Constructor for BatchGateway.</p>
     *
     * @param config a {@link com.trolley.trolley.Configuration} object.
     */
    public BatchGateway(Configuration config) {
        this.client = new Client(config);
    }

    /**
     * <p>find.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.Batch} object.
     * @throws java.lang.Exception if any.
     */
    public Batch find(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id;
        String response = this.client.get(endPoint);
        return batchFactory(response);
    }

    /**
     * <p>update.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @return a boolean.
     * @throws java.lang.Exception if any.
     */
    public boolean update(String batch_id, String body) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id;
        this.client.patch(endPoint, body);
        return true;
    }

    /**
     * <p>update.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param batch a {@link com.trolley.trolley.Batch} object.
     * @return a boolean.
     * @throws java.lang.Exception if any.
     */
    public boolean update(String batch_id, Batch batch) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (batch == null) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        String jsonBatch = new ObjectMapper().writeValueAsString(batch);

        String endPoint = "/v1/batches/" + batch_id;
        this.client.patch(endPoint, jsonBatch);

        return true;
    }

    /**
     * <p>delete.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return a boolean.
     * @throws java.lang.Exception if any.
     */
    public boolean delete(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id;
        this.client.delete(endPoint);
        return true;
    }

    /**
     * <p>create.</p>
     *
     * @param body a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.Batch} object.
     * @throws java.lang.Exception if any.
     */
    public Batch create(String body) throws Exception {
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        String endPoint = "/v1/batches/";
        String response = this.client.post(endPoint, body);
        return batchFactory(response);
    }

    /**
     * <p>create.</p>
     *
     * @param batch a {@link com.trolley.trolley.Batch} object.
     * @return a {@link com.trolley.trolley.Batch} object.
     * @throws java.lang.Exception if any.
     */
    public Batch create(Batch batch) throws Exception {
        if (batch == null) {
            throw new InvalidFieldException("Batch cannot be null.");
        }
        
        String result = new ObjectMapper().writeValueAsString(batch);
        String endPoint = "/v1/batches/";
        String response = this.client.post(endPoint, result);
        
        return batchFactory(response);
    }

    /**
     * <p>generateQuote.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String generateQuote(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id + "/generate-quote";
        String response = this.client.post(endPoint);
        return response;
    }

    /**
     * <p>processBatch.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String processBatch(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        String endPoint = "/v1/batches/" + batch_id + "/start-processing";
        String response = this.client.post(endPoint);
        return response;
    }

    /**
     * <p>query.</p>
     *
     * @param page a int.
     * @param pageSize a int.
     * @param message a {@link java.lang.String} object.
     * @return a {@link java.util.List} object.
     * @throws java.lang.Exception if any.
     */
    public List<Batch> query(int page, int pageSize, String message) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less than 0");
        }
        if (message == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        String endPoint = "/v1/batches/?" + "&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        String response = this.client.get(endPoint);
        return batchListFactory(response);
    }

    /**
     * <p>query.</p>
     *
     * @param message a {@link java.lang.String} object.
     * @return a {@link java.util.List} object.
     * @throws java.lang.Exception if any.
     */
    public List<Batch> query(String message) throws Exception {
        return query(1, 10, message);
    }

    /**
     * <p>query.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws java.lang.Exception if any.
     */
    public List<Batch> query() throws Exception {
        return query(1, 10, "");
    }

    /**
     * <p>query.</p>
     *
     * @param page a int.
     * @param pageNumber a int.
     * @return a {@link java.util.List} object.
     * @throws java.lang.Exception if any.
     */
    public List<Batch> query(int page, int pageNumber) throws Exception {
        return query(page, pageNumber, "");
    }

    /**
     * <p>summary.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.BatchSummary} object.
     * @throws java.lang.Exception if any.
     */
    public BatchSummary summary(String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null os empty");
        }

        String endPoint = "/v1/batches/" + batch_id + "/summary";
        String response = this.client.get(endPoint);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(response);
        BatchSummary batchSummary = mapper.readValue(node.get("batchSummary").traverse(), BatchSummary.class);
        return batchSummary;
    }

    private Batch batchFactory(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(data);

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Object payments = mapper.readValue(node.get("batch").get("payments").get("payments").traverse(), Object.class);

        @SuppressWarnings("unchecked")
        List<Payment> castPayments = (List<Payment>) payments;
        List<Payment> paymentList = new ArrayList<Payment>();

        for (int i = 0; i < castPayments.size(); i++) {
            Payment payment = mapper.convertValue(castPayments.get(i), Payment.class);
            paymentList.add(payment);
        }

        Batch batch = mapper.readValue(node.get("batch").traverse(), Batch.class);
        batch.setPayments(paymentList);
        return batch;
    }

    private List<Batch> batchListFactory(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object batch = mapper.readValue(node.get("batches").traverse(), Object.class);
        @SuppressWarnings("unchecked")
        List<Batch> batchs = (List<Batch>) batch;
        List<Batch> batches = new ArrayList<Batch>();
        for (int i = 0; i < batchs.size(); i++) {
            Batch pojo = mapper.convertValue(batchs.get(i), Batch.class);
            batches.add(pojo);
        }
        return batches;
    }
}
