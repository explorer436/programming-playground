package com.my.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.collections.CollectExamples;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectExamplesTests {

    private CollectExamples collectExamples = new CollectExamples();

    private List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    private List<String> strings = Arrays.asList("a", "bb", "ccc", "dd");

    @Test
    public void test_mapAndFilterAndCollectToList() throws JsonProcessingException {
        List<Integer> actual = collectExamples.mapAndFilterAndCollectToList(numbers);

        assertEquals("[ 2, 4, 6 ]", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_storeStringLengthGroupingResulsInASet() throws JsonProcessingException {
        Map<Integer, Set<String>> actual = collectExamples.storeStringLengthGroupingResulsInASet(strings);

        assertEquals("{\n" +
                "  \"1\" : [ \"a\" ],\n" +
                "  \"2\" : [ \"bb\", \"dd\" ],\n" +
                "  \"3\" : [ \"ccc\" ]\n" +
                "}", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_partitionByStringLength() throws JsonProcessingException {
        Map<Boolean, List<String>> actual = collectExamples.partitionByStringLength(strings);

        assertEquals("{\n" +
                "  \"false\" : [ \"a\", \"bb\", \"dd\" ],\n" +
                "  \"true\" : [ \"ccc\" ]\n" +
                "}", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_collectAndSummarize() throws JsonProcessingException {
        DoubleSummaryStatistics actual = collectExamples.collectAndSummarize(strings);

        assertEquals("""
                {
                  "count" : 4,
                  "sum" : 8.0,
                  "min" : 1.0,
                  "max" : 3.0,
                  "average" : 2.0
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }


}
