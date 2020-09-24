-- To run this, load this into Prelude (:l Factorial.hs) and 
-- call the fac function with a parameter.

-- using pattern matching
customFactorialFunctionUsingRecursion :: (Integral a) => a -> a  
customFactorialFunctionUsingRecursion 0 = 1  
customFactorialFunctionUsingRecursion n = n * customFactorialFunctionUsingRecursion (n - 1) 
-- test cases
customFactorialFunctionUsingRecursionTest1 = customFactorialFunctionUsingRecursion 3  
customFactorialFunctionUsingRecursionTest2 = customFactorialFunctionUsingRecursion 5

customFactorialFunctionWithoutUsingRecursion :: (Integral a) => a -> a  
-- using Haskell's native product function
customFactorialFunctionWithoutUsingRecursion n = product [1..n]  
-- test cases
customFactorialFunctionWithoutUsingRecursionTest1 = customFactorialFunctionWithoutUsingRecursion 4  
