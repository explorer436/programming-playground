package com.example.assignment.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceUnitTestConfiguration {

    @Bean
    RewardsGrpcService rewardsGrpcServiceService() {
        return new RewardsGrpcService();
    }

    @Bean
    OrdersGrpcService ordersGrpcService() {
        return new OrdersGrpcService();
    }

}
