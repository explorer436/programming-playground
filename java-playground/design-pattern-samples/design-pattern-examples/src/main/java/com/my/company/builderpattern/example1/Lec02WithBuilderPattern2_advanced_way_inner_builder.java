package com.my.company.builderpattern.example1;

import java.util.function.Consumer;

public class Lec02WithBuilderPattern2_advanced_way_inner_builder {

    public static void main(String[] args) {

        Person person1 = new Person.PersonBuilder()
                .with(pb -> {
                    pb.salutation = "Mr.";
                    pb.firstName = "John";
                    pb.lastName = "Doe";
                    pb.isFemale = false;
                    pb.address = new Address.AddressBuilder()
                            .with(ab -> {
                                ab.addressLine1 = "123 main st";
                                ab.city = "Phonenix";
                                ab.state = "AZ";
                            })
                            .build();
                })
                .with(pb -> pb.isHomeOwner = true)
                .build();

        System.out.println("person1: " + person1.toString());

        Person person2 = new Person.PersonBuilder()
                .with(pb -> {
                    pb.salutation = "Mr.";
                    pb.firstName = "John";
                    pb.lastName = "Doe";
                    pb.isFemale = false;
                })
                .with(pb -> pb.isHomeOwner = true)
                .build();

        System.out.println("person2: " + person2.toString());
    }

    /*
        What are we doing here?

        1. Both Customer and Bulider class have private constructor, which means we cannot instantiate them directly
        1. We can create only Immutable objects of Customer with the help of the Inner Builder Class
        1. The with method in the builder class accepts a Consumer which is telling the builder how to build the objects of Customer
        1. build method inside the Builder class is private which means we cannot invoke it directly and Builder has clearly defined the invocation order in the with method
        1. The lifespan of the builder object is limited to instantion of Customer based on the states defined by Consumer
        1. In simple words, we are telling the builder what the state of the Customer instance which we need to build it with are. It takes that, applies it, generates an instance of Customer, and returns it back. Now we can create Immutable Objects of Customer with much more readable code.
     */

    static class Person {
        private final String salutation;
        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final String suffix;
        private final Address address;
        private final boolean isFemale;
        private final boolean isEmployed;
        private final boolean isHomeOwner;

        // In the constructor, use the builder instead of accepting individual fields.
        public Person(PersonBuilder builder) {
            this.salutation = builder.salutation;
            this.firstName = builder.firstName;
            this.middleName = builder.middleName;
            this.lastName = builder.lastName;
            this.suffix = builder.suffix;
            this.address = builder.address;
            this.isFemale = builder.isFemale;
            this.isEmployed = builder.isEmployed;
            this.isHomeOwner = builder.isHomeOwner;
        }

        static class PersonBuilder {
            private String salutation;
            private String firstName;
            private String middleName;
            private String lastName;
            private String suffix;
            private Address address;
            private boolean isFemale;
            private boolean isEmployed;
            private boolean isHomeOwner;

            private PersonBuilder with(
                    Consumer<PersonBuilder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            public Person build() {
                return new Person(this);
            }

            private PersonBuilder() {
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "salutation='" + salutation + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", suffix='" + suffix + '\'' +
                    ", address=" + address +
                    ", isFemale=" + isFemale +
                    ", isEmployed=" + isEmployed +
                    ", isHomeOwner=" + isHomeOwner +
                    '}';
        }
    }

    static class Address {
        private final String addressLine1;
        private final String addressLine2;
        private final String city;
        private final String state;
        private final String zip;

        // In the constructor, use the builder instead of accepting individual fields.
        public Address(AddressBuilder builder) {
            this.addressLine1 = builder.addressLine1;
            this.addressLine2 = builder.addressLine2;
            this.city = builder.city;
            this.state = builder.state;
            this.zip = builder.zip;
        }

        static class AddressBuilder {
            private String addressLine1;
            private String addressLine2;
            private String city;
            private String state;
            private String zip;

            private AddressBuilder with(
                    Consumer<AddressBuilder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            public Address build() {
                return new Address(this);
            }
        }

        @Override
        public String toString() {
            return "Address{" +
                    "addressLine1='" + addressLine1 + '\'' +
                    ", addressLine2='" + addressLine2 + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zip='" + zip + '\'' +
                    '}';
        }
    }

}
