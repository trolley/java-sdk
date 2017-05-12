/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jesse
 */
public class PaymentRails_BatchTest {

    @Test
    public void testRetrieveRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.get(batch_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRecipientInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("fff");
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.get(batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRecipientInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-fff";
        String response = PaymentRails_Batch.get(batch_id);
    }

    @Test
    public void testUpdateRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"id\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.patch(batch_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidAPI() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("wdwdwd");
        String body = "{\"update_payments\":[{\"id\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"id\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-fweffe";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidAmount() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"id\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":9.9}]}";
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidFieldName() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"isss\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Ignore("Ignored due to not wanting to keep deleting the same batch")
    @Test
    public void testDeleteRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.delete(batch_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ff");
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.delete(batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-fff";
        String response = PaymentRails_Batch.delete(batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidBatchStatus() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-91XPR9AZD8BMP";
        String response = PaymentRails_Batch.delete(batch_id);
    }

    @Test
    public void testListBatches() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.query();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test
    public void testListBatchesWithQueries() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.query(1, 10, "");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListBatchesInvalidAPI() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("fff");
        String response = PaymentRails_Batch.query();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test
    public void testBatchSummary() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.summary("B-91XPU88Q093HW");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testBatchSummaryInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("fff");
        String response = PaymentRails_Batch.summary("B-91XPU88Q093HW");
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testBatchSummaryInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.summary("B-fff");
    }

    @Ignore("Ignored as not to keep creating batches")
    @Test
    public void testCreateBatch() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-912Q4JHD6RH7E\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";
        String response = PaymentRails_Batch.post(body);
        String batch_id = response.substring(26, 41);
        System.out.println(batch_id);
        response = PaymentRails_Batch.generateQuote(batch_id);

        response = PaymentRails_Batch.processBatch(batch_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreateBatchInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ddd");
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-912Q4JHD6RH7E\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";
        String response = PaymentRails_Batch.post(body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreateBatchInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-fefef\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";
        String response = PaymentRails_Batch.post(body);
    }

}
