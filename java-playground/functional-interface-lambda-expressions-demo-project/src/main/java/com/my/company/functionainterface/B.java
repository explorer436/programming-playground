package com.my.company.functionainterface;

public class B implements A{
    @Override
    public void show(int i) {
        System.out.println("In show() - i: " + i);
    }
}
