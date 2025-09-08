package com.my.company.datastructures.linkedlist.singlylinked.intlinkedlist;

import com.my.company.datastructures.linkedlist.doublylinked.employeelist.Employee;

import java.util.Iterator;

public class IntegerSinglyLinkedList {

    protected Node head;

    public Node getHead() {
        return head;
    }

    protected int size;

    public void prepend(int i) {
        Node node = new Node(i);
        node.setNext(head);
        head = node;
        size++;
    }

    public void append(int i) {
        Node node = new Node(i);

        if (isEmpty()) {
            head = node;
            size++;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    public void insertNodeAtIndex(int index, int value) {
        if (isEmpty() && index != 0) {
            return;
        }

        if (index < 0 | size < index) {
            return;
        }

        Node current = head;
        for (int counter = 1; counter <= index; counter++) {
            if (counter == index) {
                Node newNode = new Node(value);
                newNode.setNext(current.getNext());

                current.setNext(newNode);

                size++;
                return;
            }
            current = current.getNext();
        }
    }

    public int[] traverseForward() {
        int[] arr = new int[size];

        Node current = head;
        int counter = 0;
        while (current != null) {
            arr[counter] = current.getValue();
            counter++;
            current = current.getNext();
        }

        return arr;
    }

    public void removeFromFront() {
        if (isEmpty()) {
            return;
        } else {
            Node removedNode = head;
            head = head.getNext();
            size--;
            removedNode.setNext(null);
        }
    }

    public void removeFromLast() {
        if (isEmpty()) {
            return;
        }

        if (size == 1) {
            head = null;
            size = 0;
            return;
        }

        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        size--;
    }

    public void removeNodeAtIndex(int index) {
        if (isEmpty()) {
            return;
        }
        if (size <= index) {
            return;
        }

        if (size == 1 & index == 1) {
            head = null;
            size--;
            return;
        }

        Node current = head;
        for (int counter = 1; counter <= index - 1; counter++) {
            current = current.getNext();
            if (counter == index - 1) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
        }
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public int getSize() {
        return size;
    }

    public int findLength() {
        int count = 0;
        Node currentNode = head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public int getValueAtIndex(int index) {
        if (isEmpty()) {
            return 0;
        }

        if (index < 0 | size < index) {
            return 0;
        }

        Node current = head;
        for (int counter = 1; counter <= index; counter++) {
            if (counter == index) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return 0;
    }

    public void setValueAtIndex(int index, int value) {
        if (isEmpty()) {
            return;
        }

        if (index < 0 | size < index) {
            return;
        }

        Node current = head;
        for (int counter = 0; counter <= index; counter++) {
            if (counter == index) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }
    }

    public Node reverse_iterative(Node head) {

        // Initialize pointers for traversal.
        Node current = head;
        Node previous = null;

        while (current != null) {
            Node nextNode = current.getNext();

            // Reverse the current node's pointer
            current.setNext(previous);

            // Move on to the next one
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public Node reverse_recursive(Node node) {

        // The base case for recursion is an empty list or a list with a single node
        if (node == null || node.getNext() == null) {
            return node;
        }

        Node newHead = reverse_recursive(node.getNext());
        // Reverse the next node's pointer
        node.getNext().setNext(node);
        node.setNext(null);

        return newHead;
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
