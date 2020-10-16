{- |
    Lambdas are basically anonymous functions that are used because 
        we need some functions only once. 
    Normally, we make a lambda with the sole purpose of passing it to a higher-order function. 
    To make a lambda, we write a \ 
    (because it kind of looks like the greek letter lambda if you squint hard enough) 
        and then we write the parameters, separated by spaces. 
    After that comes a -> and then the function body. 
    We usually surround them by parentheses, 
        because otherwise they extend all the way to the right.


    See CollatzSequences.hs for an example.

    Lambdas are expressions, that's why we can just pass them like that. 
    The expression (\xs -> length xs > 15) returns a function 
    that tells us whether the length of the list passed to it is greater than 15.

    People who are not well acquainted with how currying and partial application work 
        often use lambdas where they don't need to. 
    For instance, 
        the expressions map (+3) [1,6,3,2] and map (\x -> x + 3) [1,6,3,2] are equivalent 
        since both (+3) and (\x -> x + 3) are functions 
        that take a number and add 3 to it. 
    Needless to say, making a lambda in this case is stupid 
        since using partial application is much more readable.
-}

-- Like normal functions, lambdas can take any number of parameters:
multipleParametersInALambda = zipWith (\a b -> (a * 30 + 3) / b) [5,4,3,2,1] [1,2,3,4,5]  
-- tests
-- [153.0,61.5,31.0,15.75,6.6]

-- And like normal functions, you can pattern match in lambdas. 
-- The only difference is that you can't define several patterns for one parameter, 
--  like making a [] and a (x:xs) pattern for the same parameter 
--  and then having values fall through. 
-- If a pattern matching fails in a lambda, 
--  a runtime error occurs, so be careful when pattern matching in lambdas!
patternMatchingInALambda = map (\(a,b) -> a + b) [(1,2),(3,5),(6,3),(2,6),(2,5)]  
-- tests
-- [3,8,9,8,7] 

-- Lambdas are normally surrounded by parentheses 
--  unless we mean for them to extend all the way to the right. 
-- Here's something interesting: 
--  due to the way functions are curried by default, these two are equivalent:
addThree1 :: (Num a) => a -> a -> a -> a  
addThree1 x y z = x + y + z  

addThree2 :: (Num a) => a -> a -> a -> a  
addThree2 = \x -> \y -> \z -> x + y + z 
-- If we define a function like this, 
--  it's obvious why the type declaration is what it is. 
-- There are three ->'s in both the type declaration and the equation. 
-- But of course, the first way to write functions is far more readable, 
--  the second one is pretty much a gimmick to illustrate currying.

-- However, there are times when using this notation is cool. 
-- The flip function is the most readable when defined like so:
flip' :: (a -> b -> c) -> b -> a -> c  
flip' f = \x y -> f y x 

-- Even though that's the same as writing flip' f x y = f y x, 
-- we make it obvious that this will be used for producing a new function most of the time. 
-- The most common use case with flip is calling it 
--  with just the function parameter 
--  and then passing the resulting function on to a map or a filter. 
-- So use lambdas in this way when you want to make it explicit that 
--  your function is mainly meant to be partially applied and 
--  passed on to a function as a parameter.
