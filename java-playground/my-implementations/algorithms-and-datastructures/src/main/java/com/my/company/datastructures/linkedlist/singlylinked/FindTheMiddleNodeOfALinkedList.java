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

    private static ImmutablePair<Integer, Node> findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        int slowIndex = 0;

        while (fast != null && fast.getNext() != null) {
            slowIndex++;
            slow = slow.getNext();
            fast =  fast.getNext().getNext();
        }

        return new ImmutablePair<>(slowIndex, slow);
    }

}
