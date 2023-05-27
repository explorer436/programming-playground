package com.my.company.singletonpattern.breakingsingleton.usingreflection;

public class Singleton {
    /* private instance variable */
    private static Singleton instance = new Singleton();

    /* private constructor */
    private Singleton() {
    }

    /* returns the same object */
    public static Singleton getInstance() {
        return instance;
    }
}
