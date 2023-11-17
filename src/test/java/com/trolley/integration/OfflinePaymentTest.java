
package com.trolley.integration;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.types.Batch;
import com.trolley.types.OfflinePayment;
import com.trolley.types.Recipient;
import com.trolley.types.supporting.OfflinePaymentsIterator;

@PrepareForTest(Batch.class)
public class OfflinePaymentTest {

    private static Configuration config;
    private static TestHelper testHelper;

    @BeforeClass 
    public static void setupConfig() {
        config = TestHelper.getConfig();
        testHelper = new TestHelper();
     }

    @Test
    public void testLifecycle() throws Exception {
        Gateway client = new Gateway(config);
        Recipient r = testHelper.createRecipient();

        OfflinePayment opRequest = new OfflinePayment();
        opRequest.setCurrency("CAD");
        opRequest.setAmount("10.00");
        opRequest.setMemo("Java SDK Offline Payment Test");

        // Offline Payment - Test Create
        OfflinePayment op = client.offlinePayment.create(r.getId(),opRequest);
        assertTrue(op.getId().startsWith("OP"));
        
        // Offline Payment - Test Update
        opRequest.setMemo("Java SDK Offline Payment Update Test");
        boolean updateResult = client.offlinePayment.update(r.getId(), op.getId(), opRequest);
        assertTrue(updateResult);

        //Offline Payment - Test getting all offline payments
        OfflinePaymentsIterator offlinePayments = client.offlinePayment.listAllOfflinePayments();
        int itemCount = 0;
        while(offlinePayments.hasNext()){
            offlinePayments.next();
            itemCount++;
        }
        assertTrue(itemCount>0);

        //Offline Payment - Test Delete
        boolean opDelResult = client.offlinePayment.delete(r.getId(),op.getId());
        assertTrue(opDelResult);

        //Cleanup
        boolean recDelResult = client.recipient.delete(r.getId());
        assertTrue(recDelResult);
    }
}