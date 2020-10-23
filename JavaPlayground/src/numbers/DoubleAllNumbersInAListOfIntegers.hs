module DoubleAllNumbersInAListOfIntegers where

solution :: [Int] -> [Int]
solution xs = 
    if xs == [] then []
    else map (*2) (xs)


--tests
solutionTest01 = solution [1,2]
-- [2,4]      
solutionTest02 = solution [1,2,3,4,5]        
-- [2,4,6,8,10]
solutionTest03 = solution []
-- []
