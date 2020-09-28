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

quicksort :: (Ord a) => [a] -> [a]  
quicksort [] = []  
quicksort (x:xs) =   
        let smallerSorted = quicksort [a | a <- xs, a <= x]  
            biggerSorted = quicksort [a | a <- xs, a > x]  
        in  smallerSorted ++ [x] ++ biggerSorted  

-- tests
testQuicksort01 = quicksort [10,2,5,3,1,6,7,4,2,3,4,8,9]     