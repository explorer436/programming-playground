module Datastructures.Lists.CountNumberOfOccurancesInAList (countOccurancesInAnArrayUsingListComprehension, countOccurancesInAnArrayUsingRecursion) where

-- How to count the number of occurances of an element in a list?





-- Using List Comprehension
countOccurancesInAnArrayUsingListComprehension :: Eq a => [a] -> a -> Int 
-- base condition
countOccurancesInAnArrayUsingListComprehension [] elementToBeFound = 0
-- main condition
countOccurancesInAnArrayUsingListComprehension xs elementToBeFound = length x
    where x = [x | x <- xs, x == elementToBeFound]  






-- Using Recursion
countOccurancesInAnArrayUsingRecursion :: Eq a => [a] -> a -> Int
-- base condition
countOccurancesInAnArrayUsingRecursion [] elementToBeFound = 0
-- main condition
countOccurancesInAnArrayUsingRecursion (x:xs) elementToBeFound 
    | elementToBeFound == x = 1 + (countOccurancesInAnArrayUsingRecursion xs elementToBeFound)
    | otherwise = countOccurancesInAnArrayUsingRecursion xs elementToBeFound    

