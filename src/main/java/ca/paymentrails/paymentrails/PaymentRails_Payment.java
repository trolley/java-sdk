package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;

/**
 *
 * @author Jesse
 */
public class PaymentRails_Payment {

    static String batch_id = "";

    /**
     * Retrieves a batch based on the batch id
     *
     * @param payment_id
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String get(String payment_id, String batch_id) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * Creates a payment based on the body and batch id
     *
     * @param body
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String post(String body, String batch_id) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + batch_id + "/payments";
        String response = client.post(endPoint, body);
        return response;
    }

    /**
     * Updates a payment based on the payment id, body and batch id
     *
     * @param payment_id
     * @param body
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String patch(String payment_id, String body, String batch_id) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        if (body == null || body.isEmpty()) {
            throw new InvalidFieldException("Body cannot be null or empty.");
        }

        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = client.patch(endPoint, body);
        return response;
    }

    /**
     * Deletes a payment based on the payment id and batch id
     *
     * @param payment_id
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String delete(String payment_id, String batch_id) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
        if (payment_id == null || payment_id.isEmpty()) {
            throw new InvalidFieldException("Payment id cannot be null or empty.");
        }
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + batch_id + "/payments/" + payment_id;
        String response = client.delete(endPoint);
        return response;
    }

    /**
     * List all payments based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param batch_id
     * @param page
     * @param pageSize
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(String batch_id, int page, int pageSize, String message) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {

        if (batch_id == null || batch_id.isEmpty()) {
            throw new InvalidFieldException("Batch id cannot be null or empty.");
        }
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
        String endPoint = "v1/batches/" + batch_id + "/payments/?" + "&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * List all payments based on the recipient id and a given wildcard
     *
     * @param batch_id
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(String batch_id, String message) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        return query(batch_id, 1, 10, message);
    }

    /**
     * List all payments
     *
     * @param batch_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(String batch_id) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {
        return query(batch_id, 1, 10, "");
    }

    /**
     * List all payments based on the recipient id and (optional) page amount
     * and page size
     *
     * @param batch_id
     * @param page
     * @param pageSize
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static String query(String batch_id, int page, int pageSize) throws InvalidStatusCodeException, InvalidConnectionException, InvalidFieldException {

        return query(batch_id, page, pageSize, "");
    }
}
