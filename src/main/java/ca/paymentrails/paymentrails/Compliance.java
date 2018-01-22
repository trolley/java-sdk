package ca.paymentrails.paymentrails;

import java.util.HashMap;
import java.util.Map;

public class Compliance {

    private String status;
    private Object checkedAt;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(Object checkedAt) {
        this.checkedAt = checkedAt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}