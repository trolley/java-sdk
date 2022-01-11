package ca.paymentrails.paymentrails;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    @JsonAnyGetter
    private List<Payment> payments;
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

    public List<Payment> getPayments() {
        return payments;
    }

    // public void setPayments(Payments payments) {
    //     this.payments = payments;
    // }

    public void setPayments(List<Payment> payments) {
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
        return Configuration.gateway().batch.find(batch_id);
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
    public static boolean update(String batch_id, String body) throws Exception {
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
    public static boolean delete(String batch_id) throws Exception {
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
        return Configuration.gateway().batch.create(body);
    }

    public static Batch create(Batch body) throws Exception {
        return Configuration.gateway().batch.create(body);
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
        return Configuration.gateway().batch.query(page, pageSize, message);

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
        return Configuration.gateway().batch.summary(batch_id);
        
    }
}
