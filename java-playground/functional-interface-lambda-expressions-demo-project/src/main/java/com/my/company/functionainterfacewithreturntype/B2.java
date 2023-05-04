package com.my.company.functionainterfacewithreturntype;

public class B2 implements A2 {
    @Override
    public int add(int i, int j) {
        System.out.println("In show() - i: " + i);
        return i + j;
    }
}
