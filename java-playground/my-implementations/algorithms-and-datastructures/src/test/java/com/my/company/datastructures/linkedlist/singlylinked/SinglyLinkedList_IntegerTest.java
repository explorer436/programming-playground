package com.my.company.datastructures.linkedlist.singlylinked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedList_IntegerTest {

    private SinglyLinkedList_Integer list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList_Integer(null);
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.append(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void prepend() {
        list.prepend(1);
        assertEquals(1, list.getHead().getValue());
        assertEquals(1, list.getSize());

        list.prepend(2);
        assertEquals(2, list.getHead().getValue());
        assertEquals(1, list.getHead().getNext().getValue());
        assertEquals(2, list.getSize());
    }

    @Test
    void append() {
        list.append(1);
        assertEquals(1, list.getHead().getValue());
        assertEquals(1, list.getSize());

        list.append(2);
        assertEquals(1, list.getHead().getValue());
        assertEquals(2, list.getHead().getNext().getValue());
        assertEquals(2, list.getSize());
    }

    @Test
    void addInMiddle() {
        list.append(1);
        list.append(3);
        list.addInMiddle(2);
        assertArrayEquals(new int[]{1, 2, 3}, list.traverseForward(list.getHead()));

        list = new SinglyLinkedList_Integer(1);
        list.append(2);
        list.append(4);
        list.append(5);
        list.addInMiddle(3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, list.traverseForward(list.getHead()));
    }

    @Test
    void insertNodeAtIndex() {
        list.insertNodeAtIndex(0, 1);
        // As the list is empty, this should do nothing.
        assertArrayEquals(new int[]{}, list.traverseForward(list.getHead()));

        list.append(1);
        list.append(3);
        list.insertNodeAtIndex(1, 2);
        assertArrayEquals(new int[]{1, 2, 3}, list.traverseForward(list.getHead()));
    }

    @Test
    void traverseForward() {
        assertArrayEquals(new int[]{}, list.traverseForward(list.getHead()));
        list.append(1);
        list.append(2);
        list.append(3);
        assertArrayEquals(new int[]{1, 2, 3}, list.traverseForward(list.getHead()));
    }

    @Test
    void removeFromFront() {
        list.removeFromFront();
        assertTrue(list.isEmpty());

        list.append(1);
        list.append(2);
        list.removeFromFront();
        assertArrayEquals(new int[]{2}, list.traverseForward(list.getHead()));
        assertEquals(1, list.getSize());
    }

    @Test
    void removeFromLast() {
        list.removeFromLast();
        assertTrue(list.isEmpty());

        list.append(1);
        list.removeFromLast();
        assertTrue(list.isEmpty());

        list.append(1);
        list.append(2);
        list.append(3);
        list.removeFromLast();
        assertArrayEquals(new int[]{1, 2}, list.traverseForward(list.getHead()));
        assertEquals(2, list.getSize());
    }

    @Test
    void removeNodeAtIndex() {
        list.removeNodeAtIndex(list.getHead(), 0);
        assertTrue(list.isEmpty());

        list.append(1);
        list.append(2);
        list.append(3);
        Node_Integer newHead = list.removeNodeAtIndex(list.getHead(), 1);
        assertArrayEquals(new int[]{1, 3}, list.traverseForward(list.getHead()));
        assertEquals(2, list.getSize());
    }

    @Test
    void getSize() {
        assertEquals(0, list.getSize());
        list.append(1);
        assertEquals(1, list.getSize());
        list.append(2);
        assertEquals(2, list.getSize());
        list.removeFromFront();
        assertEquals(1, list.getSize());
    }

    @Test
    void getValueAtIndex() {
        assertEquals(0, list.getValueAtIndex(0));
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(2, list.getValueAtIndex(2));
        assertEquals(0, list.getValueAtIndex(5));
    }

    @Test
    void setValueAtIndex() {
        list.setValueAtIndex(0, 1);
        assertTrue(list.isEmpty());

        list.append(1);
        list.append(2);
        list.append(3);
        list.setValueAtIndex(1, 5);
        assertArrayEquals(new int[]{1, 5, 3}, list.traverseForward(list.getHead()));
    }

    @Test
    void reverse_iterative() {
        list.append(1);
        list.append(2);
        list.append(3);
        Node_Integer newHead = list.reverse_iterative(list.getHead());
        list.head = newHead;
        assertArrayEquals(new int[]{3, 2, 1}, list.traverseForward(list.getHead()));
    }

    @Test
    void reverse_recursive() {
        list.append(1);
        list.append(2);
        list.append(3);
        Node_Integer newHead = list.reverse_recursive(list.getHead());
        list.head = newHead;
        assertArrayEquals(new int[]{3, 2, 1}, list.traverseForward(list.getHead()));
    }

    @Test
    void removeElementsWithMatchingValue() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(2);
        Node_Integer newHead = list.removeElementsWithMatchingValue(list.getHead(), 2);
        list.head = newHead;
        assertArrayEquals(new int[]{1, 3}, list.traverseForward(list.head));
    }

    @Test
    void deleteDuplicatesFromASortedList1() {
        list.append(1);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        Node_Integer newHead = list.deleteDuplicatesFromASortedList(list.getHead());
        list.head = newHead;
        assertArrayEquals(new int[]{1, 2, 3}, list.traverseForward(list.head));
    }

    @Test
    void deleteDuplicatesFromASortedList2() {
        list.append(3);
        list.append(3);
        list.append(2);
        list.append(1);
        list.append(1);
        Node_Integer newHead = list.deleteDuplicatesFromASortedList(list.getHead());
        list.head = newHead;
        assertArrayEquals(new int[]{3, 2, 1}, list.traverseForward(list.head));
    }

    @Test
    void deleteDuplicatesFromAnUnsortedList1() {
        list.append(1);
        list.append(2);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(9);
        Node_Integer newHead = list.deleteDuplicatesFromAnUnsortedList(list.getHead());
        list.head = newHead;
        assertArrayEquals(new int[]{1, 2, 4, 3, 9}, list.traverseForward(list.head));
    }
}
