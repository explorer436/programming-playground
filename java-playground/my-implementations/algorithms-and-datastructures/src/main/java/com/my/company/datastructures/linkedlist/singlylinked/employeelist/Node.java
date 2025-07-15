package com.my.company.datastructures.linkedlist.singlylinked.employeelist;

public class Node {

    private Employee employee;
    private Node next;

    public Node(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
