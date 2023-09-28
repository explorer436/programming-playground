package com.my.company.jackson.objectmapper;

import com.my.company.jackson.objectmapper.ObjectMapperReadValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperReadValueTests {

    private ObjectMapperReadValue objectMapperReadValue = new ObjectMapperReadValue();

    @Test
    public void testUsageCostProcessor() throws Exception {
        String actual = objectMapperReadValue.readValue();
        assertEquals("Black", actual);
    }
}
