package com.example.awssqs.controller;

import com.example.awssqs.service.SQSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SQSController {

    private final SQSService service;

    @PostMapping("/message/sqs1")
    public ResponseEntity<Void> putMessageOnQueue1() {
        service.putMessageOnQueue("happy", "happy");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/message/sqs2")
    public ResponseEntity<Void> putMessageOnQueue2() {
        service.putMessageOnQueue("fail", "fail");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}