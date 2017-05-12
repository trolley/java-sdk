package ca.paymentrails.paymentrails;

import ca.paymentrails.Exceptions.InvalidConnectionException;
import ca.paymentrails.Exceptions.InvalidFieldException;
import ca.paymentrails.Exceptions.InvalidStatusCodeException;

/**
 *
 * @author Jesse
 */
public class Index {

    public static void main(String[] args) throws Exception {

        recipient();
        // payoutMethods();
        // balances();
        // batch();
        // payment();
    }

    public static void recipient() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

         String recipient_id = "R-91XQ4GK3FNHG0";
         String response = PaymentRails_Recipient.get(recipient_id);
         System.out.println(response);
        // String body = "{\"type\": \"individual\", \"firstName\": \"Michael\", \"lastName\": \"Jackson\", \"email\": \"mj@example.com\"}";
        // String response = PaymentRails_Recipient.post(body);
        // System.out.println(response);
        // String recipient_id = "R-912Q4JHD6RH7E";
        // String body = "{\"email\": \"mj@theking.com\"}";
        // String response = PaymentRails_Recipient.patch(recipient_id, body);
        // System.out.println(response);
    }

    public static void payoutMethods() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        //String recipient_id = "R-912Q4JHD6RH7E";
        //String response = PaymentRails_PayoutMethods.get(recipient_id);
        //System.out.println(response);
        //String recipient_id = "R-912Q4JHD6RH7E";
        String body = "{\"primary\": {\"method\":\"bank\", \"currency\":"
                + " \"CAD\"}, \"accounts\":{\"bank\":{\"country\":\"CA\","
                + " \"accountNum\": \"6022847\", \"institution\": \"123\", "
                + "\"branchNum\": \"47261\", \"currency\": \"CAD\", \"name\":\"TD\"}}}";
        // String response = PaymentRails_PayoutMethods.post(recipient_id, body);
        // System.out.println(response);

        //String recipient_id = "R-912Q4JHD6RH7E";
        body = "{\"primary\": {\"method\":\"paypal\", \"currency\": \"CAD\"}, "
                + "\"accounts\":{\"paypal\": {\"address\": \"testpaypal@example.com\"}}}";
        //String response = PaymentRails_PayoutMethods.patch(recipient_id, body);
        //System.out.println(response);

    }

    public static void balances() throws InvalidStatusCodeException, InvalidFieldException, InvalidConnectionException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        //String response = PaymentRails_Balances.get();
        //System.out.println(response);
        String response = PaymentRails_Balances.get("paypal");
        System.out.println(response);
//        
//        String response = PaymentRails_Balances.get("paymentrails");
//        System.out.println(response);
    }

    public static void batch() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        //String batch_id = "B-91XPU88Q093HW";
        //String response = PaymentRails_Batch.get(batch_id);
        //System.out.println(response);
        //String batch_id = "B-91XPU88Q093HW";
        String body = "{\"update_payments\":[{\"id\":\"P-91XPU88Q5GN2E\","
                + "\"sourceAmount\":999}]}";
        //String response = PaymentRails_Batch.patch(batch_id, body);
        //System.out.println(response);

        // String batch_id = "B-91XPU81V35WHU";
        // String response = PaymentRails_Batch.delete(batch_id);
        // System.out.println(response);
        //String response = PaymentRails_Batch.query();
        //System.out.println(response);
        ///String response = PaymentRails_Batch.summary("B-91XPU88Q093HW");
        //System.out.println(response);
        body = "{\"payments\":[{\"recipient\":{\"id\":\"R-912Q4JHD6RH7E\"},\"sourceAmount\":\"65\",\"memo\":\"\",\"sourceCurrency\":\"CAD\"}]}";
        //String response = PaymentRails_Batch.post(body);
        //System.out.println(response);

        //String response = PaymentRails_Batch.generateQuote("B-91XPY48Y05D4J");
        // System.out.println(response);
        // String response = PaymentRails_Batch.processBatch("B-91XPY48Y05D4J");
        // System.out.println(response);
    }

    public static void payment() throws InvalidStatusCodeException {
        PaymentRails_Configuration.setApiKey("pk_test_91XPYV1Y8MXQC");

        // String payment_id = "P-91XPU88Q5GN2E";
        //PaymentRails_Payment.batch_id = "B-91XPU88Q093HW";
        //String response = PaymentRails_Payment.get(payment_id);
        //System.out.println(response);
        
        //  PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        // String body = "{\"recipient\":{\"id\":\"R-91XPJZTR612MG\"},\"sourceAmount\":\"100.10\",\"memo\":\"Freelance payment\"}";
        //String response = PaymentRails_Payment.post(body);
        //System.out.println(response);
        //PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        //String body = "{\"sourceAmount\":\"900.90\"}";
        //String response = PaymentRails_Payment.patch("P-91XPU81ECR606", body);
        //System.out.println(response);
        //PaymentRails_Payment.batch_id = "B-912Q010UD98KU";
        //String response = PaymentRails_Payment.delete("P-912Q010UF904W");
        // System.out.println(response);
        //PaymentRails_Payment.batch_id = "B-91XPU81EDNA58";
        //String response = PaymentRails_Payment.query();
        // System.out.println(response);
    }
}
