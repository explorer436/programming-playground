package com.example.assignment.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceUnitTestConfiguration {

    @Bean
    MyGrpcServer myService() {
        return new MyGrpcServer();
    }

}
