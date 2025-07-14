package com.my.company.datastructures.linkedlist.singlylinked.EmployeeList;

public class EmployeeSinglyLinkedList {

    protected Node head;
    protected int size;

    public void prepend(Employee employee) {
        Node node = new Node(employee);
        node.setNext(head);
        head = node;
        size++;
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

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public int getSize() {
        return size;
    }
}
