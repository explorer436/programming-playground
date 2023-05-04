package com.my.company.dummy;

public class Beverage {

    // instance varialbes for milkCost, soyCost, mochaCost and whipCost
    // getters and setters for milk, soy, mocha, whip

    public  double cost() {
        float condimentCost = 0.0F;
        if (hasMilk) {
            condimentCost += milkCost;
        }
        if (hasSoy) {
            condimentCost += soyCost;
        }
        if (hasMocha) {
            condimentCost += mochaCost;
        }
        if (hasWhip) {
            condimentCost += whipCost;
        }
        return condimentCost;
    }
}
