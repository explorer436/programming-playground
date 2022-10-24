package com.my.company.collections;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

/**
 * 

	In Java 8, BinaryOperator is a functional interface and it extends BiFunction.
	
	So it inherits the following methods from the BiFunction Interface:
	1. apply(T t, T u)
	2. andThen(Function<? super R, ? extends V> after)
	
	The BinaryOperator takes two arguments of the same type and returns a result of the same type of its arguments.
	
	BinaryOperator.java
	@FunctionalInterface
	public interface BinaryOperator<T> extends BiFunction<T,T,T> {
	}
	The BiFunction takes two arguments of any type, and returns a result of any type.
	
	BiFunction.java
	@FunctionalInterface
	public interface BiFunction<T, U, R> {
	      R apply(T t, U u);
	}

 *
 */
public class BinaryOperatorSamples {

	public static void main(String[] args) {
		
		// BiFunction
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
        Integer result = func.apply(2, 3);
        System.out.println(result); // 5

        // BinaryOperator
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;
        Integer result2 = func.apply(2, 3);
        System.out.println(result2); // 5
        
        System.out.println();
        
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer result3 = math(Arrays.asList(numbers), 0, (a, b) -> a + b);
        System.out.println(result3); // 55
        
        Integer result4 = math(Arrays.asList(numbers), 0, Integer::sum);
        System.out.println(result4); // 55
        
        System.out.println();
        
        int[] numbers_primary = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result5 = mathOnInts((numbers_primary), 0, (a, b) -> a + b);
        System.out.println(result5); // 55

        int result6 = mathOnInts((numbers_primary), 0, Integer::sum);
        System.out.println(result6); // 55
        
        System.out.println();
        
        Developer dev1 = new Developer("jordan", BigDecimal.valueOf(9999));
        Developer dev2 = new Developer("jack", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("jaden", BigDecimal.valueOf(10000));
        Developer dev4 = new Developer("ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("mkyong", BigDecimal.valueOf(1));

        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5);

        // 1. Create a Comparator
        Comparator<Developer> comparing = Comparator.comparing(Developer::getSalary);

        // 2. BinaryOperator with a custom Comparator
        BinaryOperator<Developer> binaryOperatorWithCustomComparator = BinaryOperator.maxBy(comparing);
        Developer developerWithMaxValueOfComparator = find(list, binaryOperatorWithCustomComparator);
        System.out.println("developerWithMaxValueOfComparator : " + developerWithMaxValueOfComparator);     // Developer{name='jaden', salary=10000}

        // We can combine the various steps into a single line - as shown below.

        // find developer with highest pay
        Developer developer = find(list, BinaryOperator.maxBy(Comparator.comparing(Developer::getSalary)));
        System.out.println(developer);  // Developer{name='jaden', salary=10000}

        // find developer with lowest pay
        Developer developer2 = find(list, BinaryOperator.minBy(Comparator.comparing(Developer::getSalary)));
        System.out.println(developer2); // Developer{name='mkyong', salary=1}

	}
	
	// This example simulates a stream.reduce() to sum all the Integer.
	public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator) {
        T result = init;
        for (T t : list) {
            result = accumulator.apply(result, t);
        }
        return result;
    }
	
	// If the math operations involve primitive types like int, change to IntBinaryOperator for better performance.
	public static int mathOnInts(int[] list, int init, IntBinaryOperator accumulator) {
        int result = init;
        for (int t : list) {
            result = accumulator.applyAsInt(result, t);
        }
        return result;
    }
	
	/**
	 * This example uses BinaryOperator and a custom Comparator to find the highest and lowest pay developer from a list of developers.
	 */
	public static Developer find(List<Developer> list, BinaryOperator<Developer> binaryOperator) {
        Developer finalResult = null;
        for (Developer currentObject : list) {
            if (finalResult == null) {
                finalResult = currentObject;
            } else {
                finalResult = binaryOperator.apply(finalResult, currentObject);
            }
        }
        return finalResult;
    }
	
	public static class Developer {
		
		String name;
	    BigDecimal salary;

	    public Developer(String name, BigDecimal salary) {
	        this.name = name;
	        this.salary = salary;
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getSalary() {
			return salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Developer [name=" + name + ", salary=" + salary + "]";
		}
	    
	}

}
