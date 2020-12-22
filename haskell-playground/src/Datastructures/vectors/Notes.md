The vector class is a thread-safe array list.

Vectors were a part of JDK since 1.0. ArrayLists were introduced only in JDK 1.2.
What was the need to introduce ArrayLists? ArrayLists are not synchronized. Vectors are synchronized.
Synchronization has an overhead.


A vector is a generic extensible array type.

TODO : Are they used extensively today? This may not be worth too much attention.

#### What Are Vectors?

A vector is a type-safe, dynamic collection class similar to an array with advanced
data-handling features. In a vector, the size of the collection is dynamic. Storage space can be
added or deleted on-the-fly. This allows for efficient memory management on a data set that
can vary in size. The vector also allows the addition, insertion, and deletion of data.

The vector class has three constructors, all of which are public. One of the protected member
fields is capacityIncrement. This member keeps track of how much to grow the
collection when memory needs to be allocated. The parameters to the constructors offer
different levels of control over the initial size and capacityIncrement. The constructors
for the vector class are as follows:

    public Vector(int initialCapacity, int capacityIncrement)
    public Vector(int initialCapacity)
    public Vector()

The first constructor enables the user to set both the initial size of the collection and the
capacityIncrement. The collection size is analogous to the length member in an
array. The second constructor sets the initial size but leaves the capacityIncrement set
as the default. The third constructor sets both the initial size and the capacityIncrement
to the defaults.

The vector class default size is 10. The default capacityIncrement is not a specific
number; instead, it is an algorithm. If no specific capacity increment exists, the vector doubles
the size of the collection every time it runs out of space. This process might seem inefficient,
but it isn't. In most cases, it is very effective as a trade-off between speed and space
management. Now take a closer look at how the vector manages memory.

The vector uses an internal array variable to store the data. As the array runs out of space, a
new array is allocated based on the capacityIncrement. The data from the old array is
copied to the new array, and the new array is assigned to the internal array variable. 
The creation of the new array and the copying are relatively expensive in terms of time. To get the
best possible performance out of a construct such as the vector, you need to minimize the
number of expansions made to the collection. At the same time, to keep resource use to a
minimum, you need to keep the unused storage space in the collection as small as feasible.

If you have a good handle on the data requirements, you can manage the growth of the
collection programmatically. In many cases, though, you will not be able to accurately estimate
the appropriate capacity and increment of the collection. In these cases, the default
capacityIncrement can be very efficient; it is a good trade-off between memory and
speed.

Consider the following scenario. A vector is created with an initial size of 1, and then 100
strings are added to the vector, one by one. Compare the capacity changes in the table below for the
default increment versus an increment of 10.

Vector capacity changes :

| Capacity change iteration | Default increment | Increment of 10  |
| ------------------------- |-------------------| -----------------|
| 0                         | 1                 | 1                |
| 1                         | 2                 | 11               |
| 2                         | 4                 | 21               |
| 3                         | 8                 | 31               |
| 4                         | 16                | 41               |
| 5                         | 32                | 51               |
| 6                         | 64                | 61               |
| 7                         | 128               | 71               |
| 8                         |                   | 81               |
| 9                         |                   | 91               |
| 10                        |                   | 101              |

Using the default capacityIncrement causes a resize only seven times, whereas using an
increment of 10 requires 10 resizes. Here, the trade-off is three less array creations and copies
against the unused space associated with the 28 extra elements that are allocated.

	public final synchronized void copyInto(Object anArray[])
	
The copyInto() method takes an array as an argument and copies the entire contents of the
vector into it, as shown in the preceding code. The collection must be of sufficient size to hold
all the elements in the vector.
	
	public final synchronized void trimToSize()

The trimToSize() method reduces the capacity of the vector to equal the number of
elements contained, as shown in the preceding code. In this scenario, a call totrimToSize() after string 100 is added reduces memory use from 128 strings to 100. This,
of course, involves another iteration of the capacity change. This time, the capacity is reduced
rather than increased.

	public final synchronized void ensureCapacity(int minCapacity)
	
The preceding method checks the length of the internal array against the minCapacity
argument. If the array is of greater or equal length, the method simply returns. If the array is
shorter than the requested capacity, the vector is resized to the minCapacity supplied or to
the next capacityIncrement step, whichever is greater.

	public final synchronized void setSize(int newSize)
	
The setSize() method enables the user to have explicit control over the size of the internal.
Here, the array is set to the specified size, and the data in the original array that was beyond the
new end of the array is truncated.

	public final int capacity()
	
This method returns the current capacity of the vector.

	public final int size()
	
This method returns the current number of used elements in the vector.

	public final boolean isEmpty()
	
This method returns true or false to indicate whether the vector has any elements. This
code is regardless of capacity; it refers strictly to the used elements.

	public final synchronized Enumeration elements()
	
The elements() method returns an enumeration of the elements in the vector. Here,
Enumeration is an interface that allows a single-pass walk-through of a data set. The
Vector class provides its own specialized Enumeration class called
VectorEnumeration. The methods are the standards provided by the interface
declaration; no new methods are defined in VectorEnumeration.

	public final boolean contains(Object elem)
	
