package com.trolley;

import io.github.cdimascio.dotenv.Dotenv;

public class Configuration
{
    private String apiBase = "https://api.trolley.com";
    private String privateKey;
    private String publicKey;
    
    public Configuration() {
        this.privateKey = "";
        this.publicKey = "";
    }
    
    public Configuration(final String publicKey, final String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.apiBase = this.setEnviroment("production");
    }
    
    public Configuration(final String publicKey, final String privateKey, final String apiBase) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.apiBase = this.setEnviroment(apiBase);
    }
    
    public String getApiBase() {
        return this.apiBase;
    }
    
    public void setEnvironment(final String env) {
        this.apiBase = this.setEnviroment(env);
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
                return "https://api.trolley.com";
            }
            case "development":
            case "DEVELOPMENT": {
                Dotenv dotenv = Dotenv.load();
                String devBaseUrl = "";
                devBaseUrl = dotenv.get("BASE_URL");

                if(null != devBaseUrl){
                    if(devBaseUrl.length() == 0){
                        throw new IllegalArgumentException("No value for BASE_URL was found in .env file while configuration environment specified was 'development'. ");
                    }
                }else{
                    throw new IllegalArgumentException("Parameter BASE_URL was not found in .env file while configuration environment specified was 'development'.");
                }

                return devBaseUrl;
            }
            default: {
                return "https://api.trolley.com";
            }
        }
    }
}
