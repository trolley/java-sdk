package ca.paymentrails.paymentrails;

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
     * @throws InvalidStatusCodeException
     */
    public static String get() throws InvalidStatusCodeException {
        return get("");
    }

    /**
     * Retrieves balance based on term
     *
     * @param term
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String get(String term) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/profile/balances/" + term;
        String response = client.get(endPoint);
        return response;
    }
}
