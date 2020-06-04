package lru_cache_implementation;

public class Node
{
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value)
	{
		this.key = key;
		this.value = value;
	}
}