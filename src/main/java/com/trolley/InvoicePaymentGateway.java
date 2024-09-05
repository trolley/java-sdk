package com.trolley;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.InvoicePayment;
import com.trolley.types.supporting.InvoicePaymentRequest;
import com.trolley.types.supporting.InvoicePaymentPart;
import com.trolley.types.supporting.InvoicePayments;
import com.trolley.types.supporting.InvoicePaymentsIterator;

public class InvoicePaymentGateway
{
    Client client;
    
    public InvoicePaymentGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    /**
     * Create a payment against an invoice.
     * <p>
     * NOTE: If you provide a batch id, this method will try to add the payment to it. If you provide a 
     * {@code null} or blank ({@code ""}) batch id, a new batch will be created.
     *
     * @deprecated As of v2.0.1, this method is deprecated to support improvements to Create InvoicePayment API. Use {@link InvoicePaymentGateway#create(InvoicePaymentRequest) create(InvoicePaymentRequest)} instead.
     * 
     * @param batchId (Optional) Id of the batch you want to add these payments too.
     * @param payment InvoicePaymentPart object representing the Invoice payment that needs to be created
     * @return InvoicePayment object of representing the created payment for the Invoice
     * @throws Exception
     */
    @Deprecated
    public InvoicePayment create(final String batchId, final InvoicePaymentPart payment) throws Exception {
        final String endPoint = "/v1/invoices/payment/create/";

        String body = "";

        if(null != batchId && !batchId.isEmpty()){
            body = "{ \"batchId\": \"" + batchId + "\",";
        }else{
            body = "{";
        }
        ArrayList<InvoicePaymentPart> invoicePaymentParts = new ArrayList<InvoicePaymentPart>() {
            {
                add(payment);
            }
        };

        body+= "\"ids\":" +new ObjectMapper()
                            .setSerializationInclusion(Include.NON_EMPTY)
                            .writeValueAsString(invoicePaymentParts)
                +"}";
        final String response = this.client.post(endPoint, body);
        return InvoicePayment.invoicePaymentFactory(response);
    }

    /**
     * Create a payment against multiple invoices.
     * <p>
     * NOTE: If you provide a batch id, this method will try to add the payment to it. If you provide a 
     * {@code null} or blank ({@code ""}) batch id, a new batch will be created. 
     * 
     * @deprecated As of v2.0.1, this method is deprecated to support improvements to Create InvoicePayment API. Use {@link InvoicePaymentGateway#create(InvoicePaymentRequest) create(InvoicePaymentRequest)} instead.
     * 
     * @param batchId (Optional) Id of the batch you want to add these payments too.
     * @param invoicePaymentParts A List of InvoicePaymentPart objects representing the Invoice payments that need to be created.
     * @return InvoicePayment object of representing the created payment for the Invoice
     * @throws Exception
     */
    @Deprecated
    public InvoicePayment create(final String batchId, final List<InvoicePaymentPart> invoicePaymentParts) throws Exception {
        final String endPoint = "/v1/invoices/payment/create/";

        String body = "";

        if(null != batchId && !batchId.isEmpty()){
            body = "{ \"batchId\": \"" + batchId + "\",";
        }else{
            body = "{";
        }

        body+= "\"ids\":" +new ObjectMapper()
                            .setSerializationInclusion(Include.NON_EMPTY)
                            .writeValueAsString(invoicePaymentParts)
                +"}";
        final String response = this.client.post(endPoint, body);
        return InvoicePayment.invoicePaymentFactory(response);
    }
    
    /**
     * Create a payment against an invoice, with payment fields.
     * <p>
     * NOTE: If you provide a batch id, this method will try to add the payment to it. If you provide a 
     * {@code null} or blank ({@code ""}) batch id, a new batch will be created.
     *
     * @param invoicePaymentRequest {@code InvoicePaymentRequest} object representing the InvoicePayment request, with payment fields that needs to be added to the created payment.
     * @return InvoicePayment object of representing the created payment for the Invoice
     * @throws Exception
     */
    public InvoicePayment create(final InvoicePaymentRequest invoicePaymentRequest) throws Exception {
        final String endPoint = "/v1/invoices/payment/create/";

        String body= new ObjectMapper()
                    .setSerializationInclusion(Include.NON_EMPTY)
                    .writeValueAsString(invoicePaymentRequest);

        final String response = this.client.post(endPoint, body);
        return InvoicePayment.invoicePaymentFactory(response);
    }
    
