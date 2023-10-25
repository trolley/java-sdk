package com.trolley.types.supporting;

import java.util.Iterator;
import java.util.List;

import com.trolley.RecipientGateway;
import com.trolley.types.Recipient;

public class RecipientsIterator implements Iterator<Recipient>{

    private RecipientGateway gateway = null;
    private List<Recipient> recipients = null;
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

    public RecipientsIterator(RecipientGateway gateway, Recipients r, String searchTerm) {
        this.gateway = gateway;
        this.recipients = r.getRecipients();
        this.meta = r.getMeta();
        this.searchTerm = searchTerm;
    }

    @Override
    public boolean hasNext() {
        //Check if index has indeed run out and we need to fetch the next page
        if (index >= recipients.size()) {
            /* Check if we are on the last page of results, by checking if fetching the 
            next page (page + 1) will exceed the number of pages available (pages) */
            if (meta.getPage() + 1 > meta.getPages()) {
                // Return false if we are on the last page. i.e. Fetching the next page will exceed the total number of pages
                return false;
            }

            // If we're not on the last page, then fetch the next page.
            return fetchNextPage();
        }
        
        return index < meta.getRecords();
    }

    @Override
    public Recipient next() {
        return recipients.get(index++);
    }

    /**
     * Fetches the next page (current page + 1), sets up local variables with returned data, resets the index, and returns true if everything went well.
     * @return boolean true if fetching the next page was successful
     */
    private boolean fetchNextPage(){
        try {
            Recipients r = gateway.search_by_page((meta.getPage() + 1), 10, searchTerm);
            recipients = r.getRecipients();
            meta = r.getMeta();
            index = 0;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}