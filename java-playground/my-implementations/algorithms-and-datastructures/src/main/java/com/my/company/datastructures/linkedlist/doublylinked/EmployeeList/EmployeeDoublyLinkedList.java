package com.my.company.datastructures.linkedlist.doublylinked.EmployeeList;

public class EmployeeDoublyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public void addToFront(Employee employee) {
        Node node = new Node(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void append(Employee employee) {
        Node node = new Node(employee);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public boolean prepend(Employee newEmployee, Employee existingEmployee) {
        if (head == null) {
            return false;
        } else {
            Node current = head;
            while (current != null && !current.getEmployee().equals(existingEmployee)) {
                current = current.getNext();
            }

            if (current == null) {
                return false;
            } else {
                Node newNode = new Node(newEmployee);
                newNode.setPrevious(current.getPrevious());
                newNode.setNext(current);

                current.setPrevious(newNode);
                if (head == current) {
                    head = newNode;
                } else {
                    newNode.getPrevious().setNext(newNode);
                }

                size++;
                return true;
            }
        }
    }

    public Node removeFromFront() {
        if (isEmpty()) {
            return null;
        } else {
            Node removedNode = head;

            if (head.getNext() == null) {
                tail = null;
            } else {
                head.getNext().setPrevious(null);
            }

            head = head.getNext();
            size--;
            removedNode.setNext(null);

            return removedNode;
        }
    }

    public Node removeFromEnd() {
        if (isEmpty()) {
            return null;
        } else {
            Node removedNode = tail;

            if (tail.getPrevious() == null) {
                head = null;
            } else {
                tail.getPrevious().setNext(null);
            }

            tail = tail.getPrevious();
            size--;
            removedNode.setPrevious(null);

            return removedNode;
        }
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node current = head;
        System.out.print("HEAD -> ");
        System.out.println("");
        while (current != null) {
            System.out.print(current);
            System.out.println(" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
