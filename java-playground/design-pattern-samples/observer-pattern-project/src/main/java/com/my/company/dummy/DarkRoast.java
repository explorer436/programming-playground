package com.my.company.dummy;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Most excellent Dark Roast";
    }
    public  double cost() {
        return 1.99 + super.cost();
    }
}
