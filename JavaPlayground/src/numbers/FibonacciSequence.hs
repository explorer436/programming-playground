module FibonacciSequence where

{- |
    In mathematics, the Fibonacci numbers, commonly denoted Fn, 
    form a sequence, called the Fibonacci sequence, 
    such that each number is the sum of the two preceding ones, starting from 0 and 1.
-}


-- This implementation requires O(fib n) additions.

solution :: Num a => Int -> [a]
solution n = take n (map (fibonacciNumberForPosition) [0..])

-- tests
solutionTest01 = solution 5

fibonacciNumberForPosition :: (Eq a, Num a, Num p) => a -> p
fibonacciNumberForPosition 0 = 0
fibonacciNumberForPosition 1 = 1
fibonacciNumberForPosition n = fibonacciNumberForPosition (n-1) + fibonacciNumberForPosition (n-2)

--tests
fibonacciNumberForPositionTest01 = fibonacciNumberForPosition 0
fibonacciNumberForPositionTest02 = fibonacciNumberForPosition 1
fibonacciNumberForPositionTest03 = fibonacciNumberForPosition 3
fibonacciNumberForPositionTest04 = fibonacciNumberForPosition 4
fibonacciNumberForPositionTest05 = fibonacciNumberForPosition 5
