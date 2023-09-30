package com.example.springresttemplate;

import com.example.springresttemplate.model.IpAddress;
import com.example.springresttemplate.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class SpringRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestTemplateApplication.class, args);
    }

    // A RestTemplate, which uses the Jackson JSON processing library to process the incoming data.
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // A CommandLineRunner that runs the RestTemplate (and, consequently, fetches our quotation) on startup.

	// Visit https://www.jsontest.com/ for more details.
	// http://ip.jsontest.com/ will return your IP address in JSON form. Example: {"ip": "8.8.8.8"}

    /**
     * If you request that URL through a web browser or curl, you receive a JSON document that looks something like this:
     * <p>
     * {
     * type: "success",
     * value: {
     * id: 10,
     * quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
     * }
     * }
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
			IpAddress ipAddress = restTemplate.getForObject(
                    "http://ip.jsontest.com/", IpAddress.class);
            log.info(ipAddress.getIp());
        };
    }
    // When I start the application using "mvn spring-boot:run",
    // I should see the log statement
    // (that represents the string representation of the object that is fetched from the given endpoint url)
    // in the console at application start-up.
}