   /**
    * Update an Invoice Payment whose details are provided in invoicePaymentPart object.
    * <p>
    * Refer to our <a href="https://docs.trolley.com/api/#update-an-invoice-payment">docs</a> for details 
    * about which parameters are required.
    * @param invoicePaymentPart
    * @return boolean true if the update was successful
    * @throws Exception
    */
    public boolean update(final InvoicePaymentPart invoicePaymentPart) throws Exception {
        final String endPoint = "/v1/invoices/payment/update/";

        final String body = new ObjectMapper()
                            .setSerializationInclusion(Include.NON_EMPTY)
                            .writeValueAsString(invoicePaymentPart);

        final String response = this.client.post(endPoint, body);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }

    /**
     * Search for invoice payments matching the list of paymentIds and invoiceIds provided.
     * <p>
     * Either {@code paymentIds} or {@code invoiceIds} is required. <p>
     * This method returns an iterator using which you can auto-paginate through all available pages with 10 items per page.
     * @param paymentIds
     * @param invoiceIds
     * @return InvoicePaymentsIterator to auto-paginate
     * @throws Exception
     */
    public InvoicePaymentsIterator search(final List<String> paymentIds, final List<String> invoiceIds) throws Exception {

        if(null == invoiceIds && null == paymentIds){
            throw new InvalidFieldException("Either Invoice IDs or Payment IDs should be present");
        }

        InvoicePayments ip = search(paymentIds, invoiceIds, 1, 10);

        return new InvoicePaymentsIterator(this, ip, paymentIds, invoiceIds);
    }

    /**
     * Search for invoice payments matching the list of paymentIds and invoiceIds provided.
     * <p>
     * Either {@code paymentIds} or {@code invoiceIds} is required. <p>
     * This method also allows you to paginate manually by providing {@code page} and {@code pageSize} arguments.
     * @param paymentIds
     * @param invoiceIds
     * @param page
     * @param pageSize
     * @return InvoicePayments object containing a list of found InvoicePaymentParts and Meta object for 
     * pagination information
     * @throws Exception
     */
    public InvoicePayments search(final List<String> paymentIds, final List<String> invoiceIds, final int page, final int pageSize) throws Exception {
        final String endPoint = "/v1/invoices/payment/search/";

        String body = "{";
        if(null != paymentIds && !paymentIds.isEmpty()){
            body+= "\"paymentIds\":"  + new ObjectMapper()
                                            .setSerializationInclusion(Include.NON_EMPTY)
                                            .writeValueAsString(paymentIds);
        }

        if(null != invoiceIds && !invoiceIds.isEmpty()){
            if(null != paymentIds && !paymentIds.isEmpty()){
                body+=",";
            }
            body+="\"invoiceIds\":"  + new ObjectMapper()
                                        .setSerializationInclusion(Include.NON_EMPTY)
                                        .writeValueAsString(invoiceIds);
        }
        body+= ", \"page\":" + page;
        body+= ", \"pageSize\":" + pageSize;
        
        body+= "}";

        final String response = this.client.post(endPoint, body);

        return InvoicePayment.invoicePaymentsFactory(response);
    }
    
    /**
     * Remove the association between a payment and an invoice line ID.
     * @param paymentId payment id to delete
     * @param invoiceLineId
     * @return boolean true if the delete operation was successful
     * @throws Exception
     */
    public boolean delete(final String paymentId, final String invoiceLineId) throws Exception {
        final String endPoint = "/v1/invoices/payment/delete/";
        
        ArrayList<String> invoiceLineIds = new ArrayList<String>() {
            {
                add(invoiceLineId);
            }
        };

        final String body = "{"
                +"\"paymentId\":\""+paymentId+"\","
                +"\"invoiceLineIds\":"+new ObjectMapper().writeValueAsString(invoiceLineIds)
            +"}";

        final String response = this.client.post(endPoint, body);
        
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }

    /**
     * Remove the association between a payment and multiple invoice line IDs.
     * @param paymentId payment id to delete
     * @param invoiceLineIds a {@code List<String>} of invoiceLineIds
     * @return
     * @throws Exception
     */
    public boolean delete(final String paymentId, final List<String> invoiceLineIds) throws Exception {
        final String endPoint = "/v1/invoices/payment/delete/";

        final String body = "{"
                +"\"paymentId\":\""+paymentId+"\","
                +"\"invoiceLineIds\":"+new ObjectMapper().writeValueAsString(invoiceLineIds)
            +"}";

        final String response = this.client.post(endPoint, body);
        
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }
}
