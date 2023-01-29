package com.example.springcloudawssecretsmanager.service;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    @Value("${my-secret-key}")
    private String mySecretValue;

    public ResponseEntity<String> getSecrets() {
        log.info(">>> getSecrets");

        log.info("Printing the value for the secret /secrets/dev/my-secret from secrets-manager: " + mySecretValue);

        log.info("<<< getSecrets");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
