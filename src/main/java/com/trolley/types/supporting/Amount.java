package com.trolley.types.supporting;

public class Amount {
    
    private String value;
    private String currency;

    public Amount(){
    }

    public Amount(String value, String currency){
        this.value = value;
        this.currency = currency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
