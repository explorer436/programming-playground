{- |
    In mathematics, the Fibonacci numbers, commonly denoted Fn, 
    form a sequence, called the Fibonacci sequence, 
    such that each number is the sum of the two preceding ones, starting from 0 and 1.
-}

import AddTwoNumbers (addTwoNumbers)



fib n
    | (n == 0)  = 0
    | (n == 1)  = 1
    | otherwise = (fib n-1) + (fib n-2)

--tests
testFib01 = fib 0
testFib02 = fib 1
testFib03 = fib 3