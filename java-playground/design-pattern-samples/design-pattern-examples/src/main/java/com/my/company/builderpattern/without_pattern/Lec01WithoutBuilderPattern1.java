package com.my.company.builderpattern.without_pattern;

public class Lec01WithoutBuilderPattern1 {

    public static void main(String[] args) {
        Person person = new Person("John", "Doe");
    }

    static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
