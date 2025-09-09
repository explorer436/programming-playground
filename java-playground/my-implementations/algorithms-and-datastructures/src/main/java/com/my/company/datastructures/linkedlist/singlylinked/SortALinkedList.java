package com.my.company.datastructures.linkedlist.singlylinked;

import com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist.IntegerSinglyLinkedList;
import com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist.Node;

public class SortALinkedList {

    public static void main(String args[]) {

        IntegerSinglyLinkedList linkedList = new IntegerSinglyLinkedList();
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

    public static Node mergeSort(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node middleNode = FindTheMiddleNodeOfALinkedList.findMiddleNode(head).getRight();
        Node nextOfMiddle = middleNode.getNext();
        middleNode.setNext(null);

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    public static Node sortedMerge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;
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
