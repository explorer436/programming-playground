package simple;

public class OddNumberOfAnArray 
{
	public static void main(String[] args) 
	{
		System.out.println("starting test class");
		
		OddNumberOfAnArray sol = new OddNumberOfAnArray();
		
		int finalResult = sol.solution(new int[]{9,3,9,3,9,7,9});		
		System.out.println("finalResult : " + finalResult);
	
		finalResult = sol.solution(new int[]{1});		
		System.out.println("finalResult : " + finalResult);

	}
	
	public int solution(int[] A) {
	    int result = 0;
	    for (int x : A)
	    {
	    	result ^= x;
	    }
	    return result;
	}
	
}
