package codility.prefixsums;

/**
 * 
 Problem:You are given a non-empty, zero-indexed arrayAofn(1¬n¬100 000) integersa0, a1, . . . , an−1(0¬ai¬1 000). This array represents number of mushrooms growing on theconsecutive spots along a road. You are also given integerskandm(0¬k, m < n).
 
 A mushroom picker is at spot numberkon the road and should performmmoves. Inone move she moves to an adjacent spot. She collects all the mushrooms growing on spotsshe visits. The goal is to calculate the maximum number of mushrooms that the mushroompicker can collect inmmoves.
 
 For example, consider arrayAsuch that: |2|3|7|5|1|3|9|
 
 The mushroom picker starts at spot k= 4 and should perform m= 6 moves. 
 She might move to spots 3,2,3,4,5,6 and 
 thereby collect1 + 5 + 7 + 3 + 9 = 25 mushrooms. 
 This is the maximal number of mushrooms she can collect.

 SolutionO(m2):Note that the best strategy is to move in one direction optionally followed by some moves in the opposite direction. 
In other words, the mushroom picker should not change direction more than once. 
With this observation we can find the simplest solution.Make the first p= 0,1,2, . . . , m moves in one direction, then the next m−p moves in the opposite direction. 
This is just a simple simulation of the moves of the mushroom picker which requiresO(m2)time.

SolutionO(n+m):A better approach is to use prefix sums. 
If we make p moves in one direction, we can calculate the maximal opposite location of the mushroom picker. 
The mushroom picker collects all mushrooms between these extremes. 
We can calculate the total number of collected mushrooms in constant time by using prefix sums.


def mushrooms(A, k, m):
	n = len(A)
	result = 0
	pref = prefix_sums(A)
	
	for p in xrange(min(m, k) + 1):
		left_pos = k - p
		right_pos = min(n - 1, max(k, k + m - 2*p))
		result = max(result, count_total(pref, left_pos, right_pos))
	for p in xrange(min(m + 1, n - k)):
		right_pos = k + p
		left_pos = max(0, min(k, k - (m - 2*p)))
		result = max(result, count_total(pref, left_pos, right_pos))

	returnresult
 */
public class MushroomPicker
{

    public static void main(String[] args)
    {
      int A[] = {2,3,7,5,1,3,9};
    }

    private static void solution(int A[])
    {
      int n = A.length;
      int result = 0;

    }

}
