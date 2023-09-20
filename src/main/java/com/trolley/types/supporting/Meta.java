package com.trolley.types.supporting;

public class Meta
{
    private int page;
    private int pages;
    private int records;
    
    public Meta() {
    }

    public Meta(int page, int pages, int records) {
        this.page = page;
        this.pages = pages;
        this.records = records;
    }

    public int getPage() {
        return this.page;
    }
    
    public void setPage(final int page) {
        this.page = page;
    }
    
    public int getPages() {
        return this.pages;
    }
    
    public void setPages(final int pages) {
        this.pages = pages;
    }
    
    public int getRecords() {
        return this.records;
    }
    
    public void setRecords(final int records) {
        this.records = records;
    }
}
