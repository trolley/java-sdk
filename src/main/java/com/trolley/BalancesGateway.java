package com.trolley;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trolley.Exceptions.InvalidFieldException;
import com.trolley.types.Balances;

public class BalancesGateway
{
    Client client;
    
    public BalancesGateway(final Configuration config) {
        this.client = new Client(config);
    }
    
    /**
     * Get balances of all paypal accounts
     * @return List<Balance>
     * @throws Exception
     */
    public List<Balances> getPaypalAccountBalances() throws Exception{
        return fetchBalances("paypal");
    }

    /**
     * Get balances of all paymentrails/Trolley accounts
     * @return List<Balance>
     * @throws Exception
     */
    public List<Balances> getTrolleyAccountBalances() throws Exception{
        return fetchBalances("paymentrails");
    }

    /**
     * Get balances of all accounts you hold with Trolley
     * @return List<Balance>
     * @throws Exception
     */
    public List<Balances> getAllBalances() throws Exception{
        return fetchBalances("");
    }

    private List<Balances> fetchBalances(final String accountType) throws Exception {
        if (accountType == null) {
            throw new InvalidFieldException("Account type cannot be null");
        }
        final String endPoint = "/v1/balances/" + accountType;
        final String response = this.client.get(endPoint);
        return balancesListFactory(response);
    }

    private List<Balances> balancesListFactory(final String data) throws Exception{
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(data);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        final List<Balances> balancesFromResponse = (List<Balances>)mapper.readValue(node.get("balances").traverse(), (Class)Object.class);

        ArrayList<Balances> balances = new ArrayList<Balances>();
        for (int i = 0; i < balancesFromResponse.size(); ++i) {
            final Balances pojo = (Balances)mapper.convertValue(balancesFromResponse.get(i), (Class)Balances.class);
            balances.add(pojo);
        }

        return balances;
    }
}
