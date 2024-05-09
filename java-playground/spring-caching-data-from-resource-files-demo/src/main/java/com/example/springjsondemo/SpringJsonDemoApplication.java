package com.example.springjsondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringJsonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJsonDemoApplication.class, args);
	}

}
