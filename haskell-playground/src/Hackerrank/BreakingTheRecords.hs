module Hackerrank.BreakingTheRecords where

import Data.List ( group, inits )

solve :: [Int] -> [Int]
solve xs = [best, worst]
    where best  = length (group $ map maximum $ tail $ inits $ tail xs) - 1
          worst = length (group $ map minimum $ tail $ inits $ tail xs) - 1


main :: IO()
main = interact $ unwords . map show . solve . map read . words

-- tests
test01 = solve [9,10,5,20,20,4,5,2,25,1]
-- [2,4]