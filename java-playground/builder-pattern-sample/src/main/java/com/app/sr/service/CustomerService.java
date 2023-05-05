package com.app.sr.service;

import com.app.sr.entity.Customer;
import com.app.sr.repository.CustomerRepository;
import com.app.sr.util.model.ApiResponse;
import com.app.sr.util.model.ApiResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;
    private ApiResponseBuilder apiResponseBuilder;

    public CustomerService(CustomerRepository customerRepository, ApiResponseBuilder apiResponseBuilder){
        this.customerRepository = customerRepository;
        this.apiResponseBuilder = apiResponseBuilder;
    }

    public ResponseEntity<ApiResponse> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return apiResponseBuilder.buildResponse(HttpStatus.OK.value(),"Customer details",customers);
    }
}
