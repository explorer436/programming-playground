package com.my.company.datastructures.linkedlist.singlylinked.sortedIntegerLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedIntegerLinkedListTests {

    @Test
    public void test() {
        SortedIntegerLinkedList list = new SortedIntegerLinkedList();

        list.insertSorted(3);
        assertEquals(list.head.getNumber(), 3);
        assertEquals(list.head.getNext(), null);

        list.insertSorted(6);
        assertEquals(list.head.getNumber(), 3);
        Node nextNode = list.head.getNext();
        assertEquals(nextNode.getNumber(), 6);
        assertEquals(nextNode.getNext(), null);

        list.insertSorted(9);
        assertEquals(list.head.getNumber(), 3);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getNumber(), 6);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getNumber(), 9);
        assertEquals(nextNode.getNext(), null);

        list.insertSorted(7);
        assertEquals(list.head.getNumber(), 3);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getNumber(), 6);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getNumber(), 7);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getNumber(), 9);
        assertEquals(nextNode.getNext(), null);
    }
}
