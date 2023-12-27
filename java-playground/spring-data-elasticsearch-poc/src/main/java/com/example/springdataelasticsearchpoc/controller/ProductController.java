package com.example.springdataelasticsearchpoc.controller;

import com.example.springdataelasticsearchpoc.model.Product;
import com.example.springdataelasticsearchpoc.service.ProductSearchServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products/all")
@RequiredArgsConstructor
public class ProductController {

    private final ProductSearchServiceWithRepo productSearchServiceWithRepo;

    @GetMapping
    public Iterable<Product> findAll() {
        return productSearchServiceWithRepo.findAll();
    }
}