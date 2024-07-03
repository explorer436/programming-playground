module MySolutions.Hackerrank.SockMerchant where

import Data.List ( group, sort )

solve :: [Int] -> Int
solve xs = sum . map (\xs -> length xs `div` 2) $ group $ sort xs


main :: IO()
main = interact $ show . solve . map read . tail . words



test01 = solve [10, 20, 20, 10, 10, 30, 50, 10, 20]