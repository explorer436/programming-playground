package com.example.awssqs.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

    @Bean
    public AmazonSQS amazonSqs() {

        AmazonSQS amazonSqs = AmazonSQSClientBuilder
                .standard()
                .withCredentials(new ProfileCredentialsProvider("default"))
                .build();

        return amazonSqs;
    }
}
