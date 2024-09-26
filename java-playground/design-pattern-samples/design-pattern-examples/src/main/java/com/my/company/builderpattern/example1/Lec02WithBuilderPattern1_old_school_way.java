package com.my.company.builderpattern.example1;

public class Lec02WithBuilderPattern1_old_school_way {

    public static void main(String[] args) {
        /*Person person1 = new Person("John", "Doe");
        Person person2 = new Person("John", "Doe", "M");
        Person person3 = new Person("John", "Doe", "M", "Mr.");*/

        Person person = new PersonBuilder()
                .withSalutation("Mr.")
                .withFirstName("John")
                .withMiddleName("L")
                .withLastName("Doe")
                .withIsFemale(false)
                .withAddress(new AddressBuilder()
                        .withAddressLine1("123 Main Road")
                        .withAddressLine2("Apt 456")
                        .withCity("Pune")
                        .withState("MH")
                        .withZip("411001")
                        .build())
                .build();
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
            this.isHomewOwner = builder.isHomewOwner;
        }
    }

    // This can be an inner class to Person
    static class PersonBuilder {
        private String salutation;
        private String firstName;
        private String middleName;
        private String lastName;
        private String suffix;
        private Address address;
        private boolean isFemale;
        private boolean isEmployed;
        private boolean isHomewOwner;

        public PersonBuilder withSalutation(String salutation) {
            this.salutation = salutation;
            return this;
        }

        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public PersonBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public PersonBuilder withIsFemale(boolean isFemale) {
            this.isFemale = isFemale;
            return this;
        }

        public PersonBuilder withIsEmployed(boolean isEmployed) {
            this.isEmployed = isEmployed;
            return this;
        }

        public PersonBuilder withIsHomewOwner(boolean isHomewOwner) {
            this.isHomewOwner = isHomewOwner;
            return this;
        }

        public Person build() {
            return new Person(this);
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
    }

    // This can be an inner class to Address
    static class AddressBuilder {
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String state;
        private String zip;

        public AddressBuilder withAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public AddressBuilder withAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

}
