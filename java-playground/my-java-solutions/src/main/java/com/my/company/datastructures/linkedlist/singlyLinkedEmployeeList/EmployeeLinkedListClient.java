package com.my.company.datastructures.linkedlist.singlyLinkedEmployeeList;

public class EmployeeLinkedListClient {

  public static void main(String[] args) {
    Employee janeJones = new Employee("Jane", "Jones", 123);
    Employee johnDoe = new Employee("John", "Dow", 4567);
    Employee marySmith = new Employee("Mary", "Smith", 22);
    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

    EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();
    list.addToFront(janeJones);
    list.addToFront(johnDoe);
    list.addToFront(marySmith);
    list.addToFront(mikeWilson);

    System.out.println("list.getSize() : " + list.getSize());
    list.printList();

    list.removeFromFront();
    System.out.println("list.getSize() : " + list.getSize());
    list.printList();
  }
}
