package com.my.company.functionainterfacewithreturntype;

public class DriverUsingAnonymousClass2 {
    public static void main(String[] args) {

        // Using anonymous class
        A2 obj = new A2() {
            @Override
            public int add(int i, int j) {
                System.out.println("In show() - i: " + i);
                return i + j;
            }
        };
        obj.add(6, 7);
    }
}
