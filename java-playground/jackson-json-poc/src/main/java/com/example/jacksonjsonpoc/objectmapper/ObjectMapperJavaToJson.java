package com.example.jacksonjsonpoc.objectmapper;

import com.example.jacksonjsonpoc.objectmapper.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ObjectMapperJavaToJson {
    public String javaToJson() throws JsonProcessingException {
        Employee e = new Employee();
        e.setFirstname("a-first-name");
        e.setLastname("a-last-name");

        // LocalDate ld = LocalDate.parse("2018-12-27");
        LocalDateTime ldt = LocalDateTime.parse("2016-06-24T13:39:44.687680", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        e.setJoinedDate(ldt);

        OffsetDateTime odt = OffsetDateTime.parse("2016-06-24T13:39:44+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        // e.setLeavingDate(OffsetDateTime.now());
        e.setLeavingDate(odt);

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.writeValueAsString(e);
    }

    public String javaToJson_withSpecificDateFormat() throws JsonProcessingException {
        Employee e = new Employee();
        e.setFirstname("a-first-name");
        e.setLastname("a-last-name");

        // LocalDate ld = LocalDate.parse("2018-12-27");
        LocalDateTime ldt = LocalDateTime.parse("2016-06-24T13:39:44.687680", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        e.setJoinedDate(ldt);

        OffsetDateTime odt = OffsetDateTime.parse("2016-06-24T13:39:44+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        // e.setLeavingDate(OffsetDateTime.now());
        e.setLeavingDate(odt);

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);

        return objectMapper.writeValueAsString(e);
    }
}
