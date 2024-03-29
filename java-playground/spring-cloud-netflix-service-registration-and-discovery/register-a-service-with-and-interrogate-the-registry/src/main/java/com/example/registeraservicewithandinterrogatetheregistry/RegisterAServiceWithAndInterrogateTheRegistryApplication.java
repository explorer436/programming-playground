package com.example.registeraservicewithandinterrogatetheregistry;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class RegisterAServiceWithAndInterrogateTheRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterAServiceWithAndInterrogateTheRegistryApplication.class, args);
	}
}
