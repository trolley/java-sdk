package com.trolley.types.supporting;

import java.util.ArrayList;

public class InvoicePaymentPart{
    private String invoiceId;
    private String invoiceLineId;
    private String paymentId;
    private Amount amount;

    //These fields are to hold values from parsed JSON, not for request body
    private boolean coverFees;
    private String memo;
    private String externalId;
    private ArrayList<String> tags;
    
    public InvoicePaymentPart() {
    }

    public InvoicePaymentPart(String invoiceId, String invoiceLineId, String paymentId, Amount amount) {
        this.invoiceId = invoiceId;
        this.invoiceLineId = invoiceLineId;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceLineId() {
        return invoiceLineId;
    }

    public void setInvoiceLineId(String invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public boolean shouldCoverFees() {
        return coverFees;
    }

    private void coverFees(boolean coverFees) {
        this.coverFees = coverFees;
    }

    public String getMemo() {
        return memo;
    }

    private void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExternalId() {
        return externalId;
    }

    private void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    private void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    
}