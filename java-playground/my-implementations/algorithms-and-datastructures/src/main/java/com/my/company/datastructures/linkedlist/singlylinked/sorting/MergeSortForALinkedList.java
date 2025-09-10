package com.my.company.datastructures.linkedlist.singlylinked.sorting;

import com.my.company.datastructures.linkedlist.singlylinked.FindTheMiddleNodeOfALinkedList;
import com.my.company.datastructures.linkedlist.singlylinked.SinglyLinkedList_Integer;
import com.my.company.datastructures.linkedlist.singlylinked.Node_Integer;

public class MergeSortForALinkedList {

    public static void main(String args[]) {

        SinglyLinkedList_Integer linkedList = new SinglyLinkedList_Integer();
        linkedList.append(0);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(1);

        linkedList.printList();

        mergeSort(linkedList.getHead());

        linkedList.printList();
    }

    public static Node_Integer mergeSort(Node_Integer head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node_Integer middleNode = FindTheMiddleNodeOfALinkedList.findMiddleNode(head).getRight();
        Node_Integer nextOfMiddle = middleNode.getNext();
        middleNode.setNext(null);

        Node_Integer left = mergeSort(head);
        Node_Integer right = mergeSort(nextOfMiddle);

        Node_Integer sortedList = sortedMerge(left, right);
        return sortedList;
    }

    public static Node_Integer sortedMerge(Node_Integer a, Node_Integer b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node_Integer result;
        // Should we put "a" on the left, or "b" on the left?
        if (a.getValue() <= b.getValue()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

}
