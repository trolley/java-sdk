package com.trolley;

import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.Batch;
import com.trolley.types.Payment;
import com.trolley.types.supporting.BatchSummary;
import com.trolley.types.supporting.Batches;
import com.trolley.types.supporting.BatchesIterator;
import com.trolley.types.supporting.Meta;

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
    
    /**
     * Search for batches.
     * This method returns an iterator which auto-paginate with 10 items per page.
     * If you want to paginate manually, please use the {@code search_by_page()} method
     * @param searchTerm the search keyword to be searched for
     * @return BatchIterator which auto paginates through all available payments 10 items per page
     * @throws Exception
     */
    public BatchesIterator search(final String searchTerm) throws Exception {
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }
        int pageSize = 10;
        Batches b = search_by_page(1, pageSize, searchTerm);
        return new BatchesIterator(this, b, searchTerm);
    }

    /**
     * Search for Batches manual pagination.
     * @param page which page number you want to access
     * @param pageSize number of items you want per page
     * @param searchTerm keyword to search for
     * @return {@code Batches} object, containing a {@code List<Batch>} object and a {@code Meta} object to access pagination information
     * @throws Exception
     */
    public Batches search_by_page(final int page, final int pageSize, final String searchTerm) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("pageSize cannot be less than 0");
        }
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }
        final String endPoint = "/v1/batches/?&search=" + searchTerm + "&page=" + page + "&pageSize=" + pageSize;
        final String response = this.client.get(endPoint);
        return this.batchListFactory(response);
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
    
    private Batches batchListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        final List<Batch> batchesFromResponse = (List<Batch>)mapper.readValue(node.get("batches").traverse(), (Class)Object.class);
        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);

        final List<Batch> batches = new ArrayList<Batch>();
        for (int i = 0; i < batchesFromResponse.size(); ++i) {
            final Batch pojo = (Batch)mapper.convertValue((Object)batchesFromResponse.get(i), (Class)Batch.class);
            batches.add(pojo);
        }

        return new Batches(batches, meta);
    }
}
