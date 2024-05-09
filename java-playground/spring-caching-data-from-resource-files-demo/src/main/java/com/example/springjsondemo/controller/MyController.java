package com.example.springjsondemo.controller;

import com.example.springjsondemo.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/json")
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final MyService myService;

    @GetMapping("/convert")
    public ResponseEntity<Void> convert() {

        myService.convert();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
