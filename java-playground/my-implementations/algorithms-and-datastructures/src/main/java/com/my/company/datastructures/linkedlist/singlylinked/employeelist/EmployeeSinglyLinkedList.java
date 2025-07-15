package com.my.company.datastructures.linkedlist.singlylinked.employeelist;

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
}
