package com.example.springhttpdemo.controller;

import com.example.springhttpdemo.service.MyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final MyService myService;

    @PostMapping("/greeting")
    public String greeting(HttpServletRequest httpServletRequest) {
        myService.doSomethingAsynchronously(httpServletRequest);
        return "Hello world";
    }
}