Reference Objects and Value Types

In Java, two basic types of variables exist: primitive types and reference types. Primitive types
are the standard built-in types we would expect to find in any modern programming language:
int, long, short, byte, char, boolean, void, float, and double. Reference types are any variables that refer to an object.
This is an important distinction, because the two variable types are treated differently in
various situations. All reference type objects are of a specific class, for example.

(Void is a valid return type, even though it technically is not a data type. Variables cannot be declared
as type void. Void is used to denote that a method returns nothing.)

All classes in Java are derived from the root class Object. So, given the rules of inheritance
and polymorphism, an Object class variable can refer to any reference object of any class. In
other words, a widening conversion can take place from any class to Object. Take a look at
the following code, for example:

	String s = new String("Hello World");
	Object o = s;
	
	MyClass m = new MyClass();
	Object o = m;
	
One of Java's strengths is the fact that it uses a polymorphic model 3 wherein all classes are
derived from a common root. All objects share a common base Application Programming
Interface (API). This does not apply to the primitive types, however. The following code doesnot work, for example:

	double d = 3.8;
	Object o = d;	
	
The Java Development Kit (JDK) comes complete with a set of
classes defined by Sun as the core API. All these classes are the Java equivalent of a standard
library. The Java core classes include wrapper classes for all the primitive types: Integer
for int, Double for double, Float for float, and so on. Of course, all these wrapper classes
are derived from the root class Object as well.

One unique case is that of the array. An array can be an array of primitives or an array of
reference types. For the most part, the array itself is treated as a reference type of the Object
class. The individual members, of course, are not treated in any special way. The rule of thumb
is that anything created by the operator new is assignable to Object. So, again, the following
code would work:	

	long 1[10] = new long[10];
	Object o = 1;
	
	Object a[] = new Object[10];
	Object o = a;

What does all this mean in terms of ADTs? Well, if we create a construct that works with
objects of class Object, we can use the construct with any reference type in place of
Object.

Passing Reference and Value Types

When calling a class member function, the developer will pass any required parameters to the
method as arguments to the method call. Suppose that class foo has a member method
declared as the following:

	public int bar( String s, int i )

The caller of the method must supply a String (or an equivalent object that is automatically
convertible to String) and an int to the call, or the compiler will generate an error. The
questions here are, ''What are we passing?" and "What are the consequences of passing any
given parameter type?"

In very oversimplified terms, when a method is called, the system takes the arguments passed
to the method from the calling routine and pushes them on the program stack. The execution
point in the program then is jumped to the beginning of the method's code. The system then pops
the arguments off the stack and uses them as variables of the types declared in the method's 
parameter list. This type of mechanism enables methods to be passed arguments that normally
may be outside the method's scope of visibility. When it is time for the method to return to the
calling routine, it pushes the return value onto the stack. The program then jumps back to the
calling routine and pops the return value back off the stack. For the purposes of this discussion,
it is not important that we know the details of how a stack works. It is enough to know that a
stack is a construct used to store data.

Java uses a mechanism called pass by value to handle argument passing in method calls. This
means that the system makes a copy of the value of the argument and pushes that onto the stack
for the called method to access.

In the following example, the value 4 is passed to the method foo():
	int i = 4;
	foo(i);
	
The method itself has no knowledge of the variable i. Changes made by foo() to the value
passed will have no effect on i from the caller. If 4 is incremented to 5, for example, the value
of i remains 4.

This pass by value approach is relatively straightforward for primitive types. But what about
reference types? Aren't they references to objects? Isn't passing a reference equivalent to
passing the original object itself? To answer these questions, take a closer look at the
relationship between Java objects and the variables that are declared to hold them. Think about
what really is happening in this statement:

	String s = new String("Hello World");	
	
Here, s is a variable of class String. The operator new allocates enough memory for a
String object and calls the constructor for string with the argument "Hello World".
The return value for the operator new is a handle to the newly created String object. A
handle to an object is basically an indicator to a location in memory. You might be familiar
with pointers from the C and C++ programming languages. The handle is similar to a pointer; 
it does "point" to an object. Unlike the more traditional pointers, though, a handle to a Java object
cannot be modified except in the case of assignment to variables. A Java reference variable
can be reassigned to a different object.
	
The implications of the differences between handles and pointers are subtle but important.
When a reference type is passed as an argument to a method, the handle to the object is copied
and passed—not the object itself So, in this code segment, the output would be "Hello":

	String s = new String( "Hello" );
	
	change( s );
	System.out.println( s );
	. . .
	public void change( String t )
	{
		t = new String( "World" );
	}
	
The handle to the object containing "Hello" is passed to change() as String t. t is
reassigned to the new object containing "World", but s remains unchanged. So, on the return
of the function, "World" is left unreferenced, and the memory it occupies eventually is
reclaimed by the garbage collector

So, any handle that we want to be reassigned during a method call must be the return value for
the method, or the handle must be a member of an enclosing or wrapper class.

In the following example, a new string containing "Hello" is created:

	String s = new String("Hello");
	s = s.concat(" World");	
	
When the concat() method then is used, a new string is created in the concat() method
containing "Hello World" and is returned to the calling routine. This new string is
completely unrelated to the original string "Hello". The concat() method is defined to
return a String object.

In the next example, StringWrapper contains as a member field a String object:	
	
	class StringWrapper
	{
		public String s;
	}
	. . .
	changeString( StringWrapper t )
	{
		t.s += " World";
	}
	StringWrapper s = new StringWrapper();
	s.s = "Hello";
	changeString(s);
	
Here, the StringWrapper object is passed as an argument to changeString(), and
StringWrapper.s is reassigned to the new string "Hello World". After returning from
the call to changeString(), the calling routine has access to the new "Hello World"
string. A core class called StringBuffer provides a mutable String class. This class is
much more complete than this simple example here.
	
Summary

• Primitive types and reference types have very different properties.
• All arguments to methods are passed by value in Java. Primitive types pass the value of the
	variable; reference types pass the value of the handle.

	