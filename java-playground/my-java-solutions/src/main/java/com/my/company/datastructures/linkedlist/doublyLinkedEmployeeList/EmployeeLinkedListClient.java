package com.my.company.datastructures.linkedlist.doublyLinkedEmployeeList;

import com.my.company.datastructures.linkedlist.doublyLinkedEmployeeList.EmployeeNode.Employee;

public class EmployeeLinkedListClient {

    public static void main(String[] args) {
        Employee janeJones = new EmployeeNode().new Employee("Jane", "Jones", 123);
        Employee johnDoe = new EmployeeNode().new Employee("John", "Doe", 4567);
        Employee marySmith = new EmployeeNode().new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new EmployeeNode().new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println("list.getSize() : " + list.getSize());
        list.printList();

        Employee billEnd = new EmployeeNode().new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);

        System.out.println("list.getSize() : " + list.getSize());
        list.printList();

        list.removeFromFront();
        System.out.println("list.getSize() : " + list.getSize());
        list.printList();

        list.removeFromEnd();
        System.out.println("list.getSize() : " + list.getSize());
        list.printList();

        Employee jamesBond = new EmployeeNode().new Employee("James", "Bond", 007);
        list.addBefore(jamesBond, johnDoe);
        list.printList();
    }
}
