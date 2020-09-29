-- scanl and scanr are like foldl and foldr, 
--     only they report all the intermediate accumulator states in the form of a list.
-- There are also scanl1 and scanr1, which are analogous to foldl1 and foldr1.

testScanLeftAddition = scanl (+) 0 [3,5,2,1]  
-- [0,3,8,10,11]  
testScanRightAddition = scanr (+) 0 [3,5,2,1]  
-- [11,8,3,1,0]  
testScanLeftAccumulation = scanl1 (\acc x -> if x > acc then x else acc) [3,4,5,3,7,9,2,1]  
-- [3,4,5,5,7,9,9,9]  
testScanLeftFlip = scanl (flip (:)) [] [3,2,1]  
-- [[],[3],[2,3],[1,2,3]]  

-- When using a scanl, 
--     the final result will be in the last element of the resulting list 
--     while a scanr will place the result in the head.

-- Scans are used to monitor the progression of a function that can be implemented as a fold. 
-- Let's answer us this question:
-- How many elements does it take for 
--     the sum of the roots of all natural numbers to exceed 1000?
-- To get the square roots of all natural numbers, 
--     we just do map sqrt [1..]. 
-- Now, to get the sum, we could do a fold, 
--     but because we're interested in how the sum progresses, 
--     we're going to do a scan. 
-- Once we've done the scan, we just see how many sums are under 1000. 
-- The first sum in the scanlist will be 1, normally.
-- The second will be 1 plus the square root of 2.
-- The third will be that plus the square root of 3.
-- If there are X sums under 1000, then it takes X+1 elements for the sum to exceed 1000.

sqrtSums :: Int  
sqrtSums = length (takeWhile (<1000) (scanl1 (+) (map sqrt [1..]))) + 1  
-- 131  

testSumSqrt01 = sum (map sqrt [1..131])  
-- 1005.0942035344083  
testSumSqrt02 = sum (map sqrt [1..130])  
-- 993.6486803921487  

-- We use takeWhile here instead of filter because filter doesn't work on infinite lists. 
-- Even though we know the list is ascending, filter doesn't, 
--      so we use takeWhile to cut the scanlist off 
--      at the first occurence of a sum greater than 1000.
