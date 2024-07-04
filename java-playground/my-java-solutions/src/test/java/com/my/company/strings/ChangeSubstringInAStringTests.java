package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeSubstringInAStringTests {

    ChangeSubstringInAString changeSubstringInAString = new ChangeSubstringInAString();

    @Test
    public void test_changeSubstringInAString_01() throws Exception {
        String actual = changeSubstringInAString.changeSubstringInAString("(00)", "((((00)0)0)0)", "0");
        assertEquals("(((00)0)0)", actual);
    }

    @Test
    public void test_changeSubstringInAString_02() throws Exception {
        String actual = changeSubstringInAString.changeSubstringInAString("(00)", "(((00)0)0)", "0");
        assertEquals("((00)0)", actual);
    }

    @Test
    public void test_changeSubstringInAString_03() throws Exception {
        String actual = changeSubstringInAString.changeSubstringInAString("(00)","((00)0)", "0");
        assertEquals("(00)", actual);
    }

    @Test
    public void test_changeSubstringInAString_04() throws Exception {
        String actual = changeSubstringInAString.changeSubstringInAString("(00)", "((00)(00))", "0");
        assertEquals("(00)", actual);
    }

}
