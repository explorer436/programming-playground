package com.app.sr.builderpattern.service;

import com.app.sr.builderpattern.entity.Customer;
import com.app.sr.builderpattern.model.ApiResponse;
import com.app.sr.builderpattern.model.ApiResponseBuilder;
import com.app.sr.builderpattern.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ApiResponseBuilder apiResponseBuilder;

    public ResponseEntity<ApiResponse> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return apiResponseBuilder.buildResponse(HttpStatus.OK.value(),"Customer details",customers);
    }
}
