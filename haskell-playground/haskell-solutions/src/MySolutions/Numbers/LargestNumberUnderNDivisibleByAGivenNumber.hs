module MySolutions.Numbers.LargestNumberUnderNDivisibleByAGivenNumber (largestDivisible) where

largestDivisible :: Integral a => a -> a -> a
largestDivisible n d = head (filter p [n,n-1..])
    where p x = x `mod` d == 0

-- We do not have to start with a finite list for our starting set.
-- laziness is in action here.
-- The evaluation stops when the first adequate solution is found.

-- tests
testLargestDivisible01 = largestDivisible 100000 3829
-- 99554
