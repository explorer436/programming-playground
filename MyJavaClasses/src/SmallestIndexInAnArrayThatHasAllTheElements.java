
import java.util.HashMap;
import java.util.Map;

public class SmallestIndexInAnArrayThatHasAllTheElements
{
	public static void main(String[] args)
	{
		System.out.println("starting test class");
		// List<Integer> A = new ArrayList<Integer>();

		int[] A = new int[] { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };

		SmallestIndexInAnArrayThatHasAllTheElements sol = new SmallestIndexInAnArrayThatHasAllTheElements();

		int finalResult = sol.coveringPrefixIndex(A);

		System.out.println("finalResult : " + finalResult);
	}

	public int coveringPrefixIndex(final int[] A)
	{
		Map<Integer, Integer> indexesMap = new HashMap<Integer, Integer>();
		// start from the back
		for (int i = A.length - 1; i >= 0; i--)
		{
			indexesMap.put(A[i], i);
		}
		// now find the highest value in the map
		int highestIndex = 0;
		for (Integer i : indexesMap.values())
		{
			if (highestIndex < i.intValue())
				highestIndex = i.intValue();
		}
		return highestIndex;
	}
}
