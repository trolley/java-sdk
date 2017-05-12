package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Jesse
 */
public class PaymentRails_BalancesTest {

    @Test
    public void testGetAllBalances() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");
        String response = PaymentRails_Balances.get();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testGetAllBalancesInvalidAPIKey() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("dd");
        String response = PaymentRails_Balances.get();
    }
}
