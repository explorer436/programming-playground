package com.my.company.recursion;

/**
 * 
   You have been asked to organize the Fourth of July parade, which will consist of bands and fl oats in a
single line. Last year, adjacent bands tried to outplay each other. To avoid this problem, the sponsors
have asked you never to place one band immediately after another. In how many ways can you organ-
ize a parade of length n ?

Assume that you have at least n marching bands and n fl oats from which to choose. When count-
ing the number of ways to organize the parade, assume that the parades band-fl oat and fl oat-band , for
example, are different parades and count as two ways.

The parade can end with either a fl oat or a band. The number of ways to organize the parade is
simply the sum of the number of parades of each type. That is, let
P ( n ) be the number of ways to organize a parade of length n
F ( n ) be the number of parades of length n that end with a fl oat
B ( n ) be the number of parades of length n that end with a band
Then
P(n) = F(n) + B(n)

First, consider F ( n ). You will have a parade of length n that ends with a fl oat simply by placing a
fl oat at the end of any acceptable parade of length n – 1. Hence, the number of acceptable parades of
length n that end with a fl oat is precisely equal to the total number of acceptable parades of length
n – 1; that is 
F ( n ) = P ( n - 1 )

Next, consider B ( n ). The only way a parade can end with a band is if the unit just before the end is
a fl oat. (If it is a band, you will have two adjacent bands.) Thus, the only way to organize an acceptable
parade of length n that ends with a band is fi rst to organize a parade of length n – 1 that ends with a fl oat
and then add a band to the end. Therefore, the number of acceptable parades of length n that end with a
band is precisely equal to the number of acceptable parades of length n – 1 that end with a fl oat:
B ( n ) = F ( n - 1 )

You use the earlier fact that F ( n ) = P ( n - 1) to obtain
B ( n ) = P ( n - 2 )

Thus, you have solved F ( n ) and B ( n ) in terms of the smaller problems P ( n - 1) and P ( n - 2),
respectively. You then use
P(n) = F(n) + B(n)
to obtain
P(n) = P ( n - 1 ) + P ( n - 2 )

The form of this recurrence relation is identical to the solution for the multiplying rabbits problem.
(See MultiplyingRabbits.java)

As you saw in the rabbit problem, two base cases are necessary, because the recurrence rela-
tion defi nes a problem in terms of two smaller problems. As you did for the rabbit problem, you
can choose n ⫽ 1 and n ⫽ 2 for the base cases. Although both problems use the same values of n
for their base cases, there is no reason to expect that they use the same values for these base
cases. That is, there is no reason to expect that rabbit (1) is equal to P (1) and that rabbit (2) is
equal to P (2).

A little thought reveals that for the parade problem,
P (1) = 2 (The parades of length 1 are float and band .)
P (2) = 3 (The parades of length 2 are float - float , band - float , and float - band .)

In summary, the solution to this problem is
P ( 1 ) = 2
P ( 2 ) = 3
P ( n ) = P ( n - 1 ) + P ( n - 2 ) for n > 2

Remember : 
This example demonstrates the following points about recursion:
• Sometimes you can solve a problem by breaking it up into cases—for example, parades that
end with a float and parades that end with a band.
• The values that you use for the base cases are extremely important. Although the recurrence
relations for P and rabbit are the same, their base cases (when n = 1 or 2) are different. This
difference causes rabbit ( n ) and P ( n ) to differ when n is greater than 2. For example,
rabbit (20) = 6,765, while P (20) = 17,711. The larger the value of n , the larger the discrep-
ancy. 

 * 
 */
public class OrganizingAParade {
    public static void main(String[] args) {
        System.out.println(solve(20));
    }

    public static int solve( int n)
    {
        if (n == 1)
        {
            return 2;
        }
        else if (n == 2)
        {
            return 3;
        }
        else // n > 2, so n - 1 > 0 and n - 2 > 0
        {
            return solve(n - 1) + solve(n - 2);
        }
    }
}