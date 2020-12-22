{- |
    Multiples of 3 or 5
    If we list all the natural numbers below 10 that are multiples of 3 or 5, 
    we get 3, 5, 6 and 9. 
    The sum of these multiples is 23. 
    Find the sum of all the multiples of 3 or 5 below 1000. 
-}

module SumOfMultiplesOf3Or5SmallerThanN where

solution :: Integral a => a -> a
solution upperLimit = sum (takeWhile (< upperLimit) (filter isMultipleOf3Or5 [1..])) 
-- Then, filter them so that we get only the multiples of 3 and 5.
-- Then, take elements from that list while they are smaller than upperLimit.
-- Finally, get a sum of that list.

-- We start with some initial data (the infinite list of all natural numbers) and then we map over it, 
-- filter it and cut it until it suits our needs and then we just sum it up.

-- tests
testSolution01 = solution 10
-- 23 

testSolution02 = solution 1000
-- 233168

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

isMultipleOf3Or5 :: Integral a => a -> Bool
isMultipleOf3Or5 x 
    | (x `mod` 3 == 0 || x `mod` 5 == 0) = True
    | otherwise   = False

--tests
isMultipleOf3Or5Test01 = isMultipleOf3Or5 3
-- True
isMultipleOf3Or5Test02 = isMultipleOf3Or5 5
-- True
isMultipleOf3Or5Test03 = isMultipleOf3Or5 15
-- True
isMultipleOf3Or5Test04 = isMultipleOf3Or5 7
-- False