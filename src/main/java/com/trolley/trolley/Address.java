package com.trolley.trolley;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Address class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Address {
    private String street1;
    private String street2;
    private String city;
    private String postalCode;
    private String country;
    private String region;
    private String phone;
    private Boolean phoneValidated;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * <p>Getter for the field <code>street1</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * <p>Setter for the field <code>street1</code>.</p>
     *
     * @param street1 a {@link java.lang.String} object.
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * <p>Getter for the field <code>street2</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * <p>Setter for the field <code>street2</code>.</p>
     *
     * @param street2 a {@link java.lang.String} object.
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * <p>Getter for the field <code>city</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCity() {
        return city;
    }

    /**
     * <p>Setter for the field <code>city</code>.</p>
     *
     * @param city a {@link java.lang.String} object.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * <p>Getter for the field <code>postalCode</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * <p>Setter for the field <code>postalCode</code>.</p>
     *
     * @param postalCode a {@link java.lang.String} object.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * <p>Getter for the field <code>country</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>Setter for the field <code>country</code>.</p>
     *
     * @param country a {@link java.lang.String} object.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <p>Getter for the field <code>region</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRegion() {
        return region;
    }

    /**
     * <p>Setter for the field <code>region</code>.</p>
     *
     * @param region a {@link java.lang.String} object.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * <p>Getter for the field <code>phone</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <p>Setter for the field <code>phone</code>.</p>
     *
     * @param phone a {@link java.lang.String} object.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * <p>Getter for the field <code>phoneValidated</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getPhoneValidated() {
        return phoneValidated;
    }

    /**
     * <p>Setter for the field <code>phoneValidated</code>.</p>
     *
     * @param phoneValidated a {@link java.lang.Boolean} object.
     */
    public void setPhoneValidated(Boolean phoneValidated) {
        this.phoneValidated = phoneValidated;
    }

    /**
     * <p>Getter for the field <code>additionalProperties</code>.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * <p>setAdditionalProperty.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     */
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
