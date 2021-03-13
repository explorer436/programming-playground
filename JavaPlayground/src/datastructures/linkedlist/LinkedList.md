### Linked lists:


This use of linked lists for building stacks and queues achieves optimum design goals:
■ It can be used for any type of data.
■ The space required is always proportional to the size of the collection.
■ The time per operation is always independent of the size of the collection.

Lets consider the use of a fundamental data structure that is an appropriate choice for representing the data in a collection ADT implementation. 
This is our first example of building a data structure that is not directly supported by the Java
language. Our implementation serves as a model for the code that we use for building
more complex data structures throughout the book, so you should read this section
carefully, even if you have experience working with linked lists.

	Definition. A linked list is a recursive data structure that is either empty (null) or a
	reference to a node having a generic item and a reference to a linked list.
	
The node in this definition is an abstract entity that might hold any kind of data, in ad-
dition to the node reference that characterizes its role in building linked lists. As with a
recursive program, the concept of a recursive data structure can be a bit mindbending
at first, but is of great value because of its simplicity.

#### Node record:
With object-oriented programming, implementing linked lists is not dif-
ficult. We start with a nested class that defines the node abstraction:
	
	private class Node
	{
		Item item;
		Node next;
	}
	
A Node has two instance variables: an Item (a parameterized type) and a Node . We
define Node within the class where we want to use it, and make it private because it
is not for use by clients. As with any data type, we create an object of type Node by in-
voking the (no-argument) constructor with new Node() . The result is a reference to a
Node object whose instance variables are both initialized to the value null . The Item is
a placeholder for any data that we might want to structure with a linked list (we will use
Java’s generic mechanism so that it can represent any reference type); the instance vari-
able of type Node characterizes the linked nature of the data structure. To emphasize
that we are just using the Node class to structure the data, we define no methods and
we refer directly to the instance variables in code: if first is a variable associated with
an object of type Node , we can refer to the instance variables with the code first.item
and first.next . Classes of this kind are sometimes called records. They do not imple-
ment abstract data types because we refer directly to instance variables. However, Node
and its client code are in the same class in all of our implementations and not accessible
by clients of that class, so we still enjoy the benefits of data abstraction.
	
#### Building a linked list:
Now, from the recursive definition, we can represent a linked
list with a variable of type Node simply by ensuring that its value is either null or a ref-
erence to a Node whose next field is a reference to a linked list. For example, to build a
linked list that contains the items to , be , and or , we create a Node for each item:

	Node first = new Node();
	Node second = new Node();
	Node third = new Node();	

and set the item field in each of the nodes to the
desired value (for simplicity, these examples assume
that Item is String ):

	first.item = "to";
	second.item = "be";
	third.item = "or";
	
and set the next fields to build the linked list:

	first.next = second;
	second.next = third;
	
(Note that third.next remains null , the value it
was initialized to at the time of creation.)As a result,
third is a linked list (it is a reference to a node that
has a reference to null , which is the null reference
to an empty linked list), and second is a linked list
(it is a reference to a node that has a reference to
third , which is a linked list), and first is a linked
list (it is a reference to a node that has a reference to
second , which is a linked list). The code that we will
examine does these assignment statements in a dif-
ferent order, depicted in the diagram below.

When tracing code that uses linked lists and other linked structures, we use a visual
representation where
* We draw a rectangle to represent each object
* We put the values of instance variables within the rectangle
* We use arrows that point to the referenced objects to depict references

This visual representation captures the essential characteristic of linked lists. For econ-
omy, we use the term links to refer to node references. For simplicity, when item values
are strings (as in our examples), we put the string within the object rectangle rather
than the more accurate rendition depicting the string object and the character array
that we discussed. This visual representation allows us to focus on the
links.

	Node first = new Node();
	first.item = "to";
	
	first
	  |
	  |      ________
	  ---->	 |to     |
		     ________
			 |null   |
			  _______
			  
	Node second = new Node();
	second.item = "be";
	first.next = second;
	
	          first						second
	            |                        |
	         ________                 ________
	       	 |to     |          ----> |be     |
		     ________          |      ________
			 |       | ---------      |null   |
			  _______                  _______

	Node third = new Node();
	third.item = "or";
	second.next = third;

	          first						second                  third
	            |                        |                        |
	         ________                 ________                 _______
	       	 |to     |          ----> |be     |          ----> |or     |
		     ________          |      ________          |      ________
			 |       | ---------      |       | ---------      |null   |
			  _______                  _______	                _______

