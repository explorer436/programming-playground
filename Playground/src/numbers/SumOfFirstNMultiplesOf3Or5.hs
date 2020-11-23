module SumOfFirstNMultiplesOf3Or5 where

isMultipleOf3Or5 n = if (n `mod` 3 == 0 || n `mod` 3 == 0) then True else False

firstNMultiplesOf3Or5 :: Integral a => Int -> [a]
firstNMultiplesOf3Or5 n = take n $ filter isMultipleOf3Or5 [1..]

-- tests
testFirstNMultiplesOf3Or501 = firstNMultiplesOf3Or5 10
-- [3,6,9,12,15,18,21,24,27,30]

-- We start with an infinite list of all natural numbers and then we filter it and take the first 'n' elements of the list

solution n = sum $ firstNMultiplesOf3Or5 n
testSolution01 = solution 3 --18
