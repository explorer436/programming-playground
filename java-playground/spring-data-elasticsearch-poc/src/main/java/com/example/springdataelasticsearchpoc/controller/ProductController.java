package com.example.springdataelasticsearchpoc.controller;

import com.example.springdataelasticsearchpoc.model.Product;
import com.example.springdataelasticsearchpoc.service.ProductSearchServiceWithRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductSearchServiceWithRepo productSearchServiceWithRepo;

    @GetMapping
    public Iterable<Product> findAll() {
        return productSearchServiceWithRepo.findAll();
    }

    /*@PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") String id) {
        bookService.deleteById(id);
    }*/
}