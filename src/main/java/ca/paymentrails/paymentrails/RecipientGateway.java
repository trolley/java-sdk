package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidFieldException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class RecipientGateway {

    Client client;

    public RecipientGateway(Configuration config) {
        this.client = new Client(config);
    }

    public Recipient find(String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }

        String endPoint = "/v1/recipients/" + recipient_id;
        String response = this.client.get(endPoint);
        return recipientFactory(response);
    }

    public String findLogs(String recipient_id) throws Exception {
        String endPoint = "/v1/recipients/" + recipient_id + "/logs";
        String response = this.client.get(endPoint);
        return response;
    }

    public List<Payment> findPayments(String recipient_id) throws Exception {
        String endPoint = "/v1/recipients/" + recipient_id + "/payments";
        String response = this.client.get(endPoint);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
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

    public Recipient create(String body) throws Exception {
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        String endPoint = "/v1/recipients/";
        String response = this.client.post(endPoint, body);
        return recipientFactory(response);
    }

    public boolean update(String recipient_id, String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }

        String endPoint = "/v1/recipients/" + recipient_id;
        this.client.patch(endPoint, body);
        return true;
    }

    public boolean delete(String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }

        String endPoint = "/v1/recipients/" + recipient_id;
        this.client.delete(endPoint);
        return true;
    }

    public List<Recipient> search(int page, int pageSize, String term) throws Exception {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less than 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less than 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }

        String endPoint = "/v1/recipients/?" + "&search=" + term + "&page=" + page + "&pageSize=" + pageSize;
        String response = this.client.get(endPoint);

        return recipientListFactory(response);
    }

    private Recipient recipientFactory(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(data);
        Recipient recipient = mapper.readValue(node.get("recipient").traverse(), Recipient.class);
        return recipient;
    }

    private List<Recipient> recipientListFactory(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(data);

        Object recipient = mapper.readValue(node.get("recipients").traverse(), Object.class);
        @SuppressWarnings("unchecked")
        List<Recipient> recips = (List<Recipient>) recipient;
        List<Recipient> recipients = new ArrayList<Recipient>();
        for (int i = 0; i < recips.size(); i++) {
            Recipient pojo = mapper.convertValue(recips.get(i), Recipient.class);
            recipients.add(pojo);
        }
        return recipients;
    }
}