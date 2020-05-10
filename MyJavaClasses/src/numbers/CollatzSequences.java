package numbers;

/** 
we'll be dealing with Collatz sequences. 
We take a natural number. 
If that number is even, we divide it by two. 
If it's odd, we multiply it by 3 and then add 1 to that. 
We take the resulting number and apply the same thing to it, which produces a new number and so on. 
In essence, we get a chain of numbers. 
It is thought that for all starting numbers, the chains finish at the number 1. 
So if we take the starting number 13, we get this sequence: 
13, 40, 20, 10, 5, 16, 8, 4, 2, 1. 
13*3 + 1 equals 40. 
40 divided by 2 is 20, etc. 
We see that the chain has 10 terms.

Now what we want to know is this: 
for all starting numbers between 1 and 100, how many chains have a length greater than 15?

    ghci> chain 10  
    [10,5,16,8,4,2,1]  
    ghci> chain 1  
    [1]  
    ghci> chain 30  
    [30,15,46,23,70,35,106,53,160,80,40,20,10,5,16,8,4,2,1]  
*/
public class CollatzSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}