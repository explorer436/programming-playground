package com.example.assignment.rewards.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenapiGeneratorMavenPluginClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenapiGeneratorMavenPluginClientApplication.class, args);
	}

	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			IpAddress ipAddress = restTemplate.getForObject(
					"http://ip.jsontest.com/", IpAddress.class);
			log.info(ipAddress.getIp());
		};
	}*/

}
