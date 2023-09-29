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
                   "id" : 5,
                   "name" : "Jane",
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
                   "id" : 6,
                   "name" : "Gayle",
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
                   "id" : 7,
                   "name" : "Mary",
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
                   "id" : 8,
                   "name" : "Sophie",
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
                   "id" : 1,
                   "name" : "John",
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
                   "id" : 2,
                   "name" : "Rob",
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
                   "id" : 3,
                   "name" : "Clark",
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
                   "id" : 4,
                   "name" : "Trevor",
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
                    "id" : 3,
                    "name" : "Clark",
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
                    "id" : 7,
                    "name" : "Mary",
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
                    "id" : 2,
                    "name" : "Rob",
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
                    "id" : 6,
                    "name" : "Gayle",
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
                    "id" : 1,
                    "name" : "John",
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
                    "id" : 5,
                    "name" : "Jane",
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
                    "id" : 4,
                    "name" : "Trevor",
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
                    "id" : 8,
                    "name" : "Sophie",
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

        assertEquals("""
                {
                  "female" : 30.0,
                  "male" : 30.0
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
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

        assertEquals("[ \"John\", \"Rob\", \"Clark\", \"Trevor\" ]", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_getNamesOfMen_Collect_UsingArrayList() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        List<String> actual = streamCollect.getNamesOfMen_Collect_UsingArrayList(people);

        assertEquals("""
                [ \"John\", \"Rob\", \"Clark\", \"Trevor\" ]""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_groupPersonNamesByGender() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        Map<String, List<String>> actual = streamCollect.groupPersonNamesByGender(people);

        assertEquals("""
                {
                  "female" : [ "Jane", "Gayle", "Mary", "Sophie" ],
                  "male" : [ "John", "Rob", "Clark", "Trevor" ]
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_groupTotalAgeByGender() throws JsonProcessingException {
        List<Person> people = TestsHelper.getPeople();

        Map<String, Integer> actual = streamCollect.groupTotalAgeByGender(people);

        assertEquals("""
                {
                  "female" : 120,
                  "male" : 120
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }
}
