package com.example.springcloudawssecretsmanager.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AWSSecretsManager amazonSecretsManager() {

        AWSSecretsManager amazonSecretsManager = AWSSecretsManagerClientBuilder
                .standard()
                .withCredentials(new ProfileCredentialsProvider("default"))
                .build();

        return amazonSecretsManager;
    }
}
