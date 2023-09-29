package com.my.company.collections;

import java.util.ArrayList;
import java.util.List;

public class StreamAPI {
	
	/**
	 * Differences Between Aggregate Operations and Iterators:
	 * Aggregate operations, like forEach, appear to be like iterators. However, they have several fundamental differences:
	 * 
	 * 1. They use internal iteration: 
	 * Aggregate operations do not contain a method like next to instruct them to process the next element of the collection. 
	 * With internal delegation, your application determines what collection it iterates, 
	 * but the JDK determines how to iterate the collection. 
	 * With external iteration, your application determines both what collection it iterates and how it iterates it. 
	 * However, external iteration can only iterate over the elements of a collection sequentially. 
	 * Internal iteration does not have this limitation. 
	 * It can more easily take advantage of parallel computing, which involves dividing a problem into subproblems, solving those problems simultaneously, 
	 * and then combining the results of the solutions to the subproblems. See the section Parallelism (https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html) for more information.
	 * 
	 * 2. They process elements from a stream: 
	 * Aggregate operations process elements from a stream, not directly from a collection. 
	 * Consequently, they are also called stream operations.
	 * 
	 * 3. They support behavior as parameters: 
	 * You can specify lambda expressions as parameters for most aggregate operations. 
	 * This enables you to customize the behavior of a particular aggregate operation.
	 */
	
	
	
	/**
	 * Aggregate Operations
	 * 
	 */
	public static void printTheNameOfEachPerson_AggregateOperations(List<Person> people)
	{
		System.out.println("using a for each loop");
		for (Person p : people) {
		    System.out.println(p.getName());
		}
		
		System.out.println("using the aggregate operation forEach");
		people
	    .stream()
	    .forEach(e -> System.out.println(e.getName()));
	}
	
	/**
	 * Pipelines
	 * 
	 * A pipeline is a sequence of aggregate operations.
	 * Components in a pipeline :
	 * 1. source, which is a collection (in this example, it is people)
	 * 2. intermediate operations (in this example, filter)
	 * 3. a terminal operation (in this example, foreach)
	 * 
	 * 
	 * The filter operation returns a new stream that contains elements that match its predicate (this operation's parameter).
	 * 
	 * The terminal operation is supposed to produce a non-stream result, 
	 * such as a primitive value (like a double value), a collection, or in the case of forEach, no value at all.
	 * 
	 * In this example, the parameter of the forEach operation is the lambda expression e -> System.out.println(e.getName()), 
	 * which invokes the method getName on the object e. 
	 * (The Java runtime and compiler infer that the type of the object e is Person.)
	 */
	public static void printNamesOfMen_Pipelines(List<Person> people)
	{
		people
	    .stream()
	    .filter(e -> e.getGender().equals("male"))
	    .forEach(e -> System.out.println(e.getName()));
	}
	
	/**
	 * The following example calculates the average age of all male members contained in the collection people 
	 * with a pipeline that consists of the aggregate operations filter, mapToInt, and average.
	 */
	public static double getAverageAgeOfMen_TerminalOperator(List<Person> people)
	{
		/**
		The mapToInt operation returns a new stream of type IntStream (which is a stream that contains only integer values). 
		The operation applies the function specified in its parameter to each element in a particular stream. 
		In this example, the function is Person::getAge, which is a method reference that returns the age of the member. 
		(Alternatively, you could use the lambda expression e -> e.getAge().) 
		The mapToInt operation in this example returns a stream that contains the ages of all male members in the collection people.
		*/
		
		/**
		The average operation calculates the average value of the elements contained in a stream of type IntStream. 
		It returns an object of type OptionalDouble. 
		If the stream contains no elements, then the average operation returns an empty instance of OptionalDouble, 
		and invoking the method getAsDouble throws a NoSuchElementException. 
		The JDK contains many terminal operations such as average that return one value by combining the contents of a stream. 
		These operations are called reduction operations; see the section Reduction for more information.
		*/
		
		/**
		The JDK contains many terminal operations (such as average, sum, min, max, and count) that return one value by combining the contents of a stream. 
		These operations are called reduction operations. 
		Sum, min, max, and average are all special cases of reduction.
		It is not necessary to remember these special cases and implement our own implemetations using reduce function. However, these are handy for simple operations.
		
		The JDK also contains reduction operations that return a collection instead of a single value. 
		Many reduction operations perform a specific task, such as finding the average of values or grouping elements into categories. 
		However, the JDK provides you with the general-purpose reduction operations reduce and collect - which we can use to write custom code.
		*/
		
		double average = people
			    .stream()
			    .filter(p -> p.getGender().equals("male"))
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		return average;
	}
	

}
