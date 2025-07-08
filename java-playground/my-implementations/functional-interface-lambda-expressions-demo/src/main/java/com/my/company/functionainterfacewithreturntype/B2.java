package com.my.company.functionainterfacewithreturntype;

public class B2 implements A2 {
    @Override
    public int add(int i, int j) {
        System.out.println("In add() - i: " + i);
        System.out.println("In add() - j: " + j);
        return i + j;
    }
}
