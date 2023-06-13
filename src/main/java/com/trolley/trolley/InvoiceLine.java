package com.trolley.trolley;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.trolley.trolley.types.Amount;

public class InvoiceLine
{
    private String id;
    private String invoiceLineId;
    private String status;
    private String description;
    private Amount unitAmount;
    private String quantity;
    private Amount discountAmount;
    private Amount taxAmount;
    private Amount totalAmount;
    private Amount dueAmount;
    private Amount paidAmount;
    private String externalId;
    private boolean taxReportable;
    private List<String> tags;
    private InvoiceCategories category;
    private boolean forceUsTaxActivity;

    public static enum InvoiceCategories{
        SERVICES("services"),
        RENT("rent"),
        ROYALTIES("royalties"),
        ROYALTIES_FILM("royalties_film"),
        PRIZES("prizes"),
        EDUCATION("education"),
        REFUNDS("refunds");
        
        private String key;

        InvoiceCategories(String key) {
            this.key = key;
        }

        @JsonCreator
        public static InvoiceCategories fromString(String key) {
            return key == null
                    ? null
                    : InvoiceCategories.valueOf(key.toUpperCase(Locale.US));
        }

        @JsonValue
        public String getKey() {
            return key;
        }

        public String toString(){
            return key.toLowerCase(Locale.US);
        }
    };

    public InvoiceLine() {}

    /**
     * @param unitAmount
     * @param category
     * @param description
     * @param externalId
     * @param taxReportable
     * @param forceUsTaxActivity
     * @param tags
     * @param quantity
     * @param discountAmount
     * @param taxAmount
     * @param dueAmount
     * @param paidAmount
     */
    public InvoiceLine(
        Amount unitAmount,
        InvoiceCategories category,
        String description, 
        String externalId,
        boolean taxReportable, 
        boolean forceUsTaxActivity,
        List<String> tags,
        String quantity,
        Amount discountAmount, 
        Amount taxAmount, 
        Amount dueAmount, 
        Amount paidAmount) {
            this.description = description;
            this.unitAmount = unitAmount;
            this.quantity = quantity;
            this.discountAmount = discountAmount;
            this.taxAmount = taxAmount;
            this.dueAmount = dueAmount;
            this.paidAmount = paidAmount;
            this.externalId = externalId;
            this.taxReportable = taxReportable;
            this.tags = tags;
            this.category = category;
            this.forceUsTaxActivity = forceUsTaxActivity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get <code>invoiceLineId</code> for Update Invoice Line operation.
     * <p>
     * NOTE: Only used for Update operation, may not be filled by other operations.
     * <p>
     * See <code>getId()</code> for accessing InvoiceLineId from a response
     * @return String invoiceLineId the id of the invoice line that needs to be updated
     */
    public String getInvoiceLineId() {
        return invoiceLineId;
    }

    /**
     * Set <code>invoiceLineId</code> for Update Invoice Line operation.
     * <p>
     * NOTE: Only used for Update operation, may not be filled by other operations.
     * <p>
     * See <code>getId()</code> for accessing InvoiceLineId from a response
     * @param invoiceLineId the id of the invoice line that needs to be updated
     */
    public void setInvoiceLineId(String invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Amount getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Amount unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Amount getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Amount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Amount getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Amount taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Amount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Amount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Amount getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Amount dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Amount getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Amount paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public boolean isTaxReportable() {
        return taxReportable;
    }

    public void setTaxReportable(boolean taxReportable) {
        this.taxReportable = taxReportable;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public InvoiceCategories getCategory() {
        return category;
    }

    public void setCategory(InvoiceCategories category) {
        this.category = category;
    }

    public boolean isForceUsTaxActivity() {
        return forceUsTaxActivity;
    }

    public void setForceUsTaxActivity(boolean forceUsTaxActivity) {
        this.forceUsTaxActivity = forceUsTaxActivity;
    }

    /**
     * Factory method to create Invoice object from the response that was returned. <br/>
     * <p>
     * The API responds with the full Invoice object where the newly created line is added,
     * so instead of returning the individual line item, the Invoice object is returned. <br/>
     * </p>
     * 
     * @param invoiceLineResponse JSON String received in the response
     * @return Invoice object containing all the lines, including the newly created one
     * @throws IOException
     */
    public static Invoice invoiceLinesFactory(final String invoiceLineResponse) throws IOException {
        return Invoice.invoiceFactory(invoiceLineResponse);
    }

    /**
     * InvoiceLine class' toString() method, returns a valid JSON String representation of this object
     * @return String JSON String representation of this object
     */
    public String toString(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String jsonString = null;
        try {
            jsonString = objectMapper.setSerializationInclusion(Include.NON_EMPTY).writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
