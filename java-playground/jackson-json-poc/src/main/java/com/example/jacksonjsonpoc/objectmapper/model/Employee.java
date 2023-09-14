package com.example.jacksonjsonpoc.objectmapper.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
public class Employee {
    private String firstname;
    private String lastname;
    private LocalDateTime joinedDate;
    private OffsetDateTime leavingDate;
}
