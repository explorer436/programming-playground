package com.my.company.javatojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.my.company.model.Employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ObjectMapperJavaToJsonStrings {

    public String javaToJson(List<String> l) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(l);
    }

    public String javaToJson(Employee e) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());

        // No serializer found for class org.opensearch.client.opensearch.core.IndexRequest and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(e);
    }

    public String javaToJson_withSpecificDateFormat(Employee e) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(e);
    }

    public String javaToJson_withSpecificDateFormat(List<Employee> list) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
    }

    public String javaToJson_withSpecificDateFormat_withoutPrettyPrint(List<Employee> list) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.example.jacksonjsonpoc.objectmapper.model.Employee["joinedDate"])

        objectMapper.registerModule(new JavaTimeModule());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);

        return objectMapper.writeValueAsString(list);
    }
}
