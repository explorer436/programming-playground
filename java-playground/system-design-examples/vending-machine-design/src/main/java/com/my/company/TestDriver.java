package com.my.company;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.Map;

public class TestDriver {

    public static void main(String[] args) {
        VendingMachine myVendingMachine = VendingMachineFactory.createVendingMachine();

        displayItemsAndPrices(myVendingMachine);

        myVendingMachine.insertCoin(Coin.NICKLE);
        ImmutablePair<Item, List<Coin>> purchasedItemAndChange = null;
        try {
            purchasedItemAndChange = myVendingMachine.purchaseItemAndCollectChange(Item.COKE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        myVendingMachine.insertCoin(Coin.DIME);
        myVendingMachine.insertCoin(Coin.QUARTER);
        purchasedItemAndChange = myVendingMachine.purchaseItemAndCollectChange(Item.COKE);

        System.out.println("Purchased " + purchasedItemAndChange.left + ", remaining change is " + purchasedItemAndChange.right);

        displayItemsAndPrices(myVendingMachine);

        myVendingMachine.displayInventoryItemsAndPrices().forEach(System.out::println);
    }

    private static void displayItemsAndPrices(VendingMachine myVendingMachine) {
        System.out.println("Items for sale: ");
        Map<String, Long> itemNamesAndPrices = myVendingMachine.displayItemsAndPrices();
        for (Map.Entry<String, Long> set : itemNamesAndPrices.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }

}
