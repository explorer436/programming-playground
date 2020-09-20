package datastructures.heap;

import java.util.PriorityQueue;

/**
 * 
	https://en.wikipedia.org/wiki/Priority_queue
 *
 */
public class PriorityQueueClient {
	
	public static void main(String[] args) {
		
		// This is a min-heap implementation.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(25);
		pq.add(-22);
		pq.add(1343);
		pq.add(54);
		pq.add(0);
		pq.add(-3492);
		pq.add(429);
		
		System.out.println(pq.peek());
		
		// lets you remove random elements in addition to removing the root element.
		pq.remove();
		
		System.out.println(pq.peek());
		
		// same as remove. but it always removes the root element.
		System.out.println(pq.poll());
		
		System.out.println(pq.peek());
		
		System.out.println(pq.remove(54));
		
		System.out.println("--------------");
		Object[] ints = pq.toArray();
		for (Object num : ints)
		{
			System.out.println(num);
		}
		System.out.println("--------------");
		
		System.out.println(pq.peek());
		
		pq.add(-1);
		System.out.println(pq.peek());
	}
}
