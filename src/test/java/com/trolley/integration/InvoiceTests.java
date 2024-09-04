
package com.trolley.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.types.Invoice;
import com.trolley.types.InvoiceLine;
import com.trolley.types.InvoicePayment;
import com.trolley.types.Invoices;
import com.trolley.types.Recipient;
import com.trolley.types.supporting.Amount;
import com.trolley.types.supporting.InvoicePaymentFields;
import com.trolley.types.supporting.InvoicePaymentPart;
import com.trolley.types.supporting.InvoicePaymentsIterator;
import com.trolley.types.supporting.InvoicesIterator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(Invoice.class)
public class InvoiceTests {

    private static Configuration config;
    private static TestHelper testHelper;

    @BeforeClass 
    public static void setupConfig() {
        config = TestHelper.getConfig();
        testHelper = new TestHelper();
    }

    @Test
    public void testInvoices() throws Exception {
        Gateway client = new Gateway(config);
        final Recipient recipient = testHelper.createRecipient();

        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setUnitAmount(new Amount("100", "USD"));

        ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>(){
            {
                add(invoiceLine);
            }
        };

        // Create a new invoice - prepare request body
        Invoice invoice = new Invoice();
        invoice.setRecipientId(recipient.getId());
        invoice.setInvoiceNumber("invoice-123");
        invoice.setDescription("test-invoice-create-java-sdk");
        invoice.setExternalId("ext-id-"+System.currentTimeMillis());
        invoice.setLines(invoiceLines);

        // Create a new invoice - send request and receive response
        invoice = client.invoice.create(invoice);
        assertEquals(invoice.getRecipientId(), recipient.getId());

        //Update an Invoice
        Invoice updateInvoiceRequest = new Invoice();
        updateInvoiceRequest.setDescription("test-invoice-update-java-sdk");
        final Invoice updatedInvoice = client.invoice.update(
            invoice.getId(),
            updateInvoiceRequest);
        assertEquals(updatedInvoice.getDescription(),"test-invoice-update-java-sdk");
        assertEquals(updatedInvoice.getId(),invoice.getId());

        //Fetch an Invoice
        invoice = client.invoice.fetch(updatedInvoice.getId());
        assertEquals(updatedInvoice.getId(),invoice.getId());

        //Search for Invoices by recipientId - preparing params
        ArrayList<String> recipientIds = new ArrayList<String>(){
            {
                add(recipient.getId());
            }
        };

        // Search for Invoices by recipientId with pagination
        Invoices invoices = client.invoice.search(Invoice.SearchBy.RECIPIENT_ID, recipientIds, null,1,2);
        List<Invoice> invoiceList = invoices.getInvoices();
        assertEquals(invoiceList.get(0).getRecipientId(),invoice.getRecipientId());
        assertTrue(invoices.getMeta().getPages() >= 1);

        //Cleanup - Delete Recipient
        boolean recDelResult = testHelper.deleteRecipient(recipient);
        assertTrue(recDelResult);

        //Delete an Invoice
        boolean invoiceDelResult = client.invoice.delete(invoice.getId());
        assertTrue(invoiceDelResult);
    }

    @Test
    public void testInvoiceAutoPagination() throws Exception{
        Gateway client = new Gateway(config);
        
        // Search for Invoices by recipientId with iterator
        ArrayList<String> extIds = new ArrayList<String>(){
            {
                add("23");
            }
        };
        InvoicesIterator invoices = client.invoice.search(Invoice.SearchBy.EXTERNAL_ID, extIds, null);

        int itemsCount = 0;
        while(invoices.hasNext()){
            itemsCount++;
            Invoice i = invoices.next();
            assertNotNull(i.getId());
        }
        assertTrue(itemsCount>0);
    }

