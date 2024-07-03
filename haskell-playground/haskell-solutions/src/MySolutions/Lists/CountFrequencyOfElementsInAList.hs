module MySolutions.Lists.CountFrequencyOfElementsInAList (countFrequencyOfAnElementUsingListComprehension, countFrequencyOfAnElementUsingRecursion, countFrequencyOfAllElements) where

import qualified Data.Map as Map

-- How to count the number of occurances of an element in a list?





-- Using List Comprehension
countFrequencyOfAnElementUsingListComprehension :: Eq a => [a] -> a -> Int 
-- base condition
countFrequencyOfAnElementUsingListComprehension [] elementToBeFound = 0
-- main condition
countFrequencyOfAnElementUsingListComprehension xs elementToBeFound = length x
    where x = [x | x <- xs, x == elementToBeFound]  






-- Using Recursion
countFrequencyOfAnElementUsingRecursion :: Eq a => [a] -> a -> Int
-- base condition
countFrequencyOfAnElementUsingRecursion [] elementToBeFound = 0
-- main condition
countFrequencyOfAnElementUsingRecursion (x:xs) elementToBeFound 
    | elementToBeFound == x = 1 + (countFrequencyOfAnElementUsingRecursion xs elementToBeFound)
    | otherwise = countFrequencyOfAnElementUsingRecursion xs elementToBeFound    



-- countFrequencyOfAllElements :: (Ord k, Num a, Enum a) => [k] -> Map.Map k a
-- countFrequencyOfAllElements :: (Ord k, Num a, Enum a) => [k] -> [(k, a)]
countFrequencyOfAllElements xs = Map.toList $ Map.fromListWith (\count1 count2 -> count1 + count2) (zip xs[1,1..])
-- This could also be written as follows:
-- countFrequencyOfAllElements xs = Map.fromListWith (+) (zip xs[1,1..])
