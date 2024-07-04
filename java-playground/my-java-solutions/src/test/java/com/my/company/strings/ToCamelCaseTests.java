package com.my.company.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToCamelCaseTests {

    ToCamelCase toCamelCase = new ToCamelCase();

    @Test
    public void test_toCamelCase_01() throws Exception {
        String actual = toCamelCase.toCamelCase("the-stealth-warrior");
        assertEquals("theStealthWarrior", actual);
    }

    @Test
    public void test_toCamelCase_02() throws Exception {
        String actual = toCamelCase.toCamelCase("The_Stealth_Warrior");
        assertEquals("TheStealthWarrior", actual);
    }

    @Test
    public void test_toCamelCase_03() throws Exception {
        String actual = toCamelCase.toCamelCase("The-Stealth_Warrior");
        assertEquals("TheStealthWarrior", actual);
    }

    @Test
    public void test_toCamelCase_04() throws Exception {
        String actual = toCamelCase.toCamelCase("theStealthWarrior");
        assertEquals("theStealthWarrior", actual);
    }

    @Test
    public void test_toCamelCase_05() throws Exception {
        String actual = toCamelCase.toCamelCase("the Stealth Warrior");
        assertEquals("theStealthWarrior", actual);
    }

}
