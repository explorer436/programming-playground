module MySolutions.Strings.FizzBuzz (fizzBuzz) where

fizzBuzz :: Int -> [[Char]]
fizzBuzz n = take n (map fizzOrBuzzOrFizzBuzz [1..])

fizzOrBuzzOrFizzBuzz :: (Integral a, Show a) => a -> [Char]
fizzOrBuzzOrFizzBuzz n 
    | n `mod` 3 == 0 && n `mod` 5 == 0 = "FizzBuzz"  
    | n `mod` 3 == 0                   = "Fizz"  
    | n `mod` 5 == 0                   = "Buzz"  
    | otherwise                        = show n 
