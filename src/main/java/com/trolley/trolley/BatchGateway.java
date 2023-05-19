package com.trolley.trolley;

import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;

public class BatchGateway
{
    Client client;
    
    public BatchGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    public Batch find(final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id;
        final String response = this.client.get(endPoint);
        return this.batchFactory(response);
    }
    
    public boolean update(final String batch_id, final String body) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id;
        this.client.patch(endPoint, body);
        return true;
    }
    
    public boolean update(final String batch_id, final Batch batch) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (batch == null) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        final String jsonBatch = new ObjectMapper().writeValueAsString((Object)batch);
        final String endPoint = "/v1/batches/" + batch_id;
        this.client.patch(endPoint, jsonBatch);
        return true;
    }
    
    public boolean delete(final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id;
        this.client.delete(endPoint);
        return true;
    }
    
    public Batch create(final String body) throws Exception {
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/";
        final String response = this.client.post(endPoint, body);
        return this.batchFactory(response);
    }
    
    public Batch create(final Batch batch) throws Exception {
        if (batch == null) {
            throw new InvalidFieldException("Batch cannot be null.");
        }
        final String result = new ObjectMapper().writeValueAsString((Object)batch);
        final String endPoint = "/v1/batches/";
        final String response = this.client.post(endPoint, result);
        return this.batchFactory(response);
    }
    
    public String generateQuote(final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/generate-quote";
        final String response = this.client.post(endPoint);
        return response;
    }
    
    public String processBatch(final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/start-processing";
        final String response = this.client.post(endPoint);
        return response;
    }
    
    public List<Batch> query(final int page, final int pageSize, final String message) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less than 0");
        }
        if (message == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        final String endPoint = "/v1/batches/?&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        final String response = this.client.get(endPoint);
        return this.batchListFactory(response);
    }
    
    public List<Batch> query(final String message) throws Exception {
        return this.query(1, 10, message);
    }
    
    public List<Batch> query() throws Exception {
        return this.query(1, 10, "");
    }
    
    public List<Batch> query(final int page, final int pageNumber) throws Exception {
        return this.query(page, pageNumber, "");
    }
    
    public BatchSummary summary(final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null os empty");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/summary";
        final String response = this.client.get(endPoint);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        final BatchSummary batchSummary = (BatchSummary)mapper.readValue(node.get("batchSummary").traverse(), (Class)BatchSummary.class);
        return batchSummary;
    }
    
    private Batch batchFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Object payments = mapper.readValue(node.get("batch").get("payments").get("payments").traverse(), (Class)Object.class);
        final List<Payment> castPayments = (List<Payment>)payments;
        final List<Payment> paymentList = new ArrayList<Payment>();
        for (int i = 0; i < castPayments.size(); ++i) {
            final Payment payment = (Payment)mapper.convertValue((Object)castPayments.get(i), (Class)Payment.class);
            paymentList.add(payment);
        }
        final Batch batch = (Batch)mapper.readValue(node.get("batch").traverse(), (Class)Batch.class);
        batch.setPayments(paymentList);
        return batch;
    }
    
    private List<Batch> batchListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Object batch = mapper.readValue(node.get("batches").traverse(), (Class)Object.class);
        final List<Batch> batchs = (List<Batch>)batch;
        final List<Batch> batches = new ArrayList<Batch>();
        for (int i = 0; i < batchs.size(); ++i) {
            final Batch pojo = (Batch)mapper.convertValue((Object)batchs.get(i), (Class)Batch.class);
            batches.add(pojo);
        }
        return batches;
    }
}
