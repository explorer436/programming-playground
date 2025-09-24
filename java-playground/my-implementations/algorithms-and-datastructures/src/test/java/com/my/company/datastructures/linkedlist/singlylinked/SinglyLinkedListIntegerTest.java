package com.my.company.datastructures.linkedlist.singlylinked;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListIntegerTest {

    // SinglyLinkedList_Integer singlyLinkedList_Integer = new SinglyLinkedList_Integer();
    SinglyLinkedList_Integer singlyLinkedList_Integer;

    @Test
    public void test_prepend_and_remove_from_front() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        assertEquals(singlyLinkedList_Integer.size, 1);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        assertEquals(singlyLinkedList_Integer.head.getNext(), null);

        singlyLinkedList_Integer.prepend(2);
        assertEquals(singlyLinkedList_Integer.size, 2);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 2);
        Node_Integer nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.prepend(3);
        assertEquals(singlyLinkedList_Integer.size, 3);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 3);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.prepend(4);
        assertEquals(singlyLinkedList_Integer.size, 4);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 4);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.removeFromFront();
        assertEquals(singlyLinkedList_Integer.size, 3);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 3);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.removeFromFront();
        assertEquals(singlyLinkedList_Integer.size, 2);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 2);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.removeFromFront();
        assertEquals(singlyLinkedList_Integer.size, 1);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        assertEquals(singlyLinkedList_Integer.head.getNext(), null);

        singlyLinkedList_Integer.removeFromFront();
        assertEquals(singlyLinkedList_Integer.isEmpty(), true);
    }

    @Test
    public void test_append_and_remove_from_last() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        assertEquals(singlyLinkedList_Integer.size, 1);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        assertEquals(singlyLinkedList_Integer.head.getNext(), null);

        singlyLinkedList_Integer.append(2);
        assertEquals(singlyLinkedList_Integer.size, 2);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        Node_Integer nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.append(3);
        assertEquals(singlyLinkedList_Integer.size, 3);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.append(4);
        assertEquals(singlyLinkedList_Integer.size, 4);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 4);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.removeFromLast();
        assertEquals(singlyLinkedList_Integer.size, 3);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 3);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.removeFromLast();
        assertEquals(singlyLinkedList_Integer.size, 2);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 2);
        assertEquals(nextNode.getNext(), null);

        singlyLinkedList_Integer.removeFromLast();
        assertEquals(singlyLinkedList_Integer.size, 1);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 1);
        assertEquals(singlyLinkedList_Integer.head.getNext(), null);

        singlyLinkedList_Integer.removeFromLast();
        assertEquals(singlyLinkedList_Integer.isEmpty(), true);
    }

    @Test
    public void test_reverse_iterative() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        assertEquals(singlyLinkedList_Integer.size, 4);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 4);
        Node_Integer nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        Node_Integer headAfterReversal = singlyLinkedList_Integer.reverse_iterative(singlyLinkedList_Integer.head);

        assertEquals(singlyLinkedList_Integer.size, 4);
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

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        assertEquals(singlyLinkedList_Integer.size, 4);
        assertEquals(singlyLinkedList_Integer.head.getValue(), 4);
        Node_Integer nextNode = singlyLinkedList_Integer.head.getNext();
        assertEquals(nextNode.getValue(), 3);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 2);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getValue(), 1);
        assertEquals(nextNode.getNext(), null);

        Node_Integer headAfterReversal = singlyLinkedList_Integer.reverse_recursive(singlyLinkedList_Integer.head);

        assertEquals(singlyLinkedList_Integer.size, 4);
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
        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        int[] actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        int[] expected = new int[]{4,3,2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    void test_getNodeAtIndex() {
        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);

        int actual = singlyLinkedList_Integer.getValueAtIndex(2);
        assertEquals(0,actual);

        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        actual = singlyLinkedList_Integer.getValueAtIndex(2);
        int expected = 3;
        assertEquals(expected,actual);

        actual = singlyLinkedList_Integer.getValueAtIndex(10);
        assertEquals(0,actual);
    }

    @Test
    void test_setNodeAtIndex() {
        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);

        singlyLinkedList_Integer.setValueAtIndex(2, 36);

        int[] actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        int[] expected = new int[]{1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        singlyLinkedList_Integer.setValueAtIndex(2, 36);

        actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        expected = new int[]{4,3,36,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        singlyLinkedList_Integer.setValueAtIndex(10, 36);

        actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        expected = new int[]{4,3,36,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    void test_removeNodeAtIndex() {
        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        int[] actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        int[] expected = new int[]{4,3,2,1};
        assertArrayEquals(expected,actual);

        singlyLinkedList_Integer.removeNodeAtIndex(singlyLinkedList_Integer.getHead(), 2);
        actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        expected = new int[]{4,3,1};
        assertArrayEquals(expected,actual);

        singlyLinkedList_Integer.removeNodeAtIndex(singlyLinkedList_Integer.getHead(), 2);
        actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        expected = new int[]{4,3};
        assertArrayEquals(expected,actual);

        singlyLinkedList_Integer.removeNodeAtIndex(singlyLinkedList_Integer.getHead(), 2);
        actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        expected = new int[]{4,3};
        assertArrayEquals(expected,actual);
    }

    @Test
    void test_insertNodeAtIndex() {
        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.prepend(2);
        singlyLinkedList_Integer.prepend(3);
        singlyLinkedList_Integer.prepend(4);

        assertEquals(singlyLinkedList_Integer.calculateSize(singlyLinkedList_Integer.head), 4);

        int[] actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        int[] expected = new int[]{4,3,2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

        singlyLinkedList_Integer.insertNodeAtIndex(2, 22);

        actual = singlyLinkedList_Integer.traverseForward(singlyLinkedList_Integer.getHead());
        expected = new int[]{4,3,22, 2,1};
        assertTrue(EqualsBuilder.reflectionEquals(expected,actual));
    }

    @Test
    public void test_findTheMiddleNodeOfALinkedList_1() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(0);
        singlyLinkedList_Integer.append(1);
        singlyLinkedList_Integer.append(2);
        singlyLinkedList_Integer.append(3);
        singlyLinkedList_Integer.append(4);
        singlyLinkedList_Integer.append(5);
        singlyLinkedList_Integer.append(6);
        singlyLinkedList_Integer.append(7);

        ImmutablePair<Integer, Node_Integer> middleNode = singlyLinkedList_Integer.findMiddleNode(singlyLinkedList_Integer.getHead());

        assertEquals(3, middleNode.getLeft());
        assertEquals(3, middleNode.getRight().getValue());

        System.out.println("middleIndex: " + middleNode.getLeft() );
        System.out.println("data at middleIndex: " + middleNode.getRight().getValue());
    }

    @Test
    public void test_findTheMiddleNodeOfALinkedList_2() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.append(2);
        singlyLinkedList_Integer.append(1);

        ImmutablePair<Integer, Node_Integer> middleNode = singlyLinkedList_Integer.findMiddleNode(singlyLinkedList_Integer.getHead());

        assertEquals(1, middleNode.getLeft());
        assertEquals(2, middleNode.getRight().getValue());

        System.out.println("middleIndex: " + middleNode.getLeft() );
        System.out.println("data at middleIndex: " + middleNode.getRight().getValue());
    }

    @Test
    public void test_addInMiddle() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.append(2);
        singlyLinkedList_Integer.append(3);
        singlyLinkedList_Integer.append(4);

        System.out.println("Original list:");
        SinglyLinkedList_Integer.printList(singlyLinkedList_Integer.getHead()); // Output: 1 -> 2 -> 3 -> 4 -> null

        // Add 5 in the middle
        singlyLinkedList_Integer.addInMiddle(5);
        System.out.println("After adding 5 in the middle:");
        SinglyLinkedList_Integer.printList(singlyLinkedList_Integer.getHead()); // Output: 1 -> 2 -> 5 -> 3 -> 4 -> null

        // Add another element (6) in the middle
        singlyLinkedList_Integer.addInMiddle(6);
        System.out.println("After adding 6 in the middle:");
        SinglyLinkedList_Integer.printList(singlyLinkedList_Integer.getHead()); // Output: 1 -> 2 -> 6 -> 5 -> 3 -> 4 -> null
    }

    @Test
    public void test_removeElementsWithMatchingValue_01() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.append(2);
        singlyLinkedList_Integer.append(3);
        singlyLinkedList_Integer.append(4);

        System.out.println("Original list:");
        SinglyLinkedList_Integer.printList(singlyLinkedList_Integer.getHead());

        Node_Integer head = singlyLinkedList_Integer.removeElementsWithMatchingValue(singlyLinkedList_Integer.getHead(), 3);

        SinglyLinkedList_Integer.printList(head);
    }

    @Test
    public void test_removeElementsWithMatchingValue_02() {

        singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        singlyLinkedList_Integer.append(2);
        singlyLinkedList_Integer.append(3);
        singlyLinkedList_Integer.append(4);

        System.out.println("Original list:");
        SinglyLinkedList_Integer.printList(singlyLinkedList_Integer.getHead());

        Node_Integer head = singlyLinkedList_Integer.removeElementsWithMatchingValue(singlyLinkedList_Integer.getHead(), 1);

        SinglyLinkedList_Integer.printList(head);
    }


}
