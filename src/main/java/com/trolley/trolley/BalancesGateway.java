package com.trolley.trolley;

import com.trolley.Exceptions.InvalidFieldException;

public class BalancesGateway
{
    Client client;
    
    public BalancesGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    public String find(final String term) throws Exception {
        if (term == null) {
            throw new InvalidFieldException("Term cannot be null");
        }
        final String endPoint = "/v1/balances/" + term;
        final String response = this.client.get(endPoint);
        return response;
    }
}
