package com.my.company.streamsapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.company.streamsapi.CollectOperationsOnPrimitiveTypes;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectOperationsOnPrimitiveTypesTests {

    private CollectOperationsOnPrimitiveTypes collectOperationsOnPrimitiveTypes = new CollectOperationsOnPrimitiveTypes();

    private List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    private List<String> strings = Arrays.asList("a", "bb", "ccc", "dd");

    @Test
    public void test_mapAndFilterAndCollectToList() throws JsonProcessingException {
        List<Integer> actual = collectOperationsOnPrimitiveTypes.map_Filter_Collect_ToList(numbers);

        assertEquals("[ 2, 4, 6 ]", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_storeStringLengthGroupingResulsInASet() throws JsonProcessingException {
        Map<Integer, Set<String>> actual = collectOperationsOnPrimitiveTypes.collect_groupingByStringLength(strings);

        assertEquals("""
                {
                  "1" : [ "a" ],
                  "2" : [ "bb", "dd" ],
                  "3" : [ "ccc" ]
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_partitionByStringLength() throws JsonProcessingException {
        Map<Boolean, List<String>> actual = collectOperationsOnPrimitiveTypes.collect_partitioningByStringLength(strings);

        assertEquals("""
                {
                  "false" : [ "a", "bb", "dd" ],
                  "true" : [ "ccc" ]
                }""", (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(actual));
    }

    @Test
    public void test_collectAndSummarize() throws JsonProcessingException {
        DoubleSummaryStatistics actual = collectOperationsOnPrimitiveTypes.collect_SummarizingDouble(strings);

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
