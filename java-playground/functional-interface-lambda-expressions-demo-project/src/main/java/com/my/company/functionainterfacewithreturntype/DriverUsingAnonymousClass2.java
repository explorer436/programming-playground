package com.my.company.functionainterfacewithreturntype;

public class DriverUsingAnonymousClass2 {
    public static void main(String[] args) {

        // Using anonymous class
        A2 obj = new A2() {
            @Override
            public int add(int i, int j) {
                System.out.println("In add() - i: " + i);
                System.out.println("In add() - j: " + j);
                return i + j;
            }
        };
        System.out.println(obj.add(6, 7));
    }
}
