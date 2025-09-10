package com.my.company.datastructures.linkedlist.singlylinked;

public class Node_Integer {

    private Node_Integer next;

    private int value;

    public Node_Integer(int value) {
        this.value = value;
    }

    public Node_Integer getNext() {
        return next;
    }

    public void setNext(Node_Integer next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
