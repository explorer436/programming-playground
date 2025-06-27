package com.my.company;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface VendingMachine {

    Map<String, Long> getItemsAndPrices();

    Collection<VendingMachineImpl.InventoryItemNamePriceQuantity> getInventoryItemsAndPrices();

    long selectItemAndGetPrice(Item item);

    void insertCoin(Coin coin);

    long showCurrentBalance();

    List<Coin> refund();

    ImmutablePair<Item, Collection<Coin>> purchaseItemAndCollectChange(Item item);

    void reset();

}
