package com.my.company;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.Map;

public interface VendingMachine {

    Map<String, Long> displayItemsAndPrices();

    List<VendingMachineImpl.InventoryItemNamePriceQuantity> displayInventoryItemsAndPrices();

    long selectItemAndGetPrice(Item item);

    void insertCoin(Coin coin);

    List<Coin> refund();

    ImmutablePair<Item, List<Coin>> purchaseItemAndCollectChange(Item item);

    void reset();

}
