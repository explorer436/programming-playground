package com.my.company.example2;

public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Square's draw() method.");
    }
}
