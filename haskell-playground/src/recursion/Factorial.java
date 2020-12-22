package recursion;

public class Factorial {

	public static void main(String[] args) throws Exception {
int result;
		
		result = Factorial.factorial_recursive(4);
		if (result != 24)
		{
			throw new Exception("wrong answer - expected " + 24 + " but received " + result);
		}
		
		result = Factorial.factorial_recursive(-1);
		if (result != 0)
		{
			throw new Exception("wrong answer - expected " + 0 + " but received " + result);
		}
		
		result = Factorial.factorial_recursive(0);
		if (result != 1)
		{
			throw new Exception("wrong answer - expected " + 1 + " but received " + result);
		}
		
		result = Factorial.factorial_recursive(1);
		if (result != 1)
		{
			throw new Exception("wrong answer - expected " + 1 + " but received " + result);
		}
		
		result = Factorial.factorial_recursive(10);
		if (result != 3628800)
		{
			throw new Exception("wrong answer - expected " + 3628800 + " but received " + result);
		}

        //------------------------------
        
        result = Factorial.factorial_iteration(4);
        if (result != 24)
		{
			throw new Exception("wrong answer - expected " + 24 + " but received " + result);
		}
        
        result = Factorial.factorial_iteration(-1);
		if (result != 0)
		{
			throw new Exception("wrong answer - expected " + 0 + " but received " + result);
		}
		
		result = Factorial.factorial_iteration(0);
		if (result != 1)
		{
			throw new Exception("wrong answer - expected " + 1 + " but received " + result);
		}
		
		result = Factorial.factorial_iteration(1);
		if (result != 1)
		{
			throw new Exception("wrong answer - expected " + 1 + " but received " + result);
		}
		
		result = Factorial.factorial_iteration(10);
		if (result != 3628800)
		{
			throw new Exception("wrong answer - expected " + 3628800 + " but received " + result);
		}
		
		System.out.println("done");

	}
	
	public static int factorial_recursive(int number) {
        int result = 0;
        
        if (number < 0)
        {
        	return 0;
        }
        if (1 == number || 0 == number)
        {
        	return 1;
        }
        else
        {
        	result = number * factorial_recursive(number - 1);
        }

        return result;
    }

	public static int factorial_iteration(int number) {

        // factorial(0) = 1
        int previous = 1;

        // factorial(1) = 1
        // int current = 1;
        if (1 == number || 0 == number)
        {
        	return 1;
        }
        else
        {
            int result = 0;
            for (int i = 2; i <= number; i++)
            {
                result = i * (previous);

                previous = result;

            }
            return result;
        }
    }

}
