package com.trolley.trolley;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;

import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.List;

/**
 * <p>PaymentGateway class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class PaymentGateway {
    Client client;

    /**
     * <p>Constructor for PaymentGateway.</p>
     *
     * @param config a {@link com.trolley.trolley.Configuration} object.
     */
    public PaymentGateway(Configuration config) {
        this.client = new Client(config);
    }

    /**
     * <p>find.</p>
     *
     * @param payment_id a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.Payment} object.
     * @throws java.lang.Exception if any.
     */
    public Payment find(String payment_id, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = this.client.get(endPoint);
        return paymentFactory(response);
    }

    /**
     * <p>create.</p>
     *
     * @param body a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.Payment} object.
     * @throws java.lang.Exception if any.
     */
    public Payment create(String body, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id + "/payments";
        String response = this.client.post(endPoint, body);

        return paymentFactory(response);
    }

    /**
     * <p>update.</p>
     *
     * @param payment_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return a boolean.
     * @throws java.lang.Exception if any.
     */
    public boolean update(String payment_id, String body, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        this.client.patch(endPoint, body);
        return true;
    }

    /**
     * <p>delete.</p>
     *
     * @param payment_id a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return a boolean.
     * @throws java.lang.Exception if any.
     */
    public boolean delete(String payment_id, String batch_id) throws Exception {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }

        String endPoint = "/v1/batches/" + batch_id + "/payments/" + payment_id;
        this.client.delete(endPoint);
        return true;
    }

    /**
     * <p>query.</p>
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param page a int.
     * @param pageSize a int.
     * @param message a {@link java.lang.String} object.
     * @return a {@link java.util.List} object.
     * @throws java.lang.Exception if any.
     */
    public List<Payment> query(String batch_id, int page, int pageSize, String message) throws Exception {

        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less than 0");
        }
        if (message == null) {
            throw new InvalidFieldException("Message cannot be null");
        }

        String endPoint = "/v1/batches/" + batch_id + "/payments/?" + "&search=" + message + "&page=" + page
                + "&pageSize=" + pageSize;
        String response = this.client.get(endPoint);
        return paymentListFactory(response);
    }

    private Payment paymentFactory(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(data);
        Payment payment = mapper.readValue(node.get("payment").traverse(), Payment.class);
        return payment;
    }

    private List<Payment> paymentListFactory(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object payment = mapper.readValue(node.get("payments").traverse(), Object.class);
        @SuppressWarnings("unchecked")
        List<Payment> paymens = (List<Payment>) payment;
        List<Payment> payments = new ArrayList<Payment>();
        for (int i = 0; i < paymens.size(); i++) {
            Payment pojo = mapper.convertValue(paymens.get(i), Payment.class);
            payments.add(pojo);
        }

        return payments;
    }
}
