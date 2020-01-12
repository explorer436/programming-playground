package codility.countingelements;

public class MaxCounters
{

	public static void main(String[] args)
	{
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		for (int i : solution(5, A))
		{
			System.out.println("counter : " + i);
		}

		/*
		 * int[] A2 = {3}; System.out.println("result : " + solution(5, A2));
		 * 
		 * int[] A3 = {3}; System.out.println("result : " + solution(2, A3));
		 * 
		 * int[] A4 = {3}; System.out.println("result : " + solution(3, A4));
		 * 
		 * int[] A5 = {1}; System.out.println("result : " + solution(1, A5));
		 * 
		 * int[] A6 = {2, 2, 2, 2, 2}; System.out.println("result : " + solution(2,
		 * A5));
		 */
	}

	public static int[] solution(int N, int[] A)
	{
		int counter[] = new int[N];
		int current_max = -1;
		int min_counter_value = 0;

		for (int K = 0; K < A.length; K++)
		{
			int currentArrayValue = A[K];
			System.out.println("K : " + K + " - currentArrayValue : " + currentArrayValue + " - N : " + N);
			if (1 <= currentArrayValue && currentArrayValue <= N)
			{
				int c_num = counter[currentArrayValue - 1];
				System.out.println("counter" + (currentArrayValue - 1) + " : " + c_num + " - min_counter_value : "
						+ min_counter_value);
				// before incrementing c_num, make sure c_num value is above min_counter_value
				if (c_num < min_counter_value)
				{
					c_num = min_counter_value;
				}
				c_num = c_num + 1;
				if (c_num > current_max)
				{
					current_max = c_num;
				}
			}
			else if (currentArrayValue == N + 1)
			{
				min_counter_value = current_max;
			}
		}
		System.out.println("current_min : " + min_counter_value);
		for (int i = 0; i < N; i++)
		{
			System.out.println("i : " + i + " - counter[i] : " + counter[i]);
			if (counter[i] < min_counter_value)
			{
				counter[i] = min_counter_value;
			}
		}
		return counter;
	}

	/*
	 * public static int[] solution(int N, int[] A) { int[] counterArray = new
	 * int[N];
	 * 
	 * for(int K=0; K<A.length; K++) { //System.out.println("A[K] : " + A[K]); if(1
	 * <= A[K] && A[K] <= N) { counterArray[A[K] - 1] = increase(counterArray[A[K] -
	 * 1]); } else if(A[K] == N + 1) { //get max counter and put it in every
	 * location of counterArray int maxCounterVal =
	 * getMaxCounterValue(counterArray); //System.out.println("maxCounterVal : " +
	 * maxCounterVal);
	 * 
	 * Arrays.fill(counterArray, maxCounterVal); }
	 * System.out.println("at the end of for loop : "); for(int i : counterArray) {
	 * System.out.println("counter : " + i); } }
	 * 
	 * //System.out.println("==========="); return counterArray; }
	 * 
	 * private static int increase(int X) { return X + 1; }
	 * 
	 * private static int getMaxCounterValue(int[] counterArray) {
	 * Arrays.sort(counterArray);
	 * 
	 * return counterArray[counterArray.length - 1]; }
	 */

}
