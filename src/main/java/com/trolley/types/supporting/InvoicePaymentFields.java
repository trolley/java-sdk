package com.trolley.types.supporting;

import java.util.ArrayList;

public class InvoicePaymentFields{
    private boolean coverFees;
    private String memo;
    private String externalId;
    private ArrayList<String> tags;
    
    public InvoicePaymentFields() {
    }

    /**
     * 
     * @param coverFees
     * @param memo
     * @param externalId
     * @param tags
     */
    public InvoicePaymentFields(boolean coverFees, String memo, String externalId, ArrayList<String> tags) {
        this.coverFees = coverFees;
        this.memo = memo;
        this.externalId = externalId;
        this.tags = tags;
    }



    public boolean shouldCoverFees() {
        return coverFees;
    }

    public void coverFees(boolean coverFees) {
        this.coverFees = coverFees;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }    
}