package com.my.company.datastructures.streamsapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamApiTests {

    private StreamAPI streamAPI = new StreamAPI();

    @Test
    public void test_printTheNameOfEachPerson_AggregateOperations() {
        streamAPI.printTheNameOfEachPerson_AggregateOperations(TestsHelper.getPeople());
    }

    @Test
    public void test_printNamesOfMen_Pipelines() {
        streamAPI.printNamesOfMen_Pipelines(TestsHelper.getPeople());
    }

    @Test
    public void test_getAverageAgeOfMen_TerminalOperator() {
        double actual = streamAPI.getAverageAgeOfMen_TerminalOperator(TestsHelper.getPeople());
        assertEquals(30.0, actual);
    }

}
