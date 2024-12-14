package com.trolley.types.supporting;

public class InvoicePaymentPart{
    private String invoiceId;
    private String invoiceLineId;
    private String paymentId;
    private Amount amount;

    //These fields are to hold values from parsed JSON, not for request body
    private Boolean coverFees;
    private String memo;
    private String externalId;
    private String[] tags;
    
    public InvoicePaymentPart() {
    }

    public InvoicePaymentPart(String invoiceId, String invoiceLineId, String paymentId, Amount amount) {
        this.invoiceId = invoiceId;
        this.invoiceLineId = invoiceLineId;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    /**
     * IMPORTANT: Use as request only while updating an InvoicePayment. For "Create Invoice Payment" request, use {@link InvoicePaymentRequest#InvoicePaymentRequest(String, boolean, String, String, String[], InvoicePaymentPart) InvoicePaymentRequest}.
     */
    public InvoicePaymentPart(String invoiceId, String invoiceLineId, String paymentId, Amount amount,
            Boolean coverFees, String memo, String externalId, String[] tags) {
        this.invoiceId = invoiceId;
        this.invoiceLineId = invoiceLineId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.coverFees = coverFees;
        this.memo = memo;
        this.externalId = externalId;
        this.tags = tags;
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

    public Boolean shouldCoverFees() {
        return coverFees;
    }

    /**
     * IMPORTANT: Use as request only while updating an InvoicePayment
     * @param coverFees
     */
    public void setCoverFees(boolean coverFees) {
        this.coverFees = coverFees;
    }

    public String getMemo() {
        return memo;
    }

    /**
     * IMPORTANT: Use as request only while updating an InvoicePayment
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExternalId() {
        return externalId;
    }

    /**
     * IMPORTANT: Use as request only while updating an InvoicePayment
     * @param externalId
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String[] getTags() {
        return tags;
    }

    /**
     * IMPORTANT: Use as request only while updating an InvoicePayment
     * @param tags
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }
}