/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidStatusCodeException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Jesse
 */
public class PaymentRails_BalancesTest {

    @Test
    public void testGetAllBalances() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_live_91XNJFBD19ZQ6");
        String response = PaymentRails_Balances.get();
        String result = response.substring(6, 10);
        assertEquals("true", result);
    }

    @Test(expected = InvalidStatusCodeException.class)
    public void testGetAllBalancesInvalidAPIKey() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("dd");
        String response = PaymentRails_Balances.get();
    }
}
