package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
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
@PrepareForTest(PaymentRails_Recipient.class)
public class PaymentRails_RecipientTest {

    @Test
    public void testRetrieveRecipient() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(PaymentRails_Recipient.get(recipient_id)).thenReturn(fakeGet(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Recipient.get(recipient_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRecipientInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "91XQ4VKD39C3P";
        when(PaymentRails_Recipient.get(recipient_id)).thenReturn(fakeGet(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.get(recipient_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrieveRecipientNullRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = null;
        when(PaymentRails_Recipient.get(recipient_id)).thenReturn(fakeGet(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.get(recipient_id);

    }

    @Test
    public void testCreateRecipient() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String body = "{\"type\": \"individual\", \"firstName\": \"test\", \"lastName\": \"teston\", \"email\": \"test@example.com\"}";

        when(PaymentRails_Recipient.post(body)).thenReturn(fakePost(body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Recipient.post(body);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidFieldException.class)
    public void testCreateRecipientNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String body = null;

        when(PaymentRails_Recipient.post(body)).thenReturn(fakePost(body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.post(body);
    }

    @Test
    public void testUpdateRecipient() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String body = "{\"email\": \"mj@theking.com\"}";
        when(PaymentRails_Recipient.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Recipient.patch(recipient_id, body);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "91XQ4VKD39C3P";
        String body = "{\"email\": \"mj@theking.com\"}";
        when(PaymentRails_Recipient.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.patch(recipient_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateRecipientNullRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = null;
        String body = "{\"email\": \"mj@theking.com\"}";
        when(PaymentRails_Recipient.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.patch(recipient_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateRecipientNullBody() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String body = null;
        when(PaymentRails_Recipient.patch(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.patch(recipient_id, body);
    }

    @Test
    public void testDeleteRecipient() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(PaymentRails_Recipient.delete(recipient_id)).thenReturn(fakeDelete(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Recipient.delete(recipient_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "91XQ4VKD39C3P";
        when(PaymentRails_Recipient.delete(recipient_id)).thenReturn(fakeDelete(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        PaymentRails_Recipient.delete(recipient_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeleteRecipientNullRecipientId() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = null;
        when(PaymentRails_Recipient.delete(recipient_id)).thenReturn(fakeDelete(recipient_id));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        PaymentRails_Recipient.delete(recipient_id);
    }

    @Test
    public void testListAllRecipientsWithQueries() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);

        when(PaymentRails_Recipient.query(1, 10, "j@j.com")).thenReturn(fakeQuery(1, 10, "j@j.com"));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        String response = PaymentRails_Recipient.query(1, 10, "j@j.com");
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllRecipientsWithQueriesNegativePage() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);

        when(PaymentRails_Recipient.query(-1, 10, "j@j.com")).thenReturn(fakeQuery(-1, 10, "j@j.com"));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        PaymentRails_Recipient.query(-1, 10, "j@j.com");

    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllRecipientsWithQueriesNegativePageNumber() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);

        when(PaymentRails_Recipient.query(1, -10, "j@j.com")).thenReturn(fakeQuery(1, -10, "j@j.com"));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        PaymentRails_Recipient.query(1, -10, "j@j.com");

    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllRecipientsWithQueriesNullTerm() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        when(PaymentRails_Recipient.query(1, 10, null)).thenReturn(fakeQuery(1, 10, null));

        PaymentRails_Configuration.setApiKey("pk_test_test");
        PaymentRails_Recipient.query(1, 10, null);
    }

    @Test
    public void testRetrieveAlPayments() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(PaymentRails_Recipient.get(recipient_id, "payments")).thenReturn(fakeGet(recipient_id, "payments"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Recipient.get(recipient_id, "payments");
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test
    public void testRetrieveAlLogs() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PowerMockito.mockStatic(PaymentRails_Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(PaymentRails_Recipient.get(recipient_id, "logs")).thenReturn(fakeGet(recipient_id, "logs"));

        PaymentRails_Configuration.setApiKey("pk_test_test");

        String response = PaymentRails_Recipient.get(recipient_id, "logs");
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    private String fakeGet(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException {
        return fakeGet(recipient_id, "");
    }

    private String fakeGet(String recipient_id, String term) throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        return "{\"ok\":true,\"recipient\":{\"id\":\"R-91XQ8T3G088QM\",\"referenceId\":\"jsmith@examwdple.com\",\"email\":\"jsmith@examwdple.com\",\"name\":\"John Smith\",\"lastName\":\"Smith\",\"firstName\":\"John\",\"type\":\"individual\",\"status\":\"incomplete\",\"language\":\"en\",\"complianceStatus\":\"pending\",\"dob\":null,\"payoutMethod\":null,\"updatedAt\":\"2017-05-15T20:34:50.558Z\",\"createdAt\":\"2017-05-15T20:34:50.558Z\",\"gravatarUrl\":\"https://s3.amazonaws.com/static.api.paymentrails.com/icon_user.svg\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"payout\":{\"method\":null},\"address\":{\"street1\":null,\"street2\":null,\"city\":null,\"postalCode\":null,\"country\":null,\"region\":null,\"phone\":null}}}";
    }

    private String fakePost(String body) throws InvalidFieldException, InvalidStatusCodeException {

        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
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

    private String fakeDelete(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
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
        return "{\"ok\":true,\"recipients\":[{\"id\":\"R-91XQ4GK3FNHG0\",\"referenceId\":\"j@j.com\",\"email\":\"j@j.com\",\"name\":\"Mark j\",\"lastName\":\"j\",\"firstName\":\"Mark\",\"type\":\"individual\",\"status\":\"incomplete\",\"language\":\"\",\"complianceStatus\":\"pending\",\"dob\":null,\"payoutMethod\":null,\"updatedAt\":\"2017-05-12T16:34:54.504Z\",\"createdAt\":\"2017-05-10T14:34:10.843Z\",\"gravatarUrl\":\"https://s3.amazonaws.com/static.api.paymentrails.com/icon_user.svg\",\"compliance\":{\"status\":\"pending\",\"checkedAt\":null},\"payout\":{\"method\":null},\"address\":{\"street1\":null,\"street2\":null,\"city\":null,\"postalCode\":null,\"country\":null,\"region\":null,\"phone\":null}}],\"meta\":{\"page\":1,\"pages\":1,\"records\":1}}";
    }
}
