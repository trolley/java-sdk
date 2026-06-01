package com.trolley;

import java.net.URLEncoder;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VerificationGateway {
    Client client;

    public VerificationGateway(final Configuration config) {
        this.client = new Client(config);
    }

    public String search(final Map<String, Object> filters) throws Exception {
        String endpoint = "/v1/verifications";
        if (filters != null && !filters.isEmpty()) {
            endpoint += "?" + queryString(filters);
        }
        return this.client.get(endpoint);
    }

    public String all(final Map<String, Object> filters) throws Exception {
        return search(filters);
    }

    public String expire(final Object body) throws Exception {
        final String endpoint = "/v1/verifications/expire";
        return this.client.patch(endpoint, new ObjectMapper().writeValueAsString(body));
    }

    public String trigger(final String verificationType, final Object body) throws Exception {
        final String endpoint = "/v1/verifications/{verificationType}/trigger".replace("{verificationType}", verificationType);
        return this.client.post(endpoint, new ObjectMapper().writeValueAsString(body));
    }

    public String triggerWatchlist(final Object body) throws Exception {
        return trigger("watchlist", body);
    }

    private String queryString(final Map<String, Object> filters) throws Exception {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            builder.append("=");
            builder.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
        }
        return builder.toString();
    }
}
