package com.my.company.jsontojava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.jsontojava.ObjectMapperReadValue;
import com.my.company.model.ColorData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperReadValueTests {

    private ObjectMapperReadValue objectMapperReadValue = new ObjectMapperReadValue();

    @Test
    public void test_readOneField() throws Exception {
        String actual = objectMapperReadValue.readOneField();
        assertEquals("Black", actual);
    }

    @Test
    public void readEntireObject() throws Exception {
        ColorData actual = objectMapperReadValue.readEntireObject();
        assertEquals("{\"color\":\"Black\"}", (new ObjectMapper()).writeValueAsString(actual));
    }
}
