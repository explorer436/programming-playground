package com.my.company.builderpattern.example1;

public class Lec01WithoutBuilderPattern2 {

    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("John", "Doe", "M");
    }

    static class Person {

        private final String firstName;
        private final String lastName;
        private final String middleName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = null;
        }

        public Person(String firstName, String lastName, String middleName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
        }
    }
}
