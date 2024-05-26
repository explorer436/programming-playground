package com.example.springcloudawssecretsmanager.controller;

import com.example.springcloudawssecretsmanager.service.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class Controller {

private final Service service;

    @GetMapping("/parameters")
    public ResponseEntity<String> getParameters() {
        log.info(">>> getParameters");

        service.getParameters();

        log.info("<<< getParameters");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
