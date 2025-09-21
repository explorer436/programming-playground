package com.my.company.datastructures.linkedlist.singlylinked.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortForALinkedListTests {

    @Test
    public void test() {
        InsertionSortForALinkedList list = new InsertionSortForALinkedList();

        list.insertSorted(3);
        assertEquals(list.head.getValue(), 3);
        assertEquals(list.head.getNext(), null);

        list.insertSorted(6);
        assertEquals(list.head.getValue(), 3);
        Node nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 6);
        assertEquals(nextNode.getNext(), null);

        list.insertSorted(9);
        assertEquals(list.head.getValue(), 3);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 6);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 9);
        assertEquals(nextNode.getNext(), null);

        list.insertSorted(7);
        assertEquals(list.head.getValue(), 3);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 6);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 7);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 9);
        assertEquals(nextNode.getNext(), null);

        list.printList();
    }
}
