package com.trolley;

import java.net.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PartnerGateway {
    private final Client client;
    private final ObjectMapper objectMapper;

    public PartnerGateway(final Configuration config) {
        this.client = new Client(config);
        this.objectMapper = new ObjectMapper();
    }

    public String getFees() throws Exception {
        return this.client.get("/v1/fees");
    }

    public String getFees(final String currency) throws Exception {
        if (currency == null || currency.isEmpty()) {
            return getFees();
        }
        return this.client.get("/v1/fees?currency=" + pathSegment(currency));
    }

    public String updateFees(final Object body) throws Exception {
        return this.client.patch("/v1/fees", json(body));
    }

    public String listPayoutMethods() throws Exception {
        return this.client.get("/v1/payout-methods");
    }

    public String getPayoutMethod(final String payoutMethod) throws Exception {
        return this.client.get("/v1/payout-methods/" + pathSegment(payoutMethod));
    }

    public String updatePayoutMethod(final String payoutMethod, final Object body) throws Exception {
        return this.client.patch("/v1/payout-methods/" + pathSegment(payoutMethod), json(body));
    }

    public String getProcessingSettings() throws Exception {
        return this.client.get("/v1/processing-settings");
    }

    public String updateProcessingSettings(final Object body) throws Exception {
        return this.client.patch("/v1/processing-settings", json(body));
    }

    public String getWhiteLabelDnsRecords() throws Exception {
        return this.client.get("/v1/white-label/dns-records");
    }

    public String verifyWhiteLabelDnsRecords() throws Exception {
        return this.client.post("/v1/white-label/dns-records/verify", "{}");
    }

    public String deleteWhiteLabelEmail() throws Exception {
        return this.client.delete("/v1/white-label/email");
    }

    public String updateWhiteLabelIcon(final Object body) throws Exception {
        return this.client.patch("/v1/white-label/icon", json(body));
    }

    public String getWhiteLabelSettings() throws Exception {
        return this.client.get("/v1/white-label");
    }

    public String updateWhiteLabelSettings(final Object body) throws Exception {
        return this.client.patch("/v1/white-label", json(body));
    }

    public String getWidgetConfiguration() throws Exception {
        return this.client.get("/v1/iframe/config");
    }

    public String updateWidgetConfiguration() throws Exception {
        return updateWidgetConfiguration(new Object());
    }

    public String updateWidgetConfiguration(final Object body) throws Exception {
        return this.client.post("/v1/iframe/config", json(body));
    }

    private String json(final Object body) throws Exception {
        if (body instanceof String) {
            return (String) body;
        }
        return this.objectMapper.writeValueAsString(body);
    }

    private String pathSegment(final String value) throws Exception {
        return URLEncoder.encode(value, "UTF-8").replace("+", "%20");
    }
}
