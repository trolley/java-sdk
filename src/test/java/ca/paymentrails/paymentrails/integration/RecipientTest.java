
package ca.paymentrails.paymentrails.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import ca.paymentrails.paymentrails.Configuration;
import ca.paymentrails.paymentrails.Recipient;
import ca.paymentrails.paymentrails.RecipientAccount;
import ca.paymentrails.paymentrails.Gateway;

import java.util.List;
import java.util.UUID;

@PrepareForTest(Recipient.class)
public class RecipientTest {

    @Test
    public void testCreateRecipient() throws Exception {
        Gateway client = new Gateway(new Configuration("YOUR-API-KEY", "YOUR-API-KEY", "production"));

        UUID uuid = UUID.randomUUID();

        String body = "{\"type\": \"individual\",\"firstName\": \"Tom\",\"lastName\": \"Jones\",\"email\": \"test.create"
                + uuid.toString()
                + "@example.com\",\"address\":{\"street1\": \"123 Main St\",\"city\": \"San Francisco\",\"region\": \"CA\",\"postalCode\": \"94131\",\"country\": \"US\",\"phone\" : \"18005551212\"}}";
        Recipient recipient = client.recipient.create(body);
        assertEquals(recipient.getFirstName(), "Tom");
        assertEquals(recipient.getLastName(), "Jones");
        assertEquals(recipient.getEmail(), "test.create" + uuid.toString() + "@example.com");
        assertNotNull(recipient.getId());
    }

    @Test
    public void testLifecycle() throws Exception {
        Gateway client = new Gateway(new Configuration("YOUR-API-KEY", "YOUR-API-KEY", "production"));

        UUID uuid = UUID.randomUUID();

        String body = "{\"type\": \"individual\",\"firstName\": \"Tom\",\"lastName\": \"Jones\",\"email\": \"test.create"
                + uuid.toString() + "@example.com\"}";
        Recipient recipient = client.recipient.create(body);
        assertEquals(recipient.getFirstName(), "Tom");
        assertEquals(recipient.getLastName(), "Jones");
        assertEquals(recipient.getEmail(), "test.create" + uuid.toString() + "@example.com");
        assertNotNull(recipient.getId());

        body = "{\"firstName\": \"Bob\"}";
        boolean response = client.recipient.update(recipient.getId(), body);
        assertNotNull(response);

        Recipient anotheRecipient = client.recipient.find(recipient.getId());
        assertEquals(anotheRecipient.getFirstName(), "Bob");

        response = client.recipient.delete(recipient.getId());
        assertNotNull(response);

        Recipient anotherNewRecipient = client.recipient.find(recipient.getId());
        assertEquals("archived", anotherNewRecipient.getStatus());
    }

    @Test
    public void testAccount() throws Exception {
        Gateway client = new Gateway(new Configuration("YOUR-API-KEY", "YOUR-API-KEY", "production"));

        UUID uuid = UUID.randomUUID();

        String body = "{\"type\": \"individual\",\"firstName\": \"Tom\",\"lastName\": \"Jones\",\"email\": \"account.create"
                + uuid.toString() + "@example.com\"}";
        Recipient recipient = client.recipient.create(body);
        assertEquals(recipient.getFirstName(), "Tom");
        assertEquals(recipient.getLastName(), "Jones");
        assertEquals(recipient.getEmail(), "account.create" + uuid.toString() + "@example.com");
        assertNotNull(recipient.getId());

        body = "{\"type\": \"bank-transfer\", \"primary\": true, \"country\": \"DE\", \"currency\": \"EUR\", \"iban\": \"DE89 3704 0044 0532 0130 00\", \"accountHolderName\": \"Tom Jones\"}";
        RecipientAccount recipientAccount = client.recipientAccount.create(recipient.getId(), body);
        assertEquals("Tom Jones", recipientAccount.getAccountHolderName());

        body = "{\"type\": \"bank-transfer\", \"primary\": true, \"country\": \"DE\", \"currency\": \"EUR\", \"iban\": \"DE89 3704 0044 0532 0130 00\", \"accountHolderName\": \"Tom Jones2\"}";
        RecipientAccount recipientAccount1 = client.recipientAccount.create(recipient.getId(), body);
        assertEquals("Tom Jones2", recipientAccount1.getAccountHolderName());

        RecipientAccount recipAccount = client.recipientAccount.find(recipient.getId(), recipientAccount.getId());
        assertEquals(recipAccount.getCountry(), recipientAccount.getCountry());

        List<RecipientAccount> recipientAccounts = client.recipientAccount.findAll(recipient.getId());
        assertEquals(2, recipientAccounts.size());

        boolean response = client.recipientAccount.delete(recipient.getId(), recipientAccount1.getId());
        assertNotNull(response);

        List<RecipientAccount> recipientAccounts1 = client.recipientAccount.findAll(recipient.getId());
        assertEquals(1, recipientAccounts1.size());
    }

}