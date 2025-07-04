package com.my.company;

import com.my.company.exceptions.NotFullPaidException;
import com.my.company.exceptions.NotSufficientChangeException;
import com.my.company.exceptions.SoldOutException;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;

public class VendingMachineImpl implements VendingMachine {

    private final Inventory<Coin> cashInventory = new Inventory<Coin>();
    private final Inventory<Item> itemInventory = new Inventory<Item>();

    private long totalSales;

    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl() {
        initialize();
    }

    private void initialize() {
        //initialize machine with 5 coins of each denomination and 5 cans of each Item
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }

        for (Item i : Item.values()) {
            itemInventory.put(i, 5);
        }

    }

    @Override
    public Map<String, Long> getItemsAndPrices() {
        Map<String, Long> namesAndPrices = new HashMap<>();

        for (Item i : Item.values()) {
            namesAndPrices.put(i.getName(), i.getPrice());
        }
        return namesAndPrices;
    }

    public record InventoryItemNamePriceQuantity(String name, long price, Integer quantity) {}

    @Override
    public Collection<InventoryItemNamePriceQuantity> getInventoryItemsAndPrices() {

        Set<InventoryItemNamePriceQuantity> collection = new HashSet<>();

        Map<Item, Integer> inventoryItemsAndQuantity = itemInventory.getInventoryItemsAndPrices();

        InventoryItemNamePriceQuantity inventoryItemNamePriceQuantity;
        for (Item i : inventoryItemsAndQuantity.keySet()) {
            inventoryItemNamePriceQuantity = new InventoryItemNamePriceQuantity(i.getName(), i.getPrice(), inventoryItemsAndQuantity.get(i));
            collection.add(inventoryItemNamePriceQuantity);
        }
        return collection;
    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item)) {
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Sold Out, Please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public long showCurrentBalance() {
        return currentBalance;
    }

    @Override
    public ImmutablePair<Item, Collection<Coin>> purchaseItemAndCollectChange(Item item) {
        currentItem = item;
        collectItem(item);
        totalSales = totalSales + currentItem.getPrice();

        List<Coin> change = collectChange();

        return new ImmutablePair<Item, Collection<Coin>>(item, change);
    }

    private void collectItem(Item item) throws NotSufficientChangeException, NotFullPaidException {
        if (isFullPaid()) {
            if (hasSufficientChange()) {
                itemInventory.deduct(currentItem);
            } else {
                throw new NotSufficientChangeException("Not Sufficient change in Inventory");
            }
        } else {
            throw new NotFullPaidException("Price not full paid, available balance = " + currentBalance + ", still need : ", currentItem.getPrice() - currentBalance);
        }
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }


    private boolean isFullPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        }
        return false;
    }


    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;

        if (amount > 0) {
            changes = new ArrayList<Coin>();
            long balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination()
                        && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                    continue;

                } else if (balance >= Coin.DIME.getDenomination()
                        && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                    continue;

                } else if (balance >= Coin.NICKLE.getDenomination()
                        && cashInventory.hasItem(Coin.NICKLE)) {
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();
                    continue;

                } else if (balance >= Coin.PENNY.getDenomination()
                        && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                    continue;

                } else {
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }

        return changes;
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    public void printStats() {
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Current Item Inventory : " + itemInventory);
        System.out.println("Current Cash Inventory : " + cashInventory);
    }


    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }

        return hasChange;
    }

    private void updateCashInventory(List<Coin> coins) {
        for (Coin c : coins) {
            cashInventory.deduct(c);
        }
    }

    public long getTotalSales() {
        return totalSales;
    }

}
