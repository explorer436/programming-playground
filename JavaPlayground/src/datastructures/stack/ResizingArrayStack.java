package datastructures.stack;

import java.util.Iterator;

/**
 * 
	This is an implementation of our Stack API that resizes the array, allows
	clients to make stacks for any type of data, and supports client use of foreach to iterate
	through the stack items in LIFO order. This implementation is based on Java language
	nuances involving Iterator and Iterable , but there is no need to study those nuances
	in detail, as the code itself is not complicated and can be used as a template for other
	collection implementations.
	
	For example, we can implement the Queue API by maintaining two indices as in-
	stance variables, a variable head for the beginning of the queue and a variable tail for
	the end of the queue. To remove an item, use head to access it and then increment head ;
	to insert an item, use tail to store it, and then increment tail . If incrementing an
	index brings it past the end of the array, reset it to 0. Developing the details of checking
	when the queue is empty and when the array is full and needs resizing is an interesting
	and worthwhile programming exercise (see Exercise 1.3.14).
	
	In the context of the study of algorithms, Algorithm 1.1 is significant because
	it almost (but not quite) achieves optimum performance goals for any collection
	implementation:
	■ Each operation should require time independent of the collection size.
	■ The space used should always be within a constant factor of the collection size.
	The flaw in ResizingArrayStack is that some push and pop operations require resiz-
	ing: this takes time proportional to the size of the stack. Next, we consider a way to cor-
	rect this flaw, using a fundamentally different way to structure data.

 *
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {

	@Override
	public Iterator<Item> iterator() {
		// TODO Implement
		return null;
	}

	

}