    @Test
    public void testInvoiceLines() throws Exception {
        Gateway client = new Gateway(config);

        //Setup - create recipient
        final Recipient recipient = testHelper.createRecipient();

        //Setup - create Invoice
        Invoice createInvoiceRequest = new Invoice();
        createInvoiceRequest.setRecipientId(recipient.getId());
        createInvoiceRequest.setInvoiceNumber("invoice-123");
        createInvoiceRequest.setDescription("test-invoice-create-java-sdk");
        createInvoiceRequest.setExternalId("ext-id-"+System.currentTimeMillis());

        Invoice invoice = client.invoice.create(createInvoiceRequest);
        assertEquals(invoice.getRecipientId(), recipient.getId());

        //Add a new Invoice Line to the Invoice just created
        InvoiceLine invoiceLineRequest = new InvoiceLine();
        invoiceLineRequest.setUnitAmount(new Amount("100", "USD"));
        invoiceLineRequest.setCategory(InvoiceLine.InvoiceCategories.SERVICES);
        invoiceLineRequest.setDescription("Invoice Line from Java SDK");
        invoiceLineRequest.setExternalId("ILine-ExtId-"+System.currentTimeMillis());
        invoiceLineRequest.setTaxReportable(true);
        invoiceLineRequest.setForceUsTaxActivity(true);
        invoiceLineRequest.setQuantity("2");
        invoiceLineRequest.setDiscountAmount(new Amount("10", "USD"));
        invoiceLineRequest.setTaxAmount(new Amount("5", "USD"));

        Invoice invoiceWithLines = client.invoiceLine.create(invoice.getId(), invoiceLineRequest);
            
        assertEquals(invoiceWithLines.getLines().get(0).getUnitAmount().getValue(), "100.00");

        //Add multiple new Invoice Lines to the Invoice created
        List<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
        for (int i=1 ; i<=3; i++){
            invoiceLines.add(new InvoiceLine(
                new Amount("10"+i, "USD"),
                InvoiceLine.InvoiceCategories.SERVICES,
                "Invoice Line from Java SDK", 
                "ILine-ExtId-"+System.currentTimeMillis()+"-"+i, 
                true, 
                true,
                null, 
                "2", 
                new Amount("1"+i, "USD"), 
                new Amount("5", "USD"),
                null, 
                null));
        }

        invoiceWithLines = client.invoiceLine.create(invoice.getId(), 
            invoiceLines);
        assertEquals(invoiceWithLines.getLines().size(),4);

        //Update an invoice line
        InvoiceLine lineToUpdate = invoiceWithLines.getLines().get(0);
        lineToUpdate.setInvoiceLineId(lineToUpdate.getId());
        lineToUpdate.setUnitAmount(new Amount("500","USD"));
        invoiceWithLines = client.invoiceLine.update(invoice.getId(), 
            lineToUpdate);
        assertEquals(invoiceWithLines.getLines().get(0).getUnitAmount().getValue(),"500.00");

        //Update multiple invoice lines
        ArrayList<InvoiceLine> linesToUpdate = new ArrayList<InvoiceLine>();
        for (InvoiceLine invoiceLine : invoiceWithLines.getLines()) {
            invoiceLine.setInvoiceLineId(invoiceLine.getId());
            invoiceLine.setUnitAmount(new Amount("350","USD"));
            linesToUpdate.add(invoiceLine);
        }
        invoiceWithLines = client.invoiceLine.update(invoice.getId(), 
            linesToUpdate);
        assertEquals(invoiceWithLines.getLines().size(),4);
        assertEquals(invoiceWithLines.getLines().get(3).getUnitAmount().getValue(),"350.00");

        //Delete an invoice line
        boolean delete = client.invoiceLine.delete(invoiceWithLines.getId(), invoiceWithLines.getLines().get(0).getId());
        assertTrue(delete);

        //Refreshing invoice object
        invoiceWithLines = client.invoice.fetch(invoiceWithLines.getId());

        //Delete multiple invoice lines
        ArrayList<String> lineIdsToDel = new ArrayList<String>();
        for (InvoiceLine line : invoiceWithLines.getLines()) {
            lineIdsToDel.add(line.getId());
        }
        boolean deleteMultiple = client.invoiceLine.delete(invoiceWithLines.getId(), lineIdsToDel);
        assertTrue(deleteMultiple);
        
        // Assert that all lines were deleted
        invoiceWithLines = client.invoice.fetch(invoiceWithLines.getId());
        assertTrue(invoiceWithLines.getLines().size() == 0);

        //Cleanup - delete invoice
        boolean invoiceDelResult = client.invoice.delete(invoice.getId());
        assertTrue(invoiceDelResult);

        //Cleanup - delete recipient
        boolean recDelResult = testHelper.deleteRecipient(recipient);
        assertTrue(recDelResult);
    }

