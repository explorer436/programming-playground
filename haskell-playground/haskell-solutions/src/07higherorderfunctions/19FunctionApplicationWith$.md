Lets take a look at the $ function, also called function application. 
Let's check out how it's defined:

($) :: (a -> b) -> a -> b  
f $ x = f x  
Given an a -> b function and an a to apply it to, it gives us a b.

What the heck? What is this useless operator? 
It's just function application! 
Well, almost, but not quite! 
Whereas normal function application 
    (putting a space between two things) has a really high precedence, 
    the $ function has the lowest precedence. 
Function application with a space is left-associative (so f a b c is the same as ((f a) b) c)), 
    function application with $ is right-associative.

That's all very well, but how does this help us? 
Most of the time, it's a convenience function so that we don't have to write so many parentheses. 
Consider the expression sum (map sqrt [1..130]). 
Because $ has such a low precedence, 
    we can rewrite that expression as sum $ map sqrt [1..130], 
    saving ourselves precious keystrokes! 
When a $ is encountered, 
    the expression on its right is applied as the parameter to the function on its left. 
How about sqrt 3 + 4 + 9? This adds together 9, 4 and the square root of 3. 
If we want get the square root of 3 + 4 + 9, 
    we'd have to write sqrt (3 + 4 + 9) 
    or if we use $ we can write it as sqrt $ 3 + 4 + 9 
    because $ has the lowest precedence of any operator. 
That's why you can imagine a $ being sort of the equivalent of 
    writing an opening parentheses 
    and then writing a closing one on the far right side of the expression.

How about sum (filter (> 10) (map (*2) [2..10]))?
Well, because $ is right-associative,
    f (g (z x)) is equal to f $ g $ z x. 
And so, we can rewrite sum (filter (> 10) (map (*2) [2..10])) as sum $ filter (> 10) $ map (*2) [2..10].

But apart from getting rid of parentheses,
    $ means that function application can be treated just like another function. 
That way, we can, for instance, map function application over a list of functions.

testFunctionApplicationOnAMap = map ($ 3) [(4+), (10*), (^2), sqrt]  
-- [7.0,30.0,9.0,1.7320508075688772]  

In Haskell, we prefer not to use so many parentheses. 
There is a higher order function called ($) that will take a function on the left of it, and some expression on the right, and apply the function to the expression. 
It has an extremely low precedence, which means it will pretty much be applied last of all. 
This is basically the same effect as having parentheses wrapped around the expression on the right. 

Note also that the ($) function is only for the cases where the parentheses would go right to the very end of the expression on the right.

Another note: The ($) function may not be very useful when dealing with infinite lists.

