package com.my.company.datastructures.streamsapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.datastructures.streamsapi.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapVsFlatmapTests {

    private MapVsFlatmap mapVsFlatmap = new MapVsFlatmap();

    @Test
    public void test_getAllPhoneNumbers() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        List<List<String>> phoneNumbers = mapVsFlatmap.getPhoneNumberLists(people);

        assertEquals("[ [ \"555-1123\", \"555-3389\" ], [ \"555-2243\", \"555-5264\" ], [ \"555-6654\", \"555-3242\" ] ]",
                (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(phoneNumbers));
    }

    @Test
    public void test_getAllDistinctPhoneNumbers() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        List<String> phoneNumbers = mapVsFlatmap.getAllDistinctPhoneNumbers(people);

        assertEquals("[ \"555-1123\", \"555-3389\", \"555-2243\", \"555-5264\", \"555-6654\", \"555-3242\" ]",
                (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(phoneNumbers));
    }

    
}
