package com.my.company.singletonpattern.example1;

public class TestDriver {
    public static void main(String[] args) {
        FactoryManager fm = FactoryManager.getInstance();
        fm.startTracks();
    }
}
