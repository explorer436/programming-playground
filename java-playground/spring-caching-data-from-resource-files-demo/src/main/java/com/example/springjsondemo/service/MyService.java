package com.example.springjsondemo.service;

import com.example.springjsondemo.cacheutils.LookupDataProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyService {

    private final LookupDataProvider lookupDataProvider;

    public void convert() {
        List<String> valueList = Arrays.asList("first", "second", "third");

        log.info(">>> valueList before conversion: " + valueList.toString());

        Map<String, String> lookupMap = lookupDataProvider.getLookupData();

        valueList = valueList
                .stream()
                .map(a -> lookupMap.get(a))
                .collect(Collectors.toList());

        log.info(">>> valueList after conversion: " + valueList.toString());
    }
}
