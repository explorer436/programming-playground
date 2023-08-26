package com.example.springaspectorientedprogrammingdemo.initialize;

import com.example.springaspectorientedprogrammingdemo.entities.Employee;
import com.example.springaspectorientedprogrammingdemo.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void load() throws JsonProcessingException {

        Employee employee1 = (new ObjectMapper()).readValue("{\n" +
                "                \"firstName\": \"John\",\n" +
                "                \"lastName\":  \"Mathew\",\n" +
                "                \"emailId\": \"John.Mathew@xyz.com\"\n" +
                "                }", Employee.class);
        Employee employee2 = (new ObjectMapper()).readValue("{\n" +
                "                \"firstName\": \"Jim\",\n" +
                "                \"lastName\":  \"Parker\",\n" +
                "                \"emailId\": \"Jim.Parker@xyz.com\"\n" +
                "                }", Employee.class);
        Employee employee3 = (new ObjectMapper()).readValue("{\n" +
                "                \"firstName\": \"Sophia\",\n" +
                "                \"lastName\":  \"Ran\",\n" +
                "                \"emailId\": \"Sophia.Ran@xyz.com\"\n" +
                "                }", Employee.class);
        Employee employee4 = (new ObjectMapper()).readValue("{\n" +
                "                \"firstName\": \"Wendi\",\n" +
                "                \"lastName\":  \"Blake\",\n" +
                "                \"emailId\": \"Wendi.Blake@xyz.com\"\n" +
                "                }", Employee.class);

        employeeRepository.saveAll(Arrays.asList(employee1,employee2,employee3,employee4));
    }



}
