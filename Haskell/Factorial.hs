-- To run this, load this into Prelude (:l Factorial.hs) and 
-- call the fac function with a parameter.

customFactorialFunctionUsingRecursion :: (Integral a) => a -> a  
customFactorialFunctionUsingRecursion 0 = 1  
customFactorialFunctionUsingRecursion n = n * customFactorialFunctionUsingRecursion (n - 1) 
customFactorialFunctionUsingRecursionTest1 = customFactorialFunctionUsingRecursion 3  
customFactorialFunctionUsingRecursionTest2 = customFactorialFunctionUsingRecursion 5

customFactorialFunctionWithoutUsingRecursion :: (Integral a) => a -> a  
customFactorialFunctionWithoutUsingRecursion n = product [1..n]  
customFactorialFunctionWithoutUsingRecursionTest1 = customFactorialFunctionWithoutUsingRecursion 4  
