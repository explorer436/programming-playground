package com.example.springjsondemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyService {

    @Value("classpath:IdValuesFile.json")
    private Resource jsonFile;

    public void convert() {
        List<String> valueList = Arrays.asList("first", "second", "third");

        log.info("valueList before conversion: " + valueList.toString());

        Map<String, String> myMap;
        try {
            myMap = (new ObjectMapper()).readValue(jsonFile.getInputStream(), HashMap.class);

            valueList = valueList
                    .stream()
                    .map(a -> myMap.get(a))
                    .collect(Collectors.toList());

            log.info("valueList after conversion: " + valueList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
