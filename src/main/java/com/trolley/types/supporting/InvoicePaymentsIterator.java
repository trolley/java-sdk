package com.trolley.types.supporting;

import java.util.Iterator;
import java.util.List;

import com.trolley.InvoicePaymentGateway;

public class InvoicePaymentsIterator implements Iterator<InvoicePaymentPart>{

    private InvoicePaymentGateway gateway = null;
    private List<InvoicePaymentPart> paymentParts = null;
    private Meta meta;

    /**
     * Which index we're on in the {@code recipients} List.
     */
    private int index = 0;

    /**
     * Originally used parameters
     * This will be used while fetching next pages.
     */
    final List<String> paymentIds = null;
    final List<String> invoiceIds = null;

    public InvoicePaymentsIterator(InvoicePaymentGateway gateway, InvoicePayments ip, final List<String> paymentIds, final List<String> invoiceIds) {
        this.gateway = gateway;
        this.paymentParts = ip.getInvoicePaymentParts();
        this.meta = ip.getMeta();
    }

    @Override
    public boolean hasNext() {
        //Check if index has indeed run out and we need to fetch the next page
        if (index >= paymentParts.size()) {
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
    public InvoicePaymentPart next() {
        return paymentParts.get(index++);
    }

    /**
     * Fetches the next page (current page + 1), sets up local variables with returned data, resets the index, and returns true if everything went well.
     * @return boolean true if fetching the next page was successful
     */
    private boolean fetchNextPage(){
        try {
            InvoicePayments ip = gateway.search(paymentIds, invoiceIds, (meta.getPage() + 1), 10);
            paymentParts = ip.getInvoicePaymentParts();
            meta = ip.getMeta();
            index = 0;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}