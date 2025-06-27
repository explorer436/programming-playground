package com.my.company;

import com.my.company.exceptions.NotFullPaidException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestVendingMachine {

    VendingMachine myVendingMachine = VendingMachineFactory.createVendingMachine();

    @Test
    public void testVendingMachine() {

        Map<String, Long> expectedMap = new HashMap<>();
        expectedMap.put("Coke", 25L);
        expectedMap.put("Pepsi", 35L);
        expectedMap.put("Soda", 45L);

        assertEquals(expectedMap, myVendingMachine.getItemsAndPrices());

        Collection<VendingMachineImpl.InventoryItemNamePriceQuantity> expectedInventoryItemsAndPrices = new HashSet<>();

        expectedInventoryItemsAndPrices.addAll(
                Set.of(
                        new VendingMachineImpl.InventoryItemNamePriceQuantity("Pepsi", 35L, 5),
                        new VendingMachineImpl.InventoryItemNamePriceQuantity("Coke", 25L, 5),
                        new VendingMachineImpl.InventoryItemNamePriceQuantity("Soda", 45L, 5)
                ));

        assertEquals(expectedInventoryItemsAndPrices, myVendingMachine.getInventoryItemsAndPrices());

        myVendingMachine.insertCoin(Coin.NICKLE);
        assertEquals(5L, myVendingMachine.showCurrentBalance());

        Exception exception = assertThrows(NotFullPaidException.class, () -> {
            ImmutablePair<Item, Collection<Coin>> purchasedItemAndChange = myVendingMachine.purchaseItemAndCollectChange(Item.COKE);
        });
        assertEquals("Price not full paid, available balance = 5, still need : 20", exception.getMessage());

        myVendingMachine.insertCoin(Coin.DIME);
        assertEquals(15L, myVendingMachine.showCurrentBalance());

        myVendingMachine.insertCoin(Coin.QUARTER);
        assertEquals(40L, myVendingMachine.showCurrentBalance());

        ImmutablePair<Item, Collection<Coin>> purchasedItemAndChange = myVendingMachine.purchaseItemAndCollectChange(Item.COKE);
        assertEquals("Coke", purchasedItemAndChange.left.getName());
        assertEquals(List.of(Coin.DIME, Coin.NICKLE), purchasedItemAndChange.right);

        expectedInventoryItemsAndPrices.clear();
        // updated quantity for purchased items
        expectedInventoryItemsAndPrices.addAll(
                Set.of(
                        new VendingMachineImpl.InventoryItemNamePriceQuantity("Pepsi", 35L, 5),
                        new VendingMachineImpl.InventoryItemNamePriceQuantity("Coke", 25L, 4),
                        new VendingMachineImpl.InventoryItemNamePriceQuantity("Soda", 45L, 5)
                ));

        assertEquals(expectedInventoryItemsAndPrices, myVendingMachine.getInventoryItemsAndPrices());
    }
}
