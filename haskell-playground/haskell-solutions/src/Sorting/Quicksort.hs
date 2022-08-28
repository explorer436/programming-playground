module Sorting.Quicksort where

{- |
    Quicksort definition: 
    A sorted list is a list 
        that has all the values smaller than (or equal to) the head of the list in front 
        (and those values are sorted), 
        then comes the head of the list in the middle and 
        then come all the values that are bigger than the head (they're also sorted).
-}

-- Notice that we defined it using the verb `is` to define the algorithm 
-- instead of saying do this, do that, then do that .... 
-- That's the beauty of functional programming!


-- How are we going to filter the list 
-- so that we get only the elements smaller than the head of our list and 
-- only elements that are bigger?
-- List comprehensions.
quicksort1 :: (Ord a) => [a] -> [a]  
quicksort1 [] = []  
quicksort1 (x:xs) =   
        let smallerSorted = quicksort1 [a | a <- xs, a <= x]  
            biggerSorted = quicksort1 [a | a <- xs, a > x]  
        in  smallerSorted ++ [x] ++ biggerSorted  

-- tests
testQuicksort1_01 = quicksort1 [10,2,5,3,1,6,7,4,2,3,4,8,9]     

-- Quick sort using filter
quicksort2 :: (Ord a) => [a] -> [a]    
quicksort2 [] = []    
quicksort2 (x:xs) =     
    let smallerSorted = quicksort2 (filter (<=x) xs)  
        biggerSorted = quicksort2 (filter (>x) xs)   
    in  smallerSorted ++ [x] ++ biggerSorted 
testQuicksort2_01 = quicksort2 [10,2,5,3,1,6,7,4,2,3,4,8,9]     
