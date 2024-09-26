package com.my.company.builderpattern.example1;

public class Lec01WithoutBuilderPattern3_ChainingConstructors {

    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("John", "Doe", "M");
        Person person3 = new Person("John", "Doe", "M", "Mr.");
    }

    static class Person {

        private String firstName;
        private String lastName;
        private String middleName;
        private String salutation;

        public Person(String firstName, String lastName) {
            new Person(firstName, lastName, null);
        }

        public Person(String firstName,
                      String lastName,
                      String middleName) {
            new Person(firstName, lastName, middleName, null);
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
