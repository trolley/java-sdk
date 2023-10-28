package com.trolley.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.types.Recipient;
import com.trolley.types.RecipientAccount;
import com.trolley.types.supporting.Recipients;
import com.trolley.types.supporting.RecipientsIterator;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertEquals(recipient.getContactEmails(), Arrays.asList("john1@example.com", "john2@example.com"));

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

        // Test Compliance Status
        assertTrue(recipient.getComplianceStatus() == Recipient.ComplianceStatus.PENDING);

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

        Recipients recipients = client.recipient.search(1, 10, "");

        //Making sure routeMinimum is not null before asserting it's value
        for (Recipient recipient : recipients.getRecipients()) {
            if(null != recipient.getRouteMinimum()){
                //Making sure routeMinium is set to a non-null value
                assertTrue(Integer.parseInt(recipient.getRouteMinimum()) >= 0);
                break;
            }
        }        
    }

    @Test
    public void testPagination() throws Exception{
        Gateway client = new Gateway(config);

        RecipientsIterator recipients = client.recipient.search("");

        int itemCount = 0;
        while(recipients.hasNext()) {
            itemCount++;
            assertNotNull(recipients.next().getId());
        }

        assertTrue(itemCount>0);
    }

}