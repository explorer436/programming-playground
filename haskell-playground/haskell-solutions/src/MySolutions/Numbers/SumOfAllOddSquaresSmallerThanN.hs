module MySolutions.Numbers.SumOfAllOddSquaresSmallerThanN (sumOfAllOddSquaresSmallerThanN) where

sumOfAllOddSquaresSmallerThanN :: Integral a => a -> a
sumOfAllOddSquaresSmallerThanN n = sum (takeWhile (< n) (filter odd (map (^2) [1..])))  
-- Begin by mapping the (^2) function to the infinite list [1..].
-- Then, filter them so that we get only the odd ones.
-- Then, take elements from that list while they are smaller than 10,000.
-- Finally, get a sum of that list.

-- We start with some initial data (the infinite list of all natural numbers) and then we map over it, filter it and cut it until it suits our needs and then we just sum it up.

{- |
    takeWhile function takes a predicate and a list 
    and then goes from the beginning of the list 
    and returns its elements while the predicate holds true. 
    Once an element is found for which the predicate doesn't hold, it stops.    
   
   If we wanted to get the first word of the string "elephants know how to party",
   we could do 
   takeWhile (/=' ') "elephants know how to party"
   and it would return "elephants". 
 
--}


-- TODO fix this.
-- Same solution using List comprehensions:
-- solution2 :: Integral a => a -> a
-- solution2 = sum (takeWhile (<10000) [n^2 | n <- [1..], odd (n^2)])
-- testSolution02 = solution2 10000


{- |
    It's a matter of taste as to which one you find prettier. 
    Again, Haskell's property of laziness is what makes this possible. 
    We can map over and filter an infinite list, 
        because it won't actually map and filter it right away, it'll delay those actions. 
    Only when we force Haskell to show us the sum 
        does the sum function say to the takeWhile that it needs those numbers.
    takeWhile forces the filtering and mapping to occur, 
        but only until a number greater than or equal to 10,000 is encountered. 
--}
