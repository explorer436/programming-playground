package com.app.sr.builderpattern.controller;

import com.app.sr.builderpattern.model.ApiResponse;
import com.app.sr.builderpattern.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Find all customers
     * @return ApiResponse object
     */
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getEmployees(){
        return customerService.findAll();
    }
}
