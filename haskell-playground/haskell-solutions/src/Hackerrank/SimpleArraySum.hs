module Hackerrank.SimpleArraySum where

{- |
    Given an array of integers, find the sum of its elements.

    For example, if the array ar = [1,2.3], 1 + 2 + 3 = 6, so return 6.

    Function Description

    Complete the simpleArraySum function in the editor below. It must return the sum of the array elements as an integer.

    simpleArraySum has the following parameter(s):

        ar: an array of integers

    Input Format

    The first line contains an integer, n, denoting the size of the array.
    The second line contains n space-separated integers representing the array's elements.

    Constraints
    0 < n, ar[i] <= 1000

    Output Format

    Print the sum of the array's elements as a single integer.

    Sample Input

    6
    1 2 3 4 10 11

    Sample Output

    31

    Explanation

    We print the sum of the array's elements:
-}

-- see SolveMeFirst.hs for explanation.

-- `tail` is to ignore the first element of the input.
-- We don't really need to know the length. So ignore it.

simpleArraySum :: String -> String
simpleArraySum inputStringArray = 
    show $ sum $ map read $ words $ tail inputStringArray
-- tests
simpleArraySumTest_01 = simpleArraySum "6 1 2 3 4 10 11"
-- "31"

-- To submit the solution, we have to convert the above expression into a function 
-- which we can put into interact.
-- So, take the expression and replace all the `$` signs with functional composition.
main = interact $
        show . sum . map read . words . tail
