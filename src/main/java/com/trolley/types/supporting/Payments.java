package com.trolley.types.supporting;

import java.util.List;

import com.trolley.types.Payment;

public class Payments
{
    private List<Payment> payments;
    private Meta meta;
    
    public Payments(final List<Payment> payments, final Meta meta) {
        this.payments = payments;
        this.meta = meta;
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
