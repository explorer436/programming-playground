-- How to count the number of occurances of an element in a list using List Comprehension?
countOccurancesInAnArrayUsingListComprehension :: Eq a => [a] -> a -> Int 
-- base condition
countOccurancesInAnArrayUsingListComprehension [] elementToBeFound = 0
-- main condition
countOccurancesInAnArrayUsingListComprehension xs elementToBeFound = length x
    where x = [x | x <- xs, x == elementToBeFound]  

-- tests  
countOccurancesInAnArrayUsingListComprehensionTest1 = countOccurancesInAnArrayUsingListComprehension [1,2,3,1] 2
-- 1
countOccurancesInAnArrayUsingListComprehensionTest2 = countOccurancesInAnArrayUsingListComprehension [1,2,3,1] 5
-- 0
countOccurancesInAnArrayUsingListComprehensionTest3 = countOccurancesInAnArrayUsingListComprehension [1,2,3,1] 1
-- 2
countOccurancesInAnArrayUsingListComprehensionTest4 = countOccurancesInAnArrayUsingListComprehension "bruce" 'b'
-- 1

-- How to count the number of occurances of an element in a list using Recursion?
countOccurancesInAnArrayUsingRecursion :: Eq a => [a] -> a -> Int
-- base condition
countOccurancesInAnArrayUsingRecursion [] elementToBeFound = 0
-- main condition
countOccurancesInAnArrayUsingRecursion (x:xs) elementToBeFound 
    | elementToBeFound == x = 1 + (countOccurancesInAnArrayUsingRecursion xs elementToBeFound)
    | otherwise = countOccurancesInAnArrayUsingRecursion xs elementToBeFound    

-- tests  
countOccurancesInAnArrayUsingRecursionTest1 = countOccurancesInAnArrayUsingRecursion [1,2,3,1] 2
-- 1
countOccurancesInAnArrayUsingRecursionTest2 = countOccurancesInAnArrayUsingRecursion [1,2,3,1] 5
-- 0
countOccurancesInAnArrayUsingRecursionTest3 = countOccurancesInAnArrayUsingRecursion [1,2,3,1] 1
-- 2
countOccurancesInAnArrayUsingRecursionTest4 = countOccurancesInAnArrayUsingRecursion "bruce" 'b'
-- 1
