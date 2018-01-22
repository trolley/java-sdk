
package ca.paymentrails.paymentrails.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import ca.paymentrails.paymentrails.Batch;
import ca.paymentrails.paymentrails.BatchSummary;
import ca.paymentrails.paymentrails.Configuration;
import ca.paymentrails.paymentrails.Payment;
import ca.paymentrails.paymentrails.Recipient;
import ca.paymentrails.paymentrails.RecipientAccount;

import java.util.List;

@PrepareForTest(Recipient.class)
public class BatchTest {

    private Recipient createRecipient(int num) throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");

        String email = "\"jsmith" + num + "@example.com\"";
        String body = "{\"type\": \"individual\",\"firstName\": \"John\",\"lastName\": \"Smith\",\"email\":" + email
                + "}";
        Recipient recipient = Recipient.create(body);

        body = "{\"type\": \"bank-transfer\", \"primary\": \"true\", \"country\": \"CA\", \"currency\": \"CAD\",\"accountNum\": \"604622847\", \"bankId\": \"123\", \"branchId\": \"47261\",  \"accountHolderName\": \"John Smith\"}";
        RecipientAccount.create(recipient.getId(), body);

        return recipient;
    }

    @Test
    public void testCreate() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");
        String body = "{\"sourceCurrency\": \"USD\", \"description\":\"Integration Test Create\"}";
        Batch batch = Batch.create(body);
        assertEquals(batch.getCurrency(), "USD");
    }

    @Test
    public void testUpdate() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");
        String body = "{\"sourceCurrency\": \"USD\", \"description\":\"Integration Test Create\"}";
        Batch batch = Batch.create(body);
        assertEquals(batch.getCurrency(), "USD");

        body = "{\"description\" : \"Integration Update\"}";
        String response = Batch.update(batch.getId(), body);
        assertNotNull(response);

        Batch batch1 = Batch.find(batch.getId());
        assertEquals(batch1.getDescription(), "Integration Update");

        response = Batch.delete(batch1.getId());
        assertNotNull(response);
    }

    @Test
    public void testCreateWithPayments() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");

        Recipient recipientAlpha = createRecipient(45);
        Recipient recipientBeta = createRecipient(46);

        String body = "{\"payments\": [{\"recipient\": {\"id\": " + "\"" + recipientAlpha.getId() + "\""
                + "},\"targetAmount\": \"10.00\", \"targetCurrency\": \"CAD\"},{\"recipient\": {\"id\": " + "\""
                + recipientBeta.getId() + "\"" + "},\"sourceAmount\": \"10\", \"sourceCurrency\": \"CAD\"}]}";
        Batch batch = Batch.create(body);

        assertNotNull(batch);
        assertNotNull(batch.getId());

        Batch batch1 = Batch.find(batch.getId());
        assertNotNull(batch1);

        assertEquals(2, batch1.getPayments().getPayments().size());
    }

    @Test
    public void testPayments() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");
        String body = "{\"sourceCurrency\": \"CAD\", \"description\":\"Integration Test Create\"}";
        Batch batch = Batch.create(body);
        assertEquals(batch.getCurrency(), "CAD");

        Recipient recipient = createRecipient(53);
        body = "{\"sourceAmount\":\"10.00\", \"recipient\": {\"id\": " + "\"" + recipient.getId() + "\"" + "}}";
        Payment payment = Payment.create(body, batch.getId());
        assertNotNull(payment);
        assertNotNull(payment.getId());
        body = "{\"sourceAmount\":\"20.00\"}";
        String response = Payment.update(payment.getId(), body, batch.getId());
        assertNotNull(response);

        response = Payment.delete(payment.getId(), batch.getId());
        assertNotNull(response);
    }

    @Test
    public void testProcessing() throws Exception {
        Configuration.setPublicKey("YOUR-PUBLIC-KEY");
        Configuration.setPrivateKey("YOUR-PRIVATE-KEY");

        Recipient recipientAlpha = createRecipient(47);
        Recipient recipientBeta = createRecipient(48);

        String body = "{\"payments\": [{\"recipient\": {\"id\": " + "\"" + recipientAlpha.getId() + "\""
                + "},\"targetAmount\": \"10.00\", \"targetCurrency\": \"CAD\"},{\"recipient\": {\"id\": " + "\""
                + recipientBeta.getId() + "\"" + "},\"sourceAmount\": \"10\", \"sourceCurrency\": \"CAD\"}]}";

        Batch batch = Batch.create(body);
        assertNotNull(batch);
        assertNotNull(batch.getId());

        BatchSummary batchSummary = Batch.summary(batch.getId());
        assertNotNull(batchSummary);
        assertEquals(2, batchSummary.detail.bankTransfer.count.intValue());

        String batch1 = Batch.generateQuote(batch.getId());
        assertNotNull(batch1);
        String batch2 = Batch.processBatch(batch.getId());
        assertNotNull(batch2);

    }
}