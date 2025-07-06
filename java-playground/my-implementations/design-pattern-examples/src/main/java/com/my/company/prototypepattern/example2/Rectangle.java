package com.my.company.prototypepattern.example2;

public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Rectangle's draw() method.");
    }
}
