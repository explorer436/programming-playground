package com.my.company.datastructures.linkedlist.doublylinked;

class DoublyListNode_Integer {
    int val;
    DoublyListNode_Integer next;
    DoublyListNode_Integer prev; // 'prev' pointer for doubly linked list

    DoublyListNode_Integer(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}