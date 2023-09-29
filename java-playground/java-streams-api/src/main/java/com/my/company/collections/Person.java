package com.my.company.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.beans.Transient;

@Data
@Builder
public class Person {
    private String name;
    private int age;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    public record Address(String addressLine1, String addressLine2, String city, String state, String zip) { }

    public Address getAddress() {
        return new Address(addressLine1, addressLine2, city, state, zip);
    }
}
