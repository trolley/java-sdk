
package com.trolley.sdk.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.trolley.trolley.Invoice;
import com.trolley.trolley.InvoiceLine;
import com.trolley.trolley.InvoicePayment;
import com.trolley.trolley.Configuration;
import com.trolley.trolley.Gateway;
import com.trolley.trolley.Recipient;
import com.trolley.trolley.types.Amount;
import com.trolley.trolley.types.InvoicePaymentPart;
import com.trolley.trolley.types.InvoicePayments;
import com.trolley.trolley.types.Invoices;

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

        // Create a new invoice
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

        //Update an Invoice
        final Invoice updatedInvoice = client.invoice.update(
            invoice.getId(),
            new Invoice(
                null,
                "invoice-123", 
                "test-invoice-update-java-sdk", 
                null, 
                null,
                null, 
                null, 
                null
            ));
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
        assertEquals(invoices.getMeta().getPages(),1);

        //Cleanup - Delete Recipient
        boolean recDelResult = testHelper.deleteRecipient(recipient);
        assertTrue(recDelResult);

        //Delete an Invoice
        boolean invoiceDelResult = client.invoice.delete(invoice.getId());
        assertTrue(invoiceDelResult);
    }

    @Test
    public void testInvoiceLines() throws Exception {
        Gateway client = new Gateway(config);

        //Setup - create recipient
        final Recipient recipient = testHelper.createRecipient();

        //Setup - create Invoice
        Invoice invoice = client.invoice.create(new Invoice(
            recipient.getId(),
            "invoice-123", 
            "test-invoice-create-java-sdk", 
            "ext-id-"+System.currentTimeMillis(), 
            null,
            null, 
            null, 
            null));
        assertEquals(invoice.getRecipientId(), recipient.getId());

        //Add a new Invoice Line to the Invoice just created
        Invoice invoiceWithLines = client.invoiceLine.create(invoice.getId(), 
            new InvoiceLine(
                new Amount("100", "USD"),
                InvoiceLine.InvoiceCategories.SERVICES,
                "Invoice Line from Java SDK", 
                "ILine-ExtId-"+System.currentTimeMillis(), 
                true, 
                true,
                null, 
                "2", 
                new Amount("10", "USD"), 
                new Amount("5", "USD"),
                null, 
                null));
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

        InvoicePayment invoicePayment = client.invoicePayment.create(null, paymentPart);

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
        InvoicePayments invoicePayments = client.invoicePayment.search(null, invoiceIds);
        assertTrue(invoicePayments.getMeta().getRecords()>0);

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