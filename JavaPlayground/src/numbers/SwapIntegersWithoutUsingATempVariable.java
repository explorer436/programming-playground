package numbers;

public class SwapIntegersWithoutUsingATempVariable {
	
	

	public static void main(String[] args) throws Exception {
		
		Pair result;
		
		result = swapUsingAdditionAndSubtraction(new SwapIntegersWithoutUsingATempVariable().new Pair(10, 20));
		if (result.getA() != 20 || result.getB() != 10)
		{
			throw new Exception("wrong answer - expected (20, 10) but received " + result.getA() + result.getB());
		}
				
		result = swapUsingAdditionAndSubtraction(new SwapIntegersWithoutUsingATempVariable().new Pair(-1, -2));
		if (result.getA() != -2 || result.getB() != -1)
		{
			throw new Exception("wrong answer - expected (-2, -1) but received " + result.getA() + result.getB());
		}
		
		result = swapUsingAdditionAndSubtraction(new SwapIntegersWithoutUsingATempVariable().new Pair(Integer.MAX_VALUE, 10));
		if (result.getA() != 10 || result.getB() != Integer.MAX_VALUE)
		{
			throw new Exception("wrong answer - expected (10, " + Integer.MAX_VALUE+ ") but received (" + result.getA() + "," + result.getB() + ")");
		}
		
		result = swapUsingAdditionAndSubtraction(new SwapIntegersWithoutUsingATempVariable().new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE - 3));
		if (result.getA() != Integer.MAX_VALUE - 3 || result.getB() != Integer.MAX_VALUE)
		{
			throw new Exception("wrong answer - expected (" + (Integer.MAX_VALUE - 3) + ", " + Integer.MAX_VALUE + ") but received (" + result.getA() + "," + result.getB() + ")");
		}
		
		result = swapUsingAdditionAndSubtraction(new SwapIntegersWithoutUsingATempVariable().new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE + 5));
		if (result.getA() != Integer.MIN_VALUE + 5 || result.getB() != Integer.MIN_VALUE)
		{
			throw new Exception("wrong answer - expected (" + (Integer.MIN_VALUE + 5) + ", " + Integer.MIN_VALUE + ") but received (" + result.getA() + "," + result.getB() + ")");
		}
		
		// --------------------------------------------------------
		
		result = swapUsingBitwiseManipulation(new SwapIntegersWithoutUsingATempVariable().new Pair(10, 20));
		if (result.getA() != 20 || result.getB() != 10)
		{
			throw new Exception("wrong answer - expected (20, 10) but received " + result.getA() + result.getB());
		}
				
		result = swapUsingBitwiseManipulation(new SwapIntegersWithoutUsingATempVariable().new Pair(-1, -2));
		if (result.getA() != -2 || result.getB() != -1)
		{
			throw new Exception("wrong answer - expected (-2, -1) but received " + result.getA() + result.getB());
		}
		
		result = swapUsingBitwiseManipulation(new SwapIntegersWithoutUsingATempVariable().new Pair(Integer.MAX_VALUE, 10));
		if (result.getA() != 10 || result.getB() != Integer.MAX_VALUE)
		{
			throw new Exception("wrong answer - expected (10, " + Integer.MAX_VALUE+ ") but received (" + result.getA() + "," + result.getB() + ")");
		}
		
		result = swapUsingBitwiseManipulation(new SwapIntegersWithoutUsingATempVariable().new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE - 3));
		if (result.getA() != Integer.MAX_VALUE - 3 || result.getB() != Integer.MAX_VALUE)
		{
			throw new Exception("wrong answer - expected (" + (Integer.MAX_VALUE - 3) + ", " + Integer.MAX_VALUE + ") but received (" + result.getA() + "," + result.getB() + ")");
		}
		
		result = swapUsingBitwiseManipulation(new SwapIntegersWithoutUsingATempVariable().new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE + 5));
		if (result.getA() != Integer.MIN_VALUE + 5 || result.getB() != Integer.MIN_VALUE)
		{
			throw new Exception("wrong answer - expected (" + (Integer.MIN_VALUE + 5) + ", " + Integer.MIN_VALUE + ") but received (" + result.getA() + "," + result.getB() + ")");
		}
		
		System.out.println("done");

	}
	
	/**
	 * 
		This technique uses addition and subtraction.
		
		The integer addition will not overflow if the result of the addition is more than the maximum value of int primitive as defined by Integer.MAX_VALUE or if the result of the subtraction is less than Integer.MIN_VALUE.

		The code works in Java because overflows are clearly defined. And, this solution will not work in C or C++.
		
		The addition of two numbers will overflow.
		e.g. Consider that the two numbers in the input are Integer.MAX_VALUE and 10.
		sum after adding the two input values = Integer.MAX_VALUE + 10 = -2147483639 (after integer overflow).
		But we are also doing subtraction, which will compensate this value.
		Now, b = (-2147483639 - 10) = Integer.MAX_VALUE (again, after integer overflow)
		Now, a = (-2147483639 - Integer.MAX_VALUE) will again overflow to give you 10 as output.
		
		
		As we can see, this gets a little confusing to deal with, especially if the numbers get too large and start overflowing.
		In languages that do not support overflowing like C/C++, this gets even more diffucult and confusing.
		Another variant of this solution is using bitwise manipulation. See the other method.

	 * 
	 */
	private static Pair swapUsingAdditionAndSubtraction(Pair pair)
	{
		int a = pair.a;
		int b = pair.b;
		
		a = a + b;
		b = a - b;   // actually (a + b) - (b) -> assign this value to b.
		a = a - b;   // which is, (a + b) -((a + b) - (b)) = (a + b) - a = b -> assign this value to a.
		
		return new SwapIntegersWithoutUsingATempVariable().new Pair(a, b);
	}
	
	/**
	 * 
		The beauty of this method is, we do not have to worry about the datatype of the input variables. Or, their limits.
		We don't have to worry about overflows.
		This will work any language, including the ones that do not support overflows.
	 * 
	 */
	private static Pair swapUsingBitwiseManipulation(Pair pair)
	{
		int a = pair.a;
		int b = pair.b;
		
		a = a ^ b;
		b = a ^ b;   // actually (a ^ b) ^ b, which would give us a -> assign this value to b.
		a = a ^ b;   // which is, (a ^ b) -((a ^ b) ^ b) = (a ^ b) ^ a = b -> assign this value to a.
		
		return new SwapIntegersWithoutUsingATempVariable().new Pair(a, b);
	}
	
	private class Pair
	{
		int a;
		int b;
		
		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
	}
	
	
}

