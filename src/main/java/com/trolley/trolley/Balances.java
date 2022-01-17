package com.trolley.trolley;

/**
 * <p>Balances class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Balances {

    public EUR EUR;

    public USD USD;

    public CAD CAD;

    /**
     * <p>getEUR.</p>
     *
     * @return a {@link com.trolley.trolley.EUR} object.
     */
    public EUR getEUR() {
        return EUR;
    }

    /**
     * <p>setEUR.</p>
     *
     * @param EUR a {@link com.trolley.trolley.EUR} object.
     */
    public void setEUR(EUR EUR) {
        this.EUR = EUR;
    }

    /**
     * <p>getUSD.</p>
     *
     * @return a {@link com.trolley.trolley.USD} object.
     */
    public USD getUSD() {
        return USD;
    }

    /**
     * <p>setUSD.</p>
     *
     * @param USD a {@link com.trolley.trolley.USD} object.
     */
    public void setUSD(USD USD) {
        this.USD = USD;
    }

    /**
     * <p>getCAD.</p>
     *
     * @return a {@link com.trolley.trolley.CAD} object.
     */
    public CAD getCAD() {
        return CAD;
    }

    /**
     * <p>setCAD.</p>
     *
     * @param CAD a {@link com.trolley.trolley.CAD} object.
     */
    public void setCAD(CAD CAD) {
        this.CAD = CAD;
    }

    /**
     * Retrieves all account balances
     *
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static String find() throws Exception {
        return find("");
    }

    /**
     * Retrieves balance based on term
     *
     * @param term (paypal or trolley)
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static String find(String term) throws Exception {
        return Configuration.gateway().balances.find(term);
    }

}
