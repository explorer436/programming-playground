package com.example.springbootmultipledatabasespoc.entities.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product {

    @Id
    private int id;

    private String name;

    private double price;
}
