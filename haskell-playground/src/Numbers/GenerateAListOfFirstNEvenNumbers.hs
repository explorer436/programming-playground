module Numbers.GenerateAListOfFirstNEvenNumbers where

solution :: Integral a => Int -> [a]
solution n = take n $ filter even [1..]

-- tests
testSolution01 = solution 10
-- [2,4,6,8,10,12,14,16,18,20]

-- We start with an infinite list of all natural numbers and then we filter it and take the first 'n' elements of the list
