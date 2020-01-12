
import java.util.Arrays;

public class PermMissingElem
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 1, 5 };
		System.out.println("result : " + solution(A));

		int[] A2 = { 1 };
		System.out.println("result : " + solution(A2));

		int[] A3 = { 1, 2, 3 };
		System.out.println("result : " + solution(A3));

		int[] A4 = { 2, 3, 4 };
		System.out.println("result : " + solution(A4));

		int[] A5 = {};
		System.out.println("result : " + solution(A5));
	}

	public static int solution(int[] A)
	{
		int result = 0;
		if (A.length > 0)
		{
			Arrays.sort(A);
			for (int i = 0; i < A.length; i++)
			{
				if ((i + 1) != A[i])
				{
					result = i + 1;
					break;
				}
			}
			if (0 == result)
			{
				result = A[A.length - 1] + 1;
			}
		}
		else
		{
			result = 1;
		}
		return result;
	}

}
