package ca.paymentrails.paymentrails;

public class Configuration {

    String apiBase = "https://api.paymentrails.com";
    String privateKey = "";
    String publicKey = "";

    public Configuration() {
    }
    public Configuration(String publicKey, String privateKey){
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
    public Configuration(String publicKey, String privateKey, String apiBase) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.apiBase = setEnviroment(apiBase);
    }

    /**
     * Getter for the api base
     *
     * @return the api base
     */
    public String getApiBase() {
        return this.apiBase;
    }

    /**
     * Setter for the api base
     *
     * @param apiBase
     */
    public void setApiBase(String apiBase) {
        this.apiBase = apiBase;
    }

    /**
     * Getter for the public static api key
     * 
     * @return publicKey
     */
    public String getPublicKey() {
        return this.publicKey;
    }

    /**
     * Setter for the public static key
     * 
     * @param publicKey
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * Getter for the private key
     * 
     * @param privateKey
     */
    public String getPrivateKey() {
        return this.privateKey;
    }

    /**
     * Setter for the private key
     * 
     * @param privateKey
     */
    public void setPrivateKey(String privatKey) {
        this.privateKey = privatKey;
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
    public String setEnviroment(String enviroment) {
        switch (enviroment) {
        case "production":
        case "PRODUCTION":
            return "https://api.paymentrails.com";
        case "development":
        case "DEVELOPMENT":
            return "http://api.railz.io";
        case "integration":
        case "INTEGRATION":
            return "http://api.local.dev:3000";
        case "sandbox":
        case "SANDBOX":
        return "https://api.paymentrails.com";
        }
        return "https://api.paymentrails.com";
    }
}