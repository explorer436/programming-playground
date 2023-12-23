package com.my.company.datastructures.streamsapi;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {

  public static void main(String[] args) {

    int[] A = new int[] {1, 2, 3, 4, 5};
    System.out.println(
        "sum of all elements of the array "
            + Arrays.toString(A)
            + " is : "
            + getSumOfAllElementsOfArray(A));
    System.out.println(
        "product of all elements of the array "
            + Arrays.toString(A)
            + " is : "
            + getProductOfAllElementsOfArray(A));
  }

  /**
   * The Stream.reduce Method :
   *
   * <p>The Stream.reduce method is a general-purpose reduction operation.
   *
   * <p>The reduce operation in this example takes two arguments:
   *
   * <p>1. identity: The identity element is both the initial value of the reduction and the default
   * result if there are no elements in the stream. In this example, the identity element is 0; this
   * is the initial value of the sum of ages and the default value if no members exist in the
   * collection people.
   *
   * <p>2. accumulator: The accumulator function takes two parameters: a partial result of the
   * reduction (in this example, the sum of all processed integers so far) and the next element of
   * the stream (in this example, an integer). It returns a new partial result. In this example, the
   * accumulator function is a lambda expression that adds two Integer values and returns an Integer
   * value: (a, b) -> a + b
   *
   * <p>The reduce operation always returns a new value. However, the accumulator function also
   * returns a new value every time it processes an element of a stream. Suppose that you want to
   * reduce the elements of a stream to a more complex object, such as a collection. This might
   * hinder the performance of your application.
   *
   * <p>If your reduce operation involves adding elements to a collection, then every time your
   * accumulator function processes an element, it creates a new collection that includes the
   * element, which is inefficient.
   *
   * <p>It would be more efficient for you to update an existing collection instead. You can do this
   * with the Stream.collect method.
   *
   * <p>The difference between Stream.reduce and Stream.collect is that for collect, we need to pass
   * a third argument called "combiner". Stream.reduce does not need a "combiner".
   */
  public static Integer returnSumOfAgesOfMales_Reduce(List<Person> people) {
    // This does not use reduce.
    Integer totalAgeCalculatedUsingSum = people.stream().mapToInt(Person::getAge).sum();

    // This uses reduce.
    Integer totalAgeCalculatedUsingReduce =
        people.stream()
            .filter(p -> p.getGender().equals("male"))
            .map(Person::getAge)
            .reduce(0, (a, b) -> a + b);

    return totalAgeCalculatedUsingReduce;
  }

  public static int getSumOfAllElementsOfArray(int[] A) {
    /*
     * boxed -
     * Returns a Stream consisting of the elements of this stream, each boxed to an Integer.
     * This is an intermediate operation.
     */
    Integer sumOfAllElementsOfArray = Arrays.stream(A).boxed().reduce(0, (a, b) -> a + b);

    return sumOfAllElementsOfArray;
  }

  public static int getMaxElementInIntArray(int[] A) {
    return Arrays.stream(A).max().getAsInt();
  }

  public static int getMinElementInIntArray(int[] A) {
    return Arrays.stream(A).min().getAsInt();
  }

  public static int getProductOfAllElementsOfArray(int[] A) {
    Integer sumOfAllElementsOfArray = Arrays.stream(A).boxed().reduce(1, (a, b) -> a * b);

    return sumOfAllElementsOfArray;
  }

  /** Note : Look at GCDOfNumbersInAnArray.getGcd() Note : Look at LCMOfNumbersInAnArray.getLcm() */

  /**
   * Question about Java 8 Streams - collect vs reduce
   *
   * <p>When would you use collect() vs reduce()? Does anyone have good, concrete examples of when
   * it's definitely better to go one way or the other? Javadoc mentions that collect() is a mutable
   * reduction. Given that it's a mutable reduction, I assume it requires synchronization
   * (internally) which, in turn, can be detrimental to performance. Presumably reduce() is more
   * readily parallelizable at the cost of having to create a new data structure for return after
   * every step in the reduce. The above statements are guesswork however and I'd love an expert to
   * chime in here.
   *
   * <p>Answer : "reduce" is a "fold" operation, it applies a binary operator to each element in the
   * stream where the first argument to the operator is the return value of the previous application
   * and the second argument is the current stream element.
   *
   * <p>"collect" is an aggregation operation where a "collection" is created and each element is
   * "added" to that collection. Collections in different parts of the stream are then added
   * together.
   *
   * <p>The document you linked
   * (https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#Reduction)
   * gives the reason for having two different approaches:
   *
   * <p>If we wanted to take a stream of strings and concatenate them into a single long string, we
   * could achieve this with ordinary reduction:
   *
   * <p>String concatenated = strings.reduce("", String::concat) We would get the desired result,
   * and it would even work in parallel. However, we might not be happy about the performance! Such
   * an implementation would do a great deal of string copying, and the run time would be O(n^2) in
   * the number of characters. A more performant approach would be to accumulate the results into a
   * StringBuilder, which is a mutable container for accumulating strings. We can use the same
   * technique to parallelize mutable reduction as we do with ordinary reduction.
   *
   * <p>So the point is that the parallelisation is the same in both cases but in the reduce case we
   * apply the function to the stream elements themselves. In the collect case we apply the function
   * to a mutable container.
   *
   * <p>Another answer : The reason is simply that: collect() can only work with mutable result
   * objects. reduce() is designed to work with immutable result objects.
   *
   * <p>Another explanation : Let the stream be a <- b <- c <- d In reduction, you will have ((a #
   * b) # c) # d where # is that interesting operation that you would like to do.
   *
   * <p>In collection, your collector will have some kind of collecting structure K. K consumes a. K
   * then consumes b. K then consumes c. K then consumes d. At the end, you ask K what the final
   * result is. K then gives it to you.
   */

  /** Another example showing the difference between reduce and collect. */

  /*private static void getSalariesSumUsingReduce()
  {
  	List<EmployeeForReduce> list = new LinkedList<>();
  	  list.add(new EmployeeForReduce("1"));
  	  list.add(new EmployeeForReduce("2"));
  	  list.add(new EmployeeForReduce("3"));

  	  Integer sum = list
  	  .stream()
  	  .map(EmployeeForReduce::getSalary)
  	  .reduce(0, (Integer a, Integer b) -> Integer.sum(a, b));

  	  // This would give 6 as the result.
  	  // assertEquals(Integer.valueOf(6), sum);
  }*/

  /**
   * This works because the accumulator container.add(employee.getSalary().intValue()); is not
   * supposed to return a new object with the result but to change the state of the mutable
   * container of type MutableInt.
   *
   * <p>If you would like to use BigDecimal instead for the container you could not use the
   * collect() method as container.add(employee.getSalary()); would not change the container because
   * BigDecimal it is immutable. (Apart from this BigDecimal::new would not work as BigDecimal has
   * no empty constructor)
   */
  /*private static void getSalariesUsingCollect()
  {
  	List<Employee> list = new LinkedList<>();
  	  list.add(new Employee("1"));
  	  list.add(new Employee("2"));

  	  MutableInt sum = list.stream().collect(
  	    MutableInt::new,
  	    (MutableInt container, Employee employee) ->
  	      	container.add(employee.getSalary().intValue()),
  	    MutableInt::add);
  	  assertEquals(new MutableInt(3), sum);
  }*/

  /*private static class EmployeeForReduce {

  	public EmployeeForReduce(Integer salary) {
  		super();
  		this.salary = salary;
  	}

  	private Integer salary;

  	public EmployeeForReduce(String aSalary){
  		this.salary = new Integer(aSalary);
  	}

  	public Integer getSalary(){
  	    return this.salary;
  	}
  }*/

  /*public class Employee {

    private MutableInt salary;

    public Employee(String aSalary){
      this.salary = new MutableInt(aSalary);
    }

    public MutableInt getSalary(){
      return this.salary;
    }
  }*/

}
