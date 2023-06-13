package com.trolley.trolley.types;

public class InvoicePaymentPart{
    private String invoiceId;
    private String invoiceLineId;
    private String paymentId;
    private Amount amount;
    
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
}