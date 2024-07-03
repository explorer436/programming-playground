module MySolutions.Numbers.SumOfAllEvenNumbersInAListOfIntegers where

solution :: [Int] -> Int
solution xs = 
    if null xs then 0
    else sum (filter even xs)


--tests
solutionTest01 = solution [1,2]
-- 2        
solutionTest02 = solution [1,2,3,4,5]        
-- 6
solutionTest03 = solution []
-- 0

-- This can also be written recursively or using folds
