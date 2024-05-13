package com.example.swaggerpocjava8spring27.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestfulController {

  private static final String TEMPLATE = "Hello, %s!";

  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }

  @PostMapping("/greeting")
  public HttpEntity<Greeting> greeting(

          @RequestParam(value = "name", defaultValue = "World") String name) {

    Greeting greeting = new Greeting();
    greeting.setContent("Hello " + name);

    return new ResponseEntity<>(greeting, HttpStatus.OK);
  }

}
