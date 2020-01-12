package lru_cache_implementation;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set. get(key) - Get the
 * value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1. set(key, value) - Set or insert the value if the key is
 * not already present. When the cache reached its capacity, it should
 * invalidate the least recently used item before inserting a new item. Analysis
 * 
 * The key to solve this problem is using a double linked list which enables us
 * to quickly move nodes. The LRU cache is a hash table of keys and double
 * linked nodes. The hash table makes the time of get() to be O(1). The list of
 * double linked nodes make the nodes adding/removal operations O(1).
 * 
 * We use two data structures to implement an LRU Cache.
 * 
 * Queue which is implemented using a doubly linked list. The maximum size of
 * the queue will be equal to the total number of frames available (cache
 * size).The most recently used pages will be near front end and least recently
 * pages will be near rear end. A Hash with page number as key and address of
 * the corresponding queue node as value. When a page is referenced, the
 * required page may be in the memory. If it is in the memory, we need to detach
 * the node of the list and bring it to the front of the queue. If the required
 * page is not in the memory, we bring that in memory. In simple words, we add a
 * new node to the front of the queue and update the corresponding node address
 * in the hash. If the queue is full, i.e. all the frames are full, we remove a
 * node from the rear of queue, and add the new node to the front of queue.
 * 
 * Example – Consider the following reference string :
 * 
 * 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 Find the number of page faults using least
 * recently used (LRU) page replacement algorithm with 3 page frames.
 * Explanation –
 * 
 * look at the image in the package
 * 
 */
public class LRUCache
{
	/*
	 * There is only a few details to make it better.
	 * 
	 * 1) When the cache is reaches its max capacity you only remove the end of the
	 * list. You should also remove the entry from the hash table.
	 * 
	 * if(map.size()>=capacity) { map.remove(end.key); remove(end);
	 * setHead(newnode); }
	 * 
	 * 2) Don't forget to update capacity every time you add a new node.
	 */

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
	}

	public int get(int key)
	{
		if (map.containsKey(key))
		{
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void remove(Node n)
	{
		if (n.pre != null)
		{
			n.pre.next = n.next;
		}
		else
		{
			head = n.next;
		}

		if (n.next != null)
		{
			n.next.pre = n.pre;
		}
		else
		{
			end = n.pre;
		}
	}

	public void setHead(Node n)
	{
		n.next = head;
		n.pre = null;

		if (head != null)
			head.pre = n;

		head = n;

		if (end == null)
			end = head;
	}

	public void set(int key, int value)
	{
		if (map.containsKey(key))
		{
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		}
		else
		{
			Node created = new Node(key, value);
			if (map.size() >= capacity)
			{
				map.remove(end.key);
				remove(end);
				setHead(created);

			}
			else
			{
				setHead(created);
			}

			map.put(key, created);
		}
	}
}
