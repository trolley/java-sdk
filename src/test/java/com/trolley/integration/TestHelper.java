package com.trolley.integration;

import java.util.ArrayList;
import java.util.UUID;

import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.types.Recipient;
import com.trolley.types.RecipientAccount;
import com.trolley.types.supporting.Address;
import com.trolley.types.supporting.GovernmentId;

import io.github.cdimascio.dotenv.Dotenv;

public class TestHelper {

    public static Configuration getConfig(){
        Dotenv dotenv = Dotenv.load();

        return new Configuration(
            dotenv.get("ACCESS_KEY"), 
            dotenv.get("SECRET_KEY"));

    }

    /**
     * Creates a new Recipient for all test classes to use.
     * @return Recipient the object representing the new Recipient created
     * @throws Exception
     */
    public Recipient createRecipient() throws Exception {
        Gateway client = new Gateway(getConfig());

        UUID uuid = UUID.randomUUID();

        String email = "create.recipient.java-sdk." + uuid.toString() + "@example.com";

        Recipient recipientRequest = new Recipient();
        recipientRequest.setType("individual");
        recipientRequest.setFirstName("John");
        recipientRequest.setLastName("Smith");
        recipientRequest.setEmail(email);

        ArrayList<String> contactEmails = new ArrayList<String>();
        contactEmails.add("john1@example.com");
        contactEmails.add("john2@example.com");
        recipientRequest.setContactEmails(contactEmails);
        
        Address address = new Address();
        address.setStreet1("123 Main St");
        address.setCity("San Francisco");
        address.setRegion("CA");
        address.setPostalCode("94131");
        address.setCountry("US");
        address.setPhone("18005551212");
        recipientRequest.setAddress(address);

        GovernmentId govtId = new GovernmentId("US", "SSN", "ABCD123456");
        ArrayList<GovernmentId> govtIds = new ArrayList<GovernmentId>();
        govtIds.add(govtId);
        
        recipientRequest.setGovernmentIds(govtIds);

        Recipient recipient = client.recipient.create(recipientRequest);

        return recipient;
    }

    /**
     * Creates a new RecipientAccount for a Recipient.
     * @param Recipient recipient to take recipientId from
     * @return RecipientAccount
     * @throws Exception
     */
    public RecipientAccount createRecipientAccount(Recipient recipient) throws Exception {
        Gateway client = new Gateway(getConfig());

        String body = "{\"type\": \"bank-transfer\", \"primary\": true, \"country\": \"DE\", \"currency\": \"EUR\", \"iban\": \"DE89 3704 0044 0532 0130 00\", \"accountHolderName\": \"John Smith\"}";

        RecipientAccount recipientAcount = client.recipientAccount.create(recipient.getId(), body);

        return recipientAcount;
    }

    /**
     * Create a RecipientAccount with the provided body
     * @param recipient
     * @param body
     * @return
     * @throws Exception
     */
    public RecipientAccount createRecipientAccount(Recipient recipient, String body) throws Exception {
        Gateway client = new Gateway(getConfig());

        RecipientAccount recipientAcount = client.recipientAccount.create(recipient.getId(), body);

        return recipientAcount;
    }

    /**
     * Deletes a recipient
     * @param recipient Recipient object of the recipient which needs to be deleted
     * @return boolean indicating whether the delete operation was successful
     * @throws Exception
     */
    public boolean deleteRecipient(Recipient recipient) throws Exception {
        Gateway client = new Gateway(getConfig());

        return client.recipient.delete(recipient.getId());
    }
}
