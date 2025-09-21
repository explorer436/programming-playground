package com.my.company.datastructures.linkedlist.singlylinked;

public class FindNthNodeFromTheEndOfALinkedList {

    public static void main(String args[]) {

        SinglyLinkedList_Integer linkedList = new SinglyLinkedList_Integer();
        linkedList.append(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);

        SinglyLinkedList_Integer.printList(linkedList.getHead());

        System.out.println("value at nthNodeFromTheEnd = " + determineNthNodeFromTheEnd(linkedList.getHead(), 3).getValue());

        System.out.println("value at nthNodeFromTheEnd = " + determineNthNodeFromTheEnd(linkedList.getHead(), 2).getValue());
    }

    public static Node_Integer determineNthNodeFromTheEnd(Node_Integer head, int N) {
        if (head == null) {
            return null;
        }

        Node_Integer firstPointer = head;
        Node_Integer secondPointer = head;

        // Move the first pointer forward by N positions
        for (int i = 0; i < N; i++) {
            firstPointer = firstPointer.getNext();
        }

        if (firstPointer == null) {
            return null;
        }

        while (firstPointer.getNext() != null) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext();
        }

        return secondPointer;
    }


}
