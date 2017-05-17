package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import org.junit.Test;
import static org.junit.Assert.*;
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
@PrepareForTest(PaymentRails_PayoutMethods.class)
public class PaymentRails_PayoutMethodsTest {

    @Test
    public void testRetrievePayoutMethods() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        when(PaymentRails_PayoutMethods.get("R-91XQ4QBJ65W1U")).thenReturn(fakeGet("R-91XQ4QBJ65W1U"));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        String recipient_id = "R-91XQ4QBJ65W1U";
        String response = PaymentRails_PayoutMethods.get(recipient_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);

    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrievePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "91XQ4QBJ65W1U";
        when(PaymentRails_PayoutMethods.get(recipient_id)).thenReturn(fakeGet(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        PaymentRails_PayoutMethods.get(recipient_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrievePayoutMethodsNullRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = null;
        when(PaymentRails_PayoutMethods.get(recipient_id)).thenReturn(fakeGet(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        PaymentRails_PayoutMethods.get(recipient_id);

    }

    @Test
    public void testCreatePayoutMethods() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        when(PaymentRails_PayoutMethods.post(recipient_id, body)).thenReturn(fakePost(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_PayoutMethods.post(recipient_id, body);
        String result = response.substring(6, 10);
        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testCreatePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        when(PaymentRails_PayoutMethods.post(recipient_id, body)).thenReturn(fakePost(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_PayoutMethods.post(recipient_id, body);

    }

    @Test(expected = InvalidFieldException.class)
    public void testCreatePayoutMethodsNullRecipientId() throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = null;
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        when(PaymentRails_PayoutMethods.post(recipient_id, body)).thenReturn(fakePost(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_PayoutMethods.post(recipient_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testCreatePayoutMethodsNullBody() throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = null;
        when(PaymentRails_PayoutMethods.post(recipient_id, body)).thenReturn(fakePost(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_PayoutMethods.post(recipient_id, body);
    }

    @Test
    public void testUpdatePayoutMethods() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        when(PaymentRails_PayoutMethods.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
        String result = response.substring(6, 10);
        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdatePayoutMethodsInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        when(PaymentRails_PayoutMethods.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_PayoutMethods.patch(recipient_id, body);

    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePayoutMethodsNullRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = null;
        String body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        when(PaymentRails_PayoutMethods.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_PayoutMethods.patch(recipient_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdatePayoutMethodsNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_PayoutMethods.class);
        String recipient_id = "R-912Q4JHD6RH7E";
        String body = null;
        when(PaymentRails_PayoutMethods.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_PayoutMethods.patch(recipient_id, body);
    }

    private String fakeGet(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"recipient\":{\"id\":\"R-91XQ8T3G088QM\",\"referenceId\":\"jsmith@examwdple.com\",\"email\":\"jsmith@examwdple.com\",\"name\":\"John Smith\",\"lastName\":\"Smith\",\"firstName\":\"John\",\"type\":\"individual\",\"status\":\"incomplete\",\"language\":\"en\",\"complianceStatus\":\"pending\",\"dob\":null,\"payoutMethod\":null,\"updatedAt\":\"2017-05-15T20:34:50.558Z\",\"createdAt\":\"2017-05-15T20:34:50.558Z\",\"gravatarUrl\":\"https://s3.amazonaws.com/static.api.paymentrails.com/icon_user.svg\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"payout\":{\"method\":null},\"address\":{\"street1\":null,\"street2\":null,\"city\":null,\"postalCode\":null,\"country\":null,\"region\":null,\"phone\":null}}}";
    }

    private String fakePost(String recipient_id, String body) throws InvalidFieldException, InvalidStatusCodeException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true}";
    }

    private String fakePatch(String recipient_id, String body) throws InvalidFieldException, InvalidStatusCodeException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"object\":\"updated\"}";
    }
}
