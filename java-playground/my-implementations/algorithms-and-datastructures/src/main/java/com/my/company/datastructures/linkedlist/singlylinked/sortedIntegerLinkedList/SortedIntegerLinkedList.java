package com.my.company.datastructures.linkedlist.singlylinked.sortedIntegerLinkedList;

public class SortedIntegerLinkedList {

    protected Node head;

    public void insertSorted(int i) {
        // assumption is the list is sorted.

        if (head == null) {
            Node node = new Node(i);
            head = node;
        } else if (head.getValue() >= i) {
            Node node = new Node(i);
            node.setNext(head);
            head = node;
        } else {

            // head.getValue() is less than i.
            Node next = head.getNext();
            Node previous = head;

            while (next != null && next.getValue() < i) {
                previous = next;
                next = next.getNext();
            }

            // This will cover both next = null scenario and next != null
            // (insert between two existing nodes) scenarios.

            Node node = new Node(i);
            node.setNext(next);
            previous.setNext(node);
        }
    }
}
