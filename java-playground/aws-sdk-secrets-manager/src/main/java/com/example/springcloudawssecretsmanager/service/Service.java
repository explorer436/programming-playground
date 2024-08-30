package com.example.springcloudawssecretsmanager.service;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.example.springcloudawssecretsmanager.model.AwsSecret;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final AWSSecretsManager amazonSecretsManager;

    private final Gson gson = new Gson();

    /**
     * This method is not using spring-cloud's approach where it automatically retrieves the value of the secret based on the name of the parameter in the properties file.
     * The parsing of the retrieved value is an extra step with this approach.
     * For automating things and speeding things up, spring-cloud approach may be preferable.
     */
    public ResponseEntity<String> getSecrets() {
        log.info(">>> getSecrets");

        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest();
        getSecretValueRequest.setSecretId("/dev/my-dev-secret");
        GetSecretValueResult getSecretValueResult = amazonSecretsManager.getSecretValue(getSecretValueRequest);
        log.info("Printing the secret from secrets-manager: " + getSecretValueResult);
        log.info("Secret name: " + getSecretValueResult.getName());

        // We would have to parse the json and retrieve the values for key and value
        // Secret string: {"my-secret-key":"my-secret-value"}

        String secretString = getSecretValueResult.getSecretString();
        log.info("Secret string: " + secretString);

        // Create a POJO called AwsSecret with the parameters username and password to hold the values from the string.
	    AwsSecret awsSecret = gson.fromJson(secretString, AwsSecret.class);
        log.info("awsSecret: " + awsSecret);

        log.info("<<< getSecrets");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
