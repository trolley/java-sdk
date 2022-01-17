package com.trolley.trolley;

import java.util.List;

/**
 * <p>Payments class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Payments {

    private List<Payment> payments = null;
    private Meta meta;

    /**
     * <p>Getter for the field <code>payments</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * <p>Setter for the field <code>payments</code>.</p>
     *
     * @param payments a {@link java.util.List} object.
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     * <p>Getter for the field <code>meta</code>.</p>
     *
     * @return a {@link com.trolley.trolley.Meta} object.
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * <p>Setter for the field <code>meta</code>.</p>
     *
     * @param meta a {@link com.trolley.trolley.Meta} object.
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
