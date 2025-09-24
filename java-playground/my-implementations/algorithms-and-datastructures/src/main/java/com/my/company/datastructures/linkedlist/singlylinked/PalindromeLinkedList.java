package com.my.company.datastructures.linkedlist.singlylinked;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class PalindromeLinkedList {

    public boolean isPalindrome(Node_Integer head) {
        if (head == null || head.getNext() == null) {
            return true; // An empty list or a single-node list is a palindrome
        }

        // Step 1: Find the middle of the linked list
        ImmutablePair<Integer, Node_Integer> middleIndexAndPointer = SinglyLinkedList_Integer.findMiddleNode(head);
        Node_Integer middleNode = middleIndexAndPointer.getRight();

        // Now, 'slow' is at the end of the first half
        // The second half starts from slow.next

        // Step 2: Reverse the second half
        Node_Integer headOfReversedSecondHalf = SinglyLinkedList_Integer.reverse_iterative(middleNode.getNext());
        middleNode.setNext(null); // Disconnect the first half from the second half

        // Step 3: Compare the first half with the reversed second half
        Node_Integer p1 = head;
        Node_Integer p2 = headOfReversedSecondHalf;

        while (p1 != null && p2 != null) {
            if (p1.getValue() != p2.getValue()) {
                return false; // Not a palindrome
            }
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return true; // It's a palindrome
    }

}
