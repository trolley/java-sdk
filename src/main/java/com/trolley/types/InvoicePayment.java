package com.trolley.types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.trolley.types.supporting.InvoicePaymentPart;
import com.trolley.types.supporting.InvoicePayments;
import com.trolley.types.supporting.Meta;

public class InvoicePayment
{
    private String batchId;
    private String paymentId;
    private List<InvoicePaymentPart> invoicePayments;

    public InvoicePayment() {}    

    public InvoicePayment(List<InvoicePaymentPart> invoicePayments) {
        this.invoicePayments = invoicePayments;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public List<InvoicePaymentPart> getInvoicePayments() {
        return invoicePayments;
    }

    public void setInvoicePayments(List<InvoicePaymentPart> invoicePayments) {
        this.invoicePayments = invoicePayments;
    }

    /**
     * Factory method to create InvoicePayment object from the response that was returned.
     * 
     * @param invoicePaymentResponse JSON String received in the response
     * @return InvoicePayment object containing all the lines, including the newly created one
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    public static InvoicePayment invoicePaymentFactory(final String invoicePaymentResponse) throws JsonMappingException, JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(invoicePaymentResponse);
        String paymentId = node.get("invoicePayment").get("paymentId").asText();
        InvoicePayment invoicePayment;
        try{
            invoicePayment = (InvoicePayment)mapper.readValue(node.get("invoicePayment").traverse(), (Class)InvoicePayment.class);
        }catch(Exception e){
            e.printStackTrace();
            invoicePayment = new InvoicePayment(null);
            invoicePayment.setPaymentId(paymentId);
        }
        return invoicePayment;
    }

    public static InvoicePayments invoicePaymentsFactory(final String invoicePaymentResponse) throws StreamReadException, IOException{
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(invoicePaymentResponse);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Object invoicePayments = mapper.readValue(node.get("invoicePayments").traverse(), (Class)Object.class);
        final List<InvoicePaymentPart> parsedInvoicePayments = (List<InvoicePaymentPart>)invoicePayments;
        final ArrayList<InvoicePaymentPart> paymentPartsObjs = new ArrayList<InvoicePaymentPart>();

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);
        
        //Creating List<Invoice> object to return
        for (Object invoicePayment : parsedInvoicePayments) {
            final InvoicePaymentPart pojo = (InvoicePaymentPart)mapper.convertValue((Object)invoicePayment, (Class)InvoicePaymentPart.class);
            paymentPartsObjs.add(pojo);
        }

        return new InvoicePayments(paymentPartsObjs, meta);
    }

    /**
     * InvoicePayment class' toString() method, returns a valid JSON String representation of this object
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
