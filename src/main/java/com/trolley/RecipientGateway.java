
package com.trolley;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.Log;
import com.trolley.types.Payment;
import com.trolley.types.Recipient;
import com.trolley.types.supporting.Logs;
import com.trolley.types.supporting.LogsIterator;
import com.trolley.types.supporting.Meta;
import com.trolley.types.supporting.OfflinePayments;
import com.trolley.types.supporting.OfflinePaymentsIterator;
import com.trolley.types.supporting.Recipients;
import com.trolley.types.supporting.RecipientsIterator;

public class RecipientGateway
{
    Client client;
    
    public RecipientGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    /**
     * Fetch a recipient by id.
     * @param recipientId
     * @return
     * @throws Exception
     */
    public Recipient find(final String recipientId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipientId;
        final String response = this.client.get(endPoint);
        return this.recipientFactory(response);
    }
    
    /**
     * Get all logs of the recipient, with manual pagination
     * @param recipientId
     * @param page
     * @param pageSize
     * @return {@code Logs} object, containing a {@code List<Log>} and a {@code Meta} object
     * @throws Exception
     */
    public Logs getAllLogs(final String recipientId, final int page, final int pageSize) throws Exception {
        if (recipientId == null) {
            throw new InvalidFieldException("recipientId cannot be null.");
        }

        final String endPoint = "/v1/recipients/" + recipientId + "/logs?page="+page+"&pageSize="+pageSize;
        final String response = this.client.get(endPoint);
        return logListFactory(response);
    }

    /**
     * Get all logs of the recipient, with auto-pagination and 10 items per page.
     * @param recipientId
     * @return {@code LogsIterator} object, containing a {@code List<Log>} and a {@code Meta} object, to iterate over all the pages automatically.
     * @throws Exception
     */
    public LogsIterator getAllLogs(final String recipientId) throws Exception {
        if (recipientId == null) {
            throw new InvalidFieldException("recipientId cannot be null.");
        }

        int pageSize = 10;
        Logs p = getAllLogs(recipientId, 1, pageSize);
        return new LogsIterator(this, p, recipientId);
    }
    
    /**
     * Get all payments of the recipient, whose id is provided.
     * @param recipientId
     * @return
     * @throws Exception
     */
    public List<Payment> findPayments(final String recipientId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipientId + "/payments";
        final String response = this.client.get(endPoint);
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(response);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Object payment = mapper.readValue(node.get("payments").traverse(), (Class)Object.class);
        final List<Payment> paymens = (List<Payment>)payment;
        final List<Payment> payments = new ArrayList<Payment>();
        for (int i = 0; i < paymens.size(); ++i) {
            final Payment pojo = (Payment)mapper.convertValue((Object)paymens.get(i), (Class)Payment.class);
            payments.add(pojo);
        }
        return payments;
    }
    
