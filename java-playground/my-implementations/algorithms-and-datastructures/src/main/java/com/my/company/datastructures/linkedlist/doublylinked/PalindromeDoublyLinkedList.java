package com.my.company.datastructures.linkedlist.doublylinked;

public class PalindromeDoublyLinkedList {

    public boolean isPalindrome(DoublyListNode_Integer head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a single-node list is a palindrome
        }

        // Find the tail of the doubly linked list
        DoublyListNode_Integer tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        DoublyListNode_Integer left = head;
        DoublyListNode_Integer right = tail;

        // Move pointers inwards and compare values
        while (left != right && left.getPrevious() != right) { // Stop when they meet or cross
            if (left.getValue() != right.getValue()) {
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.getPrevious();
        }

        return true; // All elements matched, it's a palindrome
    }

    public static void main(String[] args) {
        // Helper function to create a doubly linked list
        // For simplicity, we'll manually set prev pointers in main

        // Example 1: Palindrome (1 <-> 2 <-> 2 <-> 1)
        DoublyListNode_Integer head1 = new DoublyListNode_Integer(1);
        DoublyListNode_Integer node1_2 = new DoublyListNode_Integer(2);
        DoublyListNode_Integer node1_3 = new DoublyListNode_Integer(2);
        DoublyListNode_Integer node1_4 = new DoublyListNode_Integer(1);

        head1.next = node1_2;
        node1_2.setPrevious(head1);
        node1_2.next = node1_3;
        node1_3.setPrevious(node1_2);
        node1_3.next = node1_4;
        node1_4.setPrevious(node1_3);

        PalindromeDoublyLinkedList sol = new PalindromeDoublyLinkedList();
        System.out.println("Is 1<->2<->2<->1 a palindrome? " + sol.isPalindrome(head1)); // Output: true

        // Example 2: Not a Palindrome (1 <-> 2 <-> 3 <-> 1)
        DoublyListNode_Integer head2 = new DoublyListNode_Integer(1);
        DoublyListNode_Integer node2_2 = new DoublyListNode_Integer(2);
        DoublyListNode_Integer node2_3 = new DoublyListNode_Integer(3);
        DoublyListNode_Integer node2_4 = new DoublyListNode_Integer(1);

        head2.next = node2_2;
        node2_2.setPrevious(head2);
        node2_2.next = node2_3;
        node2_3.setPrevious(node2_2);
        node2_3.next = node2_4;
        node2_4.setPrevious(node2_3);

        System.out.println("Is 1<->2<->3<->1 a palindrome? " + sol.isPalindrome(head2)); // Output: false

        // Example 3: Palindrome (1 <-> 2 <-> 1)
        DoublyListNode_Integer head3 = new DoublyListNode_Integer(1);
        DoublyListNode_Integer node3_2 = new DoublyListNode_Integer(2);
        DoublyListNode_Integer node3_3 = new DoublyListNode_Integer(1);

        head3.next = node3_2;
        node3_2.setPrevious(head3);
        node3_2.next = node3_3;
        node3_3.setPrevious(node3_2);

        System.out.println("Is 1<->2<->1 a palindrome? " + sol.isPalindrome(head3)); // Output: true

        // Example 4: Palindrome (1)
        DoublyListNode_Integer head4 = new DoublyListNode_Integer(1);
        System.out.println("Is 1 a palindrome? " + sol.isPalindrome(head4)); // Output: true
    }
}
