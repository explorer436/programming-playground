package com.my.company.javatojson;

import com.google.gson.JsonObject;
import com.my.company.model.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaToJsonStrings_Objects_Tests {

    private ObjectMapperJavaToJsonStrings objectMapperJavaToJsonStrings = new ObjectMapperJavaToJsonStrings();
    private GsonJavaToJson gsonJavaToJson = new GsonJavaToJson();

    @Test
    public void test_objectMapper_javaToJson() throws Exception {

        Employee e = getEmployee();

        String actual = objectMapperJavaToJsonStrings.javaToJson(e);
        assertEquals("{\n" +
                "  \"firstname\" : \"a-first-name\",\n" +
                "  \"lastname\" : \"a-last-name\",\n" +
                "  \"joinedDate\" : [ 2016, 6, 24, 13, 39, 44, 687680000 ],\n" +
                "  \"leavingDate\" : 1466771984.000000000\n" +
                "}", actual);
    }

    @Test
    public void test_objectMapper_javaToJson_withSpecificDateFormat_1() throws Exception {

        Employee e = getEmployee();

        String actual = objectMapperJavaToJsonStrings.javaToJson_withSpecificDateFormat(e);
        assertEquals("{\n" +
                "  \"firstname\" : \"a-first-name\",\n" +
                "  \"lastname\" : \"a-last-name\",\n" +
                "  \"joinedDate\" : \"2016-06-24T13:39:44.68768\",\n" +
                "  \"leavingDate\" : \"2016-06-24T13:39:44+01:00\"\n" +
                "}", actual);
    }

    @Test
    public void test_objectMapper_javaToJson_withSpecificDateFormat_2() throws Exception {

        List<Employee> l = new ArrayList<>();
        l.add(getEmployee());

        String actual = objectMapperJavaToJsonStrings.javaToJson_withSpecificDateFormat(l);
        assertEquals("[ {\n" +
                "  \"firstname\" : \"a-first-name\",\n" +
                "  \"lastname\" : \"a-last-name\",\n" +
                "  \"joinedDate\" : \"2016-06-24T13:39:44.68768\",\n" +
                "  \"leavingDate\" : \"2016-06-24T13:39:44+01:00\"\n" +
                "} ]", actual);
    }

    @Test
    public void test_objectMapper_javaToJson_withSpecificDateFormat_3() throws Exception {

        List<Employee> l = new ArrayList<>();
        l.add(getEmployee());

        String actual = objectMapperJavaToJsonStrings.javaToJson_withSpecificDateFormat_withoutPrettyPrint(l);
        assertEquals("[{\"firstname\":\"a-first-name\",\"lastname\":\"a-last-name\",\"joinedDate\":\"2016-06-24T13:39:44.68768\",\"leavingDate\":\"2016-06-24T13:39:44+01:00\"}]", actual);
    }

    @Test
    public void test_gson_javaToJson() throws Exception {

        Employee e = getEmployee();

        String actual = gsonJavaToJson.javaObjectToJsonString(e);
        assertEquals("{\n" +
                "  \"firstname\": \"a-first-name\",\n" +
                "  \"lastname\": \"a-last-name\",\n" +
                "  \"joinedDate\": \"2016-06-24T13:39:44.68768\",\n" +
                "  \"leavingDate\": \"2016-06-24T13:39:44+01:00\"\n" +
                "}", actual);
    }

    @Test
    public void test_gson_mapToJsonObject() {

        JsonObject actual = gsonJavaToJson.mapToJsonObject();

        JsonObject expected = new JsonObject();
        expected.addProperty("John Smith", "521-1234");
        expected.addProperty("Sam Doe", "521-5030");
        expected.addProperty("Sandra Dee", "521-9655");

        assertEquals(expected, actual);
    }

    private static Employee getEmployee() {
        Employee e = new Employee();
        e.setFirstname("a-first-name");
        e.setLastname("a-last-name");

        // LocalDate ld = LocalDate.parse("2018-12-27");
        LocalDateTime ldt = LocalDateTime.parse("2016-06-24T13:39:44.687680", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        e.setJoinedDate(ldt);

        OffsetDateTime odt = OffsetDateTime.parse("2016-06-24T13:39:44+01:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        // e.setLeavingDate(OffsetDateTime.now());
        e.setLeavingDate(odt);
        return e;
    }
}
