package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jesse
 */
public class PaymentRails_PaymentTest {

    @Test
    public void testRetrievePayment() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        PaymentRails_Payment.batch_id = "B-91XPU88Q093HW";
        String payment_id = "P-91XPU88Q5GN2E";
        String response = PaymentRails_Payment.get(payment_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRPaymentInvalidAPI() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ffff");
        PaymentRails_Payment.batch_id = "B-91XPU88Q093HW";
        String payment_id = "P-91XPU88Q5GN2E";
        String response = PaymentRails_Payment.get(payment_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePaymentInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-ffff";
        String payment_id = "P-91XPU88Q5GN2E";
        String response = PaymentRails_Payment.get(payment_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePaymentInvalidPaymentId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-91XPU88Q093HW";
        String payment_id = "P-fff";
        String response = PaymentRails_Payment.get(payment_id);
    }

    @Ignore("Ignored as not to keep creating payments")
    @Test
    public void testCreatePayment() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String response = PaymentRails_Payment.post(body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePaymentInvalidAPI() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("fff");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String response = PaymentRails_Payment.post(body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePaymentInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-ffff";
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String response = PaymentRails_Payment.post(body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePaymentInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"recipient\":{\"id\":\"R-fefe\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String response = PaymentRails_Payment.post(body);
    }

    @Test
    public void testUpdatePayment() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"sourceAmount\":\"900.90\"}";
        String payment_id = "P-91XPU81ECR606";
        String response = PaymentRails_Payment.patch(payment_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("dddd");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"sourceAmount\":\"900.90\"}";
        String payment_id = "P-91XPU81ECR606";
        String response = PaymentRails_Payment.patch(payment_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-dddd";
        String body = "{\"sourceAmount\":\"900.90\"}";
        String payment_id = "P-91XPU81ECR606";
        String response = PaymentRails_Payment.patch(payment_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidPaymentId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"sourceAmount\":\"900.90\"}";
        String payment_id = "P-ddd";
        String response = PaymentRails_Payment.patch(payment_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidSourceAmount() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String body = "{\"sourceAmount\":\"900.9\"}";
        String payment_id = "P-91XPU81ECR606";
        String response = PaymentRails_Payment.patch(payment_id, body);
    }

    @Ignore("Ignored as not to continiously delete payments")
    @Test
    public void testDeletePayment() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        PaymentRails_Payment.batch_id = "B-912Q010UD98KU";
        String payment_id = "P-912Q010UF904W";
        String response = PaymentRails_Payment.delete(payment_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("dddd");

        PaymentRails_Payment.batch_id = "B-912Q010UD98KU";
        String payment_id = "P-912Q010UF904W";
        String response = PaymentRails_Payment.delete(payment_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        PaymentRails_Payment.batch_id = "B-dddd";
        String payment_id = "P-912Q010UF904W";
        String response = PaymentRails_Payment.delete(payment_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidPaymentId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        PaymentRails_Payment.batch_id = "B-912Q010UD98KU";
        String payment_id = "P-ddd";
        String response = PaymentRails_Payment.delete(payment_id);
    }

    @Test
    public void testListAllPayments() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String response = PaymentRails_Payment.query();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test
    public void testListAllPaymentsWithQueries() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String response = PaymentRails_Payment.query(1, 10, "");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListAllPaymentsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ddd");
        PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        String response = PaymentRails_Payment.query();
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListAllPaymentsInvalidBatchId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        PaymentRails_Payment.batch_id = "B-ddds";
        String response = PaymentRails_Payment.query();
    }
}
