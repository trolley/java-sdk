package com.trolley.trolley;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;

public class InvoiceLineGateway
{
    Client client;
    
    public InvoiceLineGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    /**
     * Create a single Invoice Line and add it to the Invoice whose ID is supplied. <br/>
     * 
     * @param invoiceId Id of the invoice where this line will be added
     * @param invoiceLine InvoiceLine object which will be created
     * @return Invoice object of the updated invoice containing the newly created line
     * @throws Exception
     */
    public Invoice create(final String invoiceId, final InvoiceLine invoiceLine) throws Exception {
        final String endPoint = "/v1/invoices/create-lines/";
        ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>() {
            {
                add(invoiceLine);
            }
        };

        final String body = "{"
                +"\"invoiceId\":\"" +invoiceId+"\","
                +"\"lines\":"       +new ObjectMapper()
                                            .setSerializationInclusion(Include.NON_EMPTY)
                                            .writeValueAsString(invoiceLines)
            +"}";
        System.out.println("__REQUEST__ "+body);
        final String response = this.client.post(endPoint, body);
        return InvoiceLine.invoiceLinesFactory(response);
    }

    /**
     * Create multiple Invoice Lines and adds them to the Invoice whose ID is supplied. <br/>
     * @param invoiceId Id of the invoice where this line will be added
     * @param invoiceLines List<InvoiceLine> object represnting the lines which will be created
     * @return Invoice object of the updated invoice containing these lines
     * @throws Exception
     */
    public Invoice create(final String invoiceId, final List<InvoiceLine> invoiceLines) throws Exception {
        final String endPoint = "/v1/invoices/create-lines/";

        final String body = "{"
                +"\"invoiceId\":\"" +invoiceId+"\","
                +"\"lines\":"       +new ObjectMapper()
                                        .setSerializationInclusion(Include.NON_EMPTY)
                                        .writeValueAsString(invoiceLines)
            +"}";

        final String response = this.client.post(endPoint, body);
        return InvoiceLine.invoiceLinesFactory(response);
    }
    
   /**
     * Update a single Invoice Line in an Invoice whose ID is supplied. <br/>
     * <p>
     * NOTE: Make sure you set the <code>invoiceLineId</code> variable of the <code>invoiceLine</code> 
     * object supplied as parameter here. Not the <code>id</code>.
     * 
     * @param invoiceId Id of the invoice where this line will be added
     * @param invoiceLine InvoiceLine object which will be update
     * @return Invoice object of the updated invoice containing the updated line
     * @throws Exception
     */
    public Invoice update(final String invoiceId, final InvoiceLine invoiceLine) throws Exception {
        final String endPoint = "/v1/invoices/update-lines/";
        
        if( null == invoiceLine.getInvoiceLineId() || 
            invoiceLine.getInvoiceLineId().length() == 0){
                throw new InvalidFieldException("invoiceLineId of invoiceLine object must be set to denote which invoiceLine needs to be updated. Did you set id variable instead? Refer to method's Javadoc for more details.");
        }

        ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>() {
            {
                add(invoiceLine);
            }
        };

        final String body = "{"
                +"\"invoiceId\":\"" +invoiceId+"\","
                +"\"lines\" :"      +new ObjectMapper()
                                        .setSerializationInclusion(Include.NON_EMPTY)
                                        .writeValueAsString(invoiceLines)
            +"}";

        final String response = this.client.post(endPoint, body);
        return InvoiceLine.invoiceLinesFactory(response);
    }

    /**
     * Update multiple Invoice Lines in an Invoice whose ID is supplied. <br/>
     * <p>
     * NOTE: Make sure you set the <code>invoiceLineId</code> variable in all the objects supplied 
     * in the <code>invoiceLines</code> parameter.
     * @param invoiceId Id of the invoice where this line will be added
     * @param invoiceLines List<InvoiceLine> object representing the lines which will be edited
     * @return Invoice object of the updated invoice containing these lines
     * @throws Exception
     */
    public Invoice update(final String invoiceId, final List<InvoiceLine> invoiceLines) throws Exception {
        final String endPoint = "/v1/invoices/update-lines/";

        for (InvoiceLine invoiceLine : invoiceLines) {
            if( null == invoiceLine.getInvoiceLineId() || 
                invoiceLine.getInvoiceLineId().length() == 0){
                    throw new InvalidFieldException("invoiceLineId of invoiceLine object must be set to denote which invoiceLine needs to be updated. Please confirm all of the items have this set correctly. Refer to method's Javadoc for more details.");
            }
        }

        final String body = "{"
                +"\"invoiceId\":\"" +invoiceId+"\","
                +"\"lines\":"       +new ObjectMapper()
                                        .setSerializationInclusion(Include.NON_EMPTY)
                                        .writeValueAsString(invoiceLines)
            +"}";

        final String response = this.client.post(endPoint, body);
        return InvoiceLine.invoiceLinesFactory(response);
    }
    
    /**
     * Delete one invoice line by its ID
     * @param invoiceId ID of the invoice from where this line needs to be deleted
     * @param invoiceLineId ID of the invoice line which needs to be deleted
     * @return boolean true if the delete operation was successful
     * @throws Exception
     */
    public boolean delete(final String invoiceId, final String invoiceLineId) throws Exception {
        final String endPoint = "/v1/invoices/delete-lines/";
        
        ArrayList<String> invoiceLineIds = new ArrayList<String>() {
            {
                add(invoiceLineId);
            }
        };

        final String body = "{"
                +"\"invoiceId\":\""+invoiceId+"\","
                +"\"invoiceLineIds\":"+new ObjectMapper().writeValueAsString(invoiceLineIds)
            +"}";

        final String response = this.client.post(endPoint, body);
        
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }

    /**
     * Delete multiple invoices whose ID is provided as a List
     * @param invoiceId
     * @return boolean true if the delete operation was successful
     * @throws Exception
     */
    public boolean delete(final String invoiceId, final List<String> invoiceLineIds) throws Exception {
        final String endPoint = "/v1/invoices/delete-lines/";

        final String body = "{"
                +"\"invoiceId\":\""     +invoiceId+"\","
                +"\"invoiceLineIds\":"  +new ObjectMapper().writeValueAsString(invoiceLineIds)
            +"}";

        final String response = this.client.post(endPoint, body);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }
}
