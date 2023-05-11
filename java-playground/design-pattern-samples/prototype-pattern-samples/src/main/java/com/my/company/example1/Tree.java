package com.my.company.example1;

import lombok.Data;

@Data
public abstract class Tree {

    private double mass;
    private double height;
    private Position position;

    public Tree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public abstract Tree copy();
}
