package com.example.jacksonjsonpoc.objectmapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ObjectMapperJavaToJsonTests {
    @Autowired
    private ObjectMapperJavaToJson objectMapperJavaToJson;

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
