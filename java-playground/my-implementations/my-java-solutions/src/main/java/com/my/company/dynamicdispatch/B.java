package com.my.company.dynamicdispatch;

public class B extends A {

    int x = 20;

    public void draw() {
        System.out.println("B is drawing");
    }

    public void bad() {
        System.out.println("B is bad");
    }

}
