package com.springdatamongodbrest.models;

import org.springframework.data.annotation.Id;

public class Person {

  @Id private String id;

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("id = ").append(id);
    sb.append(", firstName = ").append(getFirstName());
    sb.append(", lastName = ").append(getLastName());
    return sb.append("}").toString();
  }

}
