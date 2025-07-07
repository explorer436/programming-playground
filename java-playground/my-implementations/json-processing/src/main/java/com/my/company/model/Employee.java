package com.my.company.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class Employee {
    private String firstname;
    private String lastname;
    private LocalDateTime joinedDate;
    private OffsetDateTime leavingDate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public OffsetDateTime getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(OffsetDateTime leavingDate) {
        this.leavingDate = leavingDate;
    }
}
