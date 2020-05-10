package hackerrank;

public class AppleAndOrange {
	
	public static void main(String[] args) {
		int[] apples1 = new int[] { -2, 2, 1 };
		int[] oranges1 = new int[] { 5, -6 };
		countApplesAndOranges(7, 11, 5, 15, apples1, oranges1);
		
		System.out.println();
		
		int[] apples2 = new int[] { -2, 2, 1 };
		int[] oranges2 = new int[] { -1, -2, -3 -4 };
		countApplesAndOranges(-4, -3, -5, -2, apples2, oranges2);	
	}
	
	// Lessons learned :
	// The test data they provide might be simple and stupid and it may not test all the edge cases.
	// In this scenario, the coordinates being negative is an edge case.
	// Build additional test cases yourself and make sure you test for them.
	
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int applesThatFallOnTheHouse = 0;
		int orangesThatFallOnTheHouse = 0;
		
		for (int appleDistance : apples)
		{
			if ((s <= (appleDistance + a)) && ((appleDistance + a <= t)))
			{
				applesThatFallOnTheHouse = applesThatFallOnTheHouse + 1;
			}
		}
		
		for (int orangeDistance : oranges)
		{
			int orangeLanding = b + orangeDistance;
			if ((orangeLanding <= t) && (s <= orangeLanding))
			{
				orangesThatFallOnTheHouse = orangesThatFallOnTheHouse + 1;
			}
		}
		
		System.out.println(applesThatFallOnTheHouse);
		System.out.println(orangesThatFallOnTheHouse);

    }
    
}