A linked list represents a sequence of items. In the example just considered, first
represents the sequence to be or . We can also use an array to represent a sequence of
items. For example, we could use
	
	String[] s = { "to", "be", "or" };
	
to represent the same sequence of strings. The difference is that it is easier to insert
items into the sequence and to remove items from the sequence with linked lists. Next,
we consider code to accomplish these tasks.
	
#### Insert at the beginning

In Linked lists, new Nodes are inserted at the beginning of the linked lists. This is done in constant time since there is no overhead of reshuffling any other nodes. If we want to insert nodes at some position that is not the beginning of the linked list, the time it takes is not linear. Instead, it will get linear depending upon the position at which the node is to be inserted/removed/updated.

First, suppose that you want to insert a new node into a linked list. 
The easiest place to do so is at the beginning of the list. For example, to insert the
string "not" at the beginning of a given linked list whose first node is "first" , we save
"first" in "oldfirst" , assign to "first" a new Node , and assign its item field to "not" and its
"next" field to "oldfirst" . This code for inserting a node at the beginning of a linked list
involves just a few assignment statements, so the amount of time that it takes is inde-
pendent of the length of the list.

save a link to the list:
	
	          first,old first		   second                  third
	            |                        |                        |
	         ________                 ________                 _______
	       	 |to     |          ----> |be     |          ----> |or     |
		     ________          |      ________          |      ________
			 |       | ---------      |       | ---------      |null   |
			  _______                  _______	                _______
			  
create a new node for the beginning:

	first = new Node();

	          first,        old first		   second                  third
	            |              |                  |                        |
	         ________        ________                 ________                 _______
	       	 |       |       |to     |          ----> |be     |          ----> |or     |
		     ________        ________          |      ________          |      ________
			 |       |       |       | ---------      |       | ---------      |null   |
			  _______         _______                  _______	              _______
			  
set the instance variables in the new node:			  

	first.item = "not";
	first.next = oldfirst;

	          first,        old first		   second                  third
	            |              |                  |                        |
	         ________        ________                 ________                 _______
	       	 | not   |   ---> |to     |          ----> |be     |          ----> |or     |
		     ________   |    ________          |      ________          |      ________
			 |       |---    |       | ---------      |       | ---------      |null   |
			  _______         _______                  _______	              _______
			  
#### Remove from the beginning
Next, suppose that you want to remove the first node from a list. 
This operation is even easier: simply assign to first the value first.next. 
Before we do this, we would retrieve the value of
the item (by assigning it to some variable of type Item ) before doing this assignment, because once we change the value of first , we may not have any access to the node to which it was referring. Typically, the node object becomes an orphan, and the Java memory manage-
ment system eventually reclaims the memory it occupies.
Again, this operation just involves one assignment statement, so its running time is
independent of the length of the list.
If we want to insert nodes at some position that is not the beginning of the linked list, the time it takes is not linear. Instead, it will get linear depending upon the position at which the node is to be inserted/removed/updated.

#### Insert at the end
How do we add a node to the end of a linked list? To do so, we need
a link to the last node in the list, because that node’s link has to be changed to refer-
ence a new node containing the item to be inserted. Maintaining an extra link is not
something that should be taken lightly in linked-list code, because every method that
modifies the list needs code to check whether that variable needs to be modified (and
to make the necessary modifications). For
example, the code that we just examined for
removing the first node in the list might in-
volve changing the reference to the last node
in the list, since when there is only one node
in the list, it is both the first one and the last
one! Also, this code does not work (it follows
a null link) in the case that the list is empty.
Details like these make linked-list code noto-
riously difficult to debug.

#### Insert/remove at other positions
In sum-
mary, we have shown that we can implement
the following operations on linked lists with
just a few instructions, provided that we have
access to both a link first to the first ele-
ment in the list and a link last to the last
element in the list:

* Insert at the beginning.
* Remove from the beginning.
* Insert at the end.

Other operations, such as the following, are not so easily handled:

