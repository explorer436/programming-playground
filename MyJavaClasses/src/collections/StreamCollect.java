package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class StreamCollect {
	
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
		
		System.out.println("average age of men : " + getAverageAgeOfMen_Collect(people));
		
		System.out.println();
		
		System.out.println("names of men : " + Arrays.toString(getNamesOfMen_Collect(people).toArray()));
		
		System.out.println();
		
		System.out.println("printing people grouped by gender : ");
		MapUtils.printMap(groupPeopleByGender(people));
		
		System.out.println();
		
		System.out.println("printing people names by gender : ");
		MapUtils.printMap(groupPersonNamesByGender(people));
		
		System.out.println();
		
		System.out.println("printing total age by gender : ");
		MapUtils.printMap(groupTotalAgeByGender(people));
		
		System.out.println();
		
		System.out.println("printing average age by gender : ");
		MapUtils.printMap(getAverageAgeByGender(people));
		
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
		 *    This is where the accumulated value will be stored.
		 *    
		 * 2. accumulator: 
		 *    The accumulator function incorporates a stream element into a result container. 
		 *    In this example, it modifies the Averager result container by incrementing the count variable by one and 
		 *    adding to the total member variable the value of the stream element, which is an integer representing the age of a male member.
		 *    Accumulating the elements - We need to create a function that defines how we’ll add an element to the result container.
		 *    It doesn’t return anything. It just updates the result container (in this case, Averager) in a mutable way.
		 * 
		 * 3. combiner: 
		 *    The combiner function takes two result containers and merges their contents. 
		 *    In this example, it modifies an Averager result container by incrementing the count variable by the count member variable of the other Averager instance and 
		 *    adding to the total member variable the value of the other Averager instance's total member variable.
		 *    
		 *    This is for combining two partial results.
		 *    In a sequential reduction the supplier and accumulator above would be sufficient. But to be able to support a parallel implementation we need to provide a combiner.
		 *    
		 *    The combiner is a function that defines how two result containers could be combined.
		 *    
		 *    Why?
		 *    
		 *    Because in a parallel scenario our stream would be split into partitions where each partition would be accumulated in parallel. When finished, the results would be merged using our combiner function.
		 *    
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
	 * The groupingBy operation returns a map whose keys are the values that result from applying the lambda expression specified as its parameter (which is called a classification function).
	 * 
	 * GroupingBy collector is used for grouping objects by some property and storing results in a Map instance.
	 */
	
	/**
	 * The following example groups members of the collection people by gender.
	 */
	private static Map<String, List<Person>> groupPeopleByGender(List<Person> people)
	{
		
		/**
		 * In this example, the returned map contains two keys, Person.Sex.MALE and Person.Sex.FEMALE. 
		 * The keys' corresponding values are instances of List that contain the stream elements that, when processed by the classification function, correspond to the key value. 
		 * For example, the value that corresponds to key Person.Sex.MALE is an instance of List that contains all male members.
		 */
		
		Map<String, List<Person>> byGender =
				people
			        .stream()
			        .collect(
			            Collectors.groupingBy(Person::getGender));
		
		return byGender;
	}
	
	/**
	 * The following example retrieves the names of each member in the collection people and groups them by gender.
	 */
	private static Map<String, List<String>> groupPersonNamesByGender(List<Person> people)
	{
		
		/**
		 * The groupingBy operation in this example takes two parameters, a classification function and an instance of Collector. 
		 * The Collector parameter is called a downstream collector. 
		 * This is a collector that the Java runtime applies to the results of another collector. 
		 * Consequently, this groupingBy operation enables you to apply a collect method to the List values created by the groupingBy operator. 
		 * This example applies the collector mapping, which applies the mapping function Person::getName to each element of the stream. 
		 * Consequently, the resulting stream consists of only the names of members. 
		 * A pipeline that contains one or more downstream collectors, like this example, is called a multilevel reduction.
		 */
		Map<String, List<String>> namesByGender =
				people
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			            	Person::getGender,
			            	Collectors.mapping(Person::getName, Collectors.toList())));
		
		return namesByGender;
	}
	
	/**
	 * The following example retrieves the total age of members of each gender.
	 * @return 
	 */
	private static Map<String, Integer> groupTotalAgeByGender(List<Person> people)
	{
		/**
		 * The reducing operation takes three parameters:
		 * 
		 * 1. identity: 
		 *    Like the Stream.reduce operation, the identity element is both the initial value of the reduction and the default result if there are no elements in the stream. 
		 *    In this example, the identity element is 0; 
		 *    this is the initial value of the sum of ages and the default value if no members exist.
		 * 
		 * 2. mapper: 
		 *    The reducing operation applies this mapper function to all stream elements. 
		 *    In this example, the mapper retrieves the age of each member.
		 * 
		 * 3. operation: 
		 *    The operation function is used to reduce the mapped values. 
		 *    In this example, the operation function adds Integer values.
		 */
		
		Map<String, Integer> totalAgeByGender =
				people
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			                Person::getGender,                      
			                Collectors.reducing(
			                    0,
			                    Person::getAge,
			                    Integer::sum)));
		
		return totalAgeByGender;
	}
	
	/**
	 *  The following example retrieves the average age of members of each gender.
	 */
	private static Map<String, Double> getAverageAgeByGender(List<Person> people)
	{
		Map<String, Double> averageAgeByGender = people
			    .stream()
			    .collect(
			        Collectors.groupingBy(
			            Person::getGender,                      
			            Collectors.averagingInt(Person::getAge)));
		
		return averageAgeByGender;
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
	    	total += i; 
	    	count++; 
	    }
	    
	    public void combine(Averager other) 
	    {
	        total += other.total;
	        count += other.count;
	    }
	}
	
	
}
