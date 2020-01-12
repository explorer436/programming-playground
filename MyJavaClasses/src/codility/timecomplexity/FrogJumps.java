package codility.timecomplexity;

public class FrogJumps
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int result1 = solution(10, 85, 30);
		System.out.println("result1 : " + result1);

		int result2 = solution(10, 70, 30);
		System.out.println("result2 : " + result2);
	}

	public static int solution(int X, int Y, int D)
	{
		int result = 0;
		if (Y > X && D != 0)
		{
			System.out.println("(Y - X) % D : " + (Y - X) % D);
			result = (((Y - X) % D) == 0) ? ((Y - X) / D) : (((Y - X) / D) + 1);
		}
		return result;
	}

}
