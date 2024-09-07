package com.example.awss3.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.transfer.s3.S3TransferManager;

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

	@Bean
	public S3TransferManager amazonS3TransferManager() {
		S3AsyncClient s3AsyncClient = S3AsyncClient.crtBuilder()
				.crossRegionAccessEnabled(true)
				.build();

		S3TransferManager transferManager = S3TransferManager.builder()
				.s3Client(s3AsyncClient)
				.build();

		return transferManager;
	}

}
