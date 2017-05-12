package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;

/**
 *
 * @author Jesse
 */
public class PaymentRails_Recipient {

    /**
     * Retrieves a recipient based on the recipient id given
     *
     * @param recipient_id
     * @param term
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String get(String recipient_id, String term) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(recipient_id == null || recipient_id.isEmpty()){
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/" + recipient_id + "/" + term;
        String response = client.get(endPoint);
        return response;
    }

    public static String get(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        return get(recipient_id, "");
    }

    /**
     * Creates a recipient based on the body given to the client
     *
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String post(String body) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(body == null || body.isEmpty()){
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/";
        String response = client.post(endPoint, body);
        return response;
    }

    /**
     * Updates a recipient based on the body given to the client
     *
     * @param recipient_id
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String patch(String recipient_id, String body) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(recipient_id == null || recipient_id.isEmpty()){
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        if(body == null || body.isEmpty()){
            throw new InvalidFieldException("Body cannot be null or empty");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/" + recipient_id;
        String response = client.patch(endPoint, body);
        return response;
    }

    /**
     * Delete a recipient based on the recipient id
     *
     * @param recipient_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String delete(String recipient_id) throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        if(recipient_id == null || recipient_id.isEmpty()){
            throw new InvalidFieldException("Recipient id cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/" + recipient_id;
        String response = client.delete(endPoint);
        return response;
    }

    /**
     * List all recipients based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param page
     * @param pageSize
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(int page, int pageSize, String message) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        if (page < 0) {
            throw new InvalidFieldException("Page cannot be less then 0");
        }
        if (pageSize < 0) {
            throw new InvalidFieldException("Page size cannot be less then 0");
        }
        if (message == null) {
            throw new InvalidFieldException("Message cannot be null");
        }
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/recipients/?" + "&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * List all recipients based on the recipient id and a given wildcard
     *
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(String message) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        return query(1, 10, message);
    }
    /**
     * 
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException 
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException 
     * @throws ca.paymentrails.Exceptions.InvalidFieldException 
     */
    public static String query() throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        return query(1, 10, "");
    }

    /**
     * List all recipients based on the recipient id and (optional) page amount
     * and page size
     *
     * @param page
     * @param pageNumber
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(int page, int pageNumber) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        return query(page, pageNumber, "");
    }

}
