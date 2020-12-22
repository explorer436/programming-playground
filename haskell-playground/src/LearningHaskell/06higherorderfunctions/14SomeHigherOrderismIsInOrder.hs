-- Functions can take functions as parameters and also return functions. 
-- Lets make a function that takes a function and then applies it twice to something!

applyTwice :: (a -> a) -> a -> a  
applyTwice f x = f (f x)  

-- Notice the type declaration.
-- `->` is mandatory here.
-- `->` is naturally right-associative. So it can be ignored in certain scenarios. But not here.
-- Here, they indicate that the first parameter is a function 
--    that takes something and returns that same thing.
-- The second parameter is something of that type also 
--      and the return value is also of the same type. 
-- This function takes two parameters and returns one thing.
-- The first parameter is a function (of type a -> a) and the second is that same `a`.

-- The body of the function is pretty simple. 
-- We just use the parameter f as a function, 
--      applying x to it by separating them with a space 
--      and then applying the result to f again.

{- |
    Note: 
    From now on, we'll say that functions take several parameters 
        despite each function actually taking only one parameter 
        and returning partially applied functions 
        until we reach a function that returns a solid value. 
    So for simplicity's sake, 
        we'll say that a -> a -> a takes two parameters, 
        even though we know what's really going on under the hood.
-}

testApplyTwice01 = applyTwice (+3) 10  
-- 16  
testApplyTwice02 = applyTwice (++ " HAHA") "HEY"  
-- "HEY HAHA HAHA"  
testApplyTwice03 = applyTwice ("HAHA " ++) "HEY"  
-- "HAHA HAHA HEY"  
-- testApplyTwice04 = (multThree 2 2) 9  
-- 144  
testApplyTwice05 = applyTwice (3:) [1]  
-- [3,3,1] 


{- |
    The awesomeness and usefulness of partial application is evident. 
    If our function requires us to pass it a function that takes only one parameter, 
    we can just partially apply a function to the point
    where it takes only one parameter and then pass it.
-}

----------------------------------------------------------------

{- |
    Use higher order programming to implement `zipWith`.
    It takes a function and two lists as parameters 
        and then joins the two lists by applying the function between corresponding elements. 
-}

zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]  
zipWith' _ [] _ = []  
zipWith' _ _ [] = []  
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys  

{- |
    Look at the type declaration. 
    The first parameter is a function 
        that takes two things and produces a third thing. 
    They don't have to be of the same type, but they can. 
    The second and third parameter are lists. 
    The result is also a list. 
    The first has to be a list of a's, 
        because the joining function takes a's as its first argument. 
    The second has to be a list of b's, 
        because the second parameter of the joining function is of type b. 
    The result is a list of c's. 
    If the type declaration of a function says 
        it accepts an a -> b -> c function as a parameter, 
        it will also accept an a -> a -> a function, 
        but not the other way around!
-}

 -- Remember that when you're making functions, 
 -- especially higher order ones, and you're unsure of the type, 
 -- you can just try omitting the type declaration 
 -- and then checking what Haskell infers it to be by using :t.

{- |
    The action in the function is pretty similar to the normal zip. 
    The edge conditions are the same, 
        only there's an extra argument, 
        the joining function, 
        but that argument doesn't matter in the edge conditions, 
        so we just use a _ for it. 
    And function body at the last pattern is also similar to zip, 
        only it doesn't do (x,y), but f x y. 
    A single higher order function can be used for a multitude of different tasks 
        if it's general enough. 
-}

testZipWith01 = zipWith' (+) [4,2,5,6] [2,6,2,3]  
-- [6,8,7,9]  
testZipWith02 = zipWith' max [6,3,2,1] [7,3,1,5]  
-- [7,3,2,5]  
testZipWith03 = zipWith' (++) ["foo ", "bar ", "baz "] ["fighters", "hoppers", "aldrin"]  
-- ["foo fighters","bar hoppers","baz aldrin"]  
testZipWith04 = zipWith' (*) (replicate 5 2) [1..]  
-- [2,4,6,8,10]  
testZipWith05 = zipWith' (zipWith' (*)) [[1,2,3],[3,5,6],[2,3,4]] [[3,2,2],[3,4,5],[5,4,3]]  
-- TODO expand this
-- [[3,4,6],[9,20,30],[10,12,12]] 
--

{- |
   A single higher order function can be used in very versatile ways. 
   Imperative programming usually uses stuff like for loops, while loops, 
        setting something to a variable, checking its state, etc. 
        to achieve some behavior and then wrap it around an interface, like a function. 
    Functional programming uses higher order functions to abstract away common patterns, 
        like examining two lists in pairs 
        and doing something with those pairs 
        or getting a set of solutions and eliminating the ones you don't need. 
-}

----------------------------------------------------------------

-- Lets implement another function that is already in the standard library, called flip. 
-- Flip simply takes a function 
--      and returns a function that is like our original function, 
--      only the first two arguments are flipped.

flip' :: (a -> b -> c) -> (b -> a -> c)  
flip' f y x = f x y 

{- |
    Reading the type declaration, 
        we say that it takes a function that takes an `a` and a `b` 
        and returns a function that takes a `b` and an `a`.
    But because functions are curried by default, 
        the second pair of parentheses is really unnecessary, 
        because -> is right associative by default. 

    Here, we take advantage of the fact that functions are curried. 
    When we call flip' f without the parameters y and x, 
        it will return an f that takes those two parameters but calls them flipped. 
    Even though flipped functions are usually passed to other functions, 
        we can take advantage of currying when making higher-order functions 
        by thinking ahead and writing what their end result would be 
        if they were called fully applied.
-}

testFlip01 = flip' zip [1,2,3,4,5] "hello"  
-- [('h',1),('e',2),('l',3),('l',4),('o',5)]  
testFlip02 = zipWith (flip' div) [2,2..] [10,8,6,4,2]  
-- [5,4,3,2,1]  