package com.my.company.streamsapi;

import com.my.company.streamsapi.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PipelineOperations {

    public static void main(String[] args) {
        printNamesOfMen_Pipelines(TestsHelper.getPeople());
    }

    public static void printNamesOfMen_Pipelines(List<Person> people) {
        people.stream()
                .filter(e -> e.getGender().equals("male"))
                .forEach(e -> log.info(e.getFirstname()));
    }

}
