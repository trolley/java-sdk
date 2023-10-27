package com.trolley.types.supporting;

import java.util.List;

import com.trolley.types.Batch;

public class Batches
{
    private List<Batch> batches;
    private Meta meta;
    
    public Batches(final List<Batch> batches, final Meta meta) {
        this.batches = batches;
        this.meta = meta;
    }
    
    public List<Batch> getBatches() {
        return this.batches;
    }
    
    public void setBatches(final List<Batch> batches) {
        this.batches = batches;
    }
    
    public Meta getMeta() {
        return this.meta;
    }
    
    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
