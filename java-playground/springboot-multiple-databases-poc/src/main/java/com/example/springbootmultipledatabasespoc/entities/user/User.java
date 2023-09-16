package com.example.springbootmultipledatabasespoc.entities.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Integer age;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer status;
}
