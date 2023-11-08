package com.trolley.types;

import java.util.List;

import com.trolley.types.supporting.Meta;

public class Invoices {

    private List<Invoice> invoices;
    private Meta meta;
    
    public Invoices(List<Invoice> invoices, Meta meta) {
        this.invoices = invoices;
        this.meta = meta;
    }

    public List<Invoice> getInvoices() {
        return this.invoices;
    }
    
    public void setInvoices(final List<Invoice> invoices) {
        this.invoices = invoices;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
