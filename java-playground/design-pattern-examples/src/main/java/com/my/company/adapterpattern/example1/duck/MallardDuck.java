package com.my.company.adapterpattern.example1.duck;

public class MallardDuck implements Duck {
    public void quack() {
        System.out.println("Duck Quacks");
    }

    public void fly() {
        System.out.println("I'm a flying duck");
    }
}
