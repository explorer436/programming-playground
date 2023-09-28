package com.my.company.jackson.objectmapper;

import com.my.company.jackson.objectmapper.ObjectMapperJavaToJson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperJavaToJsonTests {

    private ObjectMapperJavaToJson objectMapperJavaToJson = new ObjectMapperJavaToJson();

    @Test
    public void test_javaToJson() throws Exception {
        String actual = objectMapperJavaToJson.javaToJson();
        assertEquals("{\"firstname\":\"a-first-name\",\"lastname\":\"a-last-name\",\"joinedDate\":[2016,6,24,13,39,44,687680000],\"leavingDate\":1466771984.000000000}", actual);
    }

    @Test
    public void test_javaToJson_withSpecificDateFormat() throws Exception {
        String actual = objectMapperJavaToJson.javaToJson_withSpecificDateFormat();
        assertEquals("{\"firstname\":\"a-first-name\",\"lastname\":\"a-last-name\",\"joinedDate\":\"2016-06-24T13:39:44.68768\",\"leavingDate\":\"2016-06-24T13:39:44+01:00\"}", actual);
    }
}
