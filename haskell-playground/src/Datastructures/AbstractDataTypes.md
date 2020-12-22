Abstract Data Types - ADTs

What are ADTs? 

To answer this question, we'll take a look at something we already know about: an integer data type. 
Virtually every modern programming language has some representation for an integer type.
In Java, we'll look at the primitive type int. An initialized Java int variable holds a 32-bit
signed integer value between (-2 power 32) and (2 power 32) -1. So, we've established that an int holds data.

Operations can be performed on an int. We can assign a value to an int. We can apply the Java
unary prefix and postfix increment and decrement operators (i++, ++i, i--, --i) to an int. We can use an int in
binary operation expressions, such as addition, subtraction, multiplication, and division. We
can test the value of an int, and we can use an int in an equality expression.

In performing these operations on an int variable, the user does not need to be concerned with
the implementation of the operation. The internal mechanism by which these operations work is
irrelevant. Examine the following simple code fragment, for example:

	int i = 0;
	i++;
	
The user knows that after the second statement is executed, the value of the i variable is 1. It
isn't important to know how the value became 1—just that in performing the increment in this
example, i always will equal 1.

The user also does not need to know how the value is represented and stored internally Things
such as byte order again are irrelevant to the user in the preceding code example.

To summarize the built-in int data type, an int does the following:
• An int holds an item of data.
• Predefined operations can be performed on an int.
• An int has an internal representation that is hidden from the user in performing these operations.

If we consider the primitive data types in this light, it is easy to understand the definition we
will give to ADTs. An ADT is defined as the following:	
• An ADT is an externally defined data type that holds some kind of data. 1
• An ADT has built-in operations that can be performed on it or by it.
• Users of an ADT do not need to have any detailed information about the internal representation 
	of the data storage or implementation of the operations.

So, in effect, an ADT is a data construct that encapsulates the same kinds of functionality that a
built-in type would encapsulate. This does not necessarily imply that ADTs need to have
addition or increment operations in order to be valid or useful, and it does not mean that any of
the built-in operators will work with an ADT. It only means that the appropriate operations for
the type created will be transparently available and that the user does not need to be concerned
with the implementation details.

Why Use Abstract Data Types?

Now that we have some idea of what ADTs are, this section takes a look at why we use them.
The String class provides a mechanism by which string literals may be stored, accessed, 
and manipulated. It provides methods with which we can compare, concatenate, copy, and 
convert strings. If a String class did not exist, string operations would have to be 
implemented from scratch each time they were needed.

A robust and reasonably generic String class gives us the capability to use these string
operations at any time without having to "reinvent the wheel" each time. So ADTs provide us
with code reusability. After we encapsulate the operations required to make a useful String
class, we can reuse those facilities at any time in the future, with little or no additional
development effort.

This also is the case with other ADTs. All ADTs in Java are implemented as classes. 
By designing our ADTs to be as generic as possible, 
we can reuse them in various situations and over several projects. Any time we develop an 
object or a group of related objects that can be reused, we reduce the overall development 
time of a project.

There are certain guidelines that need to be followed to make ADT's reusable. In this book, we
are primarily concerned with container ADTs. A container object's primary purpose is to hold
other objects. The containers we will design and implement in the following chapters will 
hold various types of data.

To make our containers reusable, we need to make them generic. Generic, in this sense,
means that the containers need to follow three rules:

1. Containers need to be able to store data of any kind.
2 Containers should provide a public interface that encompasses only behaviors that would be
useful in a general sense.
3. Containers should be kept insulated from application-specific considerations.

BAGS, QUEUES, AND STACKS (from Algorithms by Robert Sedgewick and Kevin Wayne)

Several fundamental data types involve collections of objects. Specifically, the set
of values is a collection of objects, and the operations revolve around adding, removing, 
or examining objects in the collection. In this section, we consider three such data
types, known as the bag, the queue, and the stack. They differ in the specification of
which object is to be removed or examined next.

Bags, queues, and stacks are fundamental and broadly useful. We use them in implementations 
throughout the book. Beyond this direct applicability, the client and imple-
mentation code in this section serves as an introduction to our general approach to the
development of data structures and algorithms.

One goal of this section is to emphasize the idea that the way in which we represent
the objects in the collection directly impacts the efficiency of the various operations.
For collections, we design data structures for representing the collection of objects that
can support efficient implementation of the requisite operations.

A second goal of this section is to introduce generics and iteration, basic Java con-
structs that substantially simplify client code. These are advanced programming-lan-
guage mechanisms that are not necessarily essential to the understanding of algorithms,
but their use allows us to develop client code (and implementations of algorithms) that
is more clear, compact, and elegant than would otherwise be possible.

A third goal of this section is to introduce and show the importance of linked data
structures. In particular, a classic data structure known as the linked list enables im-
plementation of bags, queues, and stacks that achieve efficiencies not otherwise pos-
sible. Understanding linked lists is a key first step to the study of algorithms and data
structures.

For each of the three types, we consider APIs and sample client programs, then
look at possible representations of the data type values and implementations of the
data-type operations. This scenario repeats (with more complicated data structures)
throughout this book. The implementations here are models of implementations later
in the book and worthy of careful study.

