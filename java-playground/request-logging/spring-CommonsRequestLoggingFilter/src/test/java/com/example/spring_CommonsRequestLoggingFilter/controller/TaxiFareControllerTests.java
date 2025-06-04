package com.example.spring_CommonsRequestLoggingFilter.controller;

import com.example.spring_CommonsRequestLoggingFilter.SpringCommonsRequestLoggingFilterApplication;
import com.example.spring_CommonsRequestLoggingFilter.model.TaxiRide;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiFareControllerTests.class);

    @Test
    public void givenRequest_whenFetchTaxiFareRateCard_thanOK() throws JsonProcessingException {

        String URL = "http://localhost:" + port + "/taxifare";

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        TaxiRide taxiRide = new TaxiRide(true, 10l);

        LOGGER.info("taxiRide: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(taxiRide));

        String fare = testRestTemplate.postForObject(
                URL + "/calculate/",
                taxiRide, String.class);

        assertEquals("200", fare);
    }

}
