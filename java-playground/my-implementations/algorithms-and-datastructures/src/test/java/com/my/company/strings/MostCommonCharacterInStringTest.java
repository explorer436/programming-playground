package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostCommonCharacterInStringTest {

    MostCommonCharacterInString mostCommonCharacterInString = new MostCommonCharacterInString();

    @Test
    void test_mostCommonCharacters1() {
        assertAll(
                () -> assertEquals("c", mostCommonCharacterInString.mostCommonCharacters1("aaiicccnn")),
                () -> assertEquals("abcd", mostCommonCharacterInString.mostCommonCharacters1("aabbccdd")),
                () -> assertEquals("2", mostCommonCharacterInString.mostCommonCharacters1("ab2sbf2dj2skl")),
                () -> assertEquals(null, mostCommonCharacterInString.mostCommonCharacters1("")),
                () -> assertEquals(null, mostCommonCharacterInString.mostCommonCharacters1(null))
        );
    }

    @Test
    void test_mostCommonCharacters2() {
        assertAll(
                () -> assertEquals("c", mostCommonCharacterInString.mostCommonCharacters2("aaiicccnn")),
                () -> assertEquals("abcd", mostCommonCharacterInString.mostCommonCharacters2("aabbccdd")),
                () -> assertEquals("2", mostCommonCharacterInString.mostCommonCharacters2("ab2sbf2dj2skl")),
                () -> assertEquals(null, mostCommonCharacterInString.mostCommonCharacters2("")),
                () -> assertEquals(null, mostCommonCharacterInString.mostCommonCharacters2(null))
        );
    }

    @Test
    void test_firstMostCommonCharacter() {
        assertAll(
                () -> assertEquals('c', mostCommonCharacterInString.firstMostCommonCharacter("aaiicccnn")),
                () -> assertEquals('a', mostCommonCharacterInString.firstMostCommonCharacter("aabbccdd")),
                () -> assertEquals('2', mostCommonCharacterInString.firstMostCommonCharacter("ab2sbf2dj2skl")),
                () -> assertEquals(0, mostCommonCharacterInString.firstMostCommonCharacter("")),
                () -> assertEquals(0, mostCommonCharacterInString.firstMostCommonCharacter(null))
        );
    }

}