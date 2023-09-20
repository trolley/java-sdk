package com.trolley.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trolley.Configuration;
import com.trolley.types.supporting.BatchSummary;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Batch
{
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
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public Integer getTotalPayments() {
        return this.totalPayments;
    }
    
    public void setTotalPayments(final Integer totalPayments) {
        this.totalPayments = totalPayments;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public Object getSentAt() {
        return this.sentAt;
    }
    
    public void setSentAt(final Object sentAt) {
        this.sentAt = sentAt;
    }
    
    public Object getCompletedAt() {
        return this.completedAt;
    }
    
    public void setCompletedAt(final Object completedAt) {
        this.completedAt = completedAt;
    }
    
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(final String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(final List<Payment> payments) {
        this.payments = payments;
    }
    
    public static Batch find(final String batch_id) throws Exception {
        return Configuration.gateway().batch.find(batch_id);
    }
    
    public static boolean update(final String batch_id, final String body) throws Exception {
        return Configuration.gateway().batch.update(batch_id, body);
    }
    
    public static boolean delete(final String batch_id) throws Exception {
        return Configuration.gateway().batch.delete(batch_id);
    }
    
    public static Batch create(final String body) throws Exception {
        return Configuration.gateway().batch.create(body);
    }
    
    public static Batch create(final Batch body) throws Exception {
        return Configuration.gateway().batch.create(body);
    }
    
    public static String generateQuote(final String batch_id) throws Exception {
        return Configuration.gateway().batch.generateQuote(batch_id);
    }
    
    public static String processBatch(final String batch_id) throws Exception {
        return Configuration.gateway().batch.processBatch(batch_id);
    }
    
    public static List<Batch> query(final int page, final int pageSize, final String message) throws Exception {
        return Configuration.gateway().batch.query(page, pageSize, message);
    }
    
    public static List<Batch> query(final String message) throws Exception {
        return query(1, 10, message);
    }
    
    public static List<Batch> query() throws Exception {
        return query(1, 10, "");
    }
    
    public static List<Batch> query(final int page, final int pageNumber) throws Exception {
        return query(page, pageNumber, "");
    }
    
    public static BatchSummary summary(final String batch_id) throws Exception {
        return Configuration.gateway().batch.summary(batch_id);
    }
}
