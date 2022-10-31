package com.my.company.datastructures.linkedlist.singlyLinkedIntegerList;

public class Node {
	private int number;
	private Node next;
	
	public Node getNext() {
		return next;
	}
	public Node(int number) {
		super();
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
