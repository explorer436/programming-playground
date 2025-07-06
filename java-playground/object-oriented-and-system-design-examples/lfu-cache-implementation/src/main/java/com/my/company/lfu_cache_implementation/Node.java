package com.my.company.lfu_cache_implementation;

public class Node
{
	int key;
	int value;

	Node prev;
	Node next;

	int count;

	public Node(int key, int value)
	{
		this.key = key;
		this.value = value;

		// Initial frequency is 1
		count = 1;
	}

}