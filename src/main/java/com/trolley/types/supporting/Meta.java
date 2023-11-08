package com.trolley.types.supporting;

public class Meta
{
    /**
     * Which page you're on, out of the current result set.
     */
    private int page;

    /**
     * How many pages are there in the current result set.
     * Note: This will depend on {@code pageSize} parameter given to the API.
     */
    private int pages;

    /**
     * How many records in total are present in the current result set.
     */
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
