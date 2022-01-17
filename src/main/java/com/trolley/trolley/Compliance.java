package com.trolley.trolley;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Compliance class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Compliance {

    private String status;
    private Object checkedAt;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * <p>Getter for the field <code>status</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStatus() {
        return status;
    }

    /**
     * <p>Setter for the field <code>status</code>.</p>
     *
     * @param status a {@link java.lang.String} object.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * <p>Getter for the field <code>checkedAt</code>.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    public Object getCheckedAt() {
        return checkedAt;
    }

    /**
     * <p>Setter for the field <code>checkedAt</code>.</p>
     *
     * @param checkedAt a {@link java.lang.Object} object.
     */
    public void setCheckedAt(Object checkedAt) {
        this.checkedAt = checkedAt;
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
