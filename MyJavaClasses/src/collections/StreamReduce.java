package collections;

import java.util.ArrayList;
import java.util.List;

public class StreamReduce {
	
public static void main(String[] args) {
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("1John", 15, "male"));
		people.add(new Person("2Rob", 25, "male"));
		people.add(new Person("3Clark", 35, "male"));
		people.add(new Person("4Trevor", 45, "male"));
		people.add(new Person("5Jane", 15, "female"));
		people.add(new Person("6Gayle", 25, "female"));
		people.add(new Person("7Mary", 35, "female"));
		people.add(new Person("8Sophie", 45, "female"));
		
		System.out.println("sum of ages of males : " + returnSumOfAgesOfMales_Reduce(people));
		
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
	 * The difference between Stream.reduce and Stream.collect is that for collect, we need to pass a third argument called "combiner". 
	 * Stream.reduce does not need a "combiner".
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
}
