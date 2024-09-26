package com.my.company.builderpattern.without_pattern;

public class Lec01WithoutBuilderPattern4 {

    public static void main(String[] args) {
        /*Person person1 = new Person("John", "Doe");
        Person person2 = new Person("John", "Doe", "M");
        Person person3 = new Person("John", "Doe", "M", "Mr.");*/
    }

    static class Person {
        private final String salutation;
        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final String suffix;
        private final Address address;
        private final boolean isFemale;
        private final boolean isEmployed;
        private final boolean isHomewOwner;


        public Person(String salutation, String firstName, String middleName, String lastName, String suffix, Address address, boolean isFemale, boolean isEmployed, boolean isHomewOwner) {
            this.salutation = salutation;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.suffix = suffix;
            this.address = address;
            this.isFemale = isFemale;
            this.isEmployed = isEmployed;
            this.isHomewOwner = isHomewOwner;
        }
    }

    static class Address {
        private final String addressLine1;
        private final String addressLine2;
        private final String city;
        private final String state;
        private final String zip;

        public Address(String addressLine1, String addressLine2, String city, String state, String zip) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }
    }
}
