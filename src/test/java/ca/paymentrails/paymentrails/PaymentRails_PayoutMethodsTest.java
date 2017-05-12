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
public class PaymentRails_PayoutMethodsTest {

    @Test
    public void testRetrievePayoutMethods() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-91XQ4QBJ65W1U";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);

    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("ddd");
        String recipient_id = "R-91XQ4QBJ65W1U";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidPayoutStatus() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-91XQ4VKD39C3P";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-ff";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
    }

    @Ignore("Ignored as not to continousuly create payout methods")
    @Test
    public void testCreatePayoutMethods() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        String response = PaymentRails_PayoutMethods.post(recipient_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePayoutMethodsInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("ddd");
        String recipient_id = "R-91XQ4QBJ65W1U";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        String response = PaymentRails_PayoutMethods.post(recipient_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-dddd";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        String response = PaymentRails_PayoutMethods.post(recipient_id, body);
    }

    @Test
    public void testUpdatePayoutMethods() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-91XQ4QBJ65W1U";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePayoutMethodsInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("ddd");
        String recipient_id = "R-91XQ4QBJ65W1U";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String recipient_id = "R-ddd";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
    }
}
