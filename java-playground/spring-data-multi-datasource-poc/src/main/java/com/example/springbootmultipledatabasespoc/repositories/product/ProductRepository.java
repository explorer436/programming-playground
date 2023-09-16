package com.example.springbootmultipledatabasespoc.repositories.product;

import com.example.springbootmultipledatabasespoc.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> { }