APIs 
As usual, we begin our discussion of abstract data types for collections by de-
fining their APIs, shown below. Each contains a no-argument constructor, a method to
add an item to the collection, a method to test whether the collection is empty, and a
method that returns the size of the collection. Stack and Queue each have a method to
remove a particular item from the collection. Beyond these basics, these APIs reflect two
Java features that we will describe on the next few pages: generics and iterable collections.

Bag
	
	public class Bag<Item> implements Iterable<Item>
	Bag() - create an empty bag
	void add(Item item) - add an item
	boolean isEmpty() - is the bag empty?
	int size() - number of items in the bag

FIFO queue

	public class Queue<Item> implements Iterable<Item>
	Queue() - create an empty queue
	void enqueue(Item item) - add an item
	Item dequeue() - remove the least recently added item
	boolean isEmpty() - is the queue empty?
	int size() - number of items in the queue
	
Pushdown (LIFO) stack

	public class Stack<Item> implements Iterable<Item>
	Stack() - create an empty stack
	void push(Item item) - add an item
	Item pop() - remove the most recently added item
	boolean isEmpty() - is the stack empty?
	int size() - number of items in the stack
	
Generics. 
An essential characteristic of collection ADTs is that we should be able to use
them for any type of data. A specific Java mechanism known as generics, also known
as parameterized types, enables this capability. The impact of generics on the program-
ming language is sufficiently deep that they are not found in many languages (including
early versions of Java), but our use of them in the present context involves just a small
bit of extra Java syntax and is easy to understand. The notation <Item> after the class
name in each of our APIs defines the name Item as a type parameter, a symbolic place-
holder for some concrete type to be used by the client. You can read Stack<Item> as
“stack of items.” When implementing Stack , we do not know the concrete type of Item ,
but a client can use our stack for any type of data, including one defined long after we
develop our implementation. The client code provides a concrete type when the stack
is created: we can replace Item with the name of any reference data type (consistently,
everywhere it appears). This provides exactly the capability that we need. For example,
you can write code such as

	Stack<String> stack = new Stack<String>();
	stack.push("Test");
	...
	String next = stack.pop();
	
to use a stack for String objects and code such as

	Queue<Date> queue = new Queue<Date>();
	queue.enqueue(new Date(12, 31, 1999));
	...
	Date next = queue.dequeue();
	
to use a queue for Date objects. If you try to add a Date (or data of any other type than
String ) to stack or a String (or data of any other type than Date ) to queue , you will
get a compile-time error. Without generics, we would have to define (and implement)
different APIs for each type of data we might need to collect; with generics, we can use
one API (and one implementation) for all types of data, even types that are imple-
mented in the future. As you will soon see, generic types lead to clear client code that is
easy to understand and debug, so we use them throughout this book.

Autoboxing. 
Type parameters have to be instantiated as reference types, so Java has
special mechanisms to allow generic code to be used with primitive types. Recall that
Java’s wrapper types are reference types that correspond to primitive types: Boolean ,
Byte , Character , Double , Float , Integer , Long , and Short correspond to boolean ,
byte , char , double , float , int , long , and short , respectively. Java automatically con-
verts between these reference types and the corresponding primitive types—in assign-
ments, method arguments, and arithmetic/logic expressions. In the present context,
this conversion is helpful because it enables us to use generics with primitive types, as
in the following code:

	Stack<Integer> stack = new Stack<Integer>();
	stack.push(17); // auto-boxing (int -> Integer)
	int i = stack.pop(); // auto-unboxing (Integer -> int)
	
Automatically casting a primitive type to a wrapper type is known as autoboxing, and
automatically casting a wrapper type to a primitive type is known as auto-unboxing.
In this example, Java automatically casts (autoboxes) the primitive value 17 to be of
type Integer when we pass it to the push() method. The pop() method returns an
Integer , which Java casts (auto-unboxes) to an int before assigning it to the variable i .

Iterable collections. For many applications, the client’s requirement is just to process
each of the items in some way, or to iterate through the items in the collection. This
paradigm is so important that it has achieved first-class status in Java and many other
modern languages (the programming language itself has specific mechanisms to sup-
port it, not just the libraries). With it, we can write clear and compact code that is free
from dependence on the details of a collection’s implementation. For example, suppose
that a client maintains a collection of transactions in a Queue , as follows:
	
	Queue<Transaction> collection = new Queue<Transaction>();
	
If the collection is iterable, the client can print a transaction list with a single statement:

	for (Transaction t : collection)
	{ 
		StdOut.println(t);
	}

This construct is known as the foreach statement: you can read the for statement as for
each transaction t in the collection, execute the following block of code. This client code
does not need to know anything about the representation or the implementation of the
collection; it just wants to process each of the items in the collection. The same for loop
would work with a Bag of transactions or any other iterable collection. We could hardly
imagine client code that is more clear and compact. As you will see, supporting this
capability requires extra effort in the implementation, but this effort is well worthwhile.

