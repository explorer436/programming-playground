package com.my.company.example1;

public class PineTree extends Tree {

    private String type;

    public PineTree(double mass, double height) {
        super(mass, height);
        this.type = "Pine";
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(this.getMass(), this.getHeight());
        pineTreeClone.setPosition(this.getPosition());
        return pineTreeClone;
    }

}
