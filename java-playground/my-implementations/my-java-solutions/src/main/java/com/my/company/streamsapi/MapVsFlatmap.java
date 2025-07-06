package com.my.company.streamsapi;

import com.my.company.streamsapi.model.Person;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatmap {

    public List<List<String>> getPhoneNumberLists(List<Person> people) {
        return people.stream()
                .map(p -> p.getPhones())
                .filter(phones -> CollectionUtils.isNotEmpty(phones))
                .collect(Collectors.toList());
    }

    public List<String> getAllDistinctPhoneNumbers(List<Person> people) {
        return people.stream()
                .map(p -> p.getPhones())
                .filter(phones -> CollectionUtils.isNotEmpty(phones))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
