package com.trolley.types.supporting;

import java.util.HashMap;
import java.util.Map;

public class Compliance
{
    private String status;
    private Object checkedAt;
    private Map<String, Object> additionalProperties;
    
    public Compliance() {
        this.additionalProperties = new HashMap<String, Object>();
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public Object getCheckedAt() {
        return this.checkedAt;
    }
    
    public void setCheckedAt(final Object checkedAt) {
        this.checkedAt = checkedAt;
    }
    
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    public void setAdditionalProperty(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }
}
