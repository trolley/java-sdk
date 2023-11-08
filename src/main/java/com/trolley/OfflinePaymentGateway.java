package com.trolley;

import java.util.ArrayList;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.OfflinePayment;
import com.trolley.types.supporting.Meta;
import com.trolley.types.supporting.OfflinePayments;
import com.trolley.types.supporting.OfflinePaymentsIterator;

public class OfflinePaymentGateway
{
    Client client;
    
    public OfflinePaymentGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    /**
     * Create a new OfflinePayment
     * @param recipientId the id of the recipient for which this Offline Payment needs to be created
     * @param offlinePayment the request object
     * @return OfflinePayment object
     * @throws Exception
     */
    public OfflinePayment create(final String recipientId, final OfflinePayment offlinePayment) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("recipientId cannot be null or empty.");
        }
        if (offlinePayment == null) {
            throw new InvalidFieldException("OfflinePayment request object cannot be null or empty.");
        }
        String jsonRequest = new ObjectMapper()
                        .setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT)
                        .writeValueAsString((Object)offlinePayment);
        final String endPoint = "/v1/recipients/" + recipientId + "/offlinePayments/";
        final String response = this.client.post(endPoint, jsonRequest);
        return this.offlinePaymentFactory(response);
    }
    
    /**
     * Update an offline payment whose ID you provide.
     * @param recipientId the id of the recipient this offline payment is for.
     * @param offlinePaymentId the id of the offline payment you want to update.
     * @param offlinePayment the request body of the offline payment. Don't set the ID of the offline payment in the request object, provide it as an arguent to this method instead.
     * @return True if the update succeeded, an Exception otherwise.
     * @throws Exception
     */
    public boolean update(final String recipientId, final String offlinePaymentId, final OfflinePayment offlinePayment) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("recipientId cannot be null or empty.");
        }
        if (offlinePaymentId == null || offlinePaymentId.isEmpty()) {
            throw new InvalidFieldException("offlinePaymentId cannot be null or empty.");
        }
        if (offlinePayment == null) {
            throw new InvalidFieldException("offlinePayment request object cannot be null or empty.");
        }

        String jsonRequest = new ObjectMapper()
                        .setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT)
                        .writeValueAsString((Object)offlinePayment);

        final String endPoint = "/v1/recipients/" + recipientId + "/offlinePayments/" + offlinePaymentId;
        this.client.patch(endPoint, jsonRequest);
        return true;
    }
    
    /**
     * Delete an Offline Payment whose ID is provided
     * @param recipientId ID of the recipient whose Offline Payment which needs to be deleted.
     * @param offlinePaymentId ID of the Offline Payment which needs to be deleted.
     * @return True if the delete operation was successful, otherwise an Exception.
     * @throws Exception
     */
    public boolean delete(final String recipientId,final String offlinePaymentId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("recipientId cannot be null or empty.");
        }
        if (offlinePaymentId == null || offlinePaymentId.isEmpty()) {
            throw new InvalidFieldException("offlinePaymentId cannot be null or empty.");
        }

        final String endPoint = "/v1/recipients/" + recipientId + "/offlinePayments/" + offlinePaymentId;
        this.client.delete(endPoint);
        return true;
    }

    /**
     * List all OfflinePayments
     * This method returns an iterator which auto-paginate with 10 items per page.
     * If you want to paginate manually, please use the {@code listAllOfflinePayments(page, pageSize, searchTerm)} method.
     * @param searchTerm the search keyword to be searched for
     * @return OfflinePaymentsIterator which auto paginates through all available offline payments in the result set with 10 items per page.
     * @throws Exception
     */
    public OfflinePaymentsIterator listAllOfflinePayments(final String searchTerm) throws Exception {
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }
        int pageSize = 10;
        OfflinePayments p = listAllOfflinePayments(1, pageSize, searchTerm);
        return new OfflinePaymentsIterator(this, p, searchTerm);
    }

    public OfflinePaymentsIterator listAllOfflinePayments() throws Exception {
        return listAllOfflinePayments("");
    }
    
    /**
     * Get all OfflinePayments with manual pagination.
     * @param page which page number you want to access
     * @param pageSize number of items you want per page
     * @param searchTerm keyword to search for
     * @return {@code OfflinePayments} object, containing a {@code List<Payment>} object and a {@code Meta} object to access pagination information
     * @throws Exception
     */
    public OfflinePayments listAllOfflinePayments(final int page, final int pageSize, final String searchTerm) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("pageSize cannot be less than 0");
        }
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }
        final String endPoint = "/v1/offline-payments?search=" + searchTerm + "&page=" + page + "&pageSize=" + pageSize;
        final String response = this.client.get(endPoint);
        
        return this.offlinePaymentListFactory(response);
    }
    
    private OfflinePayment offlinePaymentFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        final OfflinePayment offlinePayment = (OfflinePayment)mapper.readValue(node.get("offlinePayment").traverse(), (Class)OfflinePayment.class);
        return offlinePayment;
    }
    
    public OfflinePayments offlinePaymentListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final List<OfflinePayment> paymentsFromResponse = (List<OfflinePayment>)mapper.readValue(node.get("offlinePayments").traverse(), (Class)Object.class);

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);

        final List<OfflinePayment> paymentObjs = new ArrayList<OfflinePayment>();
        for (int i = 0; i < paymentsFromResponse.size(); ++i) {
            final OfflinePayment pojo = (OfflinePayment)mapper.convertValue((Object)paymentsFromResponse.get(i), (Class)OfflinePayment.class);
            paymentObjs.add(pojo);
        }

        OfflinePayments offlinePayments = new OfflinePayments(paymentObjs, meta);
        return offlinePayments;
    }
}
