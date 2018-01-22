package ca.paymentrails.paymentrails.unit;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import ca.paymentrails.paymentrails.Payment;

import java.util.List;
import java.util.ArrayList;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Payment.class)
public class PaymentTest {

    @Test
    public void testRetrievePayment() throws Exception {

        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(Payment.find(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        Payment response = Payment.find(payment_id, batch_id);

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePaymentInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(Payment.find(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        Payment.find(payment_id, batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePaymentInvalidPaymentId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "91XQ40VT54GQM";
        when(Payment.find(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        Payment.find(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrievePaymentNullPaymentId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = null;
        when(Payment.find(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        Payment.find(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrievePaymentNullBatchId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = null;
        String payment_id = "P-91XQ40VT54GQM";
        when(Payment.find(payment_id, batch_id)).thenReturn(fakeGet(payment_id, batch_id));

        Payment.find(payment_id, batch_id);
    }

    @Test
    public void testCreatePayment() throws Exception {

        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String batch_id = "B-91XQ40VT5HF18";
        PowerMockito.mockStatic(Payment.class);

        when(Payment.create(body, batch_id)).thenReturn(fakeCreate(body, batch_id));

        Payment response = Payment.create(body, batch_id);

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePaymentInvalidBatchId() throws Exception {
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String batch_id = "91XQ40VT5HF18";
        PowerMockito.mockStatic(Payment.class);

        when(Payment.create(body, batch_id)).thenReturn(fakeCreate(body, batch_id));

        Payment.create(body, batch_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testCreatePaymentNullBatchId() throws Exception {
        String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        String batch_id = null;
        PowerMockito.mockStatic(Payment.class);

        when(Payment.create(body, batch_id)).thenReturn(fakeCreate(body, batch_id));

        Payment.create(body, batch_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testCreatePaymentNullBody() throws Exception {
        String body = null;
        String batch_id = "B-91XQ40VT5HF18";
        PowerMockito.mockStatic(Payment.class);

        when(Payment.create(body, batch_id)).thenReturn(fakeCreate(body, batch_id));

        Payment.create(body, batch_id);

    }

    @Test
    public void testUpdatePayment() throws Exception {
        String body = "{\"sourceAmount\":\"900.90\"}";
        ;
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(Payment.class);

        when(Payment.update(payment_id, body, batch_id)).thenReturn(fakeupdate(payment_id, body, batch_id));

        String response = Payment.update(payment_id, body, batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidBatchId() throws Exception {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = "91XQ40VT5HF18";
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(Payment.class);

        when(Payment.update(payment_id, body, batch_id)).thenReturn(fakeupdate(payment_id, body, batch_id));

        Payment.update(payment_id, body, batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePaymentInvalidPaymentId() throws Exception {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "ghghghgh";

        PowerMockito.mockStatic(Payment.class);

        when(Payment.update(payment_id, body, batch_id)).thenReturn(fakeupdate(payment_id, body, batch_id));

        Payment.update(payment_id, body, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePaymentNullPaymentId() throws Exception {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = null;

        PowerMockito.mockStatic(Payment.class);

        when(Payment.update(payment_id, body, batch_id)).thenReturn(fakeupdate(payment_id, body, batch_id));

        Payment.update(payment_id, body, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePaymentNullBatchId() throws Exception {
        String body = "{\"sourceAmount\":\"900.90\"}";
        String batch_id = null;
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(Payment.class);

        when(Payment.update(payment_id, body, batch_id)).thenReturn(fakeupdate(payment_id, body, batch_id));

        Payment.update(payment_id, body, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePaymentNullBody() throws Exception {
        String body = null;
        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-ghghghgh";

        PowerMockito.mockStatic(Payment.class);

        when(Payment.update(payment_id, body, batch_id)).thenReturn(fakeupdate(payment_id, body, batch_id));

        Payment.update(payment_id, body, batch_id);
    }

    @Test
    public void testDeletePayment() throws Exception {

        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        String response = Payment.delete(payment_id, batch_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "91XQ40VT5HF18";
        String payment_id = "P-91XQ40VT54GQM";
        when(Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        Payment.delete(payment_id, batch_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeletePaymentInvalidPaymentId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = "91XQ40VT54GQM";
        when(Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        Payment.delete(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeletePaymentNullPaymentId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        String payment_id = null;
        when(Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        Payment.delete(payment_id, batch_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeletePaymentNullBatchId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = null;
        String payment_id = "P-91XQ40VT54GQM";
        when(Payment.delete(payment_id, batch_id)).thenReturn(fakeDelete(payment_id, batch_id));

        Payment.delete(payment_id, batch_id);
    }

    @Test
    public void testListAllPaymentsWithQueries() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(Payment.query(batch_id, 1, 10, "hm16")).thenReturn(fakeQuery(batch_id, 1, 10, "hm16"));

        List<Payment> response = Payment.query(batch_id, 1, 10, "hm16");

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.get(0).getId());
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListAllPaymentsInvalidBatchId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "91XQ40VT5HF18";
        when(Payment.query(batch_id, 1, 10, "hm16")).thenReturn(fakeQuery(batch_id, 1, 10, "hm16"));

        Payment.query(batch_id, 1, 10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNullBatchId() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = null;
        when(Payment.query(batch_id, 1, 10, "hm16")).thenReturn(fakeQuery(batch_id, 1, 10, "hm16"));

        Payment.query(batch_id, 1, 10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNegativePage() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(Payment.query(batch_id, -1, 10, "hm16")).thenReturn(fakeQuery(batch_id, -1, 10, "hm16"));

        Payment.query(batch_id, -1, 10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNegativePageNumber() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(Payment.query(batch_id, 1, -10, "hm16")).thenReturn(fakeQuery(batch_id, 1, -10, "hm16"));

        Payment.query(batch_id, 1, -10, "hm16");
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllPaymentsNullTerm() throws Exception {
        PowerMockito.mockStatic(Payment.class);

        String batch_id = "B-91XQ40VT5HF18";
        when(Payment.query(batch_id, 1, 10, null)).thenReturn(fakeQuery(batch_id, 1, 10, null));

        Payment.query(batch_id, 1, 10, null);
    }

    private Payment fakeGet(String payment_id, String batch_id)
            throws InvalidStatusCodeException, InvalidFieldException {
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
        Payment payment = new Payment();
        payment.setId("1A2B3C");
        return payment;
    }

    private Payment fakeCreate(String body, String batch_id) throws InvalidFieldException, InvalidStatusCodeException {

        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (!batch_id.substring(0, 1).equals("B")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        Payment payment = new Payment();
        payment.setId("1A2B3C");
        return payment;
    }

    private String fakeupdate(String payment_id, String body, String batch_id)
            throws InvalidFieldException, InvalidStatusCodeException {
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

    private String fakeDelete(String payment_id, String batch_id)
            throws InvalidStatusCodeException, InvalidFieldException {

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

    private List<Payment> fakeQuery(String batch_id, int page, int pageSize, String term)
            throws InvalidFieldException, InvalidStatusCodeException {
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
        List<Payment> payments = new ArrayList<Payment>();
        Payment payment = new Payment();
        payment.setId("1A2B3C");
        payments.add(payment);
        return payments;
    }
}
