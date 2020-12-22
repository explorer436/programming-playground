Remember : A recursive solution that recomputes certain values frequently can be quite
inefficient. In such cases, iteration may be preferable to recursion.

For examples of techniques about how to choose base cases, see the following : 
TowersOfHanoi.java
OrganizingAParade.java
ChoosingKOutOfNThings.java

Remember : When you solve a problem by solving two (or more) smaller problems, each of
the smaller problems must be closer to a base case than the original problem.

Remember : When a recursive function contains more than one recursive call, you often will
need more than one base case.

Recursion and Efficiency:

Recursion is a powerful problem-solving technique that often produces very clean solutions to even the
most complex problems. Recursive solutions can be easier to understand and to describe than iterative
solutions. By using recursion, you can often write simple, short implementations of your solution.

Unfortunately, many of the recursive solutions are so inefficient that
you should not use them. 
The recursive functions binarySearch and solveTowers are the notable exceptions, as they are quite efficient. 

Two factors contribute to the inefficiency of some recursive solutions:
• The overhead associated with function calls
• The inherent inefficiency of some recursive algorithms

The first of these factors does not pertain specifically to recursive functions but is true of func-
tions in general. In most implementations of C++ and other high-level programming languages, a
function call incurs a certain amount of bookkeeping overhead. As was mentioned earlier, each func-
tion call produces an activation record, which is analogous to a box in the box trace. Recursive func-
tions magnify this overhead because a single initial call to the function can generate a large number of
recursive calls. For example, the call factorial ( n ) generates n recursive calls. On the other hand, the
use of recursion, as is true of modularity in general, can greatly clarify complex programs. This clari-
fication frequently more than compensates for the additional overhead.

However, you should not use recursion just for the sake of using recursion. For example, you
probably should not use the recursive factorial function in practice. You can easily write an iterative
factorial function. The iterative function is almost as clear as the recursive one and is more efficient. 
There is no reason to incur the overhead of recursion when its use does not gain anything. 
Recursion is truly valuable when a problem has no simple iterative solutions.

The second point about recursion and efficiency is that some recursive algorithms are inherently
inefficient. This inefficiency is a very different issue than that of overhead. It has nothing to do with
how a compiler happens to implement a recursive function, but rather is related to the technique that
the algorithm employs.

As an example, recall the recursive solution for the multiplying rabbits problem (See MultiplyingRabbits.java) :
rabbit(n) = 1   if n is 1 or 2
rabbit(n) = rabbit(n - 1) + rabbit(n - 2) if n is greater than 2.

If you draw a box trace for the solution and look at it, the computation of rabbit (7), rabbit (10). 
As the value of n increases, such a diagram would fill up most of the book. The diagram for
rabbit (100) would fill up most of this universe!

The fundamental problem with rabbit is that it computes the same values over and over again.
For example, in the diagram for rabbit (7), you can see that rabbit (3) is computed fi ve times. When n
is moderately large, many of the values are recomputed literally trillions of times. This enormous
number of computations makes the solution infeasible, even if each computation requires only a
trivial amount of work.

However, do not conclude that the recurrence relation is of no use. One way to solve the rabbit
problem is to construct an iterative solution based on this same recurrence relation. The iterative
solution goes forward instead of backward and computes each value only once. Look at MultiplyingRabbits.multiplyingRabbits_iterative()
Use the iterative function to compute rabbit ( n ) even for very large values of n.

Thus, an iterative solution can be more effi cient than a recursive solution. In certain cases, how-
ever, it may be easier to discover a recursive solution than an iterative solution. Therefore, you may
need to convert a recursive solution to an iterative solution. This conversion process is easier if your
recursive function calls itself once, instead of several times. Be careful when deciding whether your
function calls itself more than once. Although the recursive function rabbit calls itself twice, the
function binarySearch calls itself once, even though you see two calls in the C++ code. Those two
calls appear within an if statement; only one of them will be executed.

Converting a recursive solution to an iterative solution is even easier when the solitary recursive
call is the last action that the function takes. This situation is called tail recursion . For example, the
function writeBackward exhibits tail recursion because its recursive call is the last action that the
function takes. Before you conclude that this is obvious, consider the function fact . Although its
recursive call appears last in the function defi nition, fact ’s last action is the multiplication. Thus,
fact is not tail-recursive.

Look at the method StringReversal.writeBackward_recursive(). 
Because this function is tail-recursive, its last recursive call simply repeats the function’s action with
altered arguments. You can perform this repetitive action by using an iteration that will be straightfor-
ward and often more efficient. For example, the definition of writeBackward is iterative: StringReversal.reverseStringUsingWhileLoop()

Because tail-recursive functions are often less efficient than their iterative counterparts, and
because the conversion of a tail-recursive function to an equivalent iterative function is rather
mechanical, some compilers automatically replace tail recursion with iteration. Eliminating
other forms of recursion is usually more complex and is a task that we would need to undertake, if
necessary.

Some recursive algorithms, such as MultiplyingRabbits.multiplyingRabbits_iterative() , are inherently inefficient, while other recursive algo-
rithms, such as the binary search, are extremely efficient. 

You will learn how to determine the relative efficiency of a recursive algorithm in more advanced courses 
concerned with the analysis of algorithms. 
