package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Jesse
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PaymentRails_Balances.class)
public class PaymentRails_BalancesTest {

    @Test
    public void testGetAllBalances() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {

        PowerMockito.mockStatic(PaymentRails_Balances.class);
        when(PaymentRails_Balances.get()).thenReturn(fakeGet());

        PaymentRails_Configuration.setApiKey("pk_test_test");
        String response = PaymentRails_Balances.get();
        String result = response.substring(6, 10);

        PowerMockito.verifyStatic();
        assertEquals("true", result);
    }

    public String fakeGet() {
        return "{\"ok\":true,\"balances\":{\"USD\":{\"primary\":true,\"amount\":\"10000.00\",\"currency\":\"USD\",\"type\":\"paymentrails\",\"accountNumber\":null}}}";
    }
}
