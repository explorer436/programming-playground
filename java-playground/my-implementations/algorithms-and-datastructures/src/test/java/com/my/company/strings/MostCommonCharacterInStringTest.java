package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostCommonCharacterInStringTest {

    MostCommonCharacterInString mostCommonCharacterInString = new MostCommonCharacterInString();

    @Test
    void test_mostCommonCharacters1() {
        assertEquals("c", mostCommonCharacterInString.mostCommonCharacters1("aaiicccnn"));
    }

    /*public static void main(String[] args) {
        mostCommonCharacterInString.solution_printAllAnswers("aaiicccnn");
        solution_printAllAnswers("aabbccdd");
        solution_printAllAnswers("ab2sbf2dj2skl");
        solution_printAllAnswers("");
        solution_printAllAnswers(null);

        System.out.println();

        solution_printFirstAnswer("aaiicccnn");
        solution_printFirstAnswer("aabbccdd");
        solution_printFirstAnswer("ab2sbf2dj2skl");
        solution_printFirstAnswer("");
        solution_printFirstAnswer(null);
    }*/

}