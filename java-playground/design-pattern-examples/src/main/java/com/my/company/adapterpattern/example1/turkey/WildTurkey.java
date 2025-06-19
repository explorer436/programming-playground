package com.my.company.adapterpattern.example1.turkey;

public class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("Turkey says Gobble gobble");
    }

    public void fly() {
        System.out.println("I'm a flying turkey");
    }
}
