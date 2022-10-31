package com.my.company.datastructures.hashtables;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
	https://en.wikipedia.org/wiki/Hash_table
	
	https://en.wikipedia.org/wiki/Hash_table#Separate_chaining
 *
 */
public class SimpleHashTable_Chaining {

	private LinkedList<StoredEmployee>[] hashTable;
	
	public SimpleHashTable_Chaining()
	{
		hashTable = new LinkedList[10];
		
		for (int i = 0; i < hashTable.length; i++)
		{
			hashTable[i] = new LinkedList<StoredEmployee>(); 
		}
	}
	
	public void put(String key, Employee employee)
	{
		int hashedKey = hashKey(key);
		
		hashTable[hashedKey].add(new StoredEmployee(key, employee));
	}
	
	public Employee get(String key)
	{
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
		StoredEmployee storedEmployee = null;
		while (iterator.hasNext())
		{
			storedEmployee = iterator.next();
			if (storedEmployee.key.equals(key))
			{
				return storedEmployee.employee;
			}
		}
		
		return null;
	}
	
	public Employee remove(String key)
	{
		int hashedKey = hashKey(key);
		
		ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
		StoredEmployee storedEmployee = null;
		int index = -1;
		while (iterator.hasNext())
		{
			storedEmployee = iterator.next();
			index++;
			if (storedEmployee.key.equals(key))
			{
				break;
			}
		}
		
		if (storedEmployee == null)
		{
			return null;
		}
		else
		{
			hashTable[hashedKey].remove(index);
			return storedEmployee.employee;
		}
	}
	
	public void printHashTable()
	{
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i].isEmpty())
			{
				System.out.println("Position " + i + ": empty");
			}
			else
			{
				System.out.print("Position " + i);
				ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
				while (iterator.hasNext()) {
					System.out.print(" ");
					System.out.print(iterator.next().employee);
					System.out.print(" <->");
				}
				System.out.println(" null");
			}
		}
	}
	
	// hashing function
	private int hashKey(String key)
	{
		// return key.length() % hashTable.length;
		
		return Math.abs(key.hashCode()) % hashTable.length;
	}
	
	public class StoredEmployee
	{
		public String key;
		public Employee employee;
		public StoredEmployee(String key, Employee employee) {
			super();
			this.key = key;
			this.employee = employee;
		}
	}
	
	public class Employee
	{
		private String firstName;
		private String lastName;
		private int id;
		public Employee(String firstName, String lastName, int id) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
		}
	}
}
