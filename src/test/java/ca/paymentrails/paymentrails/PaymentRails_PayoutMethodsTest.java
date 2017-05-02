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
public class PaymentRails_PayoutMethodsTest {

    @Test
    public void testRetrievePayoutMethods() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-912Q4JHD6RH7E";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
        String result = response.substring(6, 10);
        assertEquals("true", result);

    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ddd");
        String recipient_id = "R-912Q4JHD6RH7E";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidPayoutStatus() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-91XPY2G3F5R34";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-ff";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
    }

    @Ignore("Ignored as not to continousuly create payout methods")
    @Test
    public void testCreatePayoutMethods() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
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
    public void testCreatePayoutMethodsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ddd");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        String response = PaymentRails_PayoutMethods.post(recipient_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-dddd";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        String response = PaymentRails_PayoutMethods.post(recipient_id, body);
    }

    @Test
    public void testUpdatePayoutMethods() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePayoutMethodsInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("ddd");
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String recipient_id = "R-ddd";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
    }
}