It is interesting to note that the only differences between the APIs for Stack and
Queue are their names and the names of the methods. This observation highlights the
idea that we cannot easily specify all of the characteristics of a data type in a list of
method signatures. In this case, the true specification has to do with the English-lan-
guage descriptions that specify the rules by which an item is chosen to be removed (or
to be processed next in the foreach statement). Differences in these rules are profound,
part of the API, and certainly of critical importance in developing client code.

Bags. 
A bag is a collection where removing items is not supported—its purpose is to
provide clients with the ability to collect items and then to iterate through the collected
items (the client can also test if a bag is empty and find its number of items). The order
of iteration is unspecified and should be immaterial to the client. To appreciate the con-
cept, consider the idea of an avid marble collector, who might put marbles in a bag, one
at a time, and periodically process all the marbles to look
for one having some particular characteristic. With our 
Bag API, a client can add items to a bag and process them
all with a foreach statement whenever needed. Such a cli-
ent could use a stack or a queue, but one way to emphasize
that the order in which items are processed is immaterial
is to use a Bag . The class Stats at right illustrates a typi-
cal Bag client (TODO - implement it). The task is simply to compute the average
add ( )
and the sample standard deviation of the double values
on standard input. If there are N numbers on standard in-
put, their average is computed by adding the numbers and
dividing by N; their sample standard deviation is comput-
ed by adding the squares of the difference between each
number and the average, dividing by N–1, and taking the
add ( )
square root. The order in which the numbers are consid-
ered is not relevant for either of these calculations, so we
save them in a Bag and use the foreach construct to com-
pute each sum. Note : It is possible to compute the standard
deviation without saving all the numbers (as we did for the
average in Accumulator —see Exercise 1.2.18) (TODO - implement it). Keeping
the all numbers in a Bag is required for more complicated
statistics.

FIFO queues:
A FIFO queue (or just a queue) is a collection that is based on the first-
in-first-out (FIFO) policy. The policy of doing tasks in the same order that they arrive
is one that we encounter frequently in everyday life:
from people waiting in line at a theater, to cars wait-
ing in line at a toll booth, to tasks waiting to be ser-
viced by an application on your computer. One bed-
rock principle of any service policy is the perception
of fairness. The first idea that comes to mind when
most people think about fairness is that whoever
has been waiting the longest should be served first.
That is precisely the FIFO discipline. Queues are a
natural model for many everyday phenomena, and
they play a central role in numerous applications.
When a client iterates through the items in a queue
with the foreach construct, the items are processed
in the order they were added to the queue. A typi-
cal reason to use a queue in an application is to save
items in a collection while at the same time preserv-
ing their relative order : they come out in the same
order in which they were put in. For example, the
client below (TODO : implement) is a possible implementation of the
readDoubles() static method from our In class.
The problem that this method solves for the client
is that the client can get numbers from a file into an
array without knowing the file size ahead of time.
We enqueue the numbers from the file,
use the size() method from Queue to find the size needed for the array, create the ar-
ray, and then dequeue the num-
bers to move them to the array.
A queue is appropriate because
it puts the numbers into the ar-
ray in the order in which they
appear in the file (we might use
a Bag if that order is immateri-
al). This code uses autoboxing
and auto-unboxing to convert
between the client’s double
primitive type and and the
queue’s Double wrapper type.

Pushdown stacks.
A pushdown stack (or just a stack) is 
a collection that is based on the last-in-first-out (LIFO)
policy. When you keep your mail in a pile on your desk,
you are using a stack. You pile pieces of new mail on the
top when they arrive and take each piece of mail from
the top when you are ready to read it. People do not 
process as many papers as they did in the past, but the
same organizing principle underlies several of the ap-
plications that you use regularly on your computer. For
example, many people organize their email as a stack
they push messages on the top when they are received
and pop them from the top when they read them, with
most recently received first (last in, first out). The ad-
vantage of this strategy is that we see interesting email as
soon as possible; the disadvantage is that some old email
might never get read if we never empty the stack. You
have likely encountered another common example of a
stack when surfing the web. When you click a hyperlink,
your browser displays the new page (and pushes onto a
stack). You can keep clicking on hyperlinks to visit new
pages, but you can always revisit the previous page by
clicking the back button (popping it from the stack).
The LIFO policy offered by a stack provides just the be-
havior that you expect. When a client iterates through
the items in a stack with the foreach construct, the items
are processed in the reverse of the order in
which they were added. A typical reason to
use a stack iterator in an application is to save
items in a collection while at the same time
reversing their relative order . For example,
the client Reverse at right (TODO : implement) reverses the or-
der of the integers on standard input, again
without having to know ahead of time how
many there are. The importance of stacks in
computing is fundamental and profound,
as indicated in the detailed example that we
consider next.

See FullyParenthesizedArithmeticExpressionEvaluation.java

Implementing collections To address the issue of implementing Bag , Stack and
Queue , we begin with a simple classic implementation, then address improvements that
lead us to implementations of the APIs articulated above.

See FixedCapacityStackOfStrings.java

Generics:

See FixedCapacityStack.java

Array resizing:

See ArrayResizing.java

Iteration:

See ReverseArrayIterator.java