* Remove a given node.
* Insert a new node before a given node.

For example, how can we remove the last node from a list? The link last is no help,
because we need to set the link in the previous node in the list (the one with the same
value as last ) to null . In the absence of any other information, the only solution is to
traverse the entire list looking for the node that links to last. 
Such a solution is undesirable because it takes time proportional to the length
of the list. The standard solution to enable arbitrary insertions and deletions is to use
a doubly-linked list, where each node has two links, one in each direction. 

#### Traversal
To examine every item in an array, we use familiar code like the following
loop for processing the items in an array a[] :

	for (int i = 0; i < N; i++)
	{
		// Process a[i].
	}
	
There is a corresponding idiom for examining the items in a linked list: We initialize a
loop index variable x to reference the first Node of the linked list. Then we find the item
associated with x by accessing x.item , and then update x to refer to the next Node in the
linked list, assigning to it the value of x.next and repeating this process until x is null
(which indicates that we have reached the end of the linked list). This process is known
as traversing the list and is succinctly expressed in code like the following loop for pro-
cessing the items in a linked list whose first item is associated with the variable first :

	for (Node x = first; x != null; x = x.next)
	{
		// Process x.item.
	}
	
This idiom is as natural as the standard idiom for iterating through the items in an ar-
ray. In our implementations, we use it as the basis for iterators for providing client code
the capability of iterating through the items, without having to know the details of the
linked-list implementation.


	
Linked lists are a fundamental alternative to arrays for structuring a collection
of data. From a historical perspective, this alternative has been available to program-
mers for many decades. Indeed, a landmark in the history of programming languages
was the development of LISP by John McCarthy in the 1950s, where linked lists are the
primary structure for programs and data. Programming with linked lists presents all
sorts of challenges and is notoriously difficult to debug, as you can see in the exercises.
In modern code, the use of safe pointers, automatic garbage collection (see page 111), and
ADTs allows us to encapsulate list-processing code in just a few classes such as the ones
presented here.

#### Overview
The implementations of bags, queues, and stacks that support generics
and iteration that we considered in this package provide a level of abstraction that
allows us to write compact client programs that manipulate collections of objects. De-
tailed understanding of these ADTs is important as an introduction to the study of al-
gorithms and data structures for three reasons. 

First, we use these data types as building
blocks in higher-level data structures throughout this book. 

Second, they illustrate the
interplay between data structures and algorithms and the challenge of simultaneously
achieving natural performance goals that may conflict. 

Third, the focus of several of
our implementations is on ADTs that support more powerful operations on collections
of objects, and we use the implementations here as starting points.

#### Data structures
We now have two ways to represent collections of objects, arrays and
linked lists. Arrays are built in to Java; linked lists are easy to build with standard Java
records. These two alternatives, often referred to as sequential allocation and linked al-
location, are fundamental. Later in the book, we develop ADT implementations that
combine and extend these basic structures
in numerous ways. One important extension is to data structures with multiple links. 
For example, our focus in Sections 3.2 and 3.3 is on data structures known as binary trees 
that are built from nodes that each have two links. Another important extension is to compose data structures: 
we can have a bag of stacks, a queue of arrays, and so forth. For example, our focus
in Chapter 4 is on graphs, which we represent as arrays of bags. 
It is very easy to define data structures of arbitrary complexity
in this way: one important reason for our focus on abstract data types is an attempt to
control such complexity.

Our treatment of BAGS, queues, and STACKS in this section is a prototypical ex-
ample of the approach that we use throughout this book to describe data structures
and algorithms. In approaching a new applications domain, we identify computational
challenges and use data abstraction to address them, proceeding as follows:
* Specify an API.
* Develop client code with reference to specific applications.
* Describe a data structure (representation of the set of values) that can serve as
the basis for the instance variables in a class that will implement an ADT that
meets the specification in the API.
* Describe algorithms (approaches to implementing the set of operations) that
can serve as the basis for implementing the instance methods in the class.
* Analyze the performance characteristics of the algorithms.

The difference between Single linked lists and double linked lists is, with double linked lists,
insertion at the beginning or at the end will take constant time. Removing elements from the beginning or from the end will take linear time. We don't have to traverse through the entire linked list because the Node has references to both 'next' and 'previous' nodes.