The preceding method returns true or false to indicate whether the supplied object is
contained in the array. Here, the object is compared by using the object's equals() method.

	public final int indexOf(Object elem)

Using the same criteria as earlier, indexOf() returns the index of the desired element.

	public final synchronized int indexOf(Object elem, int index)
	
The preceding method differs from the single-parameter version only in the fact that the search
for the object starts at the supplied index instead of zero.

	public final int lastIndexOf(Object elem)

This method performs the indexOf() search backward from the last element in the collection.

	public final synchronized int lastIndexOf(Object elem, int index)

The preceding method is the same, except that the backward search begins at the specified index.
	
	public final synchronized Object elementAt(int index)
	
The elementAt() method is an accessor method that provides the same index reference
functionality as the index operators ([ ]) in an array. The element at the indicated index is
returned. Here, the index must be valid for the current collection, or an exception is thrown.

	public final synchronized Object firstElement()

This method returns the element at the zero index.

	public final synchronized Object lastElement()
	
This method returns the last element in the collection.

	public final synchronized void setElementAt(Object obj, int index)

This method enables the user to substitute a new object for the object contained in the element
indicated. Here, the index must be valid for the current collection, or an exception is thrown.

	public final synchronized void removeElementAt(int index)

This method enables the user to delete an element from the collection at the specified index.
Here, the index must be valid for the current collection, or an exception is thrown.

	public final synchronized void insertElementAt(Object obj, int index)

This method enables the user to insert an element at the specified index. Here, the index can be
anywhere from zero to the number of elements. This enables the insertElementAt()
method to be used also as an append operation (the last element in the list is indexed at one
less than the number of elements-N-l). The list is checked for available space and expanded as
necessary according to the incrementCapacity setting.

	public final synchronized void addElement(Object obj)
	
The addElement() method appends the new object to the end of the collection. The list is
checked for available space and expanded as necessary.

	public final synchronized boolean removeElement(Object obj)

The preceding method removes the element from the collection that matches the specifiedobject. 
Here, the indexOf() method is used to find the first occurrence of the object in the
collection, and that element is removed using the removeElementAt() method.

	public final synchronized void removeAllElements()
	
This method empties the collection of elements. Each element, in turn, is set to null, and the
element count is reset to zero.	

	public synchronized Object clone()
The clone method creates a copy of the vector object, not the elements. Here, the internal
array is copied to a new Vector object, which then is returned. The vector is defined to
implement the clonable interface; therefore, this method must be supported.

	public final synchronized String toString()

This method generates and returns a string representation of the Vector object.

Only three instance variables are defined in the Vector class:

	protected Object elementData[];
	protected int elementCount;
	protected int capacityIncrement;
	
All three variables are declared to be protected so that they are available to subclasses but not
the general public. elementData is a generic Object array handle that holds the internal
array storage for the collection. The elementCount member field is self-explanatory, and
capacityIncrement was covered earlier.

#### Vectors Versus Arrays:

In many cases, a vector and an array may be used interchangeably. Generally, though, one is
preferred over the other for any given circumstance. As a good general rule of thumb, we
would use an array anytime the collection meets the following conditions:

• All elements of the collection are of the same type (especially the primitive types).
• The collection is a known, fixed size or maximum size.
• The collection is a non-sorted data set (data is not inserted into the collection).

If any of these conditions are not met, it might be better to use a vector object. Generally, the
choice is pretty clear. If it necessary to manipulate the storage of the data, regardless of
whether the data itself is manipulated, it probably is better to use a vector instead of an array.
The advantages of the vector are mainly the fact that the collection is of a dynamic size and that
methods are available to manipulate the storage.

If we want to perform an insert into an array, assuming that we have space for the additional
member, we would have to do something along these lines:

	System.arrayCopy( myArray, insertPosition, myArray, insertPosition + 1, array.length - insertPosition );
	myArray[insertPosition] = newElement;

This is basically what the vector's insertElementAt() method does.

The advantages of using an array are speed, easy access, and reduced overhead. As mentioned
earlier, the vector's capability to expand as necessary comes with the price of creating and
copying the collection to the new internal array. By allocating all the memory needed for the
array at one time, these time-consuming operations are eliminated. Each access to an element in
a vector also requires a method call, which is avoided by the simple index notation an array
uses for element access.

The advantages of a vector are flexibility and control. The methods available in the vector
enable the programmer to manipulate the collection at will. It is a simple matter to insert or
move an element in the collection.

#### Extending the Vector

In the Java Vector class, most of the methods are defined as final; this prohibits us from
modifying the behavior of the class by preventing us from overriding the methods. This
restriction also speeds up the performance of the Vector class.

The vector's instance variables are declared as protected, though. Protected access to the
variables enables us to extend the functionality of the vector by allowing the subclass access to
the internal data representation of the class. So, in effect, even though the core functionality of
the class cannot be changed because of the final methods, the class may be extended at will by 
adding functionality to the class.

Any kind of functionality can be added to the class as long as we don't need to change the
behavior of any of the existing methods. In the next section, we'll take a look at extending the
vector by adding the capability to sort the elements in the collection.
