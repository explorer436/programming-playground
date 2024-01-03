package com.example.swaggerpoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestfulController {

  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }

}
