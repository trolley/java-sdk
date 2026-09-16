package com.trolley;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class VerificationGatewayTest {
    @Test
    public void triggerIdentityOrBusinessVerificationUsesDedicatedEndpoint() throws Exception {
        final VerificationGateway gateway = new VerificationGateway(new Configuration());
        final RecordingClient client = new RecordingClient();
        gateway.client = client;

        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("recipientId", "R-123");
        body.put("types", Arrays.asList("individual"));
        body.put("retryAllowed", true);

        final String response = gateway.triggerIdentityOrBusinessVerification(body);

        assertEquals("/v1/verifications/trigger", client.endpoint);
        assertEquals(
            "{\"recipientId\":\"R-123\",\"types\":[\"individual\"],\"retryAllowed\":true}",
            client.body
        );
        assertEquals("{\"ok\":true}", response);
    }

    private static class RecordingClient extends Client {
        private String endpoint;
        private String body;

        RecordingClient() {
            super(new Configuration());
        }

        @Override
        public String post(final String endpoint, final String body) {
            this.endpoint = endpoint;
            this.body = body;
            return "{\"ok\":true}";
        }
    }
}
