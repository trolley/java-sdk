package com.trolley;

import java.util.ArrayList;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.Payment;
import com.trolley.types.supporting.Meta;
import com.trolley.types.supporting.Payments;
import com.trolley.types.supporting.PaymentsIterator;

public class PaymentGateway
{
    Client client;
    
    public PaymentGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    public Payment find(final String payment_id, final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        final String response = this.client.get(endPoint);
        return this.paymentFactory(response);
    }
    
    public Payment create(final String body, final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/payments";
        final String response = this.client.post(endPoint, body);
        return this.paymentFactory(response);
    }
    
    public boolean update(final String payment_id, final String body, final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        this.client.patch(endPoint, body);
        return true;
    }
    
    public boolean delete(final String payment_id, final String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        final String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        this.client.delete(endPoint);
        return true;
    }

    public PaymentsIterator search(final String batchId, final String searchTerm) throws Exception {
        if (searchTerm == null) {
            throw new InvalidFieldException("Search Term cannot be null");
        }
        int pageSize = 10;
        Payments p = search_by_page(batchId, 1, pageSize, searchTerm);
        return new PaymentsIterator(this, p, batchId, searchTerm);
    }
    
    public Payments search_by_page(final String batchId, final int page, final int pageSize, final String searchTerm) throws Exception {
        if (batchId == null || batchId.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less than 0");
        }
        if (searchTerm == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        final String endPoint = "/v1/batches/" + batchId + "/payments/?&search=" + searchTerm + "&page=" + page + "&pageSize=" + pageSize;
        final String response = this.client.get(endPoint);
        
        return this.paymentListFactory(response);
    }
    
    private Payment paymentFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final JsonNode node = mapper.readTree(data);
        final Payment payment = (Payment)mapper.readValue(node.get("payment").traverse(), (Class)Payment.class);
        return payment;
    }
    
    private Payments paymentListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final List<Payment> paymentsFromResponse = (List<Payment>)mapper.readValue(node.get("payments").traverse(), (Class)Object.class);

        final Meta meta = (Meta)mapper.readValue(node.get("meta").traverse(), (Class)Meta.class);

        final List<Payment> paymentObjs = new ArrayList<Payment>();
        for (int i = 0; i < paymentsFromResponse.size(); ++i) {
            final Payment pojo = (Payment)mapper.convertValue((Object)paymentsFromResponse.get(i), (Class)Payment.class);
            paymentObjs.add(pojo);
        }

        Payments payments = new Payments(paymentObjs, meta);
        return payments;
    }
}