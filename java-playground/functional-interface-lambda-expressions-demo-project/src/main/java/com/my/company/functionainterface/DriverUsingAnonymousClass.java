package com.my.company.functionainterface;

public class DriverUsingAnonymousClass {
    public static void main(String[] args) {

        // Using anonymous class
        A obj = new A() {
            @Override
            public void show(int i) {
                System.out.println("In show() - i: " + i);
            }
        };
        obj.show(6);
    }
}
