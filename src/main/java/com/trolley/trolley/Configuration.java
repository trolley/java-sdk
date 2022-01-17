package com.trolley.trolley;

/**
 * <p>Configuration class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Configuration {

    String apiBase = "https://api.paymentrails.com";
    String privateKey = "";
    String publicKey = "";

    /**
     * <p>Constructor for Configuration.</p>
     */
    public Configuration() {
    }
    /**
     * <p>Constructor for Configuration.</p>
     *
     * @param publicKey a {@link java.lang.String} object.
     * @param privateKey a {@link java.lang.String} object.
     */
    public Configuration(String publicKey, String privateKey){
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
    /**
     * <p>Constructor for Configuration.</p>
     *
     * @param publicKey a {@link java.lang.String} object.
     * @param privateKey a {@link java.lang.String} object.
     * @param apiBase a {@link java.lang.String} object.
     */
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
     * @param apiBase a {@link java.lang.String} object.
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
     * @param publicKey a {@link java.lang.String} object.
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * Getter for the private key
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPrivateKey() {
        return this.privateKey;
    }

    /**
     * Setter for the private key
     *
     * @param privatKey a {@link java.lang.String} object.
     */
    public void setPrivateKey(String privatKey) {
        this.privateKey = privatKey;
    }

    /**
     * <p>gateway.</p>
     *
     * @return a {@link com.trolley.trolley.Gateway} object.
     */
    public static Gateway gateway() {
        return new Gateway(Configuration.instantiate());
    }

    /**
     * <p>client.</p>
     *
     * @param config a {@link com.trolley.trolley.Configuration} object.
     * @return a {@link com.trolley.trolley.Client} object.
     */
    public static Client client(Configuration config) {
        return new Client(config);
    }

    /**
     * <p>instantiate.</p>
     *
     * @return a {@link com.trolley.trolley.Configuration} object.
     */
    public static Configuration instantiate() {
        return new Configuration();
    }

    /**
     * Set the API enviroment
     *
     * @param enviroment a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
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
