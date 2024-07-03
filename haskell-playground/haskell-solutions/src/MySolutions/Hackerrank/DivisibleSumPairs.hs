module MySolutions.Hackerrank.DivisibleSumPairs where

import Data.List (inits )

-- See List comprehensions

solution :: Integral b => [b] -> Int
solution xs = length $ divisibleSumPairs xs

divisibleSumPairs :: Integral b => [b] -> [(b, b)]
divisibleSumPairs xs = [ (xi, xj)  | 
                           (i, xi) <- zip [0 ..] elements,
                           (j, xj) <- zip [0 ..] elements,
                           i < j,
                           (xi + xj) `mod` k == 0
                       ]
                       where k = xs !! 1
                             elements = drop 2 xs


main :: IO()
main = interact $ show . solution . map read . tail . words

test01 = solution [6,3,1,3,2,6,1,2]
