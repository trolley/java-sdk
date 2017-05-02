package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidStatusCodeException;

/**
 *
 * @author Jesse
 */
public class PaymentRails_Batch {

    /**
     * Retrieves a batch based on the batch id given
     *
     * @param batch_id
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String get(String batch_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + batch_id;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * Updates a batch based on the batch id and body
     *
     * @param batch_id
     * @param body
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String patch(String batch_id, String body) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/batches/" + batch_id;
        String response = client.patch(endPoint, body);
        return response;
    }

    /**
     * Deletes a batch based on batch id
     *
     * @param batch_id
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String delete(String batch_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/batches/" + batch_id;
        String response = client.delete(endPoint);
        return response;
    }

    /**
     * Creates a batch based on batch the body
     *
     * @param body
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String post(String body) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/batches/";
        String response = client.post(endPoint, body);
        return response;
    }

    /**
     * Generate a quote for a batch
     *
     * @param batch_id
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String generateQuote(String batch_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/batches/" + batch_id + "/generate-quote";
        String response = client.post(endPoint);
        return response;
    }

    /**
     * Process a batch
     *
     * @param batch_id
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String processBatch(String batch_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();
        String endPoint = "v1/batches/" + batch_id + "/start-processing";
        String response = client.post(endPoint);
        return response;
    }

    /**
     * List all Batches based on the recipient id and (optional) a given
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
        String endPoint = "v1/recipients/?" + "&search=" + message + "&page=" + page + "&pageSize=" + pageSize;
        String response = client.get(endPoint);
        return response;
    }

    /**
     * List all batches based on the recipient id and a given wildcard
     *
     * @param message
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query(String message) throws InvalidStatusCodeException {
        return query(1, 10, message);
    }

    /**
     * List all batches
     *
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query() throws InvalidStatusCodeException {
        return query(1, 10, "");
    }

    /**
     * List all batches based on the recipient id and (optional) page amount and
     * page size
     *
     * @param page
     * @param pageNumber
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String query(int page, int pageNumber) throws InvalidStatusCodeException {
        return query(page, pageNumber, "");
    }

    /**
     * Retrieves summary of batch
     *
     * @param batch_id
     * @return The response
     * @throws InvalidStatusCodeException
     */
    public static String summary(String batch_id) throws InvalidStatusCodeException {
        PaymentRails_Client client = PaymentRails_Client.create();

        String endPoint = "v1/batches/" + batch_id + "/summary";
        String response = client.get(endPoint);
        return response;
    }
}
