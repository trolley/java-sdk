package ca.paymentrails.paymentrails;

public class Configuration {

    static String apiBase = "http://api.local.dev:3000";

    static String privateKey = "";
    static String publicKey = "";

    /**
     * Getter for the api base
     *
     * @return the api base
     */
    public static String getApiBase() {
        return Configuration.apiBase;
    }

    /**
     * Setter for the api base
     *
     * @param apiBase
     */
    public static void setApiBase(String apiBase) {
        Configuration.apiBase = apiBase;
    }

    /**
     * Getter for the public static api key
     * 
     * @return publicKey
     */
    public static String getPublicKey() {
        return Configuration.publicKey;
    }

    /**
     * Setter for the public static key
     * 
     * @param publicKey
     */
    public static void setPublicKey(String publicKey) {
        Configuration.publicKey = publicKey;
    }

    /**
     * Getter for the private key
     * 
     * @param privateKey
     */
    public static String getPrivateKey() {
        return Configuration.privateKey;
    }

    /**
     * Setter for the private key
     * 
     * @param privateKey
     */
    public static void setPrivateKey(String privatKey) {
        Configuration.privateKey = privatKey;
    }

    public static Gateway gateway() {
        return new Gateway(Configuration.instantiate());
    }

    public static Client client(Configuration config) {
        return new Client(config);
    }

    public static Configuration instantiate() {
        return new Configuration();
    }

    /**
     * Set the API enviroment
     * 
     * @param enviroment
     */
    public static void setEnviroment(String enviroment) {
        switch (enviroment) {
        case "production":
            Configuration.apiBase = "https://api.paymentrails.com";
            break;
        case "development":
            Configuration.apiBase = "http://api.railz.io";
            break;
        case "integration":
            Configuration.apiBase = "http://api.local.dev:3000";
            break;

        }
    }
}