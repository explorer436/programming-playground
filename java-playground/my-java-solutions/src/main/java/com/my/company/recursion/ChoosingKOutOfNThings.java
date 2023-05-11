package com.my.company.recursion;

/**
 * A rock band would like to tour n cities. Unfortunately, time will allow for visits to only k
 * cities. The band’s agent considers the different choices for visiting k cities out of the n
 * possibilities. Because time is short, the band members are not concerned about the order in which
 * they visit the same k cities.
 *
 * <p>Let g ( n, k ) be the number of groups of k cities chosen from n . If we consider city C,
 * either we visit C or we do not. If we do visit city C, we will have to choose k - 1 other cities
 * to visit from the n - 1 remaining cities. Thus, the number of groups of cities that include C is
 * g ( n - 1, k - 1). On the other hand, if we do not visit city C, we will have to choose k cities
 * to visit from the remaining n - 1 cities. The number of groups of cities that do not include C is
 * g ( n - 1, k ). Thus, we can compute g ( n, k ) by solving two smaller counting problems of the
 * same type; that is, g ( n , k ) = g(n - 1, k - 1) + g(n - 1, k )
 *
 * <p>We still need to fi nd the base case(s) and demonstrate that each of the two smaller problems
 * even- tually reaches a base case. First, if the band had time to visit all n cities—that is, if k
 * equals n— there is only one group of all the cities. Thus, the fi rst base case is g ( k , k ) =
 * 1
 *
 * <p>If k < n, the second term g ( n - 1, k ) in the recursive defi nition will reach this base
 * case, because at each successive stage of the recursion, n ⫺ 1 decreases until it reaches k .
 * However, the first term, g ( n - 1, k - 1), does not reach this base case. Since n - 1 and k - 1
 * both decrease at the same rate, they will never become equal. The first term does, in fact,
 * approach another trivial selection problem. Just as there is only one group of all the cities ( k
 * = n ), there is also only one group of zero cities ( k = 0). Thus, the second base case is g ( n
 * , 0) = 1 and will be reached by the fi rst term, g ( n - 1, k - 1). (Alternatively, you could
 * define the second base case to be g ( n, 1) = n .)
 *
 * <p>Remember : When you solve a problem by solving two (or more) smaller problems, each of the
 * smaller problems must be closer to a base case than the original problem.
 *
 * <p>For completeness, we add one final part to this recursive solution: g ( n , k ) = 0 if k > n
 *
 * <p>Although k could not be greater than n in the context of this problem, the addition of this
 * case makes the recursive solution more generally applicable.
 *
 * <p>To summarize, the following recursive solution solves the problem of choosing k out of n
 * things:
 *
 * <p>g ( n, k ) = 1 if k = 0 g ( n, k ) = 1 if k = n g ( n, k ) = 0 if k > 0 g ( n, k ) = g(n - 1,
 * k -1 ) + g(n - 1, k) if 0 < k < n
 */
public class ChoosingKOutOfNThings {
    public static void main(String[] args) {
        System.out.println(getNumberOfGroups(5, 2));
    }

    public static int getNumberOfGroups(int n, int k) {
        if ((k == 0) || (k == n)) {
            return 1;
        } else if (k > n) {
            return 0;
        } else {
            return getNumberOfGroups(n - 1, k - 1) + getNumberOfGroups(n - 1, k);
        }
    }
}
