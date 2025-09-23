package com.my.company.datastructures.linkedlist.singlylinked.sorting;

import com.my.company.datastructures.linkedlist.singlylinked.Node_Integer;
import com.my.company.datastructures.linkedlist.singlylinked.SinglyLinkedList_Integer;

public class QuickSortForALinkedList {

    // Returns the last node of the list
    static Node_Integer getTail(Node_Integer cur) {
        while (cur != null && cur.getNext() != null)
            cur = cur.getNext();
        return cur;
    }

    // Partitions the list taking the first element as the pivot
    static Node_Integer partition(Node_Integer head, Node_Integer tail) {

        // Select the first node as the pivot node
        Node_Integer pivot = head;

        // 'pre' and 'curr' are used to shift all
        // smaller nodes' data to the left side of the pivot node
        Node_Integer pre = head;
        Node_Integer curr = head;

        // Traverse the list until you reach the node after the tail
        while (curr != tail.getNext()) {

            // If current node's data is less than the pivot's data
            if (curr.getValue() < pivot.getValue()) {

                int temp = curr.getValue();
                curr.setValue(pre.getNext().getValue());
                pre.getNext().setValue(temp);

                // Move 'pre' to the next node
                pre = pre.getNext();
            }

            // Move 'curr' to the next node
            curr = curr.getNext();
        }

        // Swap the pivot's data with 'pre' data
        int currData = pivot.getValue();
        pivot.setValue(pre.getValue());
        pre.setValue(currData);

        // Return 'pre' as the new pivot
        return pre;
    }

    // Helper function for quick sort
    static void quickSortHelper(Node_Integer head, Node_Integer tail) {

        // Base case: if the list is empty or consists of a single node
        if (head == null || head == tail) {
            return;
        }

        // Call partition to find the pivot node
        Node_Integer pivot = partition(head, tail);

        // Recursive call for the left part of
        // the list (before the pivot)
        quickSortHelper(head, pivot);

        // Recursive call for the right part of
        // the list (after the pivot)
        quickSortHelper(pivot.getNext(), tail);
    }

    // The main function for quick sort.
    // This is a wrapper over quickSortHelper
    static Node_Integer quickSort(Node_Integer head) {

        // Find the tail of the list
        Node_Integer tail = getTail(head);

        // Call the helper function to sort the list
        quickSortHelper(head, tail);
        return head;
    }

    public static void main(String[] args) {

        // Creating a linked list: 30 -> 3 -> 4 -> 20 -> 5
        Node_Integer head = new Node_Integer(30);
        head.setNext(new Node_Integer(3));
        head.getNext().setNext(new Node_Integer(4));
        head.getNext().getNext().setNext(new Node_Integer(20));
        head.getNext().getNext().getNext().setNext(new Node_Integer(5));

        head = quickSort(head);
        SinglyLinkedList_Integer.printList(head);
    }

}
