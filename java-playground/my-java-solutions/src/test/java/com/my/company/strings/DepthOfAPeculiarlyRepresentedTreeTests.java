package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthOfAPeculiarlyRepresentedTreeTests {

    DepthOfAPeculiarlyRepresentedTree depthOfAPeculiarlyRepresentedTree = new DepthOfAPeculiarlyRepresentedTree();

    @Test
    public void test_depthOfAPeculiarlyRepresentedTree_01() throws Exception {
        int actual = depthOfAPeculiarlyRepresentedTree.depthOfAPeculiarlyRepresentedTree("(00)", "", "0");
        assertEquals(-1, actual);
    }

    @Test
    public void test_depthOfAPeculiarlyRepresentedTree_02() throws Exception {
        int actual = depthOfAPeculiarlyRepresentedTree.depthOfAPeculiarlyRepresentedTree("(00)", "(00)", "0");
        assertEquals(0, actual);
    }

    @Test
    public void test_depthOfAPeculiarlyRepresentedTree_03() throws Exception {
        int actual = depthOfAPeculiarlyRepresentedTree.depthOfAPeculiarlyRepresentedTree("(00)", "((00)(00))", "0");
        assertEquals(1, actual);
    }

    @Test
    public void test_depthOfAPeculiarlyRepresentedTree_04() throws Exception {
        int actual = depthOfAPeculiarlyRepresentedTree.depthOfAPeculiarlyRepresentedTree("(00)", "((((00)0)0)0)", "0");
        assertEquals(3, actual);
    }
}