    @Test
    public void testInvoicePayments() throws Exception {
        Gateway client = new Gateway(config);
        //Setup - Recipient
        final Recipient recipient = testHelper.createRecipient();

        //Setup - Invoice Line
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setUnitAmount(new Amount("100", "USD"));

        ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>(){
            {
                add(invoiceLine);
            }
        };

        //Setup - Invoice
        Invoice invoice = client.invoice.create(new Invoice(
            recipient.getId(),
            "invoice-123", 
            "test-invoice-create-java-sdk", 
            "ext-id-"+System.currentTimeMillis(), 
            null,
            null, 
            null, 
            invoiceLines));
        assertEquals(invoice.getRecipientId(), recipient.getId());
        
        //Create a new Invoice Payment
        InvoicePaymentPart paymentPart = new InvoicePaymentPart();
        paymentPart.setInvoiceId(invoice.getId());
        paymentPart.setInvoiceLineId(invoice.getLines().get(0).getId());
        paymentPart.setAmount(new Amount("50", "USD"));

        ArrayList<String> tags = new ArrayList<String>();
        tags.add("tag1");
        tags.add("tag2");

        InvoicePaymentFields paymentFields = new InvoicePaymentFields(
            false,
            "Integration Test Payment",
            "ext-id-"+System.currentTimeMillis(),
            tags);       

        InvoicePayment invoicePayment = client.invoicePayment.create(null, paymentPart, paymentFields);

        assertTrue(invoicePayment.getInvoicePayments().size()>0);

        // Update an invoice payment
        paymentPart = new InvoicePaymentPart();
        paymentPart.setInvoiceId(invoice.getId());
        paymentPart.setInvoiceLineId(invoice.getLines().get(0).getId());
        paymentPart.setPaymentId(invoicePayment.getPaymentId());
        paymentPart.setAmount(new Amount("10","USD"));

        boolean paymentUpdateResult = client.invoicePayment.update(paymentPart);
        assertTrue(paymentUpdateResult);

        //Search an invoice payment
        List<String> paymentIds = new ArrayList<String>();
        paymentIds.add(invoicePayment.getPaymentId());

        List<String> invoiceIds = new ArrayList<String>();
        invoiceIds.add(invoice.getId());
        InvoicePaymentsIterator invoicePaymentsIterator = client.invoicePayment.search(null, invoiceIds);
        while (invoicePaymentsIterator.hasNext()) {
            assertNotNull(invoicePaymentsIterator.next().getInvoiceId());
        }

        //Delete an Invoice Payment
        boolean deleteResult = client.invoicePayment.delete(
            invoicePayment.getInvoicePayments().get(0).getPaymentId(), 
            invoicePayment.getInvoicePayments().get(0).getInvoiceLineId());
        assertTrue(deleteResult);

        //Cleanup - Delete Recipient
        boolean recDelResult = testHelper.deleteRecipient(recipient);
        assertTrue(recDelResult);

        //Delete an Invoice
        boolean invoiceDelResult = client.invoice.delete(invoice.getId());
        assertTrue(invoiceDelResult);
    }
    
}