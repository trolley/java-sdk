package ca.paymentrails.paymentrails;

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
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String get(String payment_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + PaymentRails_Payment.batch_id + "/payments/" + payment_id;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * Creates a payment based on the body and batch id
     *
     * @param body
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String post(String body) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + PaymentRails_Payment.batch_id + "/payments";
        String response = client.post(endPoint, body);
        return response;
    }

    /**
     * Updates a payment based on the payment id, body and batch id
     *
     * @param payment_id
     * @param body
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String patch(String payment_id, String body) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + PaymentRails_Payment.batch_id + "/payments/" + payment_id;
        String response = client.patch(endPoint, body);
        return response;
    }

    /**
     * Deletes a payment based on the payment id and batch id
     *
     * @param payment_id
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String delete(String payment_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + PaymentRails_Payment.batch_id + "/payments/" + payment_id;
        String response = client.delete(endPoint);
        return response;
    }

    /**
     * List all payments based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param page
     * @param pageSize
     * @param message
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query(int page, int pageSize, String message) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/batches/" + PaymentRails_Payment.batch_id + "/payments/?" + "&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * List all payments based on the recipient id and a given wildcard
     *
     * @param message
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query(String message) throws InvalidStatusCodeException {
        return query(1, 10, message);
    }

    /**
     * List all payments
     *
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query() throws InvalidStatusCodeException {
        return query(1, 10, "");
    }

    /**
     * List all payments based on the recipient id and (optional) page amount
     * and page size
     *
     * @param page
     * @param pageNumber
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query(int page, int pageNumber) throws InvalidStatusCodeException {
        return query(page, pageNumber, "");
    }
}
