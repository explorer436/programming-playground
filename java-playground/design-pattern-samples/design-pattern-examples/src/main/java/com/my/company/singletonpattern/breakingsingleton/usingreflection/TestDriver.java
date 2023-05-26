package com.my.company.singletonpattern.breakingsingleton.usingreflection;

import java.lang.reflect.Constructor;

public class TestDriver {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = null;
        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor: constructors) {
                constructor.setAccessible(true);
                singleton2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("instance1.hashCode(): " + singleton1.hashCode());
        System.out.println("instance2.hashCode(): " + singleton2.hashCode());

        // Output
        // instance1.hashCode(): 1159190947
        // instance2.hashCode(): 804564176
    }
}
