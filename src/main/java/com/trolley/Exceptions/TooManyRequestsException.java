package com.trolley.Exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TooManyRequestsException extends Exception
{
    private JsonNode errorResponse = null;

    /**
     * Get the JSON object representing the error response.
     * The returned object could be null if the error response string couldn't be parsed as JSON.
     * @return JsonNode errorResponse
     */
    public JsonNode getErrorResponse(){
        return errorResponse;
    }

    private void setErrorResponse(JsonNode errorJson){
        this.errorResponse = errorJson;
    }

    public TooManyRequestsException() {
    }
    
    public TooManyRequestsException(final String message) {
        super(message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode errorJson = mapper.readTree(message);
            this.setErrorResponse(errorJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
