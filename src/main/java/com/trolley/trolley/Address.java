package com.trolley.trolley;

import java.util.HashMap;
import java.util.Map;

public class Address
{
    private String street1;
    private String street2;
    private String city;
    private String postalCode;
    private String country;
    private String region;
    private String phone;
    private Boolean phoneValidated;
    private Map<String, Object> additionalProperties;
    
    public Address() {
        this.additionalProperties = new HashMap<String, Object>();
    }
    
    public String getStreet1() {
        return this.street1;
    }
    
    public void setStreet1(final String street1) {
        this.street1 = street1;
    }
    
    public String getStreet2() {
        return this.street2;
    }
    
    public void setStreet2(final String street2) {
        this.street2 = street2;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(final String country) {
        this.country = country;
    }
    
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(final String region) {
        this.region = region;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    public Boolean getPhoneValidated() {
        return this.phoneValidated;
    }
    
    public void setPhoneValidated(final Boolean phoneValidated) {
        this.phoneValidated = phoneValidated;
    }
    
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    public void setAdditionalProperty(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }
}
