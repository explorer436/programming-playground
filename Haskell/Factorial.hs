-- To run this, load this into Prelude (:l Factorial.hs) and 
-- call the fac function with a parameter.
-- fac 5

fac 0 = 1
fac n = n * fac (n-1)

-- main = print (fac 42)
factorialOfFive = fac 5


customFactorialFunctionUsingRecursion :: (Integral a) => a -> a  
customFactorialFunctionUsingRecursion 0 = 1  
customFactorialFunctionUsingRecursion n = n * customFactorialFunctionUsingRecursion (n - 1) 


customFactorialFunctionUsingRecursionTest1 = customFactorialFunctionUsingRecursion 3  



customFactorialFunctionWithoutUsingRecursion :: (Integral a) => a -> a  
customFactorialFunctionWithoutUsingRecursion n = product [1..n]  

customFactorialFunctionWithoutUsingRecursionTest1 = customFactorialFunctionWithoutUsingRecursion 4  
