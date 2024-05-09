package com.example.springjsondemo.cacheutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LookupDataProvider {

    @Value("classpath:IdValuesFile.json")
    private Resource jsonFile;

    @Cacheable("idValues")
    public Map<String, String> getLookupData() {
        Map<String, String> myMap;
        try {
            log.info(">>> Reading data from the resource file");
            myMap = (new ObjectMapper()).readValue(jsonFile.getInputStream(), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return myMap;
    }
}
