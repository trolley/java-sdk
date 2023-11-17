package com.trolley.types.supporting;

import java.util.List;

import com.trolley.types.Log;

public class Logs {
    private List<Log> logs;
    private Meta meta;
    
    public Logs(List<Log> logs, Meta meta) {
        this.logs = logs;
        this.meta = meta;
    }

    public List<Log> getLogs() {
        return this.logs;
    }
    
    public void setLogs(final List<Log> logs) {
        this.logs = logs;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
