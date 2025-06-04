package com.example.using_spring_CommonsRequestLoggingFilter.service;

import com.example.using_spring_CommonsRequestLoggingFilter.model.TaxiRide;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorService {

    public String calculateFare(TaxiRide taxiRide) {
        return String.valueOf((Long) (taxiRide.getIsNightSurcharge()
                ? taxiRide.getDistanceInMile() * 10 + 100
                : taxiRide.getDistanceInMile() * 10));
    }
}