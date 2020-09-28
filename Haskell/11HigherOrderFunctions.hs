{- |
    Haskell functions can take functions as parameters and return functions as return values. 
    A function that does either of those is called a higher order function. 
    Higher order functions aren't just a part of the Haskell experience, 
    they pretty much are the Haskell experience. 
    It turns out that if you want to define computations by defining what stuff is 
        instead of defining steps that change some state and maybe looping them, 
        higher order functions are indispensable.
    They're a really powerful way of solving problems and thinking about programs.
-}

-----------------------------------------------------------------------------------------

-- Make sure you really understand how curried functions and 
-- partial application work because they're really important!

{- |
    Curried functions

    Every function in Haskell officially only takes one parameter.
    So how is it possible that we define and used several functions 
        that take more than one parameter?
    Well, it's a clever trick! 
    All the functions that accepted several parameters are curried functions. 
    What does that mean? 
    You'll understand it best on an example. 
    Let's take our good friend, the max function. 
    It looks like it takes two parameters and returns the one that is bigger. 
    Doing max 4 5 first creates a function that takes a parameter and 
        returns either 4 or that parameter, depending on which is bigger. 
    Then, 5 is applied to that function and that function produces our desired result. 
    That sounds like a mouthful but it's actually a really cool concept. 
    The following two calls are equivalent:

    ghci> max 4 5  
    5  
    ghci> (max 4) 5  
    5  

    Putting a space between two things is simply function application. 
    The space is sort of like an operator and it has the highest precedence. 
    Let's examine the type of max. 
    It is max :: (Ord a) => a -> a -> a. 
    That can also be written as max :: (Ord a) => a -> (a -> a). 
    That could be read as: max takes an a and 
        returns (that's the ->) a function that takes an a and returns an a. 
    That is why the return type and the parameters of functions are 
        all simply separated with arrows.

    Simply speaking, if we call a function with too few parameters,
         we get back a partially applied function, 
         meaning a function that takes as many parameters as we left out. 
    Using partial application (calling functions with too few parameters, if you will) 
        is a neat way to create functions on the fly 
        so we can pass them to another function or to seed them with some data.
-}
    
multThree :: (Num a) => a -> a -> a -> a  
multThree x y z = x * y * z  

{- |
    What really happens when we do multThree 3 5 9 or ((multThree 3) 5) 9?
    First, 3 is applied to multThree, because they're separated by a space. 
    That creates a function that takes one parameter and returns a function. 
    So then 5 is applied to that, 
        which creates a function that will take a parameter and multiply it by 15.
    9 is applied to that function and the result is 135. 
    Remember that this function's type could also be written as 
        multThree :: (Num a) => a -> (a -> (a -> a)). 
    The thing before the -> is the parameter that a function takes 
        and the thing after it is what it returns. 
    So our function takes an a and returns a function of type (Num a) => a -> (a -> a). 
    Similarly, this function takes an a and returns a function of type (Num a) => a -> a. 
    And this function, finally, just takes an a and returns an a.
-}

multTwoNumbersWithNine = multThree 9  
-- tests
testMultTwoNumbersWithNine01 = multTwoNumbersWithNine 2 3
-- this is equivalent to multThree 9 2 3

multNumberWithEighteen = multTwoNumbersWithNine 2
-- tests
testMultNumberWithEighteen01 = multNumberWithEighteen 3
-- multNumberWithEighteen 3 = (multTwoNumbersWithNine 2) 3 = ((multThree 9) 2) 3

-- By calling functions with too few parameters, so to speak, 
-- we're creating new functions on the fly.

{- |
    If we wanted to create a function that takes a number and 
        compares it to 100, we could do something like this:
-}

compareWithHundred' :: (Num a, Ord a) => a -> Ordering  
compareWithHundred' x = compare 100 x
-- tests
testCompareWithHundred = compareWithHundred 99

-- The x is on the right hand side on both sides of the equation. 
-- What does compare 100 return?
-- It returns a function that takes a number and compares it with 100.
-- And that is what we need.

compareWithHundred :: (Num a, Ord a) => a -> Ordering  
compareWithHundred = compare 100

-- The type declaration stays the same, because compare 100 returns a function. 
-- Compare has a type of (Ord a) => a -> (a -> Ordering) and 
-- calling it with 100 returns a (Num a, Ord a) => a -> Ordering. 
-- The additional class constraint sneaks up there because 100 is also part of the Num typeclass.

