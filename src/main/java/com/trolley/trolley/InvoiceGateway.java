package com.trolley.trolley;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.trolley.Invoice.SearchBy;
import com.trolley.trolley.types.Invoices;

public class InvoiceGateway
{
    Client client;
    
    public InvoiceGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    /**
     * Create a new invoice with data provided by the invoice object
     * @param invoiceBody
     * @return Invoice created invoice
     * @throws Exception
     */
    public Invoice create(final Invoice invoiceBody) throws Exception {
        String body = invoiceBody.toString();
        
        final String endPoint = "/v1/invoices/create/";
        final String response = this.client.post(endPoint, body);
        return Invoice.invoiceFactory(response);
    }
    
    /**
     * Update the invoice represented by the given invoiceId with data found in 
     * invoiceBody object supplied.
     * Only the fields that you send will be updated.
     * @param invoiceId
     * @param invoiceBody
     * @return Invoice updated invoice
     * @throws Exception
     */
    public Invoice update(final String invoiceId, final Invoice invoiceBody) throws Exception {
        invoiceBody.setInvoiceId(invoiceId);
        String body = invoiceBody.toString();

        final String endPoint = "/v1/invoices/update/";
        final String response = this.client.post(endPoint, body);

        return Invoice.invoiceFactory(response);
    }
    
    /**
     * Delete one invoice by its ID
     * @param invoiceId
     * @return boolean true if the delete operation was successful
     * @throws Exception
     */
    public boolean delete(final String invoiceId) throws Exception {
        final String endPoint = "/v1/invoices/delete/";
        
        ArrayList<String> invoiceIds = new ArrayList<String>() {
            {
                add(invoiceId);
            }
        };

        final String body = "{\"invoiceIds\":"
                +new ObjectMapper().writeValueAsString(invoiceIds)
            +"}";

        final String response = this.client.post(endPoint, body);
        
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }

    /**
     * Delete multiple invoices whose ID is provided as a List
     * @param invoiceIds
     * @return boolean true if the delete operation was successful
     * @throws Exception
     */
    public boolean delete(final List<String> invoiceIds) throws Exception {
        final String endPoint = "/v1/invoices/delete/";

        final String body = "{\"invoiceIds\":"
                +new ObjectMapper()
                    .setSerializationInclusion(Include.NON_EMPTY)
                    .writeValueAsString(invoiceIds)
            +"}";

        final String response = this.client.post(endPoint, body);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(response);
        return node.get("ok").asBoolean(false);
    }
    
    /**
     * Fetch an invoice by invoiceId
     * @param invoiceId
     * @return Invoice The invoice that was fetched
     * @throws Exception
     */
    public Invoice fetch(final String invoiceId) throws Exception {
        final String endPoint = "/v1/invoices/get/";
        final String body = "{\"invoiceId\":\""+invoiceId+"\"}";
        final String response = this.client.post(endPoint, body);
        return Invoice.invoiceFactory(response);
    }

    /**
     * Search invoices by multiple options such as by invoiceId, recipientId etc.
     * Note: This method only returns the fist page, defaulting to 10 records per page.
     * For pagination, look at {@code search(SearchBy searchBy, List<String> paramsList, String param, int page, int pageSize)} below.
     * 
     * Depending on what you want to search by, you'll either provide a {@code List<String>} parameter, or a
     * String parameter. Details about when to provide which parameter are given in the parameter
     * list. 
     * These options correspond to our documentation.
     * @param searchBy Enum of type Invoice.SearchBy denoting which field you want to search by
     * @param paramsList {@code List<String>} Required if 'searchBy' is either of these: 'invoiceId'
     * 'recipientId', 'invoiceNumber', 'tags', or 'externalId'. Set to 'null' otherwise.
     * @param param String Required if 'searchBy' is 'invoiceDate'. Set to null otherwise.
     * @return {@code List<Invoice>}
     * @throws Exception
     */
    
    public List<Invoice> search(final SearchBy searchBy, 
        final List<String> paramsList,
        final String param) throws Exception {

        String body = "";

        switch (searchBy){
            case INVOICE_ID:
            case RECIPIENT_ID:
            case INVOICE_NUMBER:
            case EXTERNAL_ID:
            case TAGS:
                if(null == paramsList){
                    throw new InvalidFieldException("variable paramsList can not be null for the provided searchBy parameter. Refer to method's Javadoc for more details.");
                }
                body = "{\""+searchBy.getKey()+"\":"
                    +new ObjectMapper()
                        .setSerializationInclusion(Include.NON_EMPTY)
                        .writeValueAsString(paramsList)
                +"}";
                break;

            case INVOICE_DATE:
                if(null == param){
                    throw new InvalidFieldException("variable param can not be null for the provided searchBy parameter. Refer to method's Javadoc for more details.");
                }
                body = "{\""+searchBy.getKey()+"\":\""+param+"\"}";
                break;
        }
        final String endPoint = "/v1/invoices/search/";

        final String response = this.client.post(endPoint, body);

        return Invoice.invoiceListFactory(response).getInvoices();        
    }

    /**
     * Search invoices by multiple options such as by invoiceId, recipientId etc.
     * Note: This method supports pagination.
     * Depending on what you want to search by, you'll either provide a {@code List<String>} parameter, or a
     * String parameter. Details about when to provide which parameter are given in the parameter
     * list. 
     * These options correspond to our documentation.
     * @param searchBy Enum of type Invoice.SearchBy denoting which field you want to search by
     * @param paramsList {@code List<String>} Required if 'searchBy' is either of these: 'invoiceId'
     * 'recipientId', 'invoiceNumber', 'tags', or 'externalId'. Set to 'null' otherwise.
     * @param param String Required if 'searchBy' is 'invoiceDate'. Set to null otherwise.
     * @return Invoices object that contains {@code List<Invoice>} that you can traverse through, and a Meta object with pagination information
     * @throws Exception
     */
    
     public Invoices search(final SearchBy searchBy, 
        final List<String> paramsList,
        final String param,
        final int page,
        final int pageSize ) throws Exception {

     String body = "";

     switch (searchBy){
        case INVOICE_ID:
        case RECIPIENT_ID:
        case INVOICE_NUMBER:
        case TAGS:
             if(null == paramsList){
                 throw new InvalidFieldException("variable paramsList can not be null for the provided searchBy parameter. Refer to method's Javadoc for more details.");
             }
             body = "{\""+searchBy.getKey()+"\":"
                 +new ObjectMapper()
                    .setSerializationInclusion(Include.NON_EMPTY)
                    .writeValueAsString(paramsList)
                 +", \"page\":"+page
                 +", \"pageSize\":"+pageSize
             +"}";
             break;

        case INVOICE_DATE:
        case EXTERNAL_ID:
             if(null == param){
                 throw new InvalidFieldException("variable param can not be null for the provided searchBy parameter. Refer to method's Javadoc for more details.");
             }
             body = "{\""+searchBy.getKey()+"\":\""+param+"\"}";
             break;
     }
     final String endPoint = "/v1/invoices/search/";

     final String response = this.client.post(endPoint, body);
     return Invoice.invoiceListFactory(response);
     
 }

}
