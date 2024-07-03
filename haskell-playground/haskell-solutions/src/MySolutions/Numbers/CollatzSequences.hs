module MySolutions.Numbers.CollatzSequences where

{- |
    We take a natural number. 
    If that number is even, we divide it by two. 
    If it's odd, we multiply it by 3 and then add 1 to that. 
    We take the resulting number and apply the same thing to it, which produces a new number and so on. 
    In essence, we get a chain of numbers. 
    It is thought that for all starting numbers, the chains finish at the number 1. 
    So if we take the starting number 13, 
        we get this sequence: 13, 40, 20, 10, 5, 16, 8, 4, 2, 1.
        13*3 + 1 equals 40.
        40 divided by 2 is 20, etc.
        We see that the chain has 10 terms.

Now what we want to know is this: 
    for all starting numbers between 1 and 100, 
    how many chains have a length greater than 15?
-}

-- First, write a function that produces a chain:
chain :: (Integral a) => a -> [a]  
chain 1 = [1]  
chain n  
    | even n =  n:chain (n `div` 2)  
    | odd n  =  n:chain (n*3 + 1) 
--tests
testChain01 = chain 10
testChain02 = chain 1
testChain03 = chain 30


-- Now, the solution:
numLongChains1 :: Int  
numLongChains1 = length (filter isLengthGreaterThan15 (map chain [1..100]))  
    where isLengthGreaterThan15 xs = length xs > 15 
-- We map the chain function to [1..100] to get a list of chains, which are themselves represented as lists.
-- Then, apply a filter to see if the length of the list is greater than 15.
-- Next, see how many lists are left by using `length`.
-- 66


{- |
    Note: This function has a type of numLongChains1 :: Int because length returns an Int instead of a Num a for historical reasons. 
    If we wanted to return a more general Num a, we could have used fromIntegral on the resulting length.
-}

------------------------------------------------------------

numLongChains2 :: Int  
numLongChains2 = length (filter (\xs -> length xs > 15) (map chain [1..100]))  

