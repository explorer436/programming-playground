package com.my.company.datastructures.linkedlist.singlyLinkedIntegerList;

public class SortedIntegerLinkedList {
	
	private Node head;
	
	public void insertSorted(int i)
	{
		// assumption is the list is sorted.
		
		if (head == null)
		{
			Node node = new Node(i);
			head = node;
		}
		else if (head.getNumber() >= i)
		{
			Node node = new Node(i);
			node.setNext(head);
			head = node;
		}
		else
		{
			// head.getNumber() is less than i.
			Node current = head.getNext();
			Node previous = head;
			while (current != null && current.getNumber() < i)
			{
				previous = current;
				current = current.getNext();
			}
			
			// This will cover both current = null scenario and current != null (insert between two existing nodes) scenarios.
			Node node = new Node(i);
			node.setNext(current);
			previous.setNext(node);
		}
	}
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public void printList()
	{
		Node current = head;
		System.out.print("HEAD -> ");
		while (current != null)
		{
			System.out.print(current.getNumber());
			System.out.println(" -> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
}
