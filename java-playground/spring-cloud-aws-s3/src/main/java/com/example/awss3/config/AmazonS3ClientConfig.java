package com.example.awss3.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3ClientConfig {

	@Bean
	public AmazonS3 amazonS3Client() {

		AmazonS3 amazonS3Client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new ProfileCredentialsProvider("default"))
				.build();


		return amazonS3Client;
	}

}
