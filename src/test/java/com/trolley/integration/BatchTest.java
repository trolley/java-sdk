
package com.trolley.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.Exceptions.MalformedException;
import com.trolley.types.Batch;
import com.trolley.types.Payment;
import com.trolley.types.Recipient;
import com.trolley.types.supporting.BatchSummary;
import com.trolley.types.supporting.Batches;
import com.trolley.types.supporting.BatchesIterator;
import com.trolley.types.supporting.Payments;
import com.trolley.types.supporting.PaymentsIterator;

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

        Batch batchToCreate = new Batch();
        batchToCreate.setPayments(paymentList);

        Batch batch = client.batch.create(batchToCreate);

        assertNotNull(batch);
        assertNotNull(batch.getId());

        List<Payment> batchPayments = batch.getPayments();
        assertEquals(1, batchPayments.size());

        assertEquals("15.00", batchPayments.get(0).getAmount());
        assertEquals("USD", batchPayments.get(0).getCurrency());
        assertEquals(batchPayments.get(0).getBatch().getId(), batch.getId());

        assertNull(batchPayments.get(0).getCheckNumber());

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
        }catch(MalformedException e){
            for (JsonNode node : e.getErrorResponse().get("errors")) {
                System.out.println("Error Message: "+node.get("message"));
            }
            e.printStackTrace();
        }
        
        //Cleanup
        boolean recDelResult = testHelper.deleteRecipient(recipientAlpha);
        assertTrue(recDelResult);

        boolean batchDelResult = client.batch.delete(batch.getId());
        assertTrue(batchDelResult);
    }

    @Test
    public void testPaymentsPagination() throws Exception{
        Gateway client = new Gateway(config);

        //Testing Payments pagination - with Iterator
        String batchId = "<batch-id>";
        PaymentsIterator payments = client.payment.search(batchId, "");

        int itemCount = 0;
        while(payments.hasNext()){
            assertNotNull(payments.next().getId());
            itemCount++;
        }
        assertTrue(itemCount>0);

        //Testing Payments pagination - with manual pagination
        Payments p = client.payment.search(batchId, 1, 10, "");
        assertNotNull(p.getPayments().get(0).getId());
    }

    @Test
    public void testBatchesPagination() throws Exception{
        Gateway client = new Gateway(config);

        //Testing Batches pagination - with Iterator
        BatchesIterator batches = client.batch.search("");

        int itemCount = 0;
        while(batches.hasNext()){
            assertNotNull(batches.next().getId());
            itemCount++;
        }
        assertTrue(itemCount>0);

        //Testing Batches pagination - with manual pagination
        Batches b = client.batch.search(1, 10, "");
        assertNotNull(b.getBatches().get(0).getId());
    }
}