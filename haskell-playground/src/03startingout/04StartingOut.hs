testBuiltInSuccessorFunction_01 = succ 8
testBuiltInSuccessorFunction_02 = succ 36

-- usually, when calling a function, just separate the function name from the parameter with a space.
-- if a function needs more than one parameter, just separate the parameters with spaces.
testBuiltInMinFunction_01 = min 9 10
testBuiltInMinFunction_02 = min 3.4 3.2

testBuiltInMaxFunction_01 = max 100 101

-- function application has the highest precedence.
testFunctionPrecedence_01 = succ 9 + max 5 4 * 2
-- 10 + 5 * 2 = 20

testFunctionPrecedence_02 = succ (9 + max 5 4) * 2
-- succ (9 + 5) * 2 = 15 * 2 = 30

-- we can call a function that takes two parameters as an infix function by surroungding it with backticks.
testPrefixNotation_01 = div 92 10
testInfixNotation_01 = 92 `div` 10

-----------------------------------------------------------------------------------------

-- Custom functions

square x = x * x
testSquareFunction_01 = square 4

doubleANumber x = x + x
-- alternatively, 2 * x
testDoubleANumberFunction_01 = doubleANumber 9
-- 18

--  doubleUs x y = x*2 + y*2
doubleUs x y = doubleANumber x + doubleANumber y
testDoubleUsFunction_01 = doubleUs 9 10
-- 38


-- introduction to if statement
-- the else part is mandatory in Haskell.

-- the if statement is an expression - a piece of code that returns a value.

doubleSmallNumber x = if x > 10
then x
else x * 2
testDoubleSmallNumber_01 = doubleSmallNumber 8
--  16
testDoubleSmallNumber_02 = doubleSmallNumber 17
-- 17

-- function names cannot begin with capital letters.


