package com.my.company.javatojson;

import com.my.company.javatojson.GsonJavaToJson;
import com.my.company.javatojson.ObjectMapperJavaToJsonBytes;
import com.my.company.model.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaToJsonBytes_Objects_Tests {

    private ObjectMapperJavaToJsonBytes objectMapperJavaToJsonBytes = new ObjectMapperJavaToJsonBytes();
    private GsonJavaToJson gsonJavaToJson = new GsonJavaToJson();

    @Test
    public void test_objectMapper_javaToJson() throws Exception {

        Employee e = getEmployee();

        byte[] expectedBytes = ("{\"firstname\":\"a-first-name\",\"lastname\":\"a-last-name\",\"joinedDate\":[2016,6,24,13,39,44,687680000],\"leavingDate\":1466771984.000000000}").getBytes();

        byte[] actualBytes = objectMapperJavaToJsonBytes.javaToJson(e);
        assertEquals(new String(expectedBytes), new String(actualBytes));
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
