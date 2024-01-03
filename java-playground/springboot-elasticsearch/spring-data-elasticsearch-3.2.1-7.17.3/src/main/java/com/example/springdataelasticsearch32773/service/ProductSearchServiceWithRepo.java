package com.example.springdataelasticsearch32773.service;

import com.example.springdataelasticsearch32773.model.Product;
import com.example.springdataelasticsearch32773.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductSearchServiceWithRepo {

    private final ProductRepository productRepository;

    public void createProductIndex(final Product product) {
        productRepository.save(product);
    }

    public void createProductIndexBulk(final List<Product> products) {
        productRepository.saveAll(products);
    }

    public List<Product> findProductsByManufacturerAndCategory(final String manufacturer, final String category) {
        return productRepository.findByManufacturerAndCategory(manufacturer, category);
    }

    public List<Product> findByProductName(final String productName) {
        return productRepository.findByName(productName);
    }

    public List<Product> findByProductMatchingNames(final String productName) {
        return productRepository.findByNameContaining(productName);
    }

    public Iterable<Product> findAll() {
        /*Iterable<Product> iterableProductList = productRepository.findAll();

        List<Product> result = new ArrayList<>();

        iterableProductList.forEach(result::add);

        return result;*/
        return productRepository.findAll();
    }
}
