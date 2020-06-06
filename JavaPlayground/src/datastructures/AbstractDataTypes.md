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
