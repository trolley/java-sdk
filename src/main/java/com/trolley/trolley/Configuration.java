package com.trolley.trolley;

public class Configuration
{
    String apiBase;
    String privateKey;
    String publicKey;
    
    public Configuration() {
        this.apiBase = "https://api.paymentrails.com";
        this.privateKey = "";
        this.publicKey = "";
    }
    
    public Configuration(final String publicKey, final String privateKey) {
        this.apiBase = "https://api.paymentrails.com";
        this.privateKey = "";
        this.publicKey = "";
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
    
    public Configuration(final String publicKey, final String privateKey, final String apiBase) {
        this.apiBase = "https://api.paymentrails.com";
        this.privateKey = "";
        this.publicKey = "";
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.apiBase = this.setEnviroment(apiBase);
    }
    
    public String getApiBase() {
        return this.apiBase;
    }
    
    public void setApiBase(final String apiBase) {
        this.apiBase = apiBase;
    }
    
    public String getPublicKey() {
        return this.publicKey;
    }
    
    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }
    
    public String getPrivateKey() {
        return this.privateKey;
    }
    
    public void setPrivateKey(final String privatKey) {
        this.privateKey = privatKey;
    }
    
    public static Gateway gateway() {
        return new Gateway(instantiate());
    }
    
    public static Client client(final Configuration config) {
        return new Client(config);
    }
    
    public static Configuration instantiate() {
        return new Configuration();
    }
    
    public String setEnviroment(final String enviroment) {
        switch (enviroment) {
            case "production":
            case "PRODUCTION": {
                return "https://api.paymentrails.com";
            }
            case "development":
            case "DEVELOPMENT": {
                return "http://api.railz.io";
            }
            case "integration":
            case "INTEGRATION": {
                return "http://api.local.dev:3000";
            }
            case "sandbox":
            case "SANDBOX": {
                return "https://api.paymentrails.com";
            }
            default: {
                return "https://api.paymentrails.com";
            }
        }
    }
}
