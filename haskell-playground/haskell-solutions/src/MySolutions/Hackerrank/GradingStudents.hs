module MySolutions.Hackerrank.GradingStudents where

main = interact $
            unlines . map show . solve . map read . tail . words

solve :: [Int] -> [Int]
solve xs = map round5 xs 


round5 :: Int -> Int
round5 x
    | x < 38 = x
    | (nextMultipleOf5Forx - x) < 3 = nextMultipleOf5Forx
    | otherwise = x
    where nextMultipleOf5Forx = x + (5 - x `mod` 5)

--tests
testRound5_01 = round5 73  
-- 75  
testRound5_02 = round5 67
-- 67
testRound5_03 = round5 38
-- 40
testRound5_04 = round5 33
-- 38


-- modular arithmetic
-- Prelude> :t mod
-- mod :: Integral a => a -> a -> a

-- Prelude> :t unlines
-- unlines :: [String] -> String



