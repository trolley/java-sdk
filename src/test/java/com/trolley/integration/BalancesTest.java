
package com.trolley.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.trolley.Configuration;
import com.trolley.Gateway;
import com.trolley.types.Balances;
import com.trolley.types.Batch;
import com.trolley.types.OfflinePayment;
import com.trolley.types.Recipient;
import com.trolley.types.supporting.OfflinePaymentsIterator;

@PrepareForTest(Batch.class)
public class BalancesTest {

    private static Configuration config;

    @BeforeClass 
    public static void setupConfig() {
        config = TestHelper.getConfig();
     }

    @Test
    public void testLifecycle() throws Exception {
        Gateway client = new Gateway(config);
        
        // Test - Get All Account Balances
        List<Balances> balances = client.balances.getAllBalances();

        int itemCount = 0;
        for (Balances balance : balances) {
            itemCount++;
            assertNotNull(balance.getType());
        }
        assertTrue(itemCount>0);

        // Test - Get All Account Balances
        balances = client.balances.getTrolleyAccountBalances();

        itemCount = 0;
        for (Balances balance : balances) {
            itemCount++;
            assertNotNull(balance.getType());
        }
        assertTrue(itemCount>0);

        // Test - Get All Account Balances
        balances = client.balances.getPaypalAccountBalances();

        itemCount = 0;
        for (Balances balance : balances) {
            itemCount++;
            assertNotNull(balance.getType());
        }
        assertTrue(itemCount>0);
    }
}