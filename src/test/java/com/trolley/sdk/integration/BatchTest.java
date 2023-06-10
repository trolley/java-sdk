
package com.trolley.sdk.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
    private static TestHelper testHelper;

    @BeforeClass 
    public static void setupConfig() {
        config = TestHelper.getConfig();
        testHelper = new TestHelper();
     }

    @Test
    public void testCreate() throws Exception {
        Gateway client = new Gateway(config);

        String body = "{\"sourceCurrency\": \"GBP\", \"description\":\"Integration Test Create\"}";
        Batch batch = client.batch.create(body);
        assertEquals(batch.getCurrency(), "GBP");

        //Cleanup
        boolean deleteResult = client.batch.delete(batch.getId());
        assertTrue(deleteResult);
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

        //Cleanup
        boolean deleteResult = client.batch.delete(createdBatch.getId());
        assertTrue(deleteResult);
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

        //Cleanup
        response = client.batch.delete(batch1.getId());
        assertNotNull(response);
    }

    @Test
    public void testCreateWithPayments() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipientAlpha = testHelper.createRecipient();
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

        //Cleanup
        boolean recDelResult = testHelper.deleteRecipient(recipientAlpha);
        assertTrue(recDelResult);
        
        boolean batchDelResult = client.batch.delete(batch.getId());
        assertTrue(batchDelResult);
    }

    @Test
    public void testPayments() throws Exception {
        Gateway client = new Gateway(config);

        String body = "{\"sourceCurrency\": \"GBP\", \"description\":\"Integration Test Create\"}";
        Batch batch = client.batch.create(body);
        assertEquals(batch.getCurrency(), "GBP");

        Recipient recipient = testHelper.createRecipient();
        body = "{\"sourceAmount\":\"10.00\", \"recipient\": {\"id\": " + "\"" + recipient.getId() + "\"" + "}}";
        Payment payment = client.payment.create(body, batch.getId());
        assertNotNull(payment);
        assertNotNull(payment.getId());
        body = "{\"sourceAmount\":\"20.00\"}";
        boolean response = client.payment.update(payment.getId(), body, batch.getId());
        assertNotNull(response);

        response = client.payment.delete(payment.getId(), batch.getId());
        assertNotNull(response);

        //Cleanup
        boolean recDelResult = testHelper.deleteRecipient(recipient);
        assertTrue(recDelResult);
        
        boolean batchDelResult = client.batch.delete(batch.getId());
        assertTrue(batchDelResult);
    }

    @Test
    public void testProcessing() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipientAlpha = testHelper.createRecipient();

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
            
            String batch2 = client.batch.processBatch(batch.getId());
            assertNotNull(batch2);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Cleanup
        boolean recDelResult = testHelper.deleteRecipient(recipientAlpha);
        assertTrue(recDelResult);

        boolean batchDelResult = client.batch.delete(batch.getId());
        assertTrue(batchDelResult);
    }
}