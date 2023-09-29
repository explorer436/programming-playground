package com.my.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.collections.Person;
import com.my.company.collections.StreamCollect;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamCollectTests {

    private StreamCollect streamCollect = new StreamCollect();

    @Test
    public void test_groupPeopleByGender() throws JsonProcessingException {

        List<Person> people = TestsHelper.getPeople();

        Map<String, List<Person>> actual = streamCollect.groupPeopleByGender(people);

        assertEquals("""
               {
                 "female" : [ {
                   "name" : "5Jane",
                   "age" : 15,
                   "gender" : "female",
                   "addressLine1" : "123 JohnJane Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 JohnJane Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 }, {
                   "name" : "6Gayle",
                   "age" : 25,
                   "gender" : "female",
                   "addressLine1" : "123 RobGayle Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 RobGayle Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 }, {
                   "name" : "7Mary",
                   "age" : 35,
                   "gender" : "female",
                   "addressLine1" : "123 ClarkMary Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 ClarkMary Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 }, {
                   "name" : "8Sophie",
                   "age" : 45,
                   "gender" : "female",
                   "addressLine1" : "123 TrevorSophie Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 TrevorSophie Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 } ],
                 "male" : [ {
                   "name" : "1John",
                   "age" : 15,
                   "gender" : "male",
                   "addressLine1" : "123 JohnJane Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 JohnJane Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 }, {
                   "name" : "2Rob",
                   "age" : 25,
                   "gender" : "male",
                   "addressLine1" : "123 RobGayle Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 RobGayle Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 }, {
                   "name" : "3Clark",
                   "age" : 35,
                   "gender" : "male",
                   "addressLine1" : "123 ClarkMary Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 ClarkMary Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 }, {
                   "name" : "4Trevor",
                   "age" : 45,
                   "gender" : "male",
                   "addressLine1" : "123 TrevorSophie Ln",
                   "addressLine2" : null,
                   "city" : "Dover",
                   "state" : "NH",
                   "zip" : "03820",
                   "address" : {
                     "addressLine1" : "123 TrevorSophie Ln",
                     "addressLine2" : null,
                     "city" : "Dover",
                     "state" : "NH",
                     "zip" : "03820"
                   }
                 } ]
               }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));

    }

    @Test
    public void test_groupPeopleByAddress() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        Map<Person.Address, List<Person>> actual = streamCollect.groupPeopleByAddress(people);

        assertEquals("""
                {
                  "Address[addressLine1=123 ClarkMary Ln, addressLine2=null, city=Dover, state=NH, zip=03820]" : [ {
                    "name" : "3Clark",
                    "age" : 35,
                    "gender" : "male",
                    "addressLine1" : "123 ClarkMary Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 ClarkMary Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  }, {
                    "name" : "7Mary",
                    "age" : 35,
                    "gender" : "female",
                    "addressLine1" : "123 ClarkMary Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 ClarkMary Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  } ],
                  "Address[addressLine1=123 RobGayle Ln, addressLine2=null, city=Dover, state=NH, zip=03820]" : [ {
                    "name" : "2Rob",
                    "age" : 25,
                    "gender" : "male",
                    "addressLine1" : "123 RobGayle Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 RobGayle Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  }, {
                    "name" : "6Gayle",
                    "age" : 25,
                    "gender" : "female",
                    "addressLine1" : "123 RobGayle Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 RobGayle Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  } ],
                  "Address[addressLine1=123 JohnJane Ln, addressLine2=null, city=Dover, state=NH, zip=03820]" : [ {
                    "name" : "1John",
                    "age" : 15,
                    "gender" : "male",
                    "addressLine1" : "123 JohnJane Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 JohnJane Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  }, {
                    "name" : "5Jane",
                    "age" : 15,
                    "gender" : "female",
                    "addressLine1" : "123 JohnJane Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 JohnJane Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  } ],
                  "Address[addressLine1=123 TrevorSophie Ln, addressLine2=null, city=Dover, state=NH, zip=03820]" : [ {
                    "name" : "4Trevor",
                    "age" : 45,
                    "gender" : "male",
                    "addressLine1" : "123 TrevorSophie Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 TrevorSophie Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  }, {
                    "name" : "8Sophie",
                    "age" : 45,
                    "gender" : "female",
                    "addressLine1" : "123 TrevorSophie Ln",
                    "addressLine2" : null,
                    "city" : "Dover",
                    "state" : "NH",
                    "zip" : "03820",
                    "address" : {
                      "addressLine1" : "123 TrevorSophie Ln",
                      "addressLine2" : null,
                      "city" : "Dover",
                      "state" : "NH",
                      "zip" : "03820"
                    }
                  } ]
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_getAverageAgeByGender() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        Map<String, Double> actual = streamCollect.getAverageAgeByGender(people);

        assertEquals("{\n" +
                "  \"female\" : 30.0,\n" +
                "  \"male\" : 30.0\n" +
                "}", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_getAverageAgeOfMen_Collect() {
        List<Person> people = TestsHelper.getPeople();

        double actual = streamCollect.getAverageAgeOfMen_Collect(people);

        assertEquals(30.0, actual);
    }

    @Test
    public void test_getNamesOfMen_Collect_UsingStandardCollector() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        List<String> actual = streamCollect.getNamesOfMen_Collect_UsingStandardCollector(people);

        assertEquals("[ \"1John\", \"2Rob\", \"3Clark\", \"4Trevor\" ]", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_getNamesOfMen_Collect_UsingArrayList() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        List<String> actual = streamCollect.getNamesOfMen_Collect_UsingArrayList(people);

        assertEquals("""
                [ \"1John\", \"2Rob\", \"3Clark\", \"4Trevor\" ]""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_groupPersonNamesByGender() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        Map<String, List<String>> actual = streamCollect.groupPersonNamesByGender(people);

        assertEquals("""
                {
                  "female" : [ "5Jane", "6Gayle", "7Mary", "8Sophie" ],
                  "male" : [ "1John", "2Rob", "3Clark", "4Trevor" ]
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_groupTotalAgeByGender() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        Map<String, Integer> actual = streamCollect.groupTotalAgeByGender(people);

        assertEquals("{\n" +
                "  \"female\" : 120,\n" +
                "  \"male\" : 120\n" +
                "}", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }
}
