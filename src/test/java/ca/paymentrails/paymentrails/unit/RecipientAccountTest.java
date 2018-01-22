package ca.paymentrails.paymentrails.unit;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import ca.paymentrails.paymentrails.RecipientAccount;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RecipientAccount.class)
public class RecipientAccountTest {

    @Test
    public void testRetrieveAccounts() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String recipientAccount_id = "A-AfVfXyJn89geqHynF9Adbp";

        when(RecipientAccount.find(recipient_id, recipientAccount_id))
                .thenReturn(fakeGet(recipient_id, recipientAccount_id));

        RecipientAccount response = RecipientAccount.find(recipient_id, recipientAccount_id);

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test(expected = InvalidFieldException.class)
    public void testRetrieveAccountsNullRecipId() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = null;
        String recipientAccount_id = "A-AfVfXyJn89geqHynF9Adbp";

        when(RecipientAccount.find(recipient_id, recipientAccount_id))
                .thenReturn(fakeGet(recipient_id, recipientAccount_id));

        RecipientAccount.find(recipient_id, recipientAccount_id);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testRetrieveAccountsInvalidRecipId() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = "JD8DJDHFHF7H";
        String recipientAccount_id = "A-AfVfXyJn89geqHynF9Adbp";

        when(RecipientAccount.find(recipient_id, recipientAccount_id))
                .thenReturn(fakeGet(recipient_id, recipientAccount_id));

        RecipientAccount.find(recipient_id, recipientAccount_id);

    }

    @Test
    public void testRetrieveAllAccounts() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = "R-91XQ4VKD39C3P";

        when(RecipientAccount.findAll(recipient_id)).thenReturn(fakeGetAll(recipient_id));

        List<RecipientAccount> response = RecipientAccount.findAll(recipient_id);

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.get(0).getId());
    }

    @Test
    public void testCreateAccount() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String body = "{\"type\": \"bank-transfer\", \"primary\": \"true\", \"country\": \"CA\", \"currency\": \"CAD\",\"accountNum\": \"604622847\", \"bankId\": \"123\", \"branchId\": \"47261\",  \"accountHolderName\": \"John Smith\"}";
        when(RecipientAccount.create(recipient_id, body)).thenReturn(fakePost(recipient_id, body));

        RecipientAccount response = RecipientAccount.create(recipient_id, body);

        PowerMockito.verifyStatic();
        assertEquals("1A2B3C", response.getId());
    }

    @Test
    public void testDeleteAccount() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String recipientAccount_id = "A-7DHFFHW8SJSK0";
        when(RecipientAccount.delete(recipient_id, recipientAccount_id))
                .thenReturn(fakeDelete(recipient_id, recipientAccount_id));

        String response = RecipientAccount.delete(recipient_id, recipientAccount_id);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    @Test
    public void testPatchAccount() throws Exception {
        PowerMockito.mockStatic(RecipientAccount.class);
        String recipient_id = "R-91XQ4VKD39C3P";
        String recipientAccount_id = "A-DDJ8FJDEL0D93K";
        String body = "{\"accountHolderName\": \"Acer Philips\"}";
        when(RecipientAccount.update(recipient_id, recipientAccount_id, body))
                .thenReturn(fakePatch(recipient_id, recipientAccount_id, body));

        String response = RecipientAccount.update(recipient_id, recipientAccount_id, body);
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    private RecipientAccount fakeGet(String recipient_id, String term)
            throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        RecipientAccount recipientAccount = new RecipientAccount();
        recipientAccount.setId("1A2B3C");
        return recipientAccount;
    }

    private RecipientAccount fakeGet(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException {
        return fakeGet(recipient_id, "");
    }

    private RecipientAccount fakePost(String recipient_id, String body)
            throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        RecipientAccount recipientAccount = new RecipientAccount();
        recipientAccount.setId("1A2B3C");
        return recipientAccount;
    }

    private String fakePatch(String recipient_id, String recipientAccount_id, String body)
            throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        return "{\"ok\":true,\"object\":\"updated\"}";
    }

    private String fakeDelete(String recipient_id, String recipientAccountId)
            throws InvalidStatusCodeException, InvalidFieldException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (recipientAccountId == null || recipientAccountId.isEmpty()) {
            throw new InvalidFieldException("Recipient account id cannot be null or empty.");
        }
        return "{\"ok\":true,\"object\":\"deleted\"}";
    }

    private List<RecipientAccount> fakeGetAll(String recipient_id)
            throws InvalidFieldException, InvalidStatusCodeException {
        if (recipient_id == null || recipient_id.isEmpty()) {
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if (!recipient_id.substring(0, 1).equals("R")) {
            throw new InvalidStatusCodeException("Invalid anan");
        }
        List<RecipientAccount> recipientAccounts = new ArrayList<RecipientAccount>();
        RecipientAccount recipientAccount = new RecipientAccount();
        recipientAccount.setId("1A2B3C");
        recipientAccounts.add(recipientAccount);
        return recipientAccounts;

    }
}
