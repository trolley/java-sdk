package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import ca.paymentrails.paymentrails.PaymentRails_Configuration;
import ca.paymentrails.paymentrails.PaymentRails_Recipient;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jesse
 */
public class PaymentRails_RecipientTest {

    @Test
    public void testRetrieveRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.get(recipient_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRecipientInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("jjj");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.get(recipient_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRecipientInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-wd";
        String response = PaymentRails_Recipient.get(recipient_id);
    }

    @Ignore("Ingore as not to continuously create recipients")
    @Test
    public void testCreateRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String body = "{\"type\": \"individual\", \"firstName\": \"test\", \"lastName\": \"teston\", \"email\": \"test@example.com\"}";
        String response = PaymentRails_Recipient.post(body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreateRecipientInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("jjj");
        String body = "{\"type\": \"individual\", \"firstName\": \"Michael\", \"lastName\": \"Jackson\", \"email\": \"mj@example.com\"}";
        String response = PaymentRails_Recipient.post(body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreateRecipientMissingField() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String body = "{\"firstName\": \"Michael\", \"lastName\": \"Jackson\", \"email\": \"mj@example.com\"}";
        String response = PaymentRails_Recipient.post(body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreateRecipientInvalidFieldValidation() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String body = "{\"type\": \"individual\", \"firstName\": \"Michael\", \"lastName\": \"Jackson\", \"email\": \"m\"}";
        String response = PaymentRails_Recipient.post(body);
    }

    @Test
    public void testUpdateRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"email\": \"mj@theking.com\"}";
        String response = PaymentRails_Recipient.patch(recipient_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("fe");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"email\": \"mj@theking.com\"}";
        String response = PaymentRails_Recipient.patch(recipient_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-wdwd";
        String body = "{\"email\": \"mj@theking.com\"}";
        String response = PaymentRails_Recipient.patch(recipient_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidField() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"email\": \"}";
        String response = PaymentRails_Recipient.patch(recipient_id, body);
    }

    @Ignore("Ignored as not to continuously delete recipients")
    @Test
    public void testDeleteRecipient() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-91XPY1JF4X316";
        String response = PaymentRails_Recipient.delete(recipient_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("wdwd");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.delete(recipient_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-wdwd";
        String response = PaymentRails_Recipient.delete(recipient_id);
    }

    @Test
    public void testListAllRecipientsWithQueries() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String response = PaymentRails_Recipient.query(1, 10, "");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test
    public void testListAllRecipients() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String response = PaymentRails_Recipient.query();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testListAllRecipientsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("wdwd");
        String response = PaymentRails_Recipient.query();
    }

    @Test
    public void testRetrieveAlPayments() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.get(recipient_id, "payments");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveAlPaymentsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ffe");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.get(recipient_id, "payments");
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveAlPaymentsInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-fee";
        String response = PaymentRails_Recipient.get(recipient_id, "payments");
    }

    @Test
    public void testRetrieveAlLogs() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.get(recipient_id, "logs");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveAllLogsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("dd");
        String recipient_id = "R-91XPJZTR612MG";
        String response = PaymentRails_Recipient.get(recipient_id, "payments");
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveAlLogsInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-ff";
        String response = PaymentRails_Recipient.get(recipient_id, "payments");
    }
}
