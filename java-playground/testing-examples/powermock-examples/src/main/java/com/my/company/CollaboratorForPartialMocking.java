package com.my.company;

public class CollaboratorForPartialMocking {
    static String staticMethod() {
        return "Hello Baeldung!";
    }

    final String finalMethod() {
        return "Hello Baeldung!";
    }

    private String privateMethod() {
        return "Hello Baeldung!";
    }

    String privateMethodCaller() {
        return privateMethod() + " Welcome to the Java world.";
    }
}
