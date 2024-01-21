package com.my.company.datastructures.streamsapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.beans.Transient;
import java.util.List;

@Data
@Builder
public class Person {
  private int id;
  private String name;
  private int age;
  private String gender;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String zip;
  private List<String> phones;

  // If this class happens to be an entity in an application, mark this with the annotation
  // "@Transient". If not, hibernate will complain that it cannot determine the type of the object
  // "Address".

  public record Address(
      String addressLine1, String addressLine2, String city, String state, String zip) {}

  public Address getAddress() {
    return new Address(addressLine1, addressLine2, city, state, zip);
  }
}
