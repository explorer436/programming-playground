package com.my.company.decoratorpattern.example3;

public class TestDriver {
    public static void main(String[] args) {
        Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
        System.out.println(icecream.makeIcecream());
    }
}
