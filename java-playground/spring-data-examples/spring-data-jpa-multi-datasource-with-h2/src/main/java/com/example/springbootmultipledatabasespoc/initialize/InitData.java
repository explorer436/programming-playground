package com.example.springbootmultipledatabasespoc.initialize;

import com.example.springbootmultipledatabasespoc.entities.user.User;
import com.example.springbootmultipledatabasespoc.entities.product.Product;
import com.example.springbootmultipledatabasespoc.repositories.user.UserRepository;
import com.example.springbootmultipledatabasespoc.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    @PostConstruct
    public void load() {

        User user = new User();
        user.setName("John");
        user.setEmail("john@test.com");
        user.setAge(20);
        user = userRepository.save(user);

        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        product = productRepository.save(product);
    }

}
