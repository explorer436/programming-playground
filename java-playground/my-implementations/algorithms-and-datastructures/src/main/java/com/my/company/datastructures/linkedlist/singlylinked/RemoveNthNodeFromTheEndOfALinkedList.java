package com.my.company.datastructures.linkedlist.singlylinked;

public class RemoveNthNodeFromTheEndOfALinkedList {

    public static void main(String args[]) {

        SinglyLinkedList_Integer linkedList = new SinglyLinkedList_Integer(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);

        SinglyLinkedList_Integer.printList(linkedList.getHead());

        removeNthNodeFromTheEnd(linkedList.getHead(), 3);

        SinglyLinkedList_Integer.printList(linkedList.getHead());
    }

    private static void removeNthNodeFromTheEnd(Node_Integer head, int N) {
        if (head == null) {
            return;
        }

        Node_Integer firstPointer = head;
        Node_Integer secondPointer = head;

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
        Node_Integer temp = secondPointer.getNext();
        secondPointer.setNext(temp.getNext());
        temp.setNext(null);
    }


}
