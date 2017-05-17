package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;

/**
 *
 * @author Jesse
 */
public class PaymentRails_Balances {

    /**
     * Retrieves all account balances
     *
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String get() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        return get("");
    }

    /**
     * Retrieves balance based on term
     *
     * @param term (paypal or paymentrails)
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String get(String term) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if (term == null) {
            throw new InvalidFieldException("Term cannot be null");
        }
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/profile/balances/" + term;
        String response = client.get(endPoint);
        return response;
    }

}
