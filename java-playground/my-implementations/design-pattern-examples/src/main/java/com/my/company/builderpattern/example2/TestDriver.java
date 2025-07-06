package com.my.company.builderpattern.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class TestDriver {
    
    public static void main(String[] args) {
        ResponseEntity<ApiResponse> def = findAll();
        log.info("def.getBody().getData(): {}", def.getBody().getData());
    }

    public static ResponseEntity<ApiResponse> findAll() {
        // List<Customer> customers = customerRepository.findAll();
        List<Customer> customers = List.of(
                Customer.builder()
                        .id(123L)
                        .firstName("testuser1firstname")
                        .lastName("testuser1lastname")
                        .email("testuser1email")
                        .contactNumber("testuser1contactnumber")
                        .build(),
                Customer.builder()
                        .id(456L)
                        .firstName("testuser2firstname")
                        .lastName("testuser2lastname")
                        .email("testuser2email")
                        .contactNumber("testuser2contactnumber")
                        .build()
        );
        ApiResponseBuilder apiResponseBuilder = new ApiResponseBuilder();
        ResponseEntity<ApiResponse> abc = apiResponseBuilder.buildResponse(HttpStatus.OK.value(), "Customer details", customers);

        return abc;
    }
    
}
