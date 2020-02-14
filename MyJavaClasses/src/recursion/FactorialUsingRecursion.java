package recursion;

public class FactorialUsingRecursion {
	
	public static void main(String[] args) {
        System.out.println("factorial of 4 : " + FactorialUsingRecursion.factorial(4));
        
        System.out.println("factorial of -1 : " + FactorialUsingRecursion.factorial(-1));
        
        System.out.println("factorial of 0 : " + FactorialUsingRecursion.factorial(0));
        
        System.out.println("factorial of 1 : " + FactorialUsingRecursion.factorial(1));
        
        System.out.println("factorial of 10 : " + FactorialUsingRecursion.factorial(10));
    }
	
	public static int factorial(int number) {
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
        	result = number * factorial(number - 1);
        }

        return result;
    }
}
