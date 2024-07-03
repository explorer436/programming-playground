module MySolutions.Hackerrank.NumberLineJumps where 

-- If they meet after time k, this will be true: x1 + k v1 = x2 + k V2.
-- If we solve for k and if k is an interger, then they meet.
-- k = (x2 - x1) / (v1 - v2)
-- If k is an integer, (x2 - x1) `mod` (v1 - v2) will be 0.

-- Note that x1 < x2
solve [x1, v1, x2, v2]
    | v2 < v1 && (x2 - x1) `mod` (v1 - v2) ==0 = "YES"
    | otherwise                                = "NO"

main :: IO()
main = interact $ solve . map read . words

-- tests
test01 = solve [0,3,4,2]
-- YES