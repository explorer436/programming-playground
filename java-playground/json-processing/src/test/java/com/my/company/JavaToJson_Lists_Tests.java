package com.my.company;

import com.my.company.javatojson.GsonJavaToJson;
import com.my.company.javatojson.ObjectMapperJavaToJson;
import com.my.company.model.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaToJson_Lists_Tests {

    private ObjectMapperJavaToJson objectMapperJavaToJson = new ObjectMapperJavaToJson();
    private GsonJavaToJson gsonJavaToJson = new GsonJavaToJson();

    @Test
    public void test_objectMapper_javaToJson() throws Exception {

        List<String> l = getList();

        String actual = objectMapperJavaToJson.javaToJson(l);
        assertEquals("[ \"first\", \"second\" ]", actual);
    }

    @Test
    public void test_gson_javaToJson() throws Exception {

        List<String> l = getList();

        String actual = gsonJavaToJson.javaToJson(l);
        assertEquals("[\n" +
                "  \"first\",\n" +
                "  \"second\"\n" +
                "]", actual);
    }

    private static List<String> getList() {
        List<String> l = new ArrayList<>();
        l.add("first");
        l.add("second");
        return l;
    }
}
