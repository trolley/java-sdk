package ca.paymentrails.paymentrails;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.List;

public class Batch {

    private String id;
    private String status;
    private String amount;
    private Integer totalPayments;
    private String currency;
    private String description;
    private Object sentAt;
    private Object completedAt;
    private String createdAt;
    private String updatedAt;
    private Payments payments;
    public String quoteExpiredAt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(Integer totalPayments) {
        this.totalPayments = totalPayments;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getSentAt() {
        return sentAt;
    }

    public void setSentAt(Object sentAt) {
        this.sentAt = sentAt;
    }

    public Object getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Object completedAt) {
        this.completedAt = completedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    /**
     * Retrieves a batch based on the batch id given
     *
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static Batch find(String batch_id) throws Exception {
        String response =  Configuration.gateway().batch.find(batch_id);
        ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(response);
        Batch batch = mapper.readValue(node.get("batch").traverse(), Batch.class);
        return batch;
    }

    /**
     * Updates a batch based on the batch id and body
     *
     * @param batch_id
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String update(String batch_id, String body) throws Exception {
        return Configuration.gateway().batch.update(batch_id, body);
    }

    /**
     * Deletes a batch based on batch id
     *
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String delete(String batch_id) throws Exception {
        return Configuration.gateway().batch.delete(batch_id);
    }

    /**
     * Creates a batch based on batch the body
     *
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static Batch create(String body) throws Exception {
        String response =  Configuration.gateway().batch.create(body);
        ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(response);
        Batch batch = mapper.readValue(node.get("batch").traverse(), Batch.class);
        return batch;
    }

    /**
     * Generate a quote for a batch
     *
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String generateQuote(String batch_id) throws Exception {
        return Configuration.gateway().batch.generateQuote(batch_id);
    }

    /**
     * Process a batch
     *
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String processBatch(String batch_id) throws Exception {
        return Configuration.gateway().batch.processBatch(batch_id);
    }

    /**
     * List all Batches based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param page
     * @param pageSize
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Batch> query(int page, int pageSize, String message) throws Exception {
        String response =  Configuration.gateway().batch.query(page, pageSize, message);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
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

    /**
     * List all batches based on the recipient id and a given wildcard
     *
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Batch> query(String message) throws Exception {
        return query(1, 10, message);
    }

    /**
     * List all batches
     *
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Batch> query() throws Exception {
        return query(1, 10, "");
    }

    /**
     * List all batches based on the recipient id and (optional) page amount and
     * page size
     *
     * @param page
     * @param pageNumber
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Batch> query(int page, int pageNumber) throws Exception {
        return query(page, pageNumber, "");
    }

    /**
     * Retrieves summary of batch
     *
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static BatchSummary summary(String batch_id) throws Exception {
        String response = Configuration.gateway().batch.summary(batch_id);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(response);
        System.out.println(node);
        BatchSummary batchSummary = mapper.readValue(node.get("batchSummary").traverse(), BatchSummary.class);
        return batchSummary;
    }
}
