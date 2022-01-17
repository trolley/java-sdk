package com.trolley.trolley;

import com.trolley.Exceptions.InvalidFieldException;

/**
 * <p>BalancesGateway class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class BalancesGateway {
    Client client;
    
    /**
     * <p>Constructor for BalancesGateway.</p>
     *
     * @param config a {@link com.trolley.trolley.Configuration} object.
     */
    public BalancesGateway(Configuration config) {
        this.client = new Client(config);
    }

    /**
     * <p>find.</p>
     *
     * @param term a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String find(String term) throws Exception {
        if (term == null) {
            throw new InvalidFieldException("Term cannot be null");
        }
        String endPoint = "/v1/balances/" + term;
        String response = this.client.get(endPoint);
        return response;
    }
}
