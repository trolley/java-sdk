package com.trolley.types.supporting;

import java.util.Iterator;
import java.util.List;

import com.trolley.InvoiceGateway;
import com.trolley.types.Invoice;
import com.trolley.types.Invoices;
import com.trolley.types.Invoice.SearchBy;

public class InvoicesIterator implements Iterator<Invoice>{

    private InvoiceGateway gateway  = null;
    private List<Invoice> invoices  = null;
    private Meta meta               = null;

    private SearchBy searchBy       = null;
    private List<String> paramsList = null;
    private String param            = null;
    /**
     * Which index we're on in the {@code recipients} List.
     */
    private int index = 0;

    public InvoicesIterator(final SearchBy searchBy, 
        final List<String> paramsList,
        final String param,
        final InvoiceGateway gateway, 
        final Invoices i) {
            
            this.searchBy = searchBy;
            this.paramsList = paramsList;
            this.param = param;

            this.gateway = gateway;
            this.invoices = i.getInvoices();
            this.meta = i.getMeta();
    }

    @Override
    public boolean hasNext() {
        //Check if index has indeed run out and we need to fetch the next page
        if (index >= invoices.size()) {
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
    public Invoice next() {
        return invoices.get(index++);
    }

    /**
     * Fetches the next page (current page + 1), sets up local variables with returned data, resets the index, and returns true if everything went well.
     * @return boolean true if fetching the next page was successful
     */
    private boolean fetchNextPage(){
        try {
            Invoices i = gateway.search(searchBy, paramsList, param, (meta.getPage()+1), 10);
            invoices = i.getInvoices();
            meta = i.getMeta();
            index = 0;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}