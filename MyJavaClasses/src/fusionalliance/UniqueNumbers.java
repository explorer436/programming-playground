package fusionalliance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class UniqueNumbers {    

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
	
	public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Set<Integer> mySet = null;
        if (null != numbers)
        {
            mySet = new HashSet<Integer>();

            for (int i : numbers) {
                if (mySet.contains(i)) {
                    mySet.remove(i);
                }
                else {
                    mySet.add(i);
                }
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }

        return mySet;
    }
	
	/* public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    } */
}