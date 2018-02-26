package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidFieldException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.List;

public class RecipientAccountGateway {

    Client client;

    public RecipientAccountGateway(Configuration config) {
        this.client = new Client(config);
    }

    public List<RecipientAccount> findAll(String recipient_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        // Client client = Client.create();
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts";
        String response = this.client.get(endPoint);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object recipientAccount = mapper.readValue(node.get("accounts").traverse(), Object.class);
        @SuppressWarnings("unchecked")
        List<RecipientAccount> recipAccounts = (List<RecipientAccount>) recipientAccount;
        List<RecipientAccount> recipientAccounts = new ArrayList<RecipientAccount>();
        for (int i = 0; i < recipAccounts.size(); i++) {
            RecipientAccount pojo = mapper.convertValue(recipAccounts.get(i), RecipientAccount.class);
            recipientAccounts.add(pojo);
        }
        return recipientAccounts;
    }

    public RecipientAccount find(String recipient_id, String recipient_account_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts/" + recipient_account_id;
        String response = this.client.get(endPoint);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        RecipientAccount recipientAccount = mapper.readValue(node.get("account").traverse(), RecipientAccount.class);
        return recipientAccount;
    }

    public RecipientAccount create(String recipient_id, String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts";
        String response = this.client.post(endPoint,body);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        RecipientAccount recipientAccount = mapper.readValue(node.get("account").traverse(), RecipientAccount.class);
        return recipientAccount;
    }

    public RecipientAccount update(String recipient_id, String recipient_account_id, String body) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts/" + recipient_account_id;
        String response = this.client.patch(endPoint, body);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        RecipientAccount recipientAccount = mapper.readValue(node.get("account").traverse(), RecipientAccount.class);
        return recipientAccount;
    }

    public boolean delete(String recipient_id, String recipient_account_id) throws Exception {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        
        String endPoint = "/v1/recipients/" + recipient_id + "/accounts/" + recipient_account_id;
        this.client.delete(endPoint);
        return true;
    }

}