module MySolutions.Numbers.LeapYear where

{- |
    Leap year
`    Write a function which checks if a given year is a leap year:

    module Leap where

    isLeapYear :: Int -> Bool
    isLeapYear yr = _todo
    Here is the logic for determining a leap year:

    every year that is evenly divisible by 4 is a leap year
    except every year that is evenly divisible by 100
    unless the year is also evenly divisible by 400
    Hint: You will need to use the mod function and a bunch of if-then-else statements to get this done.

    GHCi> :l Leap
    GHCi> isLeapYear 2000
    True
    GHCi> isLeapYear 1999
    False`
-}

solutionUsingIfElse :: Int -> Bool
solutionUsingIfElse yr = 
    if (yr `mod` 400 == 0) then True
    else if (yr `mod` 100 == 0) then False
    else if (yr `mod` 4 == 0) then True
    else False

-- Note: Read about Guards.
-- Using Guards is preferable here.
-- The thing is that guards are a lot more readable when you have several conditions and 
-- they play really nicely with patterns.

solutionUsingGuards :: Int -> Bool
solutionUsingGuards yr
    | (yr `mod` 400 == 0) = True
    | (yr `mod` 100 == 0) = False
    | (yr `mod` 4 == 0) = True
    | otherwise   = False

--tests

solutionUsingIfElseTest01 = solutionUsingIfElse 2000    
--True
solutionUsingIfElseTest02 = solutionUsingIfElse 1999
--False
solutionUsingIfElseTest03 = solutionUsingIfElse 500
--False
solutionUsingIfElseTest04 = solutionUsingIfElse 400
--True
solutionUsingIfElseTest05 = solutionUsingIfElse 100
--False
solutionUsingIfElseTest06 = solutionUsingIfElse 4
--True


solutionUsingGuardsTest01 = solutionUsingGuards 2000    
--True
solutionUsingGuardsTest02 = solutionUsingGuards 1999
--False
solutionUsingGuardsTest03 = solutionUsingGuards 500
--False
solutionUsingGuardsTest04 = solutionUsingGuards 400
--True
solutionUsingGuardsTest05 = solutionUsingGuards 100
--False
solutionUsingGuardsTest06 = solutionUsingGuards 4
--True