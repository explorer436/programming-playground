package datastructures.stack;

// http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm

/**
 * 
	Evaluate a postfix expression

	Suppose P is an arithmetic expression in postfix notation. We will evaluate it using a stack to hold the operands.
	
	     Start with an empty stack.  We scan P from left to right.
	
	     While (we have not reached the end of P)
	        If an operand is found
	           push it onto the stack
	        End-If
	        If an operator is found
	           Pop the stack and call the value A
	           Pop the stack and call the value B
	           Evaluate B op A using the operator just found.
	           Push the resulting value onto the stack
	        End-If
	    End-While
	    Pop the stack (this is the final value)
	
	Notes:
	
	    At the end, there should be only one element left on the stack.
	
	    This assumes the postfix expression is valid. 
 *
 */
public class EvaluatePostfixExpression {

	public static void main(String[] args) {
		// TODO
	}

}
