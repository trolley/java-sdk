package com.trolley.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Batch
{
    private String id;
    private String status;
    private List<String> tags;
    private String amount;
    private Integer totalPayments;
    private String currency;
    private String description;
    private Object sentAt;
    private Object completedAt;
    private String createdAt;
    private String updatedAt;
    public String quoteExpiredAt;
    private List<Payment> payments;
    
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
    
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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
    
    public String getQuoteExpiredAt() {
        return quoteExpiredAt;
    }

    public void setQuoteExpiredAt(String quoteExpiredAt) {
        this.quoteExpiredAt = quoteExpiredAt;
    }

    public List<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(final List<Payment> payments) {
        this.payments = payments;
    }
}
