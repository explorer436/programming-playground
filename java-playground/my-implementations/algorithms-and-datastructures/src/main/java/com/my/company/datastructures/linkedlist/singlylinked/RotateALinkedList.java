package com.my.company.datastructures.linkedlist.singlylinked;

public class RotateALinkedList {

    // SinglyLinkedList_Integer  singlyLinkedList = new SinglyLinkedList_Integer();
    FindNthNodeFromTheEndOfALinkedList findNthNodeFromTheEndOfALinkedList = new FindNthNodeFromTheEndOfALinkedList();

    public Node_Integer rotateRight(Node_Integer head, int k) {

        // Edge cases: empty list, single node list, or k = 0
        if (head == null || head.getNext() == null || k == 0) {
            return head;
        }

        int n = SinglyLinkedList_Integer.calculateSize(head);
        Node_Integer tail = SinglyLinkedList_Integer.getTail(head);

        // 2. Adjust k: k can be greater than n
        k = k % n;

        // If k is 0 after adjustment, no rotation is needed
        if (k == 0) {
            return head;
        }

        // Why k + 1?
        // Because we need to set "next" to the node in front of it
        Node_Integer newEndingNode = findNthNodeFromTheEndOfALinkedList.determineNthNodeFromTheEnd(head, k + 1).getNext();

        Node_Integer newHead = newEndingNode.getNext();
        newEndingNode.setNext(null);

        tail.setNext(head);

        return newHead;
    }

    /*public Node_Integer rotateRight(Node_Integer head, int k) {
        // Edge cases: empty list, single node list, or k = 0
        if (head == null || head.getNext() == null || k == 0) {
            return head;
        }

        // 1. Calculate the length of the list and find the tail
        Node_Integer current = head;
        int n = 1; // Length of the list
        while (current.getNext() != null) {
            current = current.next;
            n++;
        }
        Node_Integer tail = current; // 'current' is now the tail

        // 2. Adjust k: k can be greater than n
        k = k % n;

        // If k is 0 after adjustment, no rotation is needed
        if (k == 0) {
            return head;
        }

        // 3. Find the new tail (n - k - 1 from original head)
        // And the new head (n - k from original head)
        Node_Integer newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        Node_Integer newHead = newTail.next;

        // 4. Perform the rotation
        // Connect original tail to original head
        tail.next = head;

        // Break the cycle by setting newTail.next to null
        newTail.next = null;

        // The new head is the result
        return newHead;
    }*/

    public static void main(String[] args) {
        SinglyLinkedList_Integer singlyLinkedList_Integer = new SinglyLinkedList_Integer(1);
        RotateALinkedList  rotateALinkedList = new RotateALinkedList();

        singlyLinkedList_Integer.append(2);
        singlyLinkedList_Integer.append(3);
        singlyLinkedList_Integer.append(4);
        singlyLinkedList_Integer.append(5);
        singlyLinkedList_Integer.append(6);
        singlyLinkedList_Integer.append(7);

        SinglyLinkedList_Integer.printList(singlyLinkedList_Integer.head);

        Node_Integer result = rotateALinkedList.rotateRight(singlyLinkedList_Integer.head, 3);

        SinglyLinkedList_Integer.printList(result);
    }

}