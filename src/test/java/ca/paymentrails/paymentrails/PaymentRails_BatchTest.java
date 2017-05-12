package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
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
    public void testRetrieveBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-91XQ40VT5HF18";
        String response = PaymentRails_Batch.get(batch_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveBatchInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("fff");
        String batch_id = "B-91XQ40VXECQJM";
        String response = PaymentRails_Batch.get(batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveBatchInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-fff";
        String response = PaymentRails_Batch.get(batch_id);
    }

    @Test
    public void testUpdateBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ40VT54GQM\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-91XQ40VT5HF18";
        String response = PaymentRails_Batch.patch(batch_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateBatchInvalidAPI() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("wdwdwd");
        String body = "{\"update_payments\":[{\"id\":\"P-912Q8KVY19D2Y\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-91XQ40VXECQJM";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateBatchInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"id\":\"P-912Q8KVY19D2Y\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-fweffe";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateBatchInvalidAmount() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"id\":\"P-912Q8KVY19D2Y\","
                + "\"sourceAmount\":9.9}]}";
        String batch_id = "B-91XQ40VXECQJM";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateBatchInvalidFieldName() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"update_payments\":[{\"isss\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":999}]}";
        String batch_id = "B-91XPU88Q093HW";
        String response = PaymentRails_Batch.patch(batch_id, body);
    }

    @Ignore("Ignored due to not wanting to keep deleting the same batch")
    @Test
    public void testDeleteBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-91XQ40VXECQJM";
        String response = PaymentRails_Batch.delete(batch_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteBatchInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("ff");
        String batch_id = "B-91XQ40VXECQJM";
        String response = PaymentRails_Batch.delete(batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteBatchInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String batch_id = "B-fff";
        String response = PaymentRails_Batch.delete(batch_id);
    }

    @Test
    public void testListBatches() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.query();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test
    public void testListBatchesWithQueries() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.query(1, 10, "");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListBatchesInvalidAPI() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("fff");
        String response = PaymentRails_Batch.query();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test
    public void testBatchSummary() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.summary("B-91XQ40VT5HF18");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testBatchSummaryInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("fff");
        String response = PaymentRails_Batch.summary("B-91XQ40VXECQJM");
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testBatchSummaryInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Batch.summary("B-ff");
    }

    @Ignore("Ignored as not to keep creating batches")
    @Test
    public void testCreateBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
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
    public void testCreateBatchInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("ddd");
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-912Q4JHD6RH7E\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";
        String response = PaymentRails_Batch.post(body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreateBatchInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-fefef\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";
        String response = PaymentRails_Batch.post(body);
    }

}
