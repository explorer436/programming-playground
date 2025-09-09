package com.my.company.datastructures.linkedlist.singlylinked;

import com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist.IntegerSinglyLinkedList;
import com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist.Node;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class FindTheMiddleNodeOfALinkedList {

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

        ImmutablePair<Integer, Node> abc = findMiddleNode(linkedList.getHead());

        System.out.println("middleIndex: " + abc.getLeft() );
        System.out.println("data at middleIndex: " + abc.getRight().getValue());
    }

    public static ImmutablePair<Integer, Node> findMiddleNode(Node head) {
        Node fastPointer = head;
        Node slowPointer = head;
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
