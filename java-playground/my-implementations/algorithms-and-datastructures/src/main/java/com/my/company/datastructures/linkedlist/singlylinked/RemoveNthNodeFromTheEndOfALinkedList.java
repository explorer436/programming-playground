package com.my.company.datastructures.linkedlist.singlylinked;

import com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist.IntegerSinglyLinkedList;
import com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist.Node;

public class RemoveNthNodeFromTheEndOfALinkedList {

    public static void main(String args[]) {

        IntegerSinglyLinkedList linkedList = new IntegerSinglyLinkedList();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);

        linkedList.printList();

        removeNthNodeFromTheEnd(linkedList.getHead(), 3);

        linkedList.printList();
    }

    private static void removeNthNodeFromTheEnd(Node head, int N) {
        if (head == null) {
            return;
        }

        Node firstPointer = head;
        Node secondPointer = head;

        // Move the first pointer forward by N positions
        for (int i = 0; i < N; i++) {
            firstPointer = firstPointer.getNext();
        }

        if (firstPointer == null) {
            return;
        }

        while (firstPointer.getNext() != null) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext();
        }

        // Remove the node at second pointer
        Node temp = secondPointer.getNext();
        secondPointer.setNext(temp.getNext());
        temp.setNext(null);
    }


}
