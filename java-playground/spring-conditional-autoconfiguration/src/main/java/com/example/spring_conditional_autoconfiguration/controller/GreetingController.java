package com.example.spring_conditional_autoconfiguration.controller;

import com.example.spring_conditional_autoconfiguration.service.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GreetingController {

	private final Greeting greeting;

	@GetMapping("/greeting")
	public ResponseEntity<String> getEmployees(){
		return ResponseEntity.ok(greeting.sayHello());
	}

}