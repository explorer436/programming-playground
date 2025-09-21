package com.my.company.datastructures.linkedlist.singlylinked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeLinkedListTest {

    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    @Test
    public void test_palindromeLinkedList_1() {
        // Example 1: Palindrome (1 -> 2 -> 2 -> 1)
        Node_Integer head1 = new Node_Integer(1);
        head1.setNext(new Node_Integer(2));
        head1.getNext().setNext(new Node_Integer(2));
        head1.getNext().getNext().setNext(new Node_Integer(1));
        PalindromeLinkedList sol = new PalindromeLinkedList();
        assertTrue(sol.isPalindrome(head1));

        // Example 2: Not a Palindrome (1 -> 2 -> 3 -> 1)
        Node_Integer head2 = new Node_Integer(1);
        head2.setNext(new Node_Integer(2));
        head2.getNext().setNext(new Node_Integer(3));
        head2.getNext().getNext().setNext(new Node_Integer(1));
        assertFalse(sol.isPalindrome(head2));

        // Example 3: Palindrome (1 -> 2 -> 1)
        Node_Integer head3 = new Node_Integer(1);
        head3.setNext(new Node_Integer(2));
        head3.getNext().setNext(new Node_Integer(1));
        assertTrue(sol.isPalindrome(head3));

        // Example 4: Not a Palindrome (1 -> 2)
        Node_Integer head4 = new Node_Integer(1);
        head4.setNext(new Node_Integer(2));
        assertFalse(sol.isPalindrome(head4));

        // Example 5: Palindrome (1)
        Node_Integer head5 = new Node_Integer(1);
        assertTrue(sol.isPalindrome(head5));
    }
}
