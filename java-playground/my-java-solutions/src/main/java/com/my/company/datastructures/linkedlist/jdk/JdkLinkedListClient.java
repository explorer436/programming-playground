package com.my.company.datastructures.linkedlist.jdk;

import java.util.Iterator;
import java.util.LinkedList;

import com.my.company.datastructures.linkedlist.doublyLinkedEmployeeList.EmployeeNode;
import com.my.company.datastructures.linkedlist.doublyLinkedEmployeeList.EmployeeNode.Employee;

public class JdkLinkedListClient {

	public static void main(String[] args) {
		Employee janeJones = new EmployeeNode().new Employee("Jane", "Jones", 123);
		Employee johnDoe = new EmployeeNode().new Employee("John", "Dow", 4567);
		Employee marySmith = new EmployeeNode().new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new EmployeeNode().new Employee("Mike", "Wilson", 3245);
		
		LinkedList<Employee> list = new LinkedList<>();
		list.addFirst(janeJones);
		list.addFirst(johnDoe);
		list.addFirst(marySmith);
		list.addFirst(mikeWilson);
		
		printList(list);
		System.out.println("");
		
		Employee billEnd = new EmployeeNode().new Employee("Bill", "End", 78);
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
		while (iter.hasNext())
		{
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
