package ca.paymentrails.paymentrails;

/**
 *
 * @author Jesse
 */
public class PaymentRails_Configuration {

    static String apiBase = "http://api.local.dev:3000/";
    
    static String apiKey = "";

    /**
     * Getter for the api base
     *
     * @return the api base
     */
    public static String getApiBase() {
        return PaymentRails_Configuration.apiBase;
    }

    /**
     * Setter for the api base
     *
     * @param apiBase
     */
    public static void setApiBase(String apiBase) {
        PaymentRails_Configuration.apiBase = apiBase;
    }

    /**
     * Getter for the api key
     *
     * @return the api key
     */
    public static String getApiKey() {
        return PaymentRails_Configuration.apiKey;
    }

    /**
     * Setter for api key
     *
     * @param apiKey
     */
    public static void setApiKey(String apiKey) {
        PaymentRails_Configuration.apiKey = apiKey;
    }

}
