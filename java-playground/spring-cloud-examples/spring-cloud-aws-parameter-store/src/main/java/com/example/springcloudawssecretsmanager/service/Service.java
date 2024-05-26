package com.example.springcloudawssecretsmanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    @Value("${my-custom-paramter}")
    private String myCustomParameter;

    public ResponseEntity<String> getParameters() {
        log.info(">>> getParameters");

        log.info("Printing the parameter value for /config/spring-cloud-aws-parameter-store/my-custom-paramter " +
                "from parameter-store: " + myCustomParameter);

        log.info("<<< getParameters");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
