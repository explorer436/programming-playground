module Numbers.LargestNumberUnderNDivisibleByAGivenNumber where

largestDivisible :: (Integral a) => a  
largestDivisible = head (filter p [100000,99999..])  
    where p x = x `mod` 3829 == 0  

-- We don not have to start with a finite list for our starting set.
-- laziness is in action here.
-- The evaluation stops when the first adequate solution is found.

-- tests
testLargestDivisible01 = largestDivisible
-- 99554
