package datastructures.arrays;

/**
 * 
	Iteration:
	As mentioned earlier in this section, one of the fundamental operations on
	collections is to process each item by iterating through the collection using Java’s foreach
	statement. This paradigm leads to clear and compact code that is free from dependence
	on the details of a collection’s implementation. To consider the task of implementing
	iteration, we start with a snippet of client code that prints all of the items in a collection
	of strings, one per line:
		Stack<String> collection = new Stack<String>();
		...
		for (String s : collection)
		StdOut.println(s);
		...
	Now, this foreach statement is shorthand for a while construct (just like the for state-
	ment itself). It is essentially equivalent to the following while statement:
		Iterator<String> i = collection.iterator();
		while (i.hasNext())
		{
			String s = i.next();
			StdOut.println(s);
		}
	This code exposes the ingredients that we need to implement in any iterable collection:
	■ The collection must implement an iterator() method that returns an
	Iterator object.
	■ The Iterator class must include two methods: hasNext() (which returns a
	boolean value) and next() (which returns a generic item from the collection).
	
	In Java, we use the interface mechanism to express the idea that a class implements
	a specific method. For iterable collections, the necessary interfaces are al-
	ready defined for us in Java. To make a class iterable, the first step is to add the phrase
	implements Iterable<Item> to its declaration, matching the interface
		public interface Iterable<Item>
		{
			Iterator<Item> iterator();
		}
	(which is in java.lang.Iterable ), and to add a method iterator() to the class that
	returns an Iterator<Item>. Iterators are generic, so we can use our parameterized
	type Item to allow clients to iterate through objects of whatever type is provided by our
	client. For the array representation that we have been using, we need to iterate through
	an array in reverse order, so we name the iterator ReverseArrayIterator and add this
	method:
		public Iterator<Item> iterator()
		{
			return new ReverseArrayIterator();
		}
	
	What is an iterator? An object from a class that implements the methods hasNext()
	and next() , as defined in the following interface (which is in java.util.Iterator ):
		public interface Iterator<Item>
		{
			boolean hasNext();
			Item next();
			void remove();
		}
	Although the interface specifies a remove() method, we always use an empty method
	for remove() in this book, because interleaving iteration with operations that modify
	the data structure is best avoided. For ReverseArrayIterator , these methods are all
	one-liners, implemented in a nested class within our stack class:
		private class ReverseArrayIterator implements Iterator<Item>
		{
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
	Note that this nested class can access the instance variables of the enclosing class, in
	this case a[] and N (this ability is the main reason we use nested classes for iterators).
	Technically, to conform to the Iterator specification, we should throw exceptions
	in two cases: an UnsupportedOperationException if a client calls remove() and a
	NoSuchElementException if a client calls next() when i is 0 . Since we only use itera-
	tors in the foreach construction where these conditions do not arise, we omit this code.
	One crucial detail remains: we have to include
		import java.util.Iterator;
	at the beginning of the program because (for historical reasons) Iterator is not part
	of java.lang (even though Iterable is part of java.lang ). Now a client using the
	foreach statement for this class will get behavior equivalent to the common for loop for
	arrays, but does not need to be aware of the array representation (an implementation
	detail). This arrangement is of critical importance for implementations of fundamen-
	tal data types like the collections that we consider in this book and those included in
	Java libraries. For example, it frees us to switch to a totally different representation
	without having to change any client code. More important, taking the client’s point of
	view, it allows clients to use iteration without having to know any details of the class
	implementation.

	See ResizingArrayStack.java
 *
 */
public class ReverseArrayIterator {

	public static void main(String[] args) {

		// TODO

	}

}
