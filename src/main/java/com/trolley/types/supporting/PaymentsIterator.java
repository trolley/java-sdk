package com.trolley.types.supporting;

import java.util.Iterator;
import java.util.List;

import com.trolley.PaymentGateway;
import com.trolley.types.Payment;

public class PaymentsIterator implements Iterator<Payment>{

    private PaymentGateway gateway = null;
    private List<Payment> payments = null;
    private Meta meta;

    /**
     * Which index we're on in the {@code recipients} List.
     */
    private int index = 0;

    /**
     * Search term originally used.
     * This will be used while fetching next pages.
     */
    private String searchTerm = "";

    /**
     * Originally used {@code batchId}
     * This will be used while fetching next pages.
     */
    private String batchId = "";

    public PaymentsIterator(PaymentGateway gateway, Payments p, String batchId, String searchTerm) {
        this.gateway = gateway;
        this.payments = p.getPayments();
        this.meta = p.getMeta();
        this.batchId = batchId;
        this.searchTerm = searchTerm;
    }

    @Override
    public boolean hasNext() {
        //Check if index has indeed run out and we need to fetch the next page
        if (index >= payments.size()) {
            /* Check if we are on the last page of results, by checking if fetching the 
            next page (page + 1) will exceed the number of pages available (pages) */
            if (meta.getPage() + 1 > meta.getPages()) {
                // Return false if we are on the last page. i.e. Fetching the next page will exceed the total number of pages
                return false;
            }

            // If we're not on the last page, then fetch the next page.
            return fetchNextPage();
        }
        
        return this.index < meta.getRecords();
    }

    @Override
    public Payment next() {
        return payments.get(index++);
    }

    /**
     * Fetches the next page (current page + 1), sets up local variables with returned data, resets the index, and returns true if everything went well.
     * @return boolean true if fetching the next page was successful
     */
    private boolean fetchNextPage(){
        try {
            Payments p = gateway.search_by_page(batchId, (meta.getPage() + 1), 10, searchTerm);
            payments = p.getPayments();
            meta = p.getMeta();
            index = 0;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}