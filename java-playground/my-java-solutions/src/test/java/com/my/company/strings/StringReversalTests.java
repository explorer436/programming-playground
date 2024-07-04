package com.my.company.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReversalTests {

    StringReversal stringReversal = new StringReversal();

    @Test
    public void test_reverseStringUsingRecursion_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingRecursion("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingRecursion("damage"));
        assertEquals("", stringReversal.reverseStringUsingRecursion(""));
        assertEquals(null, stringReversal.reverseStringUsingRecursion(null));
    }

    @Test
    public void test_reverseStringUsingWhileLoop_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingWhileLoop("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingWhileLoop("damage"));
        assertEquals("", stringReversal.reverseStringUsingWhileLoop(""));
        assertEquals(null, stringReversal.reverseStringUsingWhileLoop(null));
    }

    @Test
    public void test_reverseStringUsingForLoop_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingForLoop("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingForLoop("damage"));
        assertEquals("", stringReversal.reverseStringUsingForLoop(""));
        assertEquals(null, stringReversal.reverseStringUsingForLoop(null));
    }

    @Test
    public void test_reverseStringUsingByteArray_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingByteArray("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingByteArray("damage"));
        assertEquals("", stringReversal.reverseStringUsingByteArray(""));
        assertEquals(null, stringReversal.reverseStringUsingByteArray(null));
    }

    @Test
    public void test_reverseStringUsingStringBuilder_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingStringBuilder("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingStringBuilder("damage"));
        assertEquals("", stringReversal.reverseStringUsingStringBuilder(""));
        assertEquals(null, stringReversal.reverseStringUsingStringBuilder(null));
    }

    @Test
    public void test_reverseStringUsingCharArray1_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingCharArray1("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingCharArray1("damage"));
        assertEquals("", stringReversal.reverseStringUsingCharArray1(""));
        assertEquals(null, stringReversal.reverseStringUsingCharArray1(null));
    }

    @Test
    public void test_reverseStringUsingCharArray2_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingCharArray2("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingCharArray2("damage"));
        assertEquals("", stringReversal.reverseStringUsingCharArray2(""));
        assertEquals(null, stringReversal.reverseStringUsingCharArray2(null));
    }

    @Test
    public void test_reverseStringUsingCollections_01() throws Exception {
        assertEquals("tac", stringReversal.reverseStringUsingCollections("cat"));
        assertEquals("egamad", stringReversal.reverseStringUsingCollections("damage"));
        assertEquals("", stringReversal.reverseStringUsingCollections(""));
        assertEquals(null, stringReversal.reverseStringUsingCollections(null));
    }

}
