
package com.trolley;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.Payment;
import com.trolley.types.Recipient;
import com.trolley.types.supporting.Meta;
import com.trolley.types.supporting.Recipients;
import com.trolley.types.supporting.RecipientsIterator;

public class RecipientGateway
{
    Client client;
    
    public RecipientGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    public Recipient find(final String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipient_id;
        final String response = this.client.get(endPoint);
        return this.recipientFactory(response);
    }
    
    public String findLogs(final String recipient_id) throws Exception {
        final String endPoint = "/v1/recipients/" + recipient_id + "/logs";
        final String response = this.client.get(endPoint);
        return response;
    }
    
    public List<Payment> findPayments(final String recipient_id) throws Exception {
        final String endPoint = "/v1/recipients/" + recipient_id + "/payments";
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
    
    public Recipient create(final String body) throws Exception {
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        final String endPoint = "/v1/recipients/";
        final String response = this.client.post(endPoint, body);
        return this.recipientFactory(response);
    }
    
    public Recipient create(final Recipient recipient) throws Exception {
        if (recipient == null) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        final String jsonRecipient = new ObjectMapper().writeValueAsString((Object)recipient);
        final String endPoint = "/v1/recipients/";
        final String response = this.client.post(endPoint, jsonRecipient);
        return this.recipientFactory(response);
    }
    
    public boolean update(final String recipient_id, final String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        final String endPoint = "/v1/recipients/" + recipient_id;
        this.client.patch(endPoint, body);
        return true;
    }
    
    public boolean update(final String recipient_id, final Recipient recipient) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (recipient == null) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        final String jsonRecipient = new ObjectMapper().writeValueAsString((Object)recipient);
        final String endPoint = "/v1/recipients/" + recipient_id;
        this.client.patch(endPoint, jsonRecipient);
        return true;
    }
    
    public boolean delete(final String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipient_id;
        this.client.delete(endPoint);
        return true;
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
    
    private Recipients recipientListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        
        final List<Recipient> recips = (List<Recipient>)mapper.readValue(node.get("recipients").traverse(), (Class)Object.class);

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);

        final Recipients recipients = new Recipients(new ArrayList<Recipient>(), meta);
        
        for (int i = 0; i < recips.size(); ++i) {
            final Recipient pojo = (Recipient)mapper.convertValue((Object)recips.get(i), (Class)Recipient.class);
            // recipients.add(pojo);
            recipients.getRecipients().add(pojo);
        }

        return recipients;
    }
}
