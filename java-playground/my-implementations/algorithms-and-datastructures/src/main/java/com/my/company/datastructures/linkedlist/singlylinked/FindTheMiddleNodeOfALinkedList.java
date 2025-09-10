package com.my.company.datastructures.linkedlist.singlylinked;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class FindTheMiddleNodeOfALinkedList {

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

        ImmutablePair<Integer, Node_Integer> abc = findMiddleNode(linkedList.getHead());

        System.out.println("middleIndex: " + abc.getLeft() );
        System.out.println("data at middleIndex: " + abc.getRight().getValue());
    }

    public static ImmutablePair<Integer, Node_Integer> findMiddleNode(Node_Integer head) {
        Node_Integer fastPointer = head;
        Node_Integer slowPointer = head;
        int slowIndex = 0;

        // If we do not use fastPointer.getNext().getNext(),
        // in cases where the list has even number of elements,
        // the method will return the left-most element in the right half of the list - which is not what we expect.
        // We want the right-most element in the left half of the list.
        while (fastPointer != null && fastPointer.getNext().getNext() != null) {
            slowIndex++;
            slowPointer = slowPointer.getNext();
            fastPointer =  fastPointer.getNext().getNext();
        }

        return new ImmutablePair<>(slowIndex, slowPointer);
    }

}
