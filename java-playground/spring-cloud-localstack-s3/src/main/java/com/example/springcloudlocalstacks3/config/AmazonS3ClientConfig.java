package com.example.springcloudlocalstacks3.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3ClientConfig {

	@Bean
	public AmazonS3 amazonS3Client() {

		// Where is this endpoint and region coming from?
		// From localstack documentation
		// You can check the port number by using this command: docker container ls

		AmazonS3 amazonS3Client = AmazonS3ClientBuilder
				.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566/","us-east-1"))
				.build();

		return amazonS3Client;
	}

}
