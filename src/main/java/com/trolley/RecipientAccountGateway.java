
package com.trolley;

import java.util.ArrayList;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.RecipientAccount;

import java.util.List;

public class RecipientAccountGateway
{
    Client client;
    
    public RecipientAccountGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    public List<RecipientAccount> findAll(final String recipientId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipientId + "/accounts";
        final String response = this.client.get(endPoint);
        return this.recipientAccountListFactory(response);
    }
    
    public RecipientAccount find(final String recipientId, final String recipientAccountId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipientId + "/accounts/" + recipientAccountId;
        final String response = this.client.get(endPoint);
        return this.recipientAccountFactory(response);
    }
    
    public RecipientAccount create(final String recipientId, final RecipientAccount account) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (account == null) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        final String jsonAccount = new ObjectMapper()
                    .setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT)
                    .writeValueAsString((Object)account);
        final String endPoint = "/v1/recipients/" + recipientId + "/accounts";
        final String response = this.client.post(endPoint, jsonAccount);
        return this.recipientAccountFactory(response);
    }
    
    public RecipientAccount update(final String recipientId, final String recipientAccountId, final RecipientAccount account) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (account == null) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        final String jsonAccount = new ObjectMapper()
                    .setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT)
                    .writeValueAsString((Object)account);
        final String endPoint = "/v1/recipients/" + recipientId + "/accounts/" + recipientAccountId;
        final String response = this.client.patch(endPoint, jsonAccount);
        return this.recipientAccountFactory(response);
    }
    
    public boolean delete(final String recipientId, final String recipientAccountId) throws Exception {
        if (recipientId == null || recipientId.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        final String endPoint = "/v1/recipients/" + recipientId + "/accounts/" + recipientAccountId;
        this.client.delete(endPoint);
        return true;
    }
    
    private RecipientAccount recipientAccountFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final RecipientAccount recipientAccount = (RecipientAccount)mapper.readValue(node.get("account").traverse(), (Class)RecipientAccount.class);
        return recipientAccount;
    }
    
    private List<RecipientAccount> recipientAccountListFactory(final String data) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Object recipientAccount = mapper.readValue(node.get("accounts").traverse(), (Class)Object.class);
        final List<RecipientAccount> recipAccounts = (List<RecipientAccount>)recipientAccount;
        final List<RecipientAccount> recipientAccounts = new ArrayList<RecipientAccount>();
        for (int i = 0; i < recipAccounts.size(); ++i) {
            final RecipientAccount pojo = (RecipientAccount)mapper.convertValue((Object)recipAccounts.get(i), (Class)RecipientAccount.class);
            recipientAccounts.add(pojo);
        }
        return recipientAccounts;
    }
}
