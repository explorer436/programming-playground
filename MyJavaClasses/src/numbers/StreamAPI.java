package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
	    System.out.println("original list: " + numbers);	    
		System.out.print("Filter for even numbers : ");
		List<Integer> result = returnEvenNumbersFromAList_Collect(numbers);		
		System.out.println(Arrays.toString(result.toArray()));
		
		System.out.println();
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("1John", 15, "male"));
		people.add(new Person("2Rob", 25, "male"));
		people.add(new Person("3Clark", 35, "male"));
		people.add(new Person("4Trevor", 45, "male"));
		people.add(new Person("5Jane", 15, "female"));
		people.add(new Person("6Gayle", 25, "female"));
		people.add(new Person("7Mary", 35, "female"));
		people.add(new Person("8Sophie", 45, "female"));
		
		printTheNameOfEachPerson_AggregateOperations(people);
		
		System.out.println();
		
		printNamesOfMen_Pipelines(people);
		
		System.out.println();
		
		System.out.println("average age of men : " + getAverageAgeOfMen_TerminalOperator(people));
		
		System.out.println();
		
		System.out.println("sum of ages of males : " + returnSumOfAgesOfMales_Reduce(people));
		
		System.out.println();
		
		System.out.println("average age of men : " + getAverageAgeOfMen_Collect(people));
		
		System.out.println();
		
		System.out.println("names of men : " + Arrays.toString(getNamesOfMen_Collect(people).toArray()));
	}
	
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
	private static void printTheNameOfEachPerson_AggregateOperations(List<Person> people)
	{
		// using a for each loop
		for (Person p : people) {
		    System.out.println(p.getName());
		}
		
		System.out.println();
		
		// using the aggregate operation forEach
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
	 * The terminal operaion is supposed to produce a non-stream result, 
	 * such as a primitive value (like a double value), a collection, or in the case of forEach, no value at all.
	 * In this example, the parameter of the forEach operation is the lambda expression e -> System.out.println(e.getName()), 
	 * which invokes the method getName on the object e. 
	 * (The Java runtime and compiler infer that the type of the object e is Person.)
	 */
	private static void printNamesOfMen_Pipelines(List<Person> people)
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
	private static double getAverageAgeOfMen_TerminalOperator(List<Person> people)
	{
		/*
		The mapToInt operation returns a new stream of type IntStream (which is a stream that contains only integer values). 
		The operation applies the function specified in its parameter to each element in a particular stream. 
		In this example, the function is Person::getAge, which is a method reference that returns the age of the member. 
		(Alternatively, you could use the lambda expression e -> e.getAge().) 
		The mapToInt operation in this example returns a stream that contains the ages of all male members in the collection people.
		*/
		
		/*
		The average operation calculates the average value of the elements contained in a stream of type IntStream. 
		It returns an object of type OptionalDouble. 
		If the stream contains no elements, then the average operation returns an empty instance of OptionalDouble, 
		and invoking the method getAsDouble throws a NoSuchElementException. 
		The JDK contains many terminal operations such as average that return one value by combining the contents of a stream. 
		These operations are called reduction operations; see the section Reduction for more information.
		*/
		
		/*
		The JDK contains many terminal operations (such as average, sum, min, max, and count) that return one value by combining the contents of a stream. 
		These operations are called reduction operations. 
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
	
	
	
	
	
	/**
	 * The Stream.reduce Method :
	 * 
	 * The Stream.reduce method is a general-purpose reduction operation.
	 * 
	 * The reduce operation in this example takes two arguments:
	 * 
	 * 1. identity: 
	 *    The identity element is both the initial value of the reduction and the default result if there are no elements in the stream. 
	 *    In this example, the identity element is 0; 
	 *    this is the initial value of the sum of ages and the default value if no members exist in the collection people.
	 * 
	 * 2. accumulator: 
	 *    The accumulator function takes two parameters: 
	 *    a partial result of the reduction (in this example, the sum of all processed integers so far) and the next element of the stream (in this example, an integer). 
	 *    It returns a new partial result. 
	 *    In this example, the accumulator function is a lambda expression that adds two Integer values and returns an Integer value:
	 *    (a, b) -> a + b
	 * 
	 * The reduce operation always returns a new value. 
	 * However, the accumulator function also returns a new value every time it processes an element of a stream. 
	 * Suppose that you want to reduce the elements of a stream to a more complex object, such as a collection. 
	 * This might hinder the performance of your application. 
	 * 
	 * If your reduce operation involves adding elements to a collection, then every time your accumulator function processes an element, 
	 * it creates a new collection that includes the element, which is inefficient. 
	 * 
	 * It would be more efficient for you to update an existing collection instead. 
	 * You can do this with the Stream.collect method.
	 * 
	 */
	private static Integer returnSumOfAgesOfMales_Reduce(List<Person> people)
	{
		// This does not use reduce.
		Integer totalAgeCalculatedUsingSum = people
			    .stream()
			    .mapToInt(Person::getAge)
			    .sum();
		
		// This uses reduce.
		Integer totalAgeCalculatedUsingReduce = people
				   .stream()
				   .filter(p -> p.getGender().equals("male"))
				   .map(Person::getAge)
				   .reduce(
				       0,
				       (a, b) -> a + b);
		
		return totalAgeCalculatedUsingReduce;
	}
	
	/**
	 * The Stream.collect Method
	 * 
	 * Unlike the reduce method, which always creates a new value when it processes an element, 
	 * the collect method modifies, or mutates, an existing value.
	 * 
	 * Consider how to find the average of values in a stream. 
	 * You require two pieces of data: the total number of values and the sum of those values. 
	 * However, like the reduce method and all other reduction methods, the collect method returns only one value. 
	 * You can create a new data type that contains member variables that keep track of the total number of values and the sum of those values, such as the class, Averager:
	 * @return 
	 */
	private static double getAverageAgeOfMen_Collect(List<Person> people)
	{
		// The following pipeline uses the Averager class and the collect method to calculate the average age of all male members:

		Averager averageCollect = people
									.stream()
									.filter(p -> p.getGender().equals("male"))
									.map(Person::getAge)
									.collect(Averager::new, Averager::accept, Averager::combine);
			                   
		System.out.println("Average age of male members: " + averageCollect.average());
		
		/**
		 * The collect operation in this example takes three arguments:
		 * 
		 * 1. supplier: 
		 *    The supplier is a factory function; it constructs new instances. 
		 *    For the collect operation, it creates instances of the result container. 
		 *    In this example, it is a new instance of the Averager class.
		 *    
		 * 2. accumulator: 
		 *    The accumulator function incorporates a stream element into a result container. 
		 *    In this example, it modifies the Averager result container by incrementing the count variable by one and 
		 *    adding to the total member variable the value of the stream element, which is an integer representing the age of a male member.
		 * 
		 * 3. combiner: 
		 *    The combiner function takes two result containers and merges their contents. 
		 *    In this example, it modifies an Averager result container by incrementing the count variable by the count member variable of the other Averager instance and 
		 *    adding to the total member variable the value of the other Averager instance's total member variable.
		 * 
		 * Note the following:
		 * 
		 * The supplier is a lambda expression (or a method reference) as opposed to a value like the identity element in the reduce operation.
		 * 
		 * The accumulator and combiner functions do not return a value.
		 * 
		 * You can use the collect operations with parallel streams; 
		 * see the section Parallelism for more information. 
		 * (If you run the collect method with a parallel stream, then the JDK creates a new thread whenever the combiner function creates a new object, such as an Averager object in this example. 
		 * Consequently, you do not have to worry about synchronization.)
		 * 
		 */
		
		/**
		 * Although the JDK provides you with the average operation to calculate the average value of elements in a stream, 
		 * you can use the collect operation and a custom class if you need to calculate several values from the elements of a stream.
		 */
			
		return averageCollect.average();
	}
	
	/**
	 * The collect operation is best suited for collections. The following example puts the names of the male members in a collection with the collect operation.
	 * @return 
	 * 
	 */
	private static List<String> getNamesOfMen_Collect(List<Person> people)
	{
		/**
		 * This version of the collect operation takes one parameter of type Collector. 
		 * This class encapsulates the functions used as arguments in the collect operation that requires three arguments (supplier, accumulator, and combiner functions).
		 * 
		 * The Collectors class contains many useful reduction operations, such as accumulating elements into collections and summarizing elements according to various criteria. 
		 * These reduction operations return instances of the class Collector, so you can use them as a parameter for the collect operation.
		 * 
		 * This example uses the Collectors.toList operation, which accumulates the stream elements into a new instance of List. 
		 * As with most operations in the Collectors class, the toList operator returns an instance of Collector, not a collection.
		 * 
		 */
		List<String> namesOfMaleMembersCollect = people
			    .stream()
			    .filter(p -> p.getGender().equals("male"))
			    .map(p -> p.getName())
			    .collect(Collectors.toList());
		
		return namesOfMaleMembersCollect;
	}
	
	/**
	 * Return only even numbers
	 */
	private static List<Integer> returnEvenNumbersFromAList_Collect(List<String> numbers)
	{
		List<Integer> even = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
		
		return even;
	}
	
	private static class Averager implements IntConsumer
	{
	    private int total = 0;
	    private int count = 0;
	        
	    public double average() 
	    {
	        return count > 0 ? ((double) total)/count : 0;
	    }
	        
	    public void accept(int i) 
	    { 
	    	total += i; count++; 
	    }
	    
	    public void combine(Averager other) 
	    {
	        total += other.total;
	        count += other.count;
	    }
	}
	
	private static class Person {

	    public Person(String name, int age, String sex) {
			this.name = name;
			this.age = age;
			this.gender = sex;
		}

		String name;
	    int age;
	    String gender;

	    public int getAge() {
	        return age;
	    }

	    public String getName() {
	        return name;
	    }
	    
	    public String getGender() {
	        return gender;
	    }
	}

}
