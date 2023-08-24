package com.example.springhttpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringHttpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHttpDemoApplication.class, args);
	}

}
