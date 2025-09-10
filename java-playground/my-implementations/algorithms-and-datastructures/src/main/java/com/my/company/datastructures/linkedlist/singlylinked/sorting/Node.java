package com.my.company.datastructures.linkedlist.singlylinked.sorting;

public class Node {

    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int number) {
        this.value = number;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
