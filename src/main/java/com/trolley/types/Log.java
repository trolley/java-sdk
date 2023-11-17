package com.trolley.types;

import java.util.List;

import com.trolley.types.supporting.LogField;

public class Log {
    
    private String via;
    private String ipAddress;
    private String userId;
    private String type;
    private List<LogField> fields;
    private String createdAt;

    public Log() {
    }

    public Log(String via, String ipAddress, String userId, String type, List<LogField> fields, String createdAt) {
        this.via = via;
        this.ipAddress = ipAddress;
        this.userId = userId;
        this.type = type;
        this.fields = fields;
        this.createdAt = createdAt;
    }
    
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<LogField> getFields() {
        return fields;
    }
    public void setFields(List<LogField> fields) {
        this.fields = fields;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    
}
