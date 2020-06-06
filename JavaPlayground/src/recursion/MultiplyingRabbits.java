package recursion;

/**
 *
    Sometimes, we might have to count certain events or combinations of events or things. 
    
    They can be good examples of recursive solutions with more than one base case. 
    
    These solutions are tremendously inefficient, and so are not practical. Do not let this inefficiency discourage you. Recur-
sion can be useful and efficient, even though it is not always so. 

    The Fibonacci Sequence (Multiplying Rabbits)

Rabbits are very prolific breeders. If rabbits did not die, their population would quickly get out of
hand. Suppose we assume the following “facts,” which were obtained in a recent survey of randomly
selected rabbits:
• Rabbits never die.
• A rabbit reaches sexual maturity exactly two months after birth; that is, at the beginning of its
third month of life.
• Rabbits are always born in male-female pairs. At the beginning of every month, each sexually
mature male-female pair gives birth to exactly one male-female pair.


Suppose that you started with a single newborn male-female pair. How many pairs would there
be in month 6, counting the births that took place at the beginning of month 6? As 6 is a relatively
small number, you can figure out the solution easily:


Month 1: 1 pair, the original rabbits.
Month 2: 1 pair still, because the rabbits are not yet sexually mature.
Month 3: 2 pairs; the original pair has reached sexual maturity and has given birth to a second pair.
Month 4: 3 pairs; the original pair has given birth again, but the pair born at the beginning of
month 3 are not yet sexually mature.
Month 5: 5 pairs; all rabbits alive in month 3 (2 pairs) are now sexually mature. Add their off-
spring to those pairs alive in month 4 (3 pairs) to yield 5 pairs.
Month 6: 8 pairs; 3 newborn pairs from the pairs alive in month 4 plus 5 pairs alive in month 5.

You can now construct a recursive solution for computing rabbit ( n ), the number of pairs alive in
month n . You must determine how you can use rabbit ( n – 1) to compute rabbit ( n ). Observe that
rabbit ( n ) is the sum of the number of pairs alive just prior to the start of month n and the number of
pairs born at the start of month n . Just prior to the start of month n, there are rabbit ( n – 1) pairs of rab-
bits. Not all of these rabbits are sexually mature at the start of month n . Only those that were alive in
month n – 2 are ready to reproduce at the start of month n . That is, the number of pairs born at the start
of month n is rabbit(n – 2). Therefore, you have the recurrence relation.

rabbit ( n ) = rabbit ( n – 1) + rabbit ( n – 2)

This does not add much conceptual diffi culty, but you must be
very careful when selecting the base case. The temptation is simply to say that rabbit (1) should be the
base case because its value is 1 according to the problem’s statement. But what about rabbit (2)?
Applying the recursive defi nition to rabbit (2) would yield

rabbit (2) = rabbit (1) + rabbit (0)

Thus, the recursive defi nition would need to specify the number of pairs alive in month 0—an unde-
fi ned quantity.

One possible solution is to defi ne rabbit (0) to be 0, but this approach seems artifi cial. A slightly
more attractive alternative is to treat rabbit (2) itself as a special case with the value of 1. Thus, the
recursive defi nition has two base cases, rabbit (2) and rabbit (1). The recursive defi nition becomes

rabbit(n) = 1   if n is 1 or 2
rabbit(n) = rabbit(n - 1) + rabbit(n - 2) if n is greater than 2.

Incidentally, the series of numbers rabbit (1), rabbit (2), rabbit (3), and so on is known as the Fibon-
accisequence , which models many naturally occurring phenomena.

 *  
 */
public class MultiplyingRabbits {
   public static void main(String[] args) {
      System.out.println(recursiveRabbit(6));
      System.out.println(iterativeRabbit(6));
   } 

    public static int recursiveRabbit( int n)
    {
        if (n <= 2)
        {
            return 1;
        }
        else // n > 2, so n - 1 > 0 and n - 2 > 0
        {
            return recursiveRabbit(n - 1) + recursiveRabbit(n - 2);
        }
    }

    /** Iterative solution to the rabbit problem. */
    public static int iterativeRabbit(int n)
    {
        // Initialize base cases:
        int previous = 1;

        // Initially rabbit(1)
        int current = 1;

        // Initially rabbit(2)
        int next = 1;

        // Result when n is 1 or 2

        // Compute next rabbit values when n >= 3
        for ( int i = 3; i <= n; i++)
        {
            // current is rabbit(i - 1), previous is rabbit(i - 2)
            next = current + previous;
            // rabbit(i)
            previous = current;
            // Get ready for next iteration
            current = next;
        } // end for

        return next;

    }
}

/*
* Should we actually use this function? Think about the number of recursive calls that rabbit(10) generates. At best,
the function rabbit is inefficient. Thus, its use is not feasible for large values of n . We will need some techniques for
generating a more efficient solution from this same recursive relationship.
*/