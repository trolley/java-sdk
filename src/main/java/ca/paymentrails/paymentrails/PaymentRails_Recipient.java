package ca.paymentrails.paymentrails;

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
     */
    public static String get(String recipient_id, String term) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/recipients/" + recipient_id + "/" + term;
        String response = client.get(endPoint);
        return response;
    }

    public static String get(String recipient_id) throws InvalidStatusCodeException {
        return get(recipient_id, "");
    }

    /**
     * Creates a recipient based on the body given to the client
     *
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     */
    public static String post(String body) throws InvalidStatusCodeException {
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
     */
    public static String patch(String recipient_id, String body) throws InvalidStatusCodeException {
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
     */
    public static String delete(String recipient_id) throws InvalidStatusCodeException {
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
     */
    public static String query(int page, int pageSize, String message) throws InvalidStatusCodeException {
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
     */
    public static String query(String message) throws InvalidStatusCodeException {
        return query(1, 10, message);
    }
    /**
     * 
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException 
     */
    public static String query() throws InvalidStatusCodeException {
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
     */
    public static String query(int page, int pageNumber) throws InvalidStatusCodeException {
        return query(page, pageNumber, "");
    }

}
