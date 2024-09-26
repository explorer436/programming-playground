package com.my.company.builderpattern.without_pattern;

public class Lec01WithoutBuilderPattern3 {

    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("John", "Doe", "M");
        Person person3 = new Person("John", "Doe", "M", "Mr.");
    }

    static class Person {

        private final String firstName;
        private final String lastName;
        private final String middleName;
        private final String salutation;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = null;
            salutation = null;
        }

        public Person(String firstName,
                      String lastName,
                      String middleName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            salutation = null;
        }

        public Person(String firstName,
                      String lastName,
                      String middleName,
                      String salutation) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.salutation = salutation;
        }
    }
}
