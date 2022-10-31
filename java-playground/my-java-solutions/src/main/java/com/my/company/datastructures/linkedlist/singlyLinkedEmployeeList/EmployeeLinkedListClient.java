package com.my.company.datastructures.linkedlist.singlyLinkedEmployeeList;

import com.my.company.datastructures.linkedlist.singlyLinkedEmployeeList.EmployeeNode.Employee;

public class EmployeeLinkedListClient {

	public static void main(String[] args) {
		Employee janeJones = new EmployeeNode().new Employee("Jane", "Jones", 123);
		Employee johnDoe = new EmployeeNode().new Employee("John", "Dow", 4567);
		Employee marySmith = new EmployeeNode().new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new EmployeeNode().new Employee("Mike", "Wilson", 3245);
		
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
