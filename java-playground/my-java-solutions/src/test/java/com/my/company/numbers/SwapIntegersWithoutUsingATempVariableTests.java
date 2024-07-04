package com.my.company.numbers;

import com.my.company.strings.ChangeSubstringInAString;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapIntegersWithoutUsingATempVariableTests {

    SwapIntegersWithoutUsingATempVariable swapIntegersWithoutUsingATempVariable = new SwapIntegersWithoutUsingATempVariable();

    @Test
    public void test_swapUsingBitwiseManipulation_01() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingBitwiseManipulation(new ImmutablePair(10, 20));
        assertEquals(new ImmutablePair(20, 10), actual);
    }

    @Test
    public void test_swapUsingBitwiseManipulation_02() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingBitwiseManipulation(new ImmutablePair(-1, -2));
        assertEquals(new ImmutablePair(-2, -1), actual);
    }

    @Test
    public void test_swapUsingBitwiseManipulation_03() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingBitwiseManipulation(new ImmutablePair(Integer.MAX_VALUE, 10));
        assertEquals(new ImmutablePair(10, Integer.MAX_VALUE), actual);
    }

    @Test
    public void test_swapUsingBitwiseManipulation_04() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingBitwiseManipulation(new ImmutablePair(Integer.MAX_VALUE, -2));
        assertEquals(new ImmutablePair(-2, Integer.MAX_VALUE), actual);
    }

    @Test
    public void test_swapUsingBitwiseManipulation_05() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingBitwiseManipulation(new ImmutablePair(Integer.MIN_VALUE, Integer.MAX_VALUE - 2));
        assertEquals(new ImmutablePair(Integer.MAX_VALUE - 2, Integer.MIN_VALUE), actual);
    }

    // ---------------

    @Test
    public void test_swapUsingAdditionAndSubtraction_01() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingAdditionAndSubtraction(new ImmutablePair(10, 20));
        assertEquals(new ImmutablePair(20, 10), actual);
    }

    @Test
    public void test_swapUsingAdditionAndSubtraction_02() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingAdditionAndSubtraction(new ImmutablePair(-1, -2));
        assertEquals(new ImmutablePair(-2, -1), actual);
    }

    @Test
    public void test_swapUsingAdditionAndSubtraction_03() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingAdditionAndSubtraction(new ImmutablePair(Integer.MAX_VALUE, 10));
        assertEquals(new ImmutablePair(10, Integer.MAX_VALUE), actual);
    }

    @Test
    public void test_swapUsingAdditionAndSubtraction_04() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingAdditionAndSubtraction(new ImmutablePair(Integer.MAX_VALUE, -2));
        assertEquals(new ImmutablePair(-2, Integer.MAX_VALUE), actual);
    }

    @Test
    public void test_swapUsingAdditionAndSubtraction_05() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingAdditionAndSubtraction(new ImmutablePair(Integer.MIN_VALUE, Integer.MAX_VALUE - 2));
        assertEquals(new ImmutablePair(Integer.MAX_VALUE - 2, Integer.MIN_VALUE), actual);
    }

    @Test
    public void test_swapUsingAdditionAndSubtraction_06() throws Exception {
        ImmutablePair actual = swapIntegersWithoutUsingATempVariable.swapUsingAdditionAndSubtraction(new ImmutablePair(Integer.MAX_VALUE, Integer.MAX_VALUE - 2));
        assertEquals(new ImmutablePair(Integer.MAX_VALUE - 2, Integer.MAX_VALUE), actual);
    }

}
