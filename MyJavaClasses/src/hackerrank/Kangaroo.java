package numbers;

public class Kangaroo {
	
	public static void main(String[] args) {
		System.out.println(kangaroo(0, 3, 5, 2));
		
		System.out.println();
		
		System.out.println(kangaroo(0, 2, 5, 3));
		
		System.out.println();
		
		System.out.println(kangaroo(0, 2, 0, 2));
	}
	
	// Lessons learned:
	// Do not forget about errors when dividing by zero.
	
	// For a successful scenario,
	// x1 + j v1 = x2 + j v2
	// j (v1 - v2) = x2 - x1
	// j = (x2 - x1) / (v1 - v2)
	
	static String kangaroo(int x1, int v1, int x2, int v2) {
		// The % is to ensure the division will result in an integer value.
		// The division is to ensure the result integer is positive.
		if (v1 == v2)
		{
			return x1 == x2 ? "YES" : "NO";
		}
		else
		{
			return ((x2 - x1) % (v1 - v2) == 0) && ((x2 - x1) / (v1 - v2) > 0) ? "YES" : "NO";
		}
	}
    
}
