-- How to find the unique numbers in an array
-- e.g. input [1, 2, 1, 3], the result should be [2, 3]
removeDuplicateEntriesFromList inputList = [x | x <- inputList, countOccurancesInAnArrayUsingRecursion inputList x == 1]
removeDuplicateEntriesFromListTest1 = removeDuplicateEntriesFromList [1,2,3,4,5,1,2]
removeDuplicateEntriesFromListTest2 = removeDuplicateEntriesFromList [1,2,1,3]