
package com.trolley.sdk.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.trolley.trolley.Batch;
import com.trolley.trolley.BatchSummary;
import com.trolley.trolley.Configuration;
import com.trolley.trolley.Gateway;
import com.trolley.trolley.Payment;
import com.trolley.trolley.Payments;
import com.trolley.trolley.Recipient;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(Batch.class)
public class BatchTest {

    private static Configuration config;

    @BeforeClass 
    public static void setupConfig() {
        final String ACCESS_KEY = "ALC7AsydFDU2KKHZH4S7RZVL";
        final String SECRET_KEY = "OMJZ4C7BGTMKIF4YXSPBGGPLAVONJILGRXQTDXQR";
        final String ENVIRONMENT = "production";

        // RecipientTest recipientTest = new RecipientTest();
        config = new Configuration(ACCESS_KEY, SECRET_KEY, ENVIRONMENT);
     }


    private Recipient createRecipient() throws Exception {
        Gateway client = new Gateway(config);

        UUID uuid = UUID.randomUUID();

        String email = "\"create.recipient" + uuid.toString() + "@example.com\"";
        String body = "{\"type\": \"individual\",\"firstName\": \"John\",\"lastName\": \"Smith\",\"email\":" + email
                + ",\"address\":{\"street1\": \"123 Main St\",\"city\": \"San Francisco\",\"region\": \"CA\",\"postalCode\": \"94131\",\"country\": \"DE\",\"phone\" : \"18005551212\"}}";

        Recipient recipient = client.recipient.create(body);

        body = "{\"type\": \"bank-transfer\", \"primary\": true, \"country\": \"DE\", \"currency\": \"EUR\", \"iban\": \"DE89 3704 0044 0532 0130 00\", \"accountHolderName\": \"John Smith\"}";

        client.recipientAccount.create(recipient.getId(), body);

        return recipient;
    }

    @Test
    public void testCreate() throws Exception {
        Gateway client = new Gateway(config);

        String body = "{\"sourceCurrency\": \"GBP\", \"description\":\"Integration Test Create\"}";
        Batch batch = client.batch.create(body);
        assertEquals(batch.getCurrency(), "GBP");
    }

    @Test
    public void testCreateObject() throws Exception {
        Gateway client = new Gateway(config);

        Batch batchToCreate = new Batch();
        batchToCreate.setCurrency("GBP");
        batchToCreate.setDescription("Integration Test Create");

        Batch createdBatch = client.batch.create(batchToCreate);
        assertEquals(createdBatch.getCurrency(), "GBP");
        assertEquals(createdBatch.getDescription(), "Integration Test Create");

        client.batch.delete(createdBatch.getId());

    }

    @Test
    public void testUpdate() throws Exception {
        Gateway client = new Gateway(config);

        String body = "{\"sourceCurrency\": \"GBP\", \"description\":\"Integration Test Create\"}";
        Batch batch = client.batch.create(body);
        assertEquals(batch.getCurrency(), "GBP");

        body = "{\"description\" : \"Integration Update\"}";
        boolean response = client.batch.update(batch.getId(), body);
        assertNotNull(response);

        Batch batch1 = client.batch.find(batch.getId());
        assertEquals(batch1.getDescription(), "Integration Update");

        response = client.batch.delete(batch1.getId());
        assertNotNull(response);
    }

    /* @Test
    public void testCreateWithPayments() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipientAlpha = createRecipient();

        String body = "{\"payments\": [{\"recipient\": {\"id\": " + "\"" + recipientAlpha.getId() + "\""
                + "},\"amount\": \"10.00\", \"currency\": \"EUR\"}]}";
        Batch batch = client.batch.create(body);
        assertEquals(batch.getCurrency(), "GBP");

        Batch updatedBatch = new Batch();
        updatedBatch.setDescription("Integration Update Object");
        boolean response = client.batch.update(batch.getId(), updatedBatch);

        assertNotNull(response);
        Batch batch1 = client.batch.find(batch.getId());
        assertEquals(batch1.getDescription(), "Integration Update Object");

        response = client.batch.delete(batch1.getId());
        assertNotNull(response);
    } */

    @Test
    public void testCreateWithPayments() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipientAlpha = createRecipient();
        Payment payment = new Payment();

        payment.setAmount("15");
        payment.setCurrency("USD");
        payment.setRecipient(recipientAlpha);

        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(payment);

        Payments payments = new Payments();
        payments.setPayments(paymentList);

        Batch batchToCreate = new Batch();
        batchToCreate.setPayments(paymentList);

        Batch batch = client.batch.create(batchToCreate);

        assertNotNull(batch);
        assertNotNull(batch.getId());

        List<Payment> batchPayments = batch.getPayments();
        assertEquals(1, batchPayments.size());

        assertEquals("15.00", batchPayments.get(0).getAmount());
        assertEquals("USD", batchPayments.get(0).getCurrency());

    }

    @Test
    public void testPayments() throws Exception {
        Gateway client = new Gateway(config);

        String body = "{\"sourceCurrency\": \"GBP\", \"description\":\"Integration Test Create\"}";
        Batch batch = client.batch.create(body);
        assertEquals(batch.getCurrency(), "GBP");

        Recipient recipient = createRecipient();
        body = "{\"sourceAmount\":\"10.00\", \"recipient\": {\"id\": " + "\"" + recipient.getId() + "\"" + "}}";
        Payment payment = client.payment.create(body, batch.getId());
        assertNotNull(payment);
        assertNotNull(payment.getId());
        body = "{\"sourceAmount\":\"20.00\"}";
        boolean response = client.payment.update(payment.getId(), body, batch.getId());
        assertNotNull(response);

        response = client.payment.delete(payment.getId(), batch.getId());
        assertNotNull(response);
    }

    @Test
    public void testProcessing() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipientAlpha = createRecipient();

        String body = "{\"payments\": [{\"recipient\": {\"id\": " + "\"" + recipientAlpha.getId() + "\""
                + "},\"amount\": \"10.00\", \"currency\": \"EUR\"}]}";

        Batch batch = client.batch.create(body);
        assertNotNull(batch);
        assertNotNull(batch.getId());

        BatchSummary batchSummary = client.batch.summary(batch.getId());
        assertNotNull(batchSummary);

        try{
            String batch1 = client.batch.generateQuote(batch.getId());
            assertNotNull(batch1);
        }catch(Exception e){
            System.err.println(e);
        }
        
        String batch2 = client.batch.processBatch(batch.getId());
        assertNotNull(batch2);

    }
}