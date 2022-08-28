module Numbers.FibonacciSequence where

import Data.List (foldl')
import Data.Array

{- |
    In mathematics, the Fibonacci numbers, commonly denoted Fn, 
    form a sequence, called the Fibonacci sequence, 
    such that each number is the sum of the two preceding ones, starting from 0 and 1.
-}

----------------------------------------------------------------------------
-- A linear-time solution.
-- This is an infinite list. We can just grab how ever many elements we want from the beginning of it.
-- In this approach, the result at each position depends on the result at the previous position.
fibsZ :: [Integer]
fibsZ = 0 : 1 : zipWith (+) fibsZ (tail fibsZ)
-- This works by taking advantage of lazyness.
-- Explanation:
-- n = 0 :    0
-- n = 1 :    1
-- n = 2 :    0:1:zipWith (+) [0,1,<lazy>][1,<lazy>]           = [0,1] + <lazy>
-- n = 3 : => 0:1:(0+1):zipWith (+) [1,1,<lazy>][1,<lazy>]     = [0,1,1] + <lazy>
-- n = 4 : => 0:1:1:(1+1):zipWith (+) [1,2,<lazy>][2,<lazy>]   = [0,1,1,2] + <lazy>
-- n = 5 : => 0:1:1:2:(1+2):zipWith (+) [2,3,<lazy>][3,<lazy>] = [0,1,1,2,3] + <lazy>
-- n = n : => ...
-- The <lazy> part is not evaluated unless it is necessary to do so.
fibsZTest01 :: [Integer]
fibsZTest01 = take 5 fibsZ

----------------------------------------------------------------------------

-- Fibonacci using arrays
fib :: (Ix i, Enum i, Num i, Num e) => i -> e
fib n = fibA n !n

-- fibA array is used even before it is completely defined, thanks to Haskell's laziness.
-- This works in O(n) time.
fibA :: (Enum i, Num i, Num e, Ix i) => i -> Array i e
fibA n = listArray (0,n) [f i | i <- [0..n]]
         where 
           f 0 = 0
           f 1 = 1
           f i = fibA n !(i-1) + fibA n !(i-2)

----------------------------------------------------------------------------

-- This implementation requires O(fib n) additions.
-- This is an inefficient way to get the fibonacci series for a given number n. The number of calls to calculate the values at the positions prior to n will increase exponentially as the value of n increases.
fibonacciUsingRecursion :: Num a => Int -> [a]
fibonacciUsingRecursion n = take n (map fibonacciNumberForPosition [0..])

-- tests
fibonacciUsingRecursionTest01 = fibonacciUsingRecursion 5

-- We are using recursion here.
-- This computes f(n) in unary, in effect.
fibonacciNumberForPosition :: (Eq a, Num a, Num p) => a -> p
fibonacciNumberForPosition 0 = 0
fibonacciNumberForPosition 1 = 1
fibonacciNumberForPosition n = fibonacciNumberForPosition (n-1) + fibonacciNumberForPosition (n-2)

--tests
fibonacciNumberForPositionTest01 = fibonacciNumberForPosition 0 -- 0
fibonacciNumberForPositionTest02 = fibonacciNumberForPosition 1 -- 1
fibonacciNumberForPositionTest03 = fibonacciNumberForPosition 3 -- 2
fibonacciNumberForPositionTest04 = fibonacciNumberForPosition 4 -- 3
fibonacciNumberForPositionTest05 = fibonacciNumberForPosition 5 -- 5
fibonacciNumberForPositionTest06 = fibonacciNumberForPosition 6 -- 8
fibonacciNumberForPositionTest07 = fibonacciNumberForPosition 7 -- 13
fibonacciNumberForPositionTest08 = fibonacciNumberForPosition 8 -- 21
fibonacciNumberForPositionTest09 = fibonacciNumberForPosition 9 -- 34
fibonacciNumberForPositionTest10 = fibonacciNumberForPosition 10 -- 55


----------------------------------------------------------------------------

{- | 
   How can we do this without calculating the fibonacciNumber for a given position without having to calculate it so many times?

   To calculate the n-th term we’ll need access to the (n-1)-th term, and the (n-2)-th term at each step.

   How can we do this with foldl'? 
   foldl' allows us to retain only one variable/value between steps? No problem – let’s use a 3-tuple...
   Look at the implementation below.

   In this function call, type a is Int and type b is (Int, Int, [Int]). 
   The latter is our 3-tuple saviour!

   What do the 3 elements in the tuple represent: - (n-1)the term of the Fibo series - n-th term of te Fibo series - Fibo series containing n-terms

   The lambda evaluates to (y, x + y, fiboList ++ [x+y]), which is of the same type (Int, Int, [Int]). 
   It calculates the n-th element of the Fibo series and also appends it to the 3rd element of the tuple.

   The initial value being passed to foldl' is (0, 1, []), which is of the same type (Int, Int, [Int]). 
   It’s the first two terms of the Fibo series, along with an empty-list (which indicates that we have not accumulated any terms of the Fibo series, yet).

   The third argument to foldl' is [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] which is of type [Int]. 
   Each element of this list is passed as the second argument to the lambda (the first argument is our 3-tuple accumulator). 
   But the lambda doesn’t seem to be doing anything with this value! 
   That is correct. 
   The actual numbers in this list don’t make any difference; only that the number of elements should be 10 (because we want the first 10 terms of the Fibo series). 
   Try the following in GHCi, and verify this for yourself:

   GHCi> foldl' (\ (x, y, fiboList) i -> (y, x + y, fiboList ++ [x+y])) (0, 1, []) [14, 19, 2, 8, 8, 9, 20, 12, 22, 29]
-}

--                      foldl' :: (   b               -> a   ->  b)                            ->  b        ->  [a]
fibonacciUsingFolds :: (Num a1, Num a2, Enum a2) => a2 -> (a1, a1, [a1])
fibonacciUsingFolds n = foldl'    (\ (x, y, fiboList)    i   ->  (y, x + y, fiboList ++ [x+y]))   (0, 1, [])    [1..n]

-- tests
testFibonacciUsingFolds01 = fibonacciUsingFolds 10
-- (55,89,[1,2,3,5,8,13,21,34,55,89])
testFibonacciUsingFolds02 = fibonacciUsingFolds 20
-- (6765,10946,[1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946]) 

test2 = foldl' (\ (x, y, fiboList) i -> (y, x + y, fiboList ++ [x+y])) (0, 1, []) [14, 19, 2, 8, 8, 9, 20, 12, 22, 29]
