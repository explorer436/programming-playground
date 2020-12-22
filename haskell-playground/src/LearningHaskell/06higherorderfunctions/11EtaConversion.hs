Eta conversion

An eta conversion (also written η-conversion) is adding or dropping of abstraction over a function. For example, the following two values are equivalent under η-conversion:
\x -> abs x
and
abs
Converting from the first to the second would constitute an eta reduction, and moving from the second to the first would be an eta abstraction. The term 'eta conversion' can refer to the process in either direction.

-----------------

Some Eta Reduction

The technical name for the process of getting rid of the variables that are repeated on the right hand side of the inside and outside is called eta reduction.

Here’s an example of it:

plus num1 num2 = num1 + num2

-- the second argument "num2" gets "erased":
plus' num1 = (num1 +)

-- this is the same as:
plus'NonSectioned = \num1 -> (+) num1

plus'' = (+)

Note that (num1 +) is technically actually what's called a section: that is, a partially applied operator. However, because we're showing this eta reduction with the (+) operator, plus' num1 = (num1 +) is effectively the same function as plus' num1 = (+) num1.

All three of these functions work in the same way. The (+) function already takes two arguments, which as we know in Haskell means it is actually two nested functions.

-----------------

Let’s look at yet another way to do the same thing, this time with lambdas:

add = \x -> (\y -> x + y)

-- the second argument, "y" gets "erased":
add' = \x -> (x +)

-- this is the same as:
add'NonSectioned = \x -> (+) x

add'' = (+)

In each step, we’re simply removing one of the unnecessary variables from our function definition, because (+) is already a function itself, so by the end, all we’re doing is effectively saying that add'' is simply the (+) function.
