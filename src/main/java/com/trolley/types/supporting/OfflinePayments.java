package com.trolley.types.supporting;

import java.util.List;

import com.trolley.types.OfflinePayment;

public class OfflinePayments
{
    private List<OfflinePayment> offlinePayments;
    private Meta meta;
    
    public OfflinePayments(final List<OfflinePayment> offlinePayments, final Meta meta) {
        this.offlinePayments = offlinePayments;
        this.meta = meta;
    }
    
    public List<OfflinePayment> getOfflinePayments() {
        return this.offlinePayments;
    }
    
    public void setPayments(final List<OfflinePayment> offlinePayments) {
        this.offlinePayments = offlinePayments;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
