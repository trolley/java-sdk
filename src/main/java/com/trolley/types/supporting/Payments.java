package com.trolley.types.supporting;

import java.util.List;

import com.trolley.types.Payment;

public class Payments
{
    private List<Payment> payments;
    private Meta meta;
    
    public Payments() {
        this.payments = null;
    }
    
    public List<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(final List<Payment> payments) {
        this.payments = payments;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
