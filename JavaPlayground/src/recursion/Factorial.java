package recursion;

public class Factorial {
	
	public static void main(String[] args) {

        System.out.println("factorial of 4 : " + Factorial.factorialUsingRecursion(4));
        System.out.println("factorial of -1 : " + Factorial.factorialUsingRecursion(-1));
        System.out.println("factorial of 0 : " + Factorial.factorialUsingRecursion(0));
        System.out.println("factorial of 1 : " + Factorial.factorialUsingRecursion(1));
        System.out.println("factorial of 10 : " + Factorial.factorialUsingRecursion(10));

        System.out.println();

        System.out.println("factorial of 4 : " + Factorial.factorial_iteration(4));
        System.out.println("factorial of -1 : " + Factorial.factorial_iteration(-1));
        System.out.println("factorial of 0 : " + Factorial.factorial_iteration(0));
        System.out.println("factorial of 1 : " + Factorial.factorial_iteration(1));
        System.out.println("factorial of 10 : " + Factorial.factorial_iteration(10));

    }
	
	public static int factorialUsingRecursion(int number) {
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
        	result = number * factorialUsingRecursion(number - 1);
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
