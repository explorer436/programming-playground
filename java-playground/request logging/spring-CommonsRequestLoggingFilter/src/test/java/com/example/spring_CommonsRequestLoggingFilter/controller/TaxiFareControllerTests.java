package com.example.spring_CommonsRequestLoggingFilter.controller;

import com.example.spring_CommonsRequestLoggingFilter.SpringCommonsRequestLoggingFilterApplication;
import com.example.spring_CommonsRequestLoggingFilter.model.TaxiRide;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringCommonsRequestLoggingFilterApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaxiFareControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void givenRequest_whenFetchTaxiFareRateCard_thanOK() {

        String URL = "http://localhost:" + port + "/taxifare";

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        TaxiRide taxiRide = new TaxiRide(true, 10l);
        String fare = testRestTemplate.postForObject(
                URL + "/calculate/",
                taxiRide, String.class);

        assertEquals("200", fare);
    }

}
