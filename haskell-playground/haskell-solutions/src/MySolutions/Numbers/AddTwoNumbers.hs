module MySolutions.Numbers.AddTwoNumbers where

addTwoNumbers :: Num a => a -> a -> a
addTwoNumbers a b = a + b

-- tests
addTwoNumbersTest01 = addTwoNumbers 2 3
addTwoNumbersTest02 = addTwoNumbers (-1) 1