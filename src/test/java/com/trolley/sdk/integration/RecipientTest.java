package com.trolley.sdk.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.trolley.trolley.Configuration;
import com.trolley.trolley.Gateway;
import com.trolley.trolley.Recipient;
import com.trolley.trolley.RecipientAccount;

import java.util.ArrayList;
import java.util.List;

@PrepareForTest(Recipient.class)
public class RecipientTest {

    private static Configuration config;
    private static TestHelper testHelper;

    @BeforeClass 
    public static void setupConfig() {
        config = TestHelper.getConfig();
        testHelper = new TestHelper();
    }

    @Test
    public void testCreateRecipient() throws Exception {
        Recipient recipient = testHelper.createRecipient();
        assertEquals(recipient.getFirstName(), "John");
        assertEquals(recipient.getLastName(), "Smith");
        assertNotNull(recipient.getId());

        //Cleanup
        boolean deleteResult = testHelper.deleteRecipient(recipient);
        assertTrue(deleteResult);
    }

    @Test
    public void testLifecycle() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipient = testHelper.createRecipient();
        assertEquals(recipient.getFirstName(), "John");
        assertEquals(recipient.getLastName(), "Smith");
        assertNotNull(recipient.getId());

        String body = "{\"firstName\": \"Bob\"}";
        boolean response = client.recipient.update(recipient.getId(), body);
        assertNotNull(response);

        Recipient anotherRecipient = client.recipient.find(recipient.getId());
        assertEquals(anotherRecipient.getFirstName(), "Bob");

        response = client.recipient.delete(recipient.getId());
        assertNotNull(response);

        Recipient anotherNewRecipient = client.recipient.find(recipient.getId());
        assertEquals("archived", anotherNewRecipient.getStatus());
    }

    @Test
    public void testAccount() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipient = testHelper.createRecipient();
        assertEquals(recipient.getFirstName(), "John");
        assertEquals(recipient.getLastName(), "Smith");
        assertNotNull(recipient.getId());

        String body = "{\"type\": \"bank-transfer\", \"primary\": true, \"country\": \"DE\", \"currency\": \"EUR\", \"iban\": \"DE89 3704 0044 0532 0130 00\", \"accountHolderName\": \"Tom Jones\"}";
        RecipientAccount recipientAccount = testHelper.createRecipientAccount(recipient, body);
        assertEquals("Tom Jones", recipientAccount.getAccountHolderName());

        body = "{\"type\": \"bank-transfer\", \"primary\": true, \"country\": \"DE\", \"currency\": \"EUR\", \"iban\": \"DE89 3704 0044 0532 0130 00\", \"accountHolderName\": \"Tom Jones2\"}";
        RecipientAccount recipientAccount1 = testHelper.createRecipientAccount(recipient, body);
        assertEquals("Tom Jones2", recipientAccount1.getAccountHolderName());

        RecipientAccount recAccFindResult = client.recipientAccount.find(recipient.getId(), recipientAccount.getId());
        assertEquals(recAccFindResult.getCountry(), recipientAccount.getCountry());

        List<RecipientAccount> recipientAccounts = client.recipientAccount.findAll(recipient.getId());
        assertEquals(2, recipientAccounts.size());

        boolean response = client.recipientAccount.delete(recipient.getId(), recipientAccount1.getId());
        assertNotNull(response);

        List<RecipientAccount> recipientAccounts1 = client.recipientAccount.findAll(recipient.getId());
        assertEquals(1, recipientAccounts1.size());

        //Cleanup
        boolean deleteResult = testHelper.deleteRecipient(recipient);
        assertTrue(deleteResult);
    }


    @Test
    public void testRecipientRouteMinimum() throws Exception {
        Gateway client = new Gateway(config);
        ArrayList<Recipient> recipients = (ArrayList<Recipient>)client.recipient.search(1,20,"");
        //Making sure routeMinimum is not null before asserting it's value
        assertNotNull(recipients.get(0).getRouteMinimum());
        //Making sure routeMinium is set to a non-null value
        assertTrue(Integer.parseInt(recipients.get(0).getRouteMinimum()) >= 0);
    }

}