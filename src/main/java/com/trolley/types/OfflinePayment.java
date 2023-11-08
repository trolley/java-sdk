package com.trolley.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trolley.types.supporting.Amount;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OfflinePayment
{
    private String id;
    private Recipient recipient;
    private String amount;
    private String currency;
    private String withholdingAmount;
    private String withholdingCurrency;
    private String equivalentWithholdingAmount;
    private String equivalentWithholdingCurrency;
    private String externalId;
    private String memo;
    private List<String> tags;
    private String category;
    private String processedAt;
    private Amount enteredAmount;
    private String updatedAt;
    private String createdAt;
    private String deletedAt;

    public void setEquivalentWithholdingCurrency(final String equivalentWithholdingCurrency) {
        this.equivalentWithholdingCurrency = equivalentWithholdingCurrency;
    }
    
    public String getEquivalentWithholdingCurrency() {
        return this.equivalentWithholdingCurrency;
    }
    
    public void setEquivalentWithholdingAmount(final String equivalentWithholdingAmount) {
        this.equivalentWithholdingAmount = equivalentWithholdingAmount;
    }
    
    public String getEquivalentWithholdingAmount() {
        return this.equivalentWithholdingAmount;
    }
    
    public void setWithholdingCurrency(final String withholdingCurrency) {
        this.withholdingCurrency = withholdingCurrency;
    }
    
    public List<String> getTags() {
        return this.tags;
    }
    
    public void setTags(final List<String> tags) {
        this.tags = tags;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(final String category) {
        this.category = category;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public String getWithholdingCurrency() {
        return this.withholdingCurrency;
    }
    
    public void setWithholdingAmount(final String withholdingAmount) {
        this.withholdingAmount = withholdingAmount;
    }
    
    public String getWithholdingAmount() {
        return this.withholdingAmount;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public Recipient getRecipient() {
        return this.recipient;
    }
    
    public void setRecipient(final Recipient recipient) {
        this.recipient = recipient;
    }
    
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(final String memo) {
        this.memo = memo;
    }
    
    public String getExternalId() {
        return this.externalId;
    }
    
    public void setExternalId(final String externalId) {
        this.externalId = externalId;
    }
    
    public String getProcessedAt() {
        return this.processedAt;
    }
    
    public void setProcessedAt(final String processedAt) {
        this.processedAt = processedAt;
    }

    public Amount getEnteredAmount() {
        return enteredAmount;
    }

    public void setEnteredAmount(Amount enteredAmount) {
        this.enteredAmount = enteredAmount;
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

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }
}
