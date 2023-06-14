package com.trolley.trolley.types;

import java.util.List;

public class InvoicePayments {

    private List<InvoicePaymentPart> invoicePaymentParts;
    private Meta meta;
    
    public InvoicePayments(List<InvoicePaymentPart> invoicePaymentParts, Meta meta) {
        this.invoicePaymentParts = invoicePaymentParts;
        this.meta = meta;
    }

    public List<InvoicePaymentPart> getInvoicePaymentParts() {
        return this.invoicePaymentParts;
    }
    
    public void setInvoicePaymentParts(final List<InvoicePaymentPart> invoicePaymentParts) {
        this.invoicePaymentParts = invoicePaymentParts;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
