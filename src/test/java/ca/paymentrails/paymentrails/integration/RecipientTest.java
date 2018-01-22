
package ca.paymentrails.paymentrails.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import ca.paymentrails.paymentrails.Configuration;
import ca.paymentrails.paymentrails.Recipient;
import ca.paymentrails.paymentrails.RecipientAccount;

import java.util.List;

@PrepareForTest(Recipient.class)
public class RecipientTest {

    @Test
    public void testCreateRecipient() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");

        String body = "{\"type\": \"individual\",\"firstName\": \"John\",\"lastName\": \"Smith\",\"email\": \"jsmith21@example.com\"}";
        Recipient recipient = Recipient.create(body);
        assertEquals(recipient.getFirstName(), "John");
        assertEquals(recipient.getLastName(), "Smith");
        assertEquals(recipient.getEmail(), "jsmith21@example.com");
        assertNotNull(recipient.getId());
    }

    @Test
    public void testLifecycle() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");

        String body = "{\"type\": \"individual\",\"firstName\": \"John\",\"lastName\": \"Smith\",\"email\": \"jsmith3@example.com\"}";
        Recipient recipient = Recipient.create(body);
        assertEquals(recipient.getFirstName(), "John");
        assertEquals(recipient.getLastName(), "Smith");
        assertEquals(recipient.getEmail(), "jsmith3@example.com");
        assertNotNull(recipient.getId());

        body = "{\"firstName\": \"Bob\"}";
        String response = Recipient.update(recipient.getId(), body);
        assertNotNull(response);

        Recipient anotheRecipient = Recipient.find(recipient.getId());
        assertEquals(anotheRecipient.getFirstName(), "Bob");

        response = Recipient.delete(recipient.getId());
        assertNotNull(response);

        Recipient anotherNewRecipient = Recipient.find(recipient.getId());
        assertEquals("archived", anotherNewRecipient.getStatus());
    }

    @Test
    public void testAccount() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");

        String body = "{\"type\": \"individual\",\"firstName\": \"John\",\"lastName\": \"Smith\",\"email\": \"jsmith34@example.com\"}";
        Recipient recipient = Recipient.create(body);
        assertEquals(recipient.getFirstName(), "John");
        assertEquals(recipient.getLastName(), "Smith");
        assertEquals(recipient.getEmail(), "jsmith34@example.com");
        assertNotNull(recipient.getId());

        body = "{\"type\": \"bank-transfer\", \"primary\": \"true\", \"country\": \"CA\", \"currency\": \"CAD\",\"accountNum\": \"604622847\", \"bankId\": \"123\", \"branchId\": \"47261\",  \"accountHolderName\": \"John Smith\"}";
        RecipientAccount recipientAccount = RecipientAccount.create(recipient.getId(), body);
        assertEquals("John Smith", recipientAccount.getAccountHolderName());

        body = "{\"type\": \"bank-transfer\", \"primary\": \"true\", \"country\": \"CA\", \"currency\": \"CAD\",\"accountNum\": \"604622847\", \"bankId\": \"123\", \"branchId\": \"47261\",  \"accountHolderName\": \"Tom Smith\"}";
        RecipientAccount recipientAccount1 = RecipientAccount.create(recipient.getId(), body);
        assertEquals("Tom Smith", recipientAccount1.getAccountHolderName());


        RecipientAccount recipAccount = RecipientAccount.find(recipient.getId(), recipientAccount.getId());
        assertEquals(recipAccount.getCountry(), recipientAccount.getCountry());

        List<RecipientAccount> recipientAccounts = RecipientAccount.findAll(recipient.getId());
        assertEquals(2, recipientAccounts.size());


        String response = RecipientAccount.delete(recipient.getId(), recipientAccount1.getId());
        assertNotNull(response);

        List<RecipientAccount> recipientAccounts1 = RecipientAccount.findAll(recipient.getId());
        assertEquals(1, recipientAccounts1.size());
        

    }

}