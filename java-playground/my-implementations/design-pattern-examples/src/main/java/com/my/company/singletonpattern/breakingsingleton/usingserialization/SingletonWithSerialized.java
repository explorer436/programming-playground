package com.my.company.singletonpattern.breakingsingleton.usingserialization;

import java.io.Serializable;

public class SingletonWithSerialized implements Serializable {

    private static final long serialVersionUID = 1L;

    private SingletonWithSerialized() {
    }

    private static SingletonWithSerialized instance = new SingletonWithSerialized();

    public static SingletonWithSerialized getInstance() {
        return SingletonWithSerialized.instance;
    }
}