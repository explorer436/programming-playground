module FizzBuzz where


solution n = take n (map (fizzOrBuzzOrFizzBuzz) [1..])

-- tests
solutionTest01 = solution 5
solutionTest02 = solution 20

fizzOrBuzzOrFizzBuzz :: (Integral a, Show a) => a -> [Char]
fizzOrBuzzOrFizzBuzz n 
    | (n `mod` 3 == 0 && n `mod` 5 == 0) = "FizzBuzz"  
    | (n `mod` 3 == 0)                    = "Fizz"  
    | (n `mod` 5 == 0)                    = "Buzz"  
    | otherwise                           = show n 
