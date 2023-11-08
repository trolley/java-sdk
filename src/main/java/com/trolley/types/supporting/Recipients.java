package com.trolley.types.supporting;

import java.util.List;

import com.trolley.types.Recipient;

public class Recipients {

    private List<Recipient> recipientList;
    private Meta meta;
    
    public Recipients(List<Recipient> recipientList, Meta meta) {
        this.recipientList = recipientList;
        this.meta = meta;
    }

    public List<Recipient> getRecipients() {
        return this.recipientList;
    }
    
    public void setRecipients(final List<Recipient> recipientList) {
        this.recipientList = recipientList;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
