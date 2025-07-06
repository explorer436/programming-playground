package com.my.company.datastructures.linkedlist.jdk;

import java.util.Iterator;
import java.util.LinkedList;

import com.my.company.datastructures.linkedlist.doublyLinkedEmployeeList.Employee;

public class JdkLinkedListClient {

  public static void main(String[] args) {
    Employee janeJones = new Employee("Jane", "Jones", 123);
    Employee johnDoe = new Employee("John", "Dow", 4567);
    Employee marySmith = new Employee("Mary", "Smith", 22);
    Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

    LinkedList<Employee> list = new LinkedList<>();
    list.addFirst(janeJones);
    list.addFirst(johnDoe);
    list.addFirst(marySmith);
    list.addFirst(mikeWilson);

    printList(list);
    System.out.println("");

    Employee billEnd = new Employee("Bill", "End", 78);
    list.add(billEnd); // adds at the end
    // alternatively, use addLast()
    printList(list);
    System.out.println("");

    list.remove(); // removes from the first.
    // alternatively, use list.removeFirst();
    printList(list);
    System.out.println("");

    list.removeLast();
    printList(list);
    System.out.println("");
  }

  private static void printList(LinkedList<Employee> list) {
    Iterator<Employee> iter = list.iterator();
    System.out.println("HEAD ->");
    while (iter.hasNext()) {
      System.out.println(iter.next());
      System.out.println("<=>");
    }
    System.out.println("null");

    /*
    for (Employee employee: list)
    {
    	System.out.println(employee);
    }
    */
  }
}
