package com.trolley.types.supporting;

import java.util.Iterator;
import java.util.List;

import com.trolley.OfflinePaymentGateway;
import com.trolley.RecipientGateway;
import com.trolley.types.OfflinePayment;

public class OfflinePaymentsIterator implements Iterator<OfflinePayment>{

    private OfflinePaymentGateway gateway = null;
    private RecipientGateway recipientGateway = null;
    private List<OfflinePayment> offlinePayments = null;
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
     * Recipient ID for when a recipient's offline payments are being fetched.
     * This will be used while fetching next pages.
     */
    private String recipientId = "";

    public OfflinePaymentsIterator(OfflinePaymentGateway gateway, OfflinePayments p, String searchTerm) {
        this.gateway = gateway;
        this.offlinePayments = p.getOfflinePayments();
        this.meta = p.getMeta();
        this.searchTerm = searchTerm;
    }

    /**
     * Constructor to use from RecipientGateway for Get All Offline Payment of Recipient
     * @param gateway
     * @param p
     */
    public OfflinePaymentsIterator(RecipientGateway gateway, OfflinePayments p, String searchTerm, String recipientId) {
        this.recipientGateway = gateway;
        this.offlinePayments = p.getOfflinePayments();
        this.meta = p.getMeta();
        this.searchTerm = searchTerm;
        this.recipientId = recipientId;
    }

    @Override
    public boolean hasNext() {
        //Check if index has indeed run out and we need to fetch the next page
        if (index >= offlinePayments.size()) {
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
    public OfflinePayment next() {
        return offlinePayments.get(index++);
    }

    /**
     * Fetches the next page (current page + 1), sets up local variables with returned data, resets the index, and returns true if everything went well.
     * @return boolean true if fetching the next page was successful
     */
    private boolean fetchNextPage(){
        try {
            OfflinePayments p;
            if(gateway != null){
                p = gateway.listAllOfflinePayments((meta.getPage() + 1), 10, searchTerm);
            }else{
                p = recipientGateway.getAllOfflinePayments(recipientId, (meta.getPage() + 1), 10, searchTerm);
            }
            
            offlinePayments = p.getOfflinePayments();
            meta = p.getMeta();
            index = 0;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}