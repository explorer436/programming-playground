package com.example.jacksonjsonpoc.objectmapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ObjectMapperReadValueTests {
    @Autowired
    private ObjectMapperReadValue objectMapperReadValue;

    @Test
    public void testUsageCostProcessor() throws Exception {
        String actual = objectMapperReadValue.readValue();
        assertEquals("Black", actual);
    }
}
