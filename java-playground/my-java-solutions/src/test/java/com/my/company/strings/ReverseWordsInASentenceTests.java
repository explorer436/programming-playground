package com.my.company.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInASentenceTests {

    ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();

    @Test
    public void test_reverseWordsInASentence_01() throws Exception {
        String actual = reverseWordsInASentence.reverseWordsInASentence("This is a test.");
        assertEquals("test. a is This", actual);
    }

}
