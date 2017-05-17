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
@PrepareForTest(PaymentRails_Payment.class)
public class PaymentRails_PaymentTest {

    @Test
    public void testRetrievePayment() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(PaymentRails_Payment.get(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.get(payment_id, batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePaymentInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(PaymentRails_Payment.get(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.get(payment_id, batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePaymentInvalidPaymentId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "91XQ40VT54GQM";
        when(PaymentRails_Payment.get(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.get(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrievePaymentNullPaymentId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = null;
        when(PaymentRails_Payment.get(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.get(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrievePaymentNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = null;
        String payment_id = "P-91XQ40VT54GQM";
        when(PaymentRails_Payment.get(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.get(payment_id, batch_id);
    }

    @Test
    public void testCreatePayment() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String batch_id = "B-91XQ40VT5HF18";
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.post(body, batch_id)).thenReturn(fakePost(body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.post(body, batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePaymentInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String batch_id = "91XQ40VT5HF18";
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.post(body, batch_id)).thenReturn(fakePost(body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.post(body, batch_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testCreatePaymentNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String batch_id = null;
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.post(body, batch_id)).thenReturn(fakePost(body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.post(body, batch_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testCreatePaymentNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = null;
        String batch_id = "B-91XQ40VT5HF18";
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.post(body, batch_id)).thenReturn(fakePost(body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.post(body, batch_id);

    }

    @Test
    public void testUpdatePayment() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"sourceAmount\":\"900.90\"}";;
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.patch(payment_id, body, batch_id)).thenReturn(fakePatch(payment_id, body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.patch(payment_id, body, batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = "91XQ40VT5HF18";
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.patch(payment_id, body, batch_id)).thenReturn(fakePatch(payment_id, body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.patch(payment_id, body, batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidPaymentId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "ghghghgh";

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.patch(payment_id, body, batch_id)).thenReturn(fakePatch(payment_id, body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.patch(payment_id, body, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePaymentNullPaymentId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = null;

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.patch(payment_id, body, batch_id)).thenReturn(fakePatch(payment_id, body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.patch(payment_id, body, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePaymentNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = null;
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.patch(payment_id, body, batch_id)).thenReturn(fakePatch(payment_id, body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.patch(payment_id, body, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePaymentNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        String body = null;
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        when(PaymentRails_Payment.patch(payment_id, body, batch_id)).thenReturn(fakePatch(payment_id, body, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.patch(payment_id, body, batch_id);
    }

    @Test
    public void testDeletePayment() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(PaymentRails_Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.delete(payment_id, batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(PaymentRails_Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.delete(payment_id, batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidPaymentId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "91XQ40VT54GQM";
        when(PaymentRails_Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.delete(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeletePaymentNullPaymentId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = null;
        when(PaymentRails_Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.delete(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeletePaymentNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = null;
        String payment_id = "P-91XQ40VT54GQM";
        when(PaymentRails_Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.delete(payment_id, batch_id);
    }

    @Test
    public void testListAllPaymentsWithQueries() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(PaymentRails_Payment.query(batch_id, 1, 10, "hm16")).thenReturn(fakeQuery(batch_id, 1, 10, "hm16"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Payment.query(batch_id, 1, 10, "hm16");
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListAllPaymentsInvalidBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "91XQ40VT5HF18";
        when(PaymentRails_Payment.query(batch_id, 1, 10, "hm16")).thenReturn(fakeQuery(batch_id, 1, 10, "hm16"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.query(batch_id, 1, 10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNullBatchId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = null;
        when(PaymentRails_Payment.query(batch_id, 1, 10, "hm16")).thenReturn(fakeQuery(batch_id, 1, 10, "hm16"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.query(batch_id, 1, 10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNegativePage() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(PaymentRails_Payment.query(batch_id, -1, 10, "hm16")).thenReturn(fakeQuery(batch_id, -1, 10, "hm16"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.query(batch_id, -1, 10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNegativePageNumber() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(PaymentRails_Payment.query(batch_id, 1, -10, "hm16")).thenReturn(fakeQuery(batch_id, 1, -10, "hm16"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.query(batch_id, 1, -10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNullTerm() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(PaymentRails_Payment.query(batch_id, 1, 10, null)).thenReturn(fakeQuery(batch_id, 1, 10, null));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Payment.query(batch_id, 1, 10, null);
    }

    private String fakeGet(String payment_id, String batch_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        if (!payment_id.substring(0, 1).equals("P")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"payment\":{\"id\":\"P-91XQ2ZGK7HM62\",\"recipient\":{\"id\":\"R-91XQ0PJH39U54\",\"referenceId\":\"U345678912\",\"email\":\"Johnny@test.com\",\"name\":\"mark Test\",\"lastName\":\"Test\",\"firstName\":\"mark\",\"type\":\"individual\",\"status\":\"active\",\"language\":\"en\",\"complianceStatus\":\"pending\",\"dob\":null,\"payoutMethod\":\"paypal\",\"updatedAt\":\"2017-05-08T14:49:12.512Z\",\"createdAt\":\"2017-05-04T16:17:04.378Z\",\"gravatarUrl\":\"https://s3.amazonaws.com/static.api.paymentrails.com/icon_user.svg\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"payout\":{\"autoswitch\":{\"limit\":1000,\"active\":false},\"holdup\":{\"limit\":1000,\"active\":false},\"primary\":{\"method\":\"paypal\",\"currency\":{\"currency\":{}}},\"method\":\"paypal\",\"accounts\":{\"paypal\":{\"address\":\"testpaypal@example.com\"}},\"methodDisplay\":\"PayPal\"},\"address\":{\"street1\":null,\"street2\":null,\"city\":null,\"postalCode\":null,\"country\":null,\"region\":null,\"phone\":null}},\"status\":\"pending\",\"sourceAmount\":\"900.90\",\"exchangeRate\":\"1.000000\",\"fees\":\"0.00\",\"recipientFees\":\"0.00\",\"targetAmount\":\"65.00\",\"fxRate\":\"2.000000\",\"memo\":\"\",\"processedAt\":null,\"createdAt\":\"2017-05-08T17:09:05.157Z\",\"updatedAt\":\"2017-05-16T20:47:10.034Z\",\"merchantFees\":\"0.00\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"sourceCurrency\":\"USD\",\"sourceCurrencyName\":\"US Dollar\",\"targetCurrency\":\"USD\",\"targetCurrencyName\":\"US Dollar\",\"batch\":{\"id\":\"B-91XQ2ZGK7DKMJ\",\"createdAt\":\"2017-05-08T17:09:04.889Z\",\"updatedAt\":\"2017-05-17T15:00:49.459Z\",\"sentAt\":\"2017-05-17T15:00:49.458Z\",\"completedAt\":null}}}";
    }

    private String fakePost(String body, String batch_id) throws InvalidFieldException, InvalidStatusCodeException {

        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true}";
    }

    private String fakePatch(String payment_id, String body, String batch_id) throws InvalidFieldException, InvalidStatusCodeException {
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        if (!payment_id.substring(0, 1).equals("P")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"updated\"}";
    }

    private String fakeDelete(String payment_id, String batch_id) throws InvalidStatusCodeException, InvalidFieldException {

        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        if (!payment_id.substring(0, 1).equals("P")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"deleted\"}";
    }

    private String fakeQuery(String batch_id, int page, int pageSize, String term) throws InvalidFieldException, InvalidStatusCodeException {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"payments\":[{\"id\":\"P-91XQ2ZGK7HM62\",\"recipient\":{\"id\":\"R-91XQ0PJH39U54\",\"referenceId\":\"U345678912\",\"email\":\"Johnny@test.com\",\"name\":\"mark Test\",\"lastName\":\"Test\",\"firstName\":\"mark\",\"type\":\"individual\",\"status\":\"active\",\"language\":\"en\",\"complianceStatus\":\"pending\",\"dob\":null,\"payoutMethod\":\"paypal\",\"updatedAt\":\"2017-05-08T14:49:12.512Z\",\"createdAt\":\"2017-05-04T16:17:04.378Z\",\"gravatarUrl\":\"https://s3.amazonaws.com/static.api.paymentrails.com/icon_user.svg\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"payout\":{\"autoswitch\":{\"limit\":1000,\"active\":false},\"holdup\":{\"limit\":1000,\"active\":false},\"primary\":{\"method\":\"paypal\",\"currency\":{\"currency\":{}}},\"method\":\"paypal\",\"accounts\":{\"paypal\":{\"address\":\"testpaypal@example.com\"}},\"methodDisplay\":\"PayPal\"},\"address\":{\"street1\":null,\"street2\":null,\"city\":null,\"postalCode\":null,\"country\":null,\"region\":null,\"phone\":null}},\"status\":\"pending\",\"sourceAmount\":\"900.90\",\"exchangeRate\":\"1.000000\",\"fees\":\"0.00\",\"recipientFees\":\"0.00\",\"targetAmount\":\"65.00\",\"fxRate\":\"2.000000\",\"memo\":\"\",\"processedAt\":null,\"createdAt\":\"2017-05-08T17:09:05.157Z\",\"updatedAt\":\"2017-05-16T20:47:10.034Z\",\"merchantFees\":\"0.00\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"sourceCurrency\":\"USD\",\"sourceCurrencyName\":\"US Dollar\",\"targetCurrency\":\"USD\",\"targetCurrencyName\":\"US Dollar\",\"batch\":{\"id\":\"B-91XQ2ZGK7DKMJ\",\"createdAt\":\"2017-05-08T17:09:04.889Z\",\"updatedAt\":\"2017-05-17T15:00:49.459Z\",\"sentAt\":\"2017-05-17T15:00:49.458Z\",\"completedAt\":null}}],\"meta\":{\"page\":1,\"pages\":1,\"records\":1}}";
    }
}
