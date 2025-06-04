package com.example.using_spring_CommonsRequestLoggingFilter.controller;

import com.example.using_spring_CommonsRequestLoggingFilter.model.RateCard;
import com.example.using_spring_CommonsRequestLoggingFilter.model.TaxiRide;
import com.example.using_spring_CommonsRequestLoggingFilter.service.TaxiFareCalculatorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiFareController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiFareController.class);

    private final TaxiFareCalculatorService taxiFareCalculatorService;

    public TaxiFareController(TaxiFareCalculatorService taxiFareCalculatorService) {
        this.taxiFareCalculatorService = taxiFareCalculatorService;
    }

    @GetMapping("/taxifare/get/")
    public RateCard getTaxiFare() {
        return new RateCard();
    }

    @PostMapping("/taxifare/calculate/")
    public String calculateTaxiFare(
            @RequestBody @Valid TaxiRide taxiRide) {

        LOGGER.debug("calculateTaxiFare() - START");
        String totalFare = taxiFareCalculatorService.calculateFare(taxiRide);
        LOGGER.debug("calculateTaxiFare() - Total Fare : {}",totalFare);
        LOGGER.debug("calculateTaxiFare() - END");
        return totalFare;
    }
}