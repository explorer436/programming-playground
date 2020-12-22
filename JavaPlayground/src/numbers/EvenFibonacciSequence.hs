module EvenFibonacciSequence where

import Data.List (foldl')

-- This implementation requires O(fib n) additions.

-- solution :: Num a => Int -> [a]
solution n = take n (filter (even) (map (fibonacciNumberForPosition) [1..]))

-- tests
testSolution01 = solution 5

-- We are using recursion here.
fibonacciNumberForPosition :: (Eq a, Num a, Num p) => a -> p
fibonacciNumberForPosition 0 = 0
fibonacciNumberForPosition 1 = 1
fibonacciNumberForPosition n = fibonacciNumberForPosition (n-1) + fibonacciNumberForPosition (n-2)

--tests
testFibonacciNumberForPosition01 = fibonacciNumberForPosition 0 -- 0
testFibonacciNumberForPosition02 = fibonacciNumberForPosition 1 -- 1
testFibonacciNumberForPosition03 = fibonacciNumberForPosition 3 -- 2
testFibonacciNumberForPosition04 = fibonacciNumberForPosition 4 -- 3
testFibonacciNumberForPosition05 = fibonacciNumberForPosition 5 -- 5
