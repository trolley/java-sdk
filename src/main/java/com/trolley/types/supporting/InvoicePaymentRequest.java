package com.trolley.types.supporting;

import java.util.ArrayList;

/**
 * Used while creating a new InvoicePayment request
 */
public class InvoicePaymentRequest{
    private String batchId;
    private boolean coverFees;
    private String memo;
    private String externalId;
    private String[] tags;
    private InvoicePaymentPart[] ids;
    
    public InvoicePaymentRequest() {
    }

    /**
     * Constructor to create a new request when you have more than one Invoices or InvoiceLines to create payment for.
     * @param batchId ID of the batch you'd want to add this payment to. If it's {@code null} or {@code ""}, a new payment will be created.
     * @param coverFees Denotes whether you want to cover fees with this payment.
     * @param memo A recipient viewable Memo that you'd want the created payment to have.
     * @param externalId A unique External ID that you'd want to assign to the created payment.
     * @param tags A {@code String[]} array where each element is a merchant-viewable tag that you want to assign to the created payment.
     * @param ids An {@code InvoicePaymentPart[]} array representing InvoicePaymentPart objects containing IDs and Amounts of Invoices and InvoiceLines you want to create payments for.
     */
    public InvoicePaymentRequest(String batchId, boolean coverFees, String memo, String externalId,
            String[] tags, InvoicePaymentPart[] ids) {
        this.batchId = batchId;
        this.coverFees = coverFees;
        this.memo = memo;
        this.externalId = externalId;
        this.tags = tags;
        this.ids = ids;
    }

    /**
     * Constructor to create a new request when you have only one Invoice/InvoiceLine to create a payment for.
     * @param batchId ID of the batch you'd want to add this payment to. If it's {@code null} or {@code ""}, a new payment will be created.
     * @param coverFees Denotes whether you want to cover fees with this payment.
     * @param memo A recipient viewable Memo that you'd want the created payment to have.
     * @param externalId A unique External ID that you'd want to assign to the created payment.
     * @param tags A {@code String[]} array where each element is a merchant-viewable tag that you want to assign to the created payment.
     * @param ids An {@code InvoicePaymentPart[]} array representing InvoicePaymentPart objects containing IDs and Amounts of Invoices and InvoiceLines you want to create payments for.
     */
    public InvoicePaymentRequest(String batchId, boolean coverFees, String memo, String externalId,
            String[] tags, InvoicePaymentPart paymentPart) {
        this.batchId = batchId;
        this.coverFees = coverFees;
        this.memo = memo;
        this.externalId = externalId;
        this.tags = tags;
        this.ids = new InvoicePaymentPart[]{paymentPart};
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public boolean shouldCoverFees() {
        return coverFees;
    }

    public void setCoverFees(boolean coverFees) {
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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public InvoicePaymentPart[] getIds() {
        return ids;
    }

    public void setIds(InvoicePaymentPart[] ids) {
        this.ids = ids;
    }
}