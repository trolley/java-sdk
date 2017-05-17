package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Jesse
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PaymentRails_Batch.class)
public class PaymentRails_BatchTest {

    @Test
    public void testRetrieveBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        when(PaymentRails_Batch.get(batch_id)).thenReturn(fakeGet(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Batch.get(batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveBatchInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        when(PaymentRails_Batch.get(batch_id)).thenReturn(fakeGet(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.get(batch_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrieveBatchNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = null;
        when(PaymentRails_Batch.get(batch_id)).thenReturn(fakeGet(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.get(batch_id);

    }

    @Test
    public void testUpdateBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ2ZGK7HM62\","
                + "\"sourceAmount\":999}]}";
        when(PaymentRails_Batch.patch(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Batch.patch(batch_id, body);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateBatchInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ2ZGK7HM62\","
                + "\"sourceAmount\":999}]}";
        when(PaymentRails_Batch.patch(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateBatchNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = null;
        String body = "{\"update_payments\":[{\"id\":\"P-91XQ2ZGK7HM62\","
                + "\"sourceAmount\":999}]}";
        when(PaymentRails_Batch.patch(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.patch(batch_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateBatchNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        String body = null;
        when(PaymentRails_Batch.patch(batch_id, body)).thenReturn(fakePatch(batch_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.patch(batch_id, body);
    }

    @Test
    public void testDeleteBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        when(PaymentRails_Batch.delete(batch_id)).thenReturn(fakeDelete(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Batch.delete(batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteBatchInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        when(PaymentRails_Batch.delete(batch_id)).thenReturn(fakeDelete(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.delete(batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeleteBatchNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = null;
        when(PaymentRails_Batch.delete(batch_id)).thenReturn(fakeDelete(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.delete(batch_id);
    }

    @Test
    public void testListBatchesWithQueries() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);

        when(PaymentRails_Batch.query(1, 10, "f18")).thenReturn(fakeQuery(1, 10, "f18"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Batch.query(1, 10, "f18");
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidFieldException.class)
    public void testListBatchesWithQueriesNegativePage() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);

        when(PaymentRails_Batch.query(-1, 10, "f18")).thenReturn(fakeQuery(-1, 10, "f18"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.query(-1, 10, "f18");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListBatchesWithQueriesNegativePageSize() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);

        when(PaymentRails_Batch.query(1, -10, "f18")).thenReturn(fakeQuery(1, -10, "f18"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.query(1, -10, "f18");

    }

    @Test(expected = InvalidFieldException.class)
    public void testListBatchesWithQueriesNullTerme() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);

        when(PaymentRails_Batch.query(1, 10, null)).thenReturn(fakeQuery(1, 10, null));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.query(1, 10, null);

    }

    @Test
    public void testBatchSummary() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "B-91XQ4VKD39C3P";
        when(PaymentRails_Batch.summary(batch_id)).thenReturn(fakeSummary(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Batch.summary(batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testBatchSummaryInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = "91XQ4VKD39C3P";
        when(PaymentRails_Batch.summary(batch_id)).thenReturn(fakeSummary(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.summary(batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testBatchSummaryNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String batch_id = null;
        when(PaymentRails_Batch.summary(batch_id)).thenReturn(fakeSummary(batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.summary(batch_id);

    }

    @Test
    public void testCreateBatch() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String body = "{\"payments\":[{\"recipient\":{\"id\":\"R-912Q4JHD6RH7E\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";

        when(PaymentRails_Batch.post(body)).thenReturn(fakePost(body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Batch.post(body);
        String result = response.substring(6, 10);
        assertEquals("true", result);

        String batch_id = "B-fhfhfh";//response.substring(26, 41);

        when(PaymentRails_Batch.generateQuote(batch_id)).thenReturn(fakeGenerateQuote(batch_id));
        response = PaymentRails_Batch.generateQuote(batch_id);
        result = response.substring(6, 10);
        assertEquals("true", result);

        when(PaymentRails_Batch.processBatch(batch_id)).thenReturn(fakeProcessBatch(batch_id));
        response = PaymentRails_Batch.processBatch(batch_id);
        result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidFieldException.class)
    public void testCreateBatchNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Batch.class);
        String body = null;

        when(PaymentRails_Batch.post(body)).thenReturn(fakePost(body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Batch.post(body);

    }

    private String fakeGet(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"batch\":{\"id\":\"B-91XQ40VT5HF18\",\"status\":\"processing\",\"amount\":\"900.90\",\"totalPayments\":1,\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":\"2017-05-16T13:41:56.149Z\",\"completedAt\":null,\"createdAt\":\"2017-05-08T18:30:44.905Z\",\"updatedAt\":\"2017-05-16T13:41:56.150Z\",\"payments\":{\"payments\":[{\"id\":\"P-91XQ40VT54GQM\",\"recipient\":{\"id\":\"R-91XQ0PJH39U54\",\"referenceId\":\"U345678912\",\"email\":\"Johnny@test.com\",\"name\":\"mark Test\",\"status\":\"active\",\"countryCode\":null},\"method\":\"paypal\",\"methodDisplay\":\"PayPal\",\"status\":\"pending\",\"sourceAmount\":\"900.90\",\"targetAmount\":\"65.00\",\"isSupplyPayment\":false,\"memo\":\"\",\"fees\":\"0.00\",\"recipientFees\":\"0.00\",\"exchangeRate\":\"1.000000\",\"processedAt\":null,\"merchantFees\":\"0.00\",\"sourceCurrency\":\"USD\",\"sourceCurrencyName\":\"US Dollar\",\"targetCurrency\":\"USD\",\"targetCurrencyName\":\"US Dollar\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null}}],\"meta\":{\"page\":1,\"pages\":1,\"records\":1}}}}";
    }

    private String fakePost(String body) throws InvalidFieldException, InvalidStatusCodeException {

        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        return "{\"ok\":true}";
    }

    private String fakePatch(String batch_id, String body) throws InvalidFieldException, InvalidStatusCodeException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"updated\"}";
    }

    private String fakeDelete(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"deleted\"}";
    }

    private String fakeQuery(int page, int pageSize, String term) throws InvalidFieldException {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        return "{\"ok\":true,\"batches\":[{\"id\":\"B-91XQ40VT5HF18\",\"status\":\"processing\",\"amount\":\"900.90\",\"totalPayments\":1,\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":\"2017-05-16T13:41:56.149Z\",\"completedAt\":null,\"createdAt\":\"2017-05-08T18:30:44.905Z\",\"updatedAt\":\"2017-05-16T13:41:56.150Z\"}],\"meta\":{\"page\":1,\"pages\":1,\"records\":1}}";
    }

    private String fakeSummary(String batch_id) throws InvalidFieldException, InvalidStatusCodeException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"batchSummary\":{\"id\":\"B-91XQ40VT5HF18\",\"serverTime\":\"2017-05-17T14:51:17.143Z\",\"status\":\"processing\",\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":\"2017-05-16T13:41:56.149Z\",\"completedAt\":null,\"createdAt\":\"2017-05-08T18:30:44.905Z\",\"processed_by\":\"API\",\"updatedAt\":\"2017-05-16T13:41:56.150Z\",\"quoteExpiredAt\":null,\"errors\":[],\"methods\":{\"paypal\":{\"count\":1,\"value\":900.9,\"fees\":0,\"recipientFees\":0,\"merchantFees\":0,\"net\":900.9,\"accountType\":\"Gateway\",\"displayName\":\"PayPal\"},\"bank-transfer\":{\"count\":0,\"value\":0,\"fees\":0,\"recipientFees\":0,\"merchantFees\":0,\"net\":0,\"accountType\":\"PaymentRails\",\"displayName\":\"Bank Transfer\"}},\"PaymentRailsTotal\":{\"count\":0,\"value\":0,\"fees\":0,\"recipientFees\":0,\"merchantFees\":0,\"net\":0},\"GatewayTotal\":{\"count\":1,\"value\":900.9,\"fees\":0,\"recipientFees\":0,\"merchantFees\":0,\"net\":900.9},\"total\":{\"count\":1,\"value\":900.9,\"fees\":0,\"recipientFees\":0,\"merchantFees\":0,\"net\":900.9},\"merchantBalances\":{\"GatewayTotal\":0,\"PaymentRailsTotal\":10000},\"enoughFunds\":true}}";
    }

    private String fakeGenerateQuote(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"batch\":{\"id\":\"B-91XQ2ZGK7DKMJ\",\"status\":\"open\",\"amount\":\"900.90\",\"totalPayments\":\"1\",\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":null,\"completedAt\":null,\"createdAt\":\"2017-05-08T17:09:04.889Z\",\"updatedAt\":\"2017-05-17T15:00:14.262Z\"}}";
    }

    private String fakeProcessBatch(String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"batch\":{\"id\":\"B-91XQ2ZGK7DKMJ\",\"status\":\"processing\",\"amount\":\"900.90\",\"totalPayments\":1,\"currency\":\"USD\",\"description\":\"Weekly Payouts on 2017-4-8\",\"sentAt\":\"2017-05-17T15:00:49.458Z\",\"completedAt\":null,\"createdAt\":\"2017-05-08T17:09:04.889Z\",\"updatedAt\":\"2017-05-17T15:00:49.459Z\"}}";
    }

}
