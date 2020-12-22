package datastructures.hashtables;

import datastructures.hashtables.SimpleHashTable_Chaining.Employee;

public class ChainingHashTableClient {

	public static void main(String[] args) {
		Employee janeJones = new SimpleHashTable_Chaining().new Employee("Jane", "Jones", 123);
		Employee johnDoe = new SimpleHashTable_Chaining().new Employee("John", "Dow", 4567);
		Employee marySmith = new SimpleHashTable_Chaining().new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new SimpleHashTable_Chaining().new Employee("Mike", "Wilson", 3245);
		
		SimpleHashTable_Chaining ht = new SimpleHashTable_Chaining();
		ht.put("Jones", janeJones);
		ht.put("Dow", johnDoe);
		ht.put("Smith", marySmith);
		ht.put("Wilson", mikeWilson);
				
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
