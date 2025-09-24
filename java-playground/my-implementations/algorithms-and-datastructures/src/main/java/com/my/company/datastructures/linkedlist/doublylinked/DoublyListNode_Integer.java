package com.my.company.datastructures.linkedlist.doublylinked;

class DoublyListNode_Integer {
    int value;
    DoublyListNode_Integer next;
    DoublyListNode_Integer previous; // 'prev' pointer for doubly linked list

    DoublyListNode_Integer(int val) {
        this.value = val;
        this.next = null;
        this.previous = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        this.value = val;
    }

    public DoublyListNode_Integer getNext() {
        return next;
    }

    public void setNext(DoublyListNode_Integer next) {
        this.next = next;
    }

    public DoublyListNode_Integer getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyListNode_Integer previous) {
        this.previous = previous;
    }
}