package com.my.company.streamsapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoiningTests {

    // private final Joining joining = new Joining();

    private final List<String> strings = Arrays.asList("a", "bb", "ccc", "dd");

    @Test
    public void test_collect_Joining() {
        String actual = Joining.collect_Joining(strings);

        assertEquals("""
                abbcccdd""", actual);
    }

    @Test
    public void test_collect_Joining_CustomSeparators_comma() {
        String actual = Joining.collect_Joining_CustomSeparators(strings, ", ");

        assertEquals("""
                a, bb, ccc, dd""", actual);
    }

    @Test
    public void test_collect_Joining_CustomSeparators_whitespace() {
        String actual = Joining.collect_Joining_CustomSeparators(strings, " ");

        assertEquals("""
                a bb ccc dd""", actual);
    }

    @Test
    public void test_collect_Joining_CustomSeparators_withoutStreams() {
        String actual = Joining.collect_Joining_CustomSeparators_withoutStreams(strings);

        assertEquals("""
                a, bb, ccc, dd""", actual);
    }

    @Test
    public void test_collect_Joining_CustomSeparators_NumberedList() {
        String actual = Joining.collect_Joining_CustomSeparators_NumberedList(strings);

        assertEquals("""
                This list has the following elements - 1. a, 2. bb, 3. ccc, 4. dd""", actual);
    }

    @Test
    public void test_collect_JoiningWithPreAndPost() {
        String actual = Joining.collect_JoiningWithPreAndPost(strings);

        assertEquals("""
                PRE-a, bb, ccc, dd-POST""", actual);
    }

    @Test
    public void test_joinListGrammaticallyWithJava() {
        String actual = Joining.joinListGrammaticallyWithJava(strings);

        assertEquals("""
                a, bb, ccc and dd""", actual);
    }
}
