
package ca.paymentrails.paymentrails.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import ca.paymentrails.paymentrails.Batch;
import ca.paymentrails.paymentrails.BatchSummary;
import ca.paymentrails.paymentrails.Configuration;
import ca.paymentrails.paymentrails.Gateway;
import ca.paymentrails.paymentrails.Payment;
import ca.paymentrails.paymentrails.Recipient;

@PrepareForTest(Recipient.class)
public class BatchTest {

    private static Configuration config;

    @BeforeClass 
    public static void setupConfig() {
        final String ACCESS_KEY = "YourAccessKey";
        final String SECRET_KEY = "YourSecretKey";
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

    @Test
    public void testCreateWithPayments() throws Exception {
        Gateway client = new Gateway(config);

        Recipient recipientAlpha = createRecipient();

        String body = "{\"payments\": [{\"recipient\": {\"id\": " + "\"" + recipientAlpha.getId() + "\""
                + "},\"amount\": \"10.00\", \"currency\": \"EUR\"}]}";
        Batch batch = client.batch.create(body);

        assertNotNull(batch);
        assertNotNull(batch.getId());

        Batch batch1 = client.batch.find(batch.getId());
        assertNotNull(batch1);

        assertEquals(1, batch1.getPayments().getPayments().size());
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

        String batch1 = client.batch.generateQuote(batch.getId());
        assertNotNull(batch1);
        String batch2 = client.batch.processBatch(batch.getId());
        assertNotNull(batch2);

    }
}