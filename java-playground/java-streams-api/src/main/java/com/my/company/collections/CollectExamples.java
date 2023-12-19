package com.my.company.collections;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExamples {

	public static void main(String[] args) {

		List<String> givenList = Arrays.asList("a", "bb", "bb", "ccc", "ccc", "ccc", "dddd", "dddd", "dddd");

		System.out.println("List converted to Array : " + Arrays.toString(collect_ToList_WithoutMapOrFilter(givenList).toArray())); // [a, bb, ccc, dd]

		System.out.println("List converted to Set : " + Arrays.toString(collect_ToSet_WithoutMapOrFilter(givenList).toArray())); // [bb, dd, a, ccc]

		System.out.println("List converted to LinkedList : " + Arrays.toString(collect_ToLinkedList_WithoutMapOrFilter(givenList).toArray())); // [a, bb, ccc, dd]

		System.out.println("List converted to ArrayList : " + Arrays.toString(collect_ToArrayList_WithoutMapOrFilter(givenList).toArray())); // [a, bb, ccc, dd]

		System.out.println("List converted to Map : " + collect_ToMap_HandleKeyCollisions(givenList));        // {dd=2, bb=2, a=1, ccc=3}
		System.out.println("List converted to Map - result class : " + collect_ToMap_HandleKeyCollisions(givenList).getClass()); // class java.util.HashMap

		System.out.println("List converted to ConcurrentHashMap : " + collect_ToMap_ConcurrentHashMap(givenList));        // {bb=2, dd=2, a=1, ccc=3}
		System.out.println("List converted to ConcurrentHashMap - result class : " + collect_ToMap_ConcurrentHashMap(givenList).getClass()); // class java.util.concurrent.ConcurrentHashMap

		System.out.println("List converted to SortedMap : " + collect_ToMap_sortedMap(givenList));        // {a=1, bb=2, ccc=3, dd=2}
		System.out.println("List converted to SortedMap - result class : " + collect_ToMap_sortedMap(givenList).getClass()); // class java.util.TreeMap

		System.out.println("result of joining : " + collect_Joining(givenList)); // abbcccdd

		System.out.println("result of joining with custom separators : " + collect_Joining_CustomSeparators(givenList)); // a bb ccc dd

		System.out.println("result of joining with custom separators with count inserted : " + collect_Joining_CustomSeparators_NumberedList(givenList)); // a bb ccc dd

		System.out.println("result of joining with pre and post : " + collect_JoiningWithPreAndPost(givenList)); // PRE-a bb ccc dd-POST

		System.out.println("result of collect and count : " + collect_Counting(givenList)); // 4

		System.out.println("result of collect and average double : " + collect_AveragingDouble(givenList)); // 2.0

		System.out.println("result of collect and summing double : " + collect_SummingDouble(givenList)); // 8.0

		Optional<String> maxBy = collect_MaxBy(givenList);
		if (maxBy.isPresent()) {
			System.out.println("result of collect and max by : " + maxBy); // Optional[dd]
		}

		Optional<String> minBy = collect_MinBy(givenList);
		if (minBy.isPresent()) {
			System.out.println("result of collect and max by : " + minBy); // Optional[a]
		}

		/**
		 * How to use pairs to check if the elements of a list meet certain criteria?
		 * This can help with the following items:
		 * 1. Do not use comma or hyphen delimited elements in the list.
		 * 2. Don't have to build maps because maps do not allow duplicates for keys.
		 */
		List<ImmutablePair<String, String>> list = new ArrayList<>();
		list.add(new ImmutablePair<>("1", "person with rank 1"));
		list.add(new ImmutablePair<>("1", "another person with rank 1"));
		list.add(new ImmutablePair<>("3", "person with rank 3"));
		list.add(new ImmutablePair<>("4", "person with rank 4"));
		list.add(new ImmutablePair<>("5", "person with rank 5"));
		list.add(new ImmutablePair<>("5", "another person with rank 5"));

		System.out.println("Do all pairs in list meet the criteria : " + list_AllMatch(list));

		Map<String, Boolean> myMap = new HashMap<>();
		myMap.put("A", true);
		myMap.put("B", true);
		myMap.put("C", false);
		myMap.put("D", true);
		myMap.put("E", true);

		System.out.println("Do all the values in the map meet the criteria : " + map_AllMatch(myMap));

	}

	private static boolean list_AllMatch(List<ImmutablePair<String, String>> list) {
		// if any of the pairs in the input list does not meet this criteria, this would return false.
		return list.stream().allMatch(pair -> {
			// some business functionality like calling a DAO layer with the value in each pair in the input list
			return true;
		});
	}

	private static boolean map_AllMatch(Map<String, Boolean> myMap) {
		// if any of the values in the input map does not meet this criteria, this would return false.
		return myMap.values().stream().allMatch((value) -> {
			// some business functionality like calling a DAO layer with the value in each pair in the input list
			return value;
		});
	}
	
	/**
	 * Return only even numbers
	 */
	public static List<Integer> map_Filter_Collect_ToList(List<String> numbers)
	{
		List<Integer> even = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
		
		return even;
	}
	
	/**
	 * ToList collector can be used for collecting all Stream elements into a List instance. 
	 * The important thing to remember is the fact that we can't assume any particular List implementation with this method. 
	 * If you want to have more control over this, use toCollection instead.
	 * 
	 */
	public static List<String> collect_ToList_WithoutMapOrFilter(List<String> givenList)
	{
		List<String> result = givenList.stream().collect(Collectors.toList());
		
		return result;
		
	}
	
	/**
	 * ToSet collector can be used for collecting all Stream elements into a Set instance. 
	 * The important thing to remember is the fact that we can't assume any particular Set implementation with this method. 
	 * If we want to have more control over this, we can use toCollection instead.
	 */
	public static Set collect_ToSet_WithoutMapOrFilter(List<String> givenList)
	{
		Set<String> result = givenList.stream().collect(Collectors.toSet());
		
		return result;
		
	}
	
	/**
	 * As you probably already noticed, when using toSet and toList collectors, you can't make any assumptions of their implementations. 
	 * If you want to use a custom implementation, you will need to use the toCollection collector with a provided collection of your choice.
	 * 
	 */
	public static List<String> collect_ToArrayList_WithoutMapOrFilter(List<String> givenList)
	{
		List<String> result = givenList.stream()
				  .collect(Collectors.toCollection(ArrayList::new));
		
		return result;
		
	}
	
	/**
	 * As you probably already noticed, when using toSet and toList collectors, you can't make any assumptions of their implementations. 
	 * If you want to use a custom implementation, you will need to use the toCollection collector with a provided collection of your choice.
	 * 
	 */
	public static List<String> collect_ToLinkedList_WithoutMapOrFilter(List<String> givenList)
	{
		List<String> result = givenList.stream()
				  .collect(Collectors.toCollection(LinkedList::new));
		
		return result;
		
	}
	
	/**
	 * ToMap collector can be used to collect Stream elements into a Map instance. To do this, we need to provide two functions:
	 * 
	 * 1. keyMapper - keyMapper will be used for extracting a Map key from a Stream element
	 * 2. valueMapper - valueMapper will be used for extracting a value associated with a given key
	 * 
	 * Let's collect those elements into a Map that stores strings as keys and their lengths as values.
	 * 
	 * Function.identity() is just a shortcut for defining a function that accepts and returns the same value.
	 * 
	 * What happens if our collection contains duplicate elements?
	 * If it sees duplicate keys, it immediately throws an IllegalStateException.
	 * 
	 * By default, a toMap() method will return a HashMap.
	 * 
	 */
	public static Map<String, Integer> collect_ToMap_HandleKeyCollisions(List<String> givenList)
	{
		/* Map<String, Integer> result = givenList.stream()
				  .collect(Collectors.toMap(Function.identity(), String::length));*/
		
		/**
		 * For cases with key collision, we should use toMap with another signature.
		 * 
		 * The third argument here is a BinaryOperator, where we can specify how we want collisions to be handled.
		 * 
		 * In this example, we'll just pick any of these two colliding values because we know that the same strings will always have the same lengths, too.
		 */
		Map<String, Integer> result = givenList.stream()
				  .collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
		
		// We can write a custom implementation for this instead of using just picking the first element that matches the criteria.
		
		return result;
	}
	
	/**
	 * Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper,
	 * Function<? super T, ? extends U> valueMapper,
	 * BinaryOperator<U> mergeFunction,
	 * Supplier<M> mapSupplier)
	 * 
	 */
	public static Map<String, Integer> collect_ToMap_ConcurrentHashMap(List<String> givenList)
	{
		/**
		 * The fourth parameter, the mapSupplier is a function that returns a new, empty Map with the results.
		 */
		
		Map<String, Integer> result = givenList.stream()
				  .collect(Collectors.toMap(
						  Function.identity(), String::length, (item, identicalItem) -> item, ConcurrentHashMap::new));
		
		return result;
		
	}
	
	public static Map<String, Integer> collect_ToMap_sortedMap(List<String> givenList)
	{
		/**
		 * Using a sorted map.
		 * 
		 * In this instance, TreeMap.
		 */
		
		Map<String, Integer> result = givenList.stream()
				  .collect(Collectors.toMap(
						  Function.identity(), String::length, (item, identicalItem) -> item, TreeMap::new));
		
		return result;
		
	}
	
	/**
	 * CollectingAndThen is a special collector that allows performing another action on a result straight after collecting ends.
	 */
	/*public static void collectingAndThen(List<String> givenList)
	{
		// Let's collect Stream elements to a List instance and then convert the result into an ImmutableList instance.
		List<String> result = givenList.stream()
				  .collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
	}*/
	
	/**
	 * Joining collector can be used for joining Stream<String> elements.
	 */
	public static String collect_Joining(List<String> givenList)
	{
		String result = givenList.stream()
				  .collect(Collectors.joining());
		
		return result;
	}
	
	public static String collect_Joining_CustomSeparators(List<String> givenList)
	{
		String result = givenList.stream()
				  .collect(Collectors.joining(", "));
		
		return result;
	}

	public static String collect_Joining_CustomSeparators_NumberedList(List<String> givenList)
	{
		ArrayList<String> inputList = new ArrayList<>(givenList);

		for (int i=0;i<inputList.size();i++){
			inputList.set(i, i + 1 + ". " + inputList.get(i));
		}
		String result = inputList.stream()
				.collect(Collectors.joining(", ", "This list has the following elements - ", ""));

		return result;
	}
	
	public static String collect_JoiningWithPreAndPost(List<String> givenList)
	{
		String result = givenList.stream()
				  .collect(Collectors.joining(", ", "PRE-", "-POST"));
		
		return result;
	}
	
	/**
	 * Counting is a simple collector that allows simply counting of all Stream elements.
	 */
	public static Long collect_Counting(List<String> givenList)
	{
		Long result = givenList.stream()
				  .collect(Collectors.counting());
		
		return result;
	}
	
	/**
	 * SummarizingDouble/Long/Int is a collector that returns a special class containing statistical information about numerical data in a Stream of extracted elements.
	 */
	public static DoubleSummaryStatistics collect_SummarizingDouble(List<String> givenList)
	{
		// We can obtain information about string lengths by doing
		DoubleSummaryStatistics result = givenList.stream()
				  .collect(Collectors.summarizingDouble(String::length));
		
		return result;
	}
	
	/**
	 * AveragingDouble/Long/Int is a collector that simply returns an average of extracted elements.
	 */
	public static Double collect_AveragingDouble(List<String> givenList)
	{
		// We can get average string length by doing
		Double result = givenList.stream()
				  .collect(Collectors.averagingDouble(String::length));
		
		return result;
	}
	
	/**
	 * SummingDouble/Long/Int is a collector that simply returns a sum of extracted elements.
	 */
	public static Double collect_SummingDouble(List<String> givenList)
	{
		// We can get a sum of all string lengths by doing
		Double result = givenList.stream()
				  .collect(Collectors.summingDouble(String::length));
		
		return result;
	}
	
	/**
	 * MaxBy/MinBy collectors return the biggest/the smallest element of a Stream according to a provided Comparator instance.
	 */
	public static Optional<String> collect_MaxBy(List<String> givenList)
	{
		// We can pick the biggest element by doing
		Optional<String> result = givenList.stream()
				  .collect(Collectors.maxBy(Comparator.naturalOrder()));
		
		// Notice that returned value is wrapped in an Optional instance. This forces users to rethink the empty collection corner case.
		
		return result;
	}
	
	public static Optional<String> collect_MinBy(List<String> givenList)
	{
		// We can pick the biggest element by doing
		Optional<String> result = givenList.stream()
				  .collect(Collectors.minBy(Comparator.naturalOrder()));
		
		// Notice that returned value is wrapped in an Optional instance. This forces users to rethink the empty collection corner case.
		
		return result;
	}
	
	/**
	 * GroupingBy collector is used for grouping objects by some property and storing results in a Map instance.
	 * 
	 */
	public static Map<Integer, Set<String>> collect_groupingByStringLength(List<String> givenList)
	{
		// We can group them by string length and store grouping results in Set instances
		
		// Notice that the second argument of the groupingBy method is a Collector and you are free to use any Collector of your choice.
		Map<Integer, Set<String>> result = givenList.stream()
				  .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		
		return result;
	}
	
	/**
	 * PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance and 
	 * collects Stream elements into a Map instance that stores Boolean values as keys and collections as values. 
	 * Under the "true" key, you can find a collection of elements matching the given Predicate, 
	 * and under the "false" key, you can find a collection of elements not matching the given Predicate.
	 * @return 
	 * 
	 */
	
	public static Map<Boolean, List<String>> collect_partitioningByStringLength(List<String> givenList)
	{
		Map<Boolean, List<String>> result = givenList.stream()
				  .collect(Collectors.partitioningBy(s -> s.length() > 2));
		
		return result;
	}

}
