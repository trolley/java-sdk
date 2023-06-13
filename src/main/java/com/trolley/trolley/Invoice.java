package com.trolley.trolley;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trolley.trolley.types.Amount;
import com.trolley.trolley.types.Invoices;
import com.trolley.trolley.types.Meta;

public class Invoice
{
    private String id;
    private String invoiceId;
    private String invoiceNumber;
    private String description;
    private String status;
    private String externalId;
    private String invoiceDate;
    private String dueDate;
    private String createdAt;
    private String updatedAt;
    private Amount totalAmount;
    private Amount paidAmount;
    private Amount dueAmount;
    private List<String> tags;
    private List<InvoiceLine> lines;
    private String recipientId;

    public static enum SearchBy {
        INVOICE_ID("invoiceId"),
        RECIPIENT_ID("recipientId"),
        INVOICE_NUMBER("invoiceNumber"),
        INVOICE_DATE("invoiceDate"),
        EXTERNAL_ID("externalId"),
        TAGS("tags");

        private String key;

        SearchBy(String key) {
            this.key = key;
        }

        @JsonCreator
        public static SearchBy fromString(String key) {
            return key == null
                    ? null
                    : SearchBy.valueOf(key.toUpperCase(Locale.US));
        }

        @JsonValue
        public String getKey() {
            return key;
        }

        public String toString(){
            return key.toLowerCase(Locale.US);
        }
    }    

    public Invoice() { }

    /**
     * 
     * @param recipientId
     * @param invoiceNumber
     * @param description
     * @param externalId
     * @param invoiceDate
     * @param dueDate
     * @param createdAt
     * @param updatedAt
     * @param tags
     * @param lines
     */
    public Invoice(String recipientId,
        String invoiceNumber, 
        String description, 
        String externalId,
        String invoiceDate, 
        String dueDate, 
        List<String> tags, 
        List<InvoiceLine> lines) {
            this.invoiceNumber = invoiceNumber;
            this.description = description;
            this.externalId = externalId;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.tags = tags;
            this.lines = lines;
            this.recipientId = recipientId;
    }

    private Invoice(String id, 
        String invoiceId, 
        String invoiceNumber, 
        String description, 
        String status, 
        String externalId,
        String invoiceDate, 
        String dueDate, 
        String createdAt, 
        String updatedAt, 
        Amount totalAmount,
        Amount paidAmount, 
        Amount dueAmount, 
        List<String> tags, 
        List<InvoiceLine> lines, 
        String recipientId) {
            this.id = id;
            this.invoiceId = invoiceId; // Only for Invoice.Update operation
            this.invoiceNumber = invoiceNumber;
            this.description = description;
            this.status = status;
            this.externalId = externalId;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.totalAmount = totalAmount;
            this.paidAmount = paidAmount;
            this.dueAmount = dueAmount;
            this.tags = tags;
            this.lines = lines;
            this.recipientId = recipientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the 'invoiceId' parameter for updating an invoice.
     * Used only by InvoiceGateway class.
     * May not have invoiceId set in most of the cases.
     * see setId() for setting ID of this invoice.
     * @param invoiceId
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * Getter for Jackson. This will not have any data in most of the cases.
     * See getId() for getting ID of this invoice.
     * @return
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Amount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Amount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Amount getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Amount paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Amount getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Amount dueAmount) {
        this.dueAmount = dueAmount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    /**
     * Factory method to generate Invoice object from a String representation of a valid Invoice JSON 
     * @param invoiceStr
     * @return
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    public static Invoice invoiceFactory(final String invoiceStr) throws JsonMappingException, JsonProcessingException  {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(invoiceStr);
        String invoiceId = node.get("invoice").get("id").asText();
        try{
            final Invoice invoice = (Invoice)mapper.readValue(node.get("invoice").traverse(), (Class)Invoice.class);
            return invoice;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Invoice(invoiceId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Factory method to create a List of Invoices
     * @param data
     * @return
     * @throws DatabindException
     * @throws StreamReadException
     * @throws IOException
     */
    public static Invoices invoiceListFactory(final String invoicesStr) throws StreamReadException, DatabindException, IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(invoicesStr);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Object invoice = mapper.readValue(node.get("invoices").traverse(), (Class)Object.class);
        final List<Invoice> parsedInvoices = (List<Invoice>)invoice;
        final List<Invoice> invoiceObjs = new ArrayList<Invoice>();

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);
        
        //Creating List<Invoice> object to return
        for (Object singleInvoice : parsedInvoices) {
            final Invoice pojo = (Invoice)mapper.convertValue((Object)singleInvoice, (Class)Invoice.class);
            invoiceObjs.add(pojo);
        }

        return new Invoices(invoiceObjs, meta);
    }

    /**
     * Invoice class' toString() method, returns a valid JSON String representation of this object
     * @return String JSON String representation of this object
     */
    public String toString(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
