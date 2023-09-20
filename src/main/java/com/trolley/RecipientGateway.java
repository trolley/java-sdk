
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
    
    public List<Recipient> search(final int page, final int pageSize, final String term) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less than 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        final String endPoint = "/v1/recipients/?&search=" + term + "&page=" + page + "&pageSize=" + pageSize;
        final String response = this.client.get(endPoint);
        return this.recipientListFactory(response);
    }
    
    private Recipient recipientFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        final Recipient recipient = (Recipient)mapper.readValue(node.get("recipient").traverse(), (Class)Recipient.class);
        return recipient;
    }
    
    private List<Recipient> recipientListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        final Object recipient = mapper.readValue(node.get("recipients").traverse(), (Class)Object.class);
        final List<Recipient> recips = (List<Recipient>)recipient;
        final List<Recipient> recipients = new ArrayList<Recipient>();
        for (int i = 0; i < recips.size(); ++i) {
            final Recipient pojo = (Recipient)mapper.convertValue((Object)recips.get(i), (Class)Recipient.class);
            recipients.add(pojo);
        }
        return recipients;
    }
}
