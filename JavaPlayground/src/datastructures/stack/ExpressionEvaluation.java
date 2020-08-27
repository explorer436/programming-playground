package datastructures.stack;

import java.util.Stack;

// http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm 

// https://www.cis.upenn.edu/~matuszek/cit594-2002/Assignments/5-expressions.html
	
// https://en.wikipedia.org/wiki/Shunting-yard_algorithm


/**
   A Java program to evaluate a given expression where tokens are separated  
   by space. 
   Test Cases: 
     "10 + 2 * 6"            ---> 22 
     "100 * 2 + 12"          ---> 212 
     "100 * ( 2 + 12 )"      ---> 1400 
     "100 * ( 2 + 12 ) / 14" ---> 100     
*/ 
public class ExpressionEvaluation 
{ 
    public static void main(String[] args) throws Exception 
    { 
        int result;
        
        result = ExpressionEvaluation.evaluate("10 + 2 * 6");
        if (22 != result)
		{
			throw new Exception("wrong answer - expected " + "22" + " but received " + result);
		}
        
        result = ExpressionEvaluation.evaluate("100 * 2 + 12"); 
        if (212 != result)
		{
			throw new Exception("wrong answer - expected " + "212" + " but received " + result);
		}
        
        result = ExpressionEvaluation.evaluate("100 * ( 2 + 12 )"); 
        if (1400 != result)
		{
			throw new Exception("wrong answer - expected " + "1400" + " but received " + result);
		}
        
        result = ExpressionEvaluation.evaluate("100 * ( 2 + 12 ) / 14");
        if (100 != result)
		{
			throw new Exception("wrong answer - expected " + "100" + " but received " + result);
		}
        
        result = ExpressionEvaluation.evaluate("10 * 2 / 4");
        if (5 != result)
		{
			throw new Exception("wrong answer - expected " + "5" + " but received " + result);
		}
        
        System.out.println("done");
    }
    
    public static int evaluate(String expression) 
    { 
        char[] tokens = expression.toCharArray(); 
  
         // Stack for numbers: 'values' 
        Stack<Integer> values = new Stack<Integer>(); 
  
        // Stack for Operators: 'operators' 
        Stack<Character> operators = new Stack<Character>(); 
  
        for (int i = 0; i < tokens.length; i++) 
        { 
             // Current token is a whitespace, skip it 
            if (tokens[i] == ' ') 
            {
            	continue;
            } 
  
            // Current token is a number, push it to stack for numbers 
            if (tokens[i] >= '0' && tokens[i] <= '9') 
            { 
                StringBuffer sbuf = new StringBuffer(); 
                
                // There may be more than one digit in number.
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
                {
                	sbuf.append(tokens[i++]); 
                }

                values.push(Integer.parseInt(sbuf.toString())); 
            } 
  
            // Current token is an opening brace, push it to 'operators' 
            else if (tokens[i] == '(') 
            {
            	operators.push(tokens[i]); 
            } 
  
            // Closing brace encountered, solve entire brace 
            else if (tokens[i] == ')') 
            { 
                while (operators.peek() != '(') 
                {
                	values.push(applyOp(operators.pop(), values.pop(), values.pop())); 
                }
                operators.pop(); 
            }
  
            // Current token is an operator. 
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') 
            { 
                // While top of 'operators' has same or greater precedence to current token, which is an operator. 
            	// Apply operator on top of 'operators' to top two elements in values stack.
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) 
                {
                	values.push(applyOp(operators.pop(), values.pop(), values.pop())); 
                }
  
                // Push current token to 'operators'. 
                operators.push(tokens[i]); 
            } 
        } 
  
        // Entire expression has been parsed at this point, apply remaining 
        // operators to remaining values 
        while (!operators.empty()) 
        {
        	values.push(applyOp(operators.pop(), values.pop(), values.pop())); 
        }
  
        // Top of 'values' contains result, return it 
        return values.pop(); 
    } 
  
    // Returns true if 'op2' has higher or same precedence as 'op1', otherwise returns false. 
    public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
        {
        	return false; 
        }
            
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
        {
        	return false; 
        }
            
        return true; 
    } 
  
    // A utility method to apply an operator 'op' on operands 'a' and 'b'.
    public static int applyOp(char op, int b, int a) 
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
            {
            	throw new UnsupportedOperationException("Cannot divide by zero"); 
            } 
            return a / b; 
        } 
        return 0; 
    }  
}
