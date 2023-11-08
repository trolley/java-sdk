package com.trolley.types.supporting;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GovernmentId
{
    private String country;
    private String type;
    private String value;

    public GovernmentId(){}
    
    public GovernmentId(String country, String type, String value) {
        this.country = country;
        this.type = type;
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }    
}
