package com.my.company.datastructures.linkedlist.singlylinked.sorting;

public class SortedIntegerLinkedList {

    protected Node head;

    public void insertSorted(int i) {

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

    public void printList() {

        Node currentNode = head;

        System.out.println();
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
}
