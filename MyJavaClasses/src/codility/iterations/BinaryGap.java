package codility.iterations;

public class BinaryGap
{
	public static void main(String[] args)
	{
		System.out.println("starting test class");

		int finalResult = (new BinaryGap()).solution(1041);
		System.out.println("finalResult : " + finalResult);

		finalResult = (new BinaryGap()).solution(328);
		System.out.println("finalResult : " + finalResult);

		finalResult = (new BinaryGap()).solution(1024);
		System.out.println("finalResult : " + finalResult);
	}

	public int solution(int N)
	{
		int current = 0;
		int max = 0;

		boolean openedGate = false;

		// Map<Integer,Integer> indexesMap = new HashMap<Integer,Integer>();

		while (N > 0)
		{
			System.out.print("N : " + N);
			if (N % 2 == 0)
			{
				if (openedGate)
				{
					++current;
				}
			}
			else
			{
				openedGate = true;

				max = Math.max(max, current);
				current = 0;
			}

			N = N / 2;

			System.out.print(" - N : " + N + " - max : " + max + " - current : " + current);
			System.out.println();
		}

		return max;

	}

}
