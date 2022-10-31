package com.my.company.datastructures.arrays;

/**
 * 
	Array resizing:
	Choosing an array to represent the stack contents 
    implies that clients must estimate the maximum size of the stack ahead of time. 
    In Java, we cannot change the size of an array once created, 
    so the stack always uses space proportional to that maximum. 
    A client that chooses a large capacity risks wasting a large amount of memory at times when 
    the collection is empty or nearly empty. 
    For example, 
    a transaction system might involve billions of items and thousands of collections of them. 
    Such a client would have to allow for the possibility that 
    each of those collections could hold all of those items, 
    even though a typical constraint in such systems is that each item can appear in only one collection. 
    Moreover, every client risks overflow if the collection grows larger than the array. 
    For this reason, push() needs code to test for a full stack,
    and we should have an isFull() method in the API to allow clients to test for that condition. 
    We omit that code, 
    because our desire is to relieve the client from having to deal with the concept of a full stack, 
    as articulated in our original Stack API. 
    Instead, we modify the array implementation to 
    dynamically adjust the size of the array a[] so that 
    it is both sufficiently large to hold all of the items and 
    not so large as to waste an excessive amount of space. 
    Achieving these goals turns out to be remarkably easy. 
    First, we implement a method that moves a stack into an array of a different size:
	
	see resize() below.
	
	Now, in push() , we check whether the array is too small. 
    In particular, we check whether there is room for the new item in the array 
    by checking whether the stack size N is equal to the array size a.length. 
    If there is no room, we double the size of the array.  
    Then we simply insert the new item with the code a[N++] = item , as before:
	
	see push() below.
	
	Similarly, in pop() , we begin by deleting the item, 
    then we halve the array size if it is too large. 
    If you think a bit about the situation, 
    you will see that the appropriate test is 
    whether the stack size is less than one-fourth the array size. 
    After the array is halved, 
    it will be about half full and 
    can accommodate a substantial number of push() and pop() operations 
    before having to change the size of the array again.
	
	see pop() below.

	With this implementation, 
    the stack never overflows and 
    never becomes less than one-quarter full 
    (unless the stack is empty, when the array size is 1). 
    We will address the performance analysis of this approach in more detail later.
 *
 */
public class ArrayResizing<Item> {

	public static void main(String[] args) {

	}
	
	// stack entries
	private Item[] a;

	// size
	private int N;
	
	private void resize(int max)
	{ 
		// Move stack of size N <= max to a new array of size max.
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
		temp[i] = a[i];
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
	
	/**
	 * 
		REMEMBER : 
		Loitering: 
		Java’s garbage collection policy is to 
        reclaim the memory associated with any objects that can no longer be accessed. 
        In our pop() implementations, 
        the reference to the popped item remains in the array. 
        The item is effectively an orphan—it will be never be accessed again—
        but the Java garbage collector has no way to know this until it is overwritten. 
        Even when the client is done with the item, the reference in the array may keep it alive. 
        This condition (holding a reference to an item that is no longer needed) is known as loitering. 
        In this case, loitering is easy to avoid, 
        by setting the array entry corresponding to the popped item to null , 
        thus overwriting the unused reference and making it possible for the system to 
        reclaim the memory associated with the popped item when the client is finished with it.
	 * 
	 */
	public Item pop()
	{
		// Remove item from top of stack.
		Item item = a[--N];
		a[N] = null; 
		
		// Avoid loitering (see text).
		if (N > 0 && N == a.length/4) 
		{
			resize(a.length/2);
		}
		
		return item;
	}

}
