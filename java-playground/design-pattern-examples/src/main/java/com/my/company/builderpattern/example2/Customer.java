package com.my.company.builderpattern.example2;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
}
