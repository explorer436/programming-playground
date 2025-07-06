package com.my.company.datastructures.linkedlist.singlyLinkedEmployeeList;

public class EmployeeSinglyLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        } else {
            EmployeeNode removedNode = head;
            head = head.getNext();
            size--;
            removedNode.setNext(null);

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
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.println(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
