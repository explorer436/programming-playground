package datastructures.stack;

import java.util.Iterator;

/**
 * 
	This is an implementation of our Stack API that resizes the array, 
    allows clients to make stacks for any type of data, 
    and supports client use of foreach to iterate through the stack items in LIFO order. 
    This implementation is based on Java language nuances involving Iterator and Iterable , 
    but there is no need to study those nuances in detail, 
    as the code itself is not complicated and 
    can be used as a template for other collection implementations.
	
	For example, 
    we can implement the Queue API by maintaining two indices as instance variables, 
    a variable head for the beginning of the queue and a variable tail for the end of the queue. 
    To remove an item, use head to access it and then increment head; 
    to insert an item, use tail to store it, and then increment tail. 
    If incrementing an index brings it past the end of the array, reset it to 0. 
    Developing the details of checking when the queue is empty 
    and when the array is full and needs resizing is 
    an interesting and worthwhile programming exercise (see Exercise 1.3.14).
	
	In the context of the study of algorithms, 
    Algorithm 1.1 is significant because it almost (but not quite) achieves 
    optimum performance goals for any collection implementation:
    
	■ Each operation should require time independent of the collection size.
	■ The space used should always be within a constant factor of the collection size.

	The flaw in ResizingArrayStack is that some push and pop operations require resizing: 
    this takes time proportional to the size of the stack. 
    Next, we consider a way to correct this flaw, 
    using a fundamentally different way to structure data.

 *
 */

// ALGORITHM 1.1 Pushdown (LIFO) stack (resizing array implementation)

/**
 * 
	This generic, iterable implementation of our Stack API is a model for collection ADTs 
	that keep items in an array. 
	It resizes the array to keep the array size within a constant factor of the stack size.
 *
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	private Item[] a = (Item[]) new Object[1]; 
	// stack items
	
	private int N = 0;
	// number of items
	
	public boolean isEmpty()
	{
		return N == 0; 
	}
	
	public int size()
	{
		return N;
	}

	private void resize(int max)
	{ 
		// Move stack to a new array of size max.
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
		{
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void push(Item item)
	{ 
		// Add item to top of stack.
		if (N == a.length) 
		{
			resize(2*a.length);
		}
		a[N++] = item;
	}
	
	public Item pop()
	{ 
		// Remove item from top of stack.
		Item item = a[--N];
		a[N] = null; // Avoid loitering (see text).
		
		if (N > 0 && N == a.length/4) 
		{
			resize(a.length/2);
		}
		return item;
	}
	
	public Iterator<Item> iterator()
	{
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>
	{ 
		// Support LIFO iteration.
		private int i = N;
		public boolean hasNext() 
		{
			return i > 0;
		}
		public Item next()
		{
			return a[--i];
		}
		public void remove() 
		{
		}
	}

}
