package com.my.company.datastructures.linkedlist.singlylinked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindStartingNodeOfALoopTest {

    FindStartingNodeOfALoop  findStartingNodeOfALoop = new FindStartingNodeOfALoop();

    @Test
    public void test_StartingPointOfTheLoop_2() {

        Node_Integer node2 = new Node_Integer(2);
        Node_Integer node3 = new Node_Integer(3);
        Node_Integer node4 = new Node_Integer(4);
        Node_Integer node5 = new Node_Integer(5);

        // Example 1: Palindrome (1 -> 2 -> 3 -> 4 -> 5 -> 3)
        Node_Integer head1 = new Node_Integer(1);
        head1.setNext(node2);
        head1.getNext().setNext(node3);
        head1.getNext().getNext().setNext(node4);
        head1.getNext().getNext().getNext().setNext(node5);
        node5.setNext(node3);

        assertEquals(3, findStartingNodeOfALoop.findStartingNodeOfALoop(head1).getValue());
    }

}
