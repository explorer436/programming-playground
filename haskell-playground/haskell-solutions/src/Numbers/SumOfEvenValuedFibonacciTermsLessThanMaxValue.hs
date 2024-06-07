module Numbers.SumOfEvenValuedFibonacciTermsLessThanMaxValue where

import qualified Numbers.FibonacciSequence as FS

-- solution upperLimit = take n (map (fibonacciNumberForPosition) [0..])

solution :: Integral a => a -> a
solution upperLimit = sum (takeWhile (< upperLimit) (filter odd (map (FS.fibonacciNumberForPosition) [0..])))  

-- sum (takeWhile (< upperLimit) (filter odd (map (^2) [1..])))  

-- tests
solutionTest01 = solution 55
-- even numbers of 0,1,1,2,3,5,8,13,21,34,55,89,.. are 2,8,34
-- result should be 44.