    public Recipient create(final Recipient recipient) throws Exception {
        if (recipient == null) {
            throw new InvalidFieldException("Recipient object cannot be null or empty");
        }
        final String jsonRecipient = new ObjectMapper()
                        .setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT)
                        .writeValueAsString((Object)recipient);
        final String endPoint = "/v1/recipients/";
        final String response = this.client.post(endPoint, jsonRecipient);
        return this.recipientFactory(response);
    }
    
    public boolean update(final String recipientId, final Recipient recipient) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (recipient == null) {
            throw new InvalidFieldException("Recipient object cannot be null or empty");
        }
        final String jsonRecipient = new ObjectMapper().writeValueAsString((Object)recipient);
        final String endPoint = "/v1/recipients/" + recipientId;
        this.client.patch(endPoint, jsonRecipient);
        return true;
    }
    
    public boolean delete(final String recipientId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipientId;
        this.client.delete(endPoint);
        return true;
    }

    /**
     * Delete multiple Recipients.
     * <p>You should pass a {@code List<Recipient>} object to this method, where each item of the list filled only with the ID of the recipient you want to delete.
     * <p>This method will serialize only the IDs.
     * @param recipients a List<Recipient> representing the batches that need to be deleted.
     * @return True if delete operation was successful
     * @throws Exception Thrown if the delete operation wasn't successful or if any other exception occurs.
     */
    public boolean delete(final List<Recipient> recipients) throws Exception {
        if (recipients == null || recipients.isEmpty()) {
            throw new InvalidFieldException("Recipient list cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/";

        String body = "{\"ids\" : [";
        
        for (int i = 0; i < recipients.size(); i++) {
            body+=new ObjectMapper().writeValueAsString(recipients.get(i).getId());
            if(i<(recipients.size()-1)){
                body+=",";
            }
        }

        body+="]}";
        this.client.delete(endPoint, body);

        return true;
    }

    /**
     * Get all offline payments of a recipient whose recipientId is provided.
     * This method returns an iterator which iterates through the pages automatically.
     * If you want to paginate manually, please use {@code getAllOfflinePayments(recipientId, page, pageSize, searchTerm)} instead.
     * @param recipientId id of the recipient whose offline payments need to be fetched
     * @param searchTerm any search term you want to include. Please provide an empty string in case you don't want to.
     * @return
     * @throws Exception
     */
    public OfflinePaymentsIterator getAllOfflinePayments(final String recipientId, final String searchTerm) throws Exception{
        if (recipientId == null) {
            throw new InvalidFieldException("recipientId cannot be null.");
        }
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }

        int pageSize = 10;
        OfflinePayments p = getAllOfflinePayments(recipientId, 1, pageSize, searchTerm);
        return new OfflinePaymentsIterator(this, p, searchTerm, recipientId);
    }

     public OfflinePayments getAllOfflinePayments(final String recipientId, final int page, final int pageSize, final String searchTerm) throws Exception{
        if (recipientId == null) {
            throw new InvalidFieldException("recipientId cannot be null.");
        }
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }

        final String endPoint = "/v1/recipients/" + recipientId + "/offlinePayments?search=" + searchTerm + "&page=" + page + "&pageSize=" + pageSize;
        
        final String response = this.client.get(endPoint);
        
        OfflinePaymentGateway opGateway = new OfflinePaymentGateway(null);
        return opGateway.offlinePaymentListFactory(response);
    }

    /**
     * Search for Recipients.
     * This method returns an iterator which auto-paginate with 10 items per page.
     * If you want to paginate manually, please use the {@code search(page, pageSize, searchTerm)} method
     * @param searchTerm the search keyword to be searched for
     * @return RecipientsIterator which auto paginates through all available payments 10 items per page
     * @throws Exception
     */
    public RecipientsIterator search(final String searchTerm) throws Exception {
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }
        int pageSize = 10;
        Recipients r = search(1, pageSize, searchTerm);
        return new RecipientsIterator(this, r, searchTerm);
    }
    
    /**
     * Search for Recipients with manual pagination.
     * @param page which page number you want to access
     * @param pageSize number of items you want per page
     * @param searchTerm keyword to search for
     * @return {@code Recipients} object, containing a {@code List<Recipient>} object and a {@code Meta} object to access pagination information
     * @throws Exception
     */
    public Recipients search(final int page, final int pageSize, final String searchTerm) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("page cannot be less than 0.");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("pageSize cannot be less than 0.");
        }
        if (searchTerm == null) {
            throw new InvalidFieldException("searchTerm cannot be null. If you don't wish to provide a searchTerm, pass a blank String.");
        }
        try{
        final String endPoint = "/v1/recipients/?&search=" + searchTerm + "&page=" + page + "&pageSize=" + pageSize;
        final String response = this.client.get(endPoint);

        return this.recipientListFactory(response);

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private Recipient recipientFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        final Recipient recipient = (Recipient)mapper.readValue(node.get("recipient").traverse(), (Class)Recipient.class);
        return recipient;
    }
    
    private Logs logListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        
        final List<Log> logsFromResponse = (List<Log>)mapper.readValue(node.get("recipientLogs").traverse(), (Class)Object.class);

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);

        final Logs logs = new Logs(new ArrayList<Log>(), meta);
        
        for (int i = 0; i < logsFromResponse.size(); ++i) {
            final Log pojo = (Log)mapper.convertValue((Object)logsFromResponse.get(i), (Class)Log.class);
            logs.getLogs().add(pojo);
        }

        return logs;
    }

    private Recipients recipientListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        
        final List<Recipient> recips = (List<Recipient>)mapper.readValue(node.get("recipients").traverse(), (Class)Object.class);

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);

        final Recipients recipients = new Recipients(new ArrayList<Recipient>(), meta);
        
        for (int i = 0; i < recips.size(); ++i) {
            final Recipient pojo = (Recipient)mapper.convertValue((Object)recips.get(i), (Class)Recipient.class);
            recipients.getRecipients().add(pojo);
        }

        return recipients;
    }
}
