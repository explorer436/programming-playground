package com.my.company.datastructures.hashtables;

import com.my.company.datastructures.hashtables.SimpleHashTable_LinearProbing.Employee;

public class LinearProbingHashTableClient {

	public static void main(String[] args) {
		Employee janeJones = new SimpleHashTable_LinearProbing().new Employee("Jane", "Jones", 123);
		Employee johnDoe = new SimpleHashTable_LinearProbing().new Employee("John", "Dow", 4567);
		Employee marySmith = new SimpleHashTable_LinearProbing().new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new SimpleHashTable_LinearProbing().new Employee("Mike", "Wilson", 3245);
		Employee billEnd = new SimpleHashTable_LinearProbing().new Employee("Bill", "End", 78);
		
		SimpleHashTable_LinearProbing ht = new SimpleHashTable_LinearProbing();
		ht.put("Jones", janeJones);
		ht.put("Dow", johnDoe);
		ht.put("Smith", marySmith);
		ht.put("Wilson", mikeWilson);
		ht.put("End", billEnd);
		
		System.out.println("---------");
		ht.printHashTable();
		
		System.out.println("---------");
		System.out.println(ht.get("Wilson"));
		
		System.out.println("---------");
		System.out.println(ht.get("Smith"));
		
		ht.remove("Wilson");
		ht.remove("Jones");
		System.out.println("---------");
		ht.printHashTable();
		
		System.out.println("---------");
		System.out.println(ht.get("Smith"));

	}

}
