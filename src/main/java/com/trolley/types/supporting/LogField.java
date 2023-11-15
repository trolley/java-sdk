package com.trolley.types.supporting;

public class LogField {
    
    private String name;
    private String oldValue;
    private String newValue;
    
    public LogField() {
    }

    public LogField(String name, String oldValue, String newValue) {
        this.name = name;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    
}
