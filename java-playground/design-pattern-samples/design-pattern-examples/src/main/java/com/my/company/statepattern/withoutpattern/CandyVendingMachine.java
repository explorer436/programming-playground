package com.my.company.statepattern.withoutpattern;

public class CandyVendingMachine {
    final static int NO_CANDY = 0;
    final static int NO_COIN = 1;
    final static int CONTAINS_COIN = 2;
    final static int DISPENSE = 3;
    int count;
    int state = NO_CANDY;

    public CandyVendingMachine(int numberOfCandies) {
        count = numberOfCandies;
        if (count > 0) state = NO_COIN;
    }

    public void insertCoin() {
        if (state == CONTAINS_COIN) {
            System.out.println("Coin already inserted");
        } else if (state == NO_COIN) {
            state = CONTAINS_COIN;
        } else if (state == NO_CANDY) {
            System.out.println("No candies available");
        } else if (state == DISPENSE) {
            System.out.println("Error. System is currently dispensing");
        }
    }

    public void pressButton() {
        if (state == CONTAINS_COIN) {
            state = DISPENSE;
        } else if (state == NO_COIN) {
            System.out.println("No coin inserted");
        } else if (state == NO_CANDY) {
            System.out.println("No candies available");
        } else if (state == DISPENSE) {
            System.out.println("No coin inserted");
        }
    }

    public void dispense() {
        if (state == CONTAINS_COIN) {
            System.out.println("No candies rolled out");
        } else if (state == NO_COIN) {
            System.out.println("No coin inserted");
        } else if (state == NO_CANDY) {
            System.out.println("No candies available");
        } else if (state == DISPENSE) {
            count = count - 1;
            if (count == 0) {
                state = NO_CANDY;
            } else
                state = NO_COIN;
        }
    }
}
