package ca.paymentrails.paymentrails.unit;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import ca.paymentrails.paymentrails.Recipient;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Recipient.class)
public class RecipientTest {

    @Test
    public void testRetrieveRecipient() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(Recipient.find(recipient_id)).thenReturn(fakeGet(recipient_id));

        Recipient response = Recipient.find(recipient_id);
        System.out.println();

        PowerMockito.verifyStatic();
        assertEquals("true", response);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveRecipientInvalidRecipientId() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "91XQ4VKD39C3P";
        when(Recipient.find(recipient_id)).thenReturn(fakeGet(recipient_id));

        Recipient.find(recipient_id);

    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrieveRecipientNullRecipientId() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = null;
        when(Recipient.find(recipient_id)).thenReturn(fakeGet(recipient_id));

        Recipient.find(recipient_id);

    }

    @Test
    public void testCreateRecipient() throws Exception {

        PowerMockito.mockStatic(Recipient.class);
        String body = "{\"type\": \"individual\", \"firstName\": \"test\", \"lastName\": \"teston\", \"email\": \"test@example.com\"}";

        when(Recipient.create(body)).thenReturn(fakePost(body));

        Recipient response = Recipient.create(body);
        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test(expected = InvalidFieldException.class)
    public void testCreateRecipientNullBody() throws Exception {

        PowerMockito.mockStatic(Recipient.class);
        String body = null;

        when(Recipient.create(body)).thenReturn(fakePost(body));

        Recipient.create(body);
    }

    @Test
    public void testUpdateRecipient() throws Exception {

        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String body = "{\"email\": \"mj@theking.com\"}";
        when(Recipient.update(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        String response = Recipient.update(recipient_id, body);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testUpdateRecipientInvalidRecipientId() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "91XQ4VKD39C3P";
        String body = "{\"email\": \"mj@theking.com\"}";
        when(Recipient.update(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        Recipient.update(recipient_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateRecipientNullRecipientId() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = null;
        String body = "{\"email\": \"mj@theking.com\"}";
        when(Recipient.update(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        Recipient.update(recipient_id, body);
    }

    @Test(expected = InvalidFieldException.class)
    public void testUpdateRecipientNullBody() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String body = null;
        when(Recipient.update(recipient_id, body)).thenReturn(fakePatch(recipient_id, body));

        Recipient.update(recipient_id, body);
    }

    @Test
    public void testDeleteRecipient() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(Recipient.delete(recipient_id)).thenReturn(fakeDelete(recipient_id));

        String response = Recipient.delete(recipient_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testDeleteRecipientInvalidRecipientId() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "91XQ4VKD39C3P";
        when(Recipient.delete(recipient_id)).thenReturn(fakeDelete(recipient_id));

        Recipient.delete(recipient_id);
    }

    @Test(expected = InvalidFieldException.class)
    public void testDeleteRecipientNullRecipientId() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = null;
        when(Recipient.delete(recipient_id)).thenReturn(fakeDelete(recipient_id));

        Recipient.delete(recipient_id);
    }

    @Test
    public void testListAllRecipientsWithQueries() throws Exception {
        PowerMockito.mockStatic(Recipient.class);

        when(Recipient.search(1, 10, "j@j.com")).thenReturn(fakeQuery(1, 10, "j@j.com"));

        List<Recipient> response = Recipient.search(1, 10, "j@j.com");
        assertEquals("123", response.get(0).getId());
    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllRecipientsWithQueriesNegativePage() throws Exception {
        PowerMockito.mockStatic(Recipient.class);

        when(Recipient.search(-1, 10, "j@j.com")).thenReturn(fakeQuery(-1, 10, "j@j.com"));

        Recipient.search(-1, 10, "j@j.com");

    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllRecipientsWithQueriesNegativePageNumber() throws Exception {
        PowerMockito.mockStatic(Recipient.class);

        when(Recipient.search(1, -10, "j@j.com")).thenReturn(fakeQuery(1, -10, "j@j.com"));

        Recipient.search(1, -10, "j@j.com");

    }

    @Test(expected = InvalidFieldException.class)
    public void testListAllRecipientsWithQueriesNullTerm() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        when(Recipient.search(1, 10, null)).thenReturn(fakeQuery(1, 10, null));

        Recipient.search(1, 10, null);
    }

    @Test
    public void testRetrieveAllPayments() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(Recipient.find(recipient_id, "payments")).thenReturn(fakeGet(recipient_id, "payments"));

        Recipient response = Recipient.find(recipient_id, "payments");

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test
    public void testRetrieveAlLogs() throws Exception {
        PowerMockito.mockStatic(Recipient.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        when(Recipient.find(recipient_id, "logs")).thenReturn(fakeGet(recipient_id, "logs"));

        Recipient response = Recipient.find(recipient_id, "logs");

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    private Recipient fakeGet(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException {
        return fakeGet(recipient_id, "");
    }

    private Recipient fakeGet(String recipient_id, String term)
            throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        Recipient recipient = new Recipient();
        recipient.setId("1A2B3C");
        return recipient;
    }

    private Recipient fakePost(String body) throws InvalidFieldException, InvalidStatusCodeException {

        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        Recipient recipient = new Recipient();
        recipient.setId("1A2B3C");
        return recipient;
    }

    private String fakePatch(String recipient_id, String body)
            throws InvalidFieldException, InvalidStatusCodeException {
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

    private List<Recipient> fakeQuery(int page, int pageSize, String term) throws InvalidFieldException {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (term == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        List<Recipient> recipients = new ArrayList<Recipient>();
        Recipient recipient = new Recipient();
        recipient.setId("123");
        recipients.add(recipient);
        return recipients;
    }
}
