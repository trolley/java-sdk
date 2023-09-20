package com.trolley.integration;

import java.util.UUID;

import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.types.Recipient;
import com.trolley.types.RecipientAccount;

import io.github.cdimascio.dotenv.Dotenv;

public class TestHelper {

    public static Configuration getConfig(){
        Dotenv dotenv = Dotenv.load();

        return new Configuration(
            dotenv.get("ACCESS_KEY"), 
            dotenv.get("SECRET_KEY"), 
            "production");

    }

    /**
     * Creates a new Recipient for all test classes to use.
     * @return Recipient the object representing the new Recipient created
     * @throws Exception
     */
    public Recipient createRecipient() throws Exception {
        Gateway client = new Gateway(getConfig());

        UUID uuid = UUID.randomUUID();

        String email = "\"create.recipient.java-sdk." + uuid.toString() + "@example.com\"";
        String body = "{\"type\": \"individual\",\"firstName\": \"John\",\"lastName\": \"Smith\",\"email\":" + email
                + ",\"contactEmails\": [\"john1@example.com\", \"john2@example.com\"]"
                + ",\"address\":{\"street1\": \"123 Main St\",\"city\": \"San Francisco\",\"region\": \"CA\",\"postalCode\": \"94131\",\"country\": \"DE\",\"phone\" : \"18005551212\"}}";

        Recipient recipient = client.recipient.create(body);

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
