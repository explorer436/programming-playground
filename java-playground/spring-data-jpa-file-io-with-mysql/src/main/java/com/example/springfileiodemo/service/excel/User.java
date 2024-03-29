package com.example.springfileiodemo.service.excel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    private Integer id;

    private String email;

    private String password;

    private String fullName;

    private boolean enabled;
}
