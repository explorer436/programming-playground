module Numbers.GenerateAListOfAllEvenNumbersTillN where

-- Important - This is not going to work with the following type signature
-- solution :: Int => [Int]
-- TODO What is the reason for this?

solution :: Integral a => a -> [a]
solution n = 
    if n == 0 then []
    else takeWhile (< n) (filter even [1..])

-- tests
testSolution01 = solution 10
-- [2,4,6,8,10] 

-- We start with an infinite list of all natural numbers and then we filter it

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
