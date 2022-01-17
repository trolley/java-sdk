package com.trolley.trolley;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * <p>Batch class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
@JsonInclude(Include.NON_NULL)
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

    private List<Payment> payments;

    public String quoteExpiredAt;

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>status</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStatus() {
        return status;
    }

    /**
     * <p>Setter for the field <code>status</code>.</p>
     *
     * @param status a {@link java.lang.String} object.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * <p>Getter for the field <code>amount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * <p>Setter for the field <code>amount</code>.</p>
     *
     * @param amount a {@link java.lang.String} object.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * <p>Getter for the field <code>totalPayments</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getTotalPayments() {
        return totalPayments;
    }

    /**
     * <p>Setter for the field <code>totalPayments</code>.</p>
     *
     * @param totalPayments a {@link java.lang.Integer} object.
     */
    public void setTotalPayments(Integer totalPayments) {
        this.totalPayments = totalPayments;
    }

    /**
     * <p>Getter for the field <code>currency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * <p>Setter for the field <code>currency</code>.</p>
     *
     * @param currency a {@link java.lang.String} object.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * <p>Getter for the field <code>description</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Setter for the field <code>description</code>.</p>
     *
     * @param description a {@link java.lang.String} object.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <p>Getter for the field <code>sentAt</code>.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    public Object getSentAt() {
        return sentAt;
    }

    /**
     * <p>Setter for the field <code>sentAt</code>.</p>
     *
     * @param sentAt a {@link java.lang.Object} object.
     */
    public void setSentAt(Object sentAt) {
        this.sentAt = sentAt;
    }

    /**
     * <p>Getter for the field <code>completedAt</code>.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    public Object getCompletedAt() {
        return completedAt;
    }

    /**
     * <p>Setter for the field <code>completedAt</code>.</p>
     *
     * @param completedAt a {@link java.lang.Object} object.
     */
    public void setCompletedAt(Object completedAt) {
        this.completedAt = completedAt;
    }

    /**
     * <p>Getter for the field <code>createdAt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * <p>Setter for the field <code>createdAt</code>.</p>
     *
     * @param createdAt a {@link java.lang.String} object.
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * <p>Getter for the field <code>updatedAt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * <p>Setter for the field <code>updatedAt</code>.</p>
     *
     * @param updatedAt a {@link java.lang.String} object.
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * <p>Getter for the field <code>payments</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * <p>Setter for the field <code>payments</code>.</p>
     *
     * @param payments a {@link java.util.List} object.
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     * Retrieves a batch based on the batch id given
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static Batch find(String batch_id) throws Exception {
        return Configuration.gateway().batch.find(batch_id);
    }

    /**
     * Updates a batch based on the batch id and body
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static boolean update(String batch_id, String body) throws Exception {
        return Configuration.gateway().batch.update(batch_id, body);
    }

    /**
     * Deletes a batch based on batch id
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static boolean delete(String batch_id) throws Exception {
        return Configuration.gateway().batch.delete(batch_id);
    }

    /**
     * Creates a batch based on batch the body
     *
     * @param body a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static Batch create(String body) throws Exception {
        return Configuration.gateway().batch.create(body);
    }

    /**
     * <p>create.</p>
     *
     * @param body a {@link com.trolley.trolley.Batch} object.
     * @return a {@link com.trolley.trolley.Batch} object.
     * @throws java.lang.Exception if any.
     */
    public static Batch create(Batch body) throws Exception {
        return Configuration.gateway().batch.create(body);
    }

    /**
     * Generate a quote for a batch
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static String generateQuote(String batch_id) throws Exception {
        return Configuration.gateway().batch.generateQuote(batch_id);
    }

    /**
     * Process a batch
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
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
     * @param pageSize a int.
     * @param message a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Batch> query(int page, int pageSize, String message) throws Exception {
        return Configuration.gateway().batch.query(page, pageSize, message);

    }

    /**
     * List all batches based on the recipient id and a given wildcard
     *
     * @param message a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Batch> query(String message) throws Exception {
        return query(1, 10, message);
    }

    /**
     * List all batches
     *
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
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
     * @param pageNumber a int.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Batch> query(int page, int pageNumber) throws Exception {
        return query(page, pageNumber, "");
    }

    /**
     * Retrieves summary of batch
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static BatchSummary summary(String batch_id) throws Exception {
        return Configuration.gateway().batch.summary(batch_id);
        
    }
}
