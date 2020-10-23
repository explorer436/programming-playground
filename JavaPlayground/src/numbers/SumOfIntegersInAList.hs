module SumOfIntegersInAList where

integerListSumPatternMatching :: [Int] -> Int
integerListSumPatternMatching [] = 0  
integerListSumPatternMatching (x:xs) = x + integerListSumPatternMatching xs
--tests
integerListSumPatternMatchingTest01 = integerListSumPatternMatching [1,2,3]        
integerListSumPatternMatchingTest02 = integerListSumPatternMatching []

integerListSumRecursion :: [Int] -> Int
integerListSumRecursion xs = 
    if xs == [] then 0
    else head xs + integerListSumRecursion (tail xs)
-- tests
integerListSumRecursionTest01 = integerListSumRecursion []  
integerListSumRecursionTest02 = integerListSumRecursion [4,5,6]