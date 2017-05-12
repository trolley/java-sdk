package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;

/**
 *
 * @author Jesse
 */
public class PaymentRails_PayoutMethods {

    /**
     * Retrieves the Payout Method method based on the recipient id given
     *
     * @param recipient_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String get(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(recipient_id == null || recipient_id.isEmpty()){
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/" + recipient_id + "/payout-methods";
        String response = client.get(endPoint);
        return response;
    }

    /**
     * Creates a Payout Method based on the recipient id given
     *
     * @param recipient_id
     * @param body
     * @return The response
     * @throws InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String post(String recipient_id, String body) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(recipient_id == null || recipient_id.isEmpty()){
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if(body == null || body.isEmpty()){
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/" + recipient_id + "/payout-methods";
        String response = client.post(endPoint, body);
        return response;
    }

    /**
     * Updates a Payout Method based on the recipient id
     *
     * @param recipient_id
     * @param body
     * @return The response
     * @throws InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String patch(String recipient_id, String body) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(recipient_id == null || recipient_id.isEmpty()){
            throw new InvalidFieldException("Recipient cannot be null or empty.");
        }
        if(body == null || body.isEmpty()){
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/" + recipient_id + "/payout-methods";
        String response = client.patch(endPoint, body);
        return response;
    }

}
