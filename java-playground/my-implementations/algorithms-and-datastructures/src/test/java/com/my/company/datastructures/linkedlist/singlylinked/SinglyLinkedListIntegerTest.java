package com.my.company.datastructures.linkedlist.singlylinked;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListIntegerTest {
    @Test
    public void test_prepend_and_remove_from_front() {

        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);
        assertEquals(list.size, 1);
        assertEquals(list.head.getValue(), 1);
        assertEquals(list.head.getNext(), null);

        list.prepend(2);
        assertEquals(list.size, 2);
        assertEquals(list.head.getValue(), 2);
        Node_Integer nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        list.prepend(3);
        assertEquals(list.size, 3);
        assertEquals(list.head.getValue(), 3);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        list.prepend(4);
        assertEquals(list.size, 4);
        assertEquals(list.head.getValue(), 4);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        list.removeFromFront();
        assertEquals(list.size, 3);
        assertEquals(list.head.getValue(), 3);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        list.removeFromFront();
        assertEquals(list.size, 2);
        assertEquals(list.head.getValue(), 2);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        list.removeFromFront();
        assertEquals(list.size, 1);
        assertEquals(list.head.getValue(), 1);
        assertEquals(list.head.getNext(), null);

        list.removeFromFront();
        assertEquals(list.isEmpty(), true);
    }

    @Test
    public void test_append_and_remove_from_last() {

        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.append(1);
        assertEquals(list.size, 1);
        assertEquals(list.head.getValue(), 1);
        assertEquals(list.head.getNext(), null);

        list.append(2);
        assertEquals(list.size, 2);
        assertEquals(list.head.getValue(), 1);
        Node_Integer nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        assertEquals(nextNode.getNext(), null);

        list.append(3);
        assertEquals(list.size, 3);
        assertEquals(list.head.getValue(), 1);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        assertEquals(nextNode.getNext(), null);

        list.append(4);
        assertEquals(list.size, 4);
        assertEquals(list.head.getValue(), 1);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 4);
        assertEquals(nextNode.getNext(), null);

        list.removeFromLast();
        assertEquals(list.size, 3);
        assertEquals(list.head.getValue(), 1);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        assertEquals(nextNode.getNext(), null);

        list.removeFromLast();
        assertEquals(list.size, 2);
        assertEquals(list.head.getValue(), 1);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        assertEquals(nextNode.getNext(), null);

        list.removeFromLast();
        assertEquals(list.size, 1);
        assertEquals(list.head.getValue(), 1);
        assertEquals(list.head.getNext(), null);

        list.removeFromLast();
        assertEquals(list.isEmpty(), true);
    }

    @Test
    public void test_reverse_iterative() {

        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        assertEquals(list.size, 4);
        assertEquals(list.head.getValue(), 4);
        Node_Integer nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        Node_Integer headAfterReversal = list.reverse_iterative(list.head);

        assertEquals(list.size, 4);
        assertEquals(headAfterReversal.getValue(), 1);
        nextNode = headAfterReversal.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 4);
        assertEquals(nextNode.getNext(), null);
    }

    @Test
    public void test_reverse_recursive() {

        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        assertEquals(list.size, 4);
        assertEquals(list.head.getValue(), 4);
        Node_Integer nextNode = list.head.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        Node_Integer headAfterReversal = list.reverse_recursive(list.head);

        assertEquals(list.size, 4);
        assertEquals(headAfterReversal.getValue(), 1);
        nextNode = headAfterReversal.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 4);
        assertEquals(nextNode.getNext(), null);
    }

    @Test
    void test_traverseForward() {
        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        int[] actual = list.traverseForward();
        int[] expected = new int[]{4,3,2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    void test_getNodeAtIndex() {
        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);

        int actual = list.getValueAtIndex(2);
        assertEquals(0,actual);

        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        actual = list.getValueAtIndex(2);
        int expected = 3;
        assertEquals(expected,actual);

        actual = list.getValueAtIndex(10);
        assertEquals(0,actual);
    }

    @Test
    void test_setNodeAtIndex() {
        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);

        list.setValueAtIndex(2, 36);

        int[] actual = list.traverseForward();
        int[] expected = new int[]{1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        list.setValueAtIndex(2, 36);

        actual = list.traverseForward();
        expected = new int[]{4,3,36,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        list.setValueAtIndex(10, 36);

        actual = list.traverseForward();
        expected = new int[]{4,3,36,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    void test_removeNodeAtIndex() {
        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        int[] actual = list.traverseForward();
        int[] expected = new int[]{4,3,2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        list.removeNodeAtIndex(2);
        actual = list.traverseForward();
        expected = new int[]{4,3,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        list.removeNodeAtIndex(2);
        actual = list.traverseForward();
        expected = new int[]{4,3};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        list.removeNodeAtIndex(2);
        actual = list.traverseForward();
        expected = new int[]{4,3};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    void test_insertNodeAtIndex() {
        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        assertEquals(list.findLength(), 4);

        int[] actual = list.traverseForward();
        int[] expected = new int[]{4,3,2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        list.insertNodeAtIndex(2, 22);

        actual = list.traverseForward();
        expected = new int[]{4,3,22, 2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }
}