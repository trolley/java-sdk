package com.trolley.trolley;

import java.util.List;

public class Payments {

    private List<Payment> payments = null;
    private Meta meta;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}