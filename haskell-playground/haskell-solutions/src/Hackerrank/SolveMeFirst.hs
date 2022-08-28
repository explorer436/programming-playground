module Hackerrank.SolveMeFirst where

import Data.Char

-- The problem we need to solve here is : 

{- |
  Complete the function solveMeFirst to compute the sum of two integers.

    Function prototype:

    int solveMeFirst(int a, int b);

    where,

        a is the first integer input.
        b is the second integer input

    Return values

        sum of the above two integers

    Sample Input

    a = 2
    b = 3

    Sample Output

    5

    Explanation

    The sum of the two integers a and b is computed as: 2 + 3 = 5. 
-}

-- Basically, read two numbers from standard input and print their sum on standard output.

{- |
    Prelude> :t interact
    interact :: (String -> String) -> IO () 

    This takes another function as argument and produces a side effect.
    The input string is the standard input of the program.
    The output string is the standard output of the program.

    Using this, we write interactive Haskell programs in a declarative way.
-}



{- |
    Use prelude to get info on the helpful operators for this function.

    Prelude> :t ($)
    ($) :: (a -> b) -> a -> b
    Applying a bunch of functions one after the other on a parameter x : f1 (f2 (f3 (f4 x)))
    In Haskell, applying a function f on parameter x can be written as f $ x = f x
    So, appying f1, f2, f3 and f4 on x can be written as f1 $ f2 $ f3 $ f4 x

    Prelude> :t (.)
    (.) :: (b -> c) -> (a -> b) -> a -> c
    It is the functional composition for Math. see wikipedia for more details.

    Prelude> :t interact
    interact :: (String -> String) -> IO ()
    The first string is the standard input to the program.
    The second string is the standard output from the program.

    Prelude> :t words
    words :: String -> [String]
    Words is to split the incoming strings into separate parts and insert them in an array.

    Prelude> :t read
    read :: Read a => String -> a
    Description: 	casts strings to another type 
    http://www.zvon.org/other/haskell/Outputprelude/read_f.html
    -- read is to convert an element into a specifid Datatype - in this scenario, we want to convert the elements into integers.
    --     Usually, it's syntax is like this : read "5" :: Int
    --     If we just try to read something and not specify a DataType for it (e.g. read "5"), ghci will throw an error. 
    --     This is because, ghci will not know how to determine the Type of the parameter that it is reading.
    --     If we are using the result of the "read" operator for something else, we don't have to specify the Type because GHCI will infer the Type of the result that we want out of our read using the rest of the parameters.
    --     e.g. read "5" -2 (The result will be 3)

    Prelude> :t map
    map :: (a -> b) -> [a] -> [b]
    Description: 	returns a list constructed by 
        appling a function (the first argument) to 
        all items in a list passed as the second argument.

    Prelude> :t sum
    sum :: (Foldable t, Num a) => t a -> a
    Description: 	computes a sum of all elements in the list

    Prelude> :t show
    show :: Show a => a -> String
-}

-- We will use the $ operator to separate "interact" with it's parameters.



-- firstFunction abc = show $ sum $ ((map read $ words abc) :: [Int])
--  since sum returns an Integer, we don't have to specify that the output of the map should be an Integer array. It is automatically inferred.
readAListOfNumbersAsStringsAndPrintTheirSumAsString :: String -> String
readAListOfNumbersAsStringsAndPrintTheirSumAsString inputStringArray = 
    show $ sum $ map read $ words inputStringArray

-- tests
readAListOfNumbersAsStringsAndPrintTheirSumAsStringTest1 = 
    readAListOfNumbersAsStringsAndPrintTheirSumAsString "1 2 3"

-- To submit the solution, we have to convert the above expression into a function 
-- which we can put into interact.
-- So, take the expression and replace all the `$` signs with functional composition.
main = interact $
        show . sum . map read . words

------------------------------------------------------------

-- breaking it down:


f1 :: String -> [String]
f1 inputString = words inputString
-- tests
f1Test_01 = f1 "1 2 3"
-- ["1","2","3"]


-- map is to do the operation for all the elements of the list xs. 
f2 :: [String] -> [Int]
f2 xs = map read xs
-- This can also be written as : f2 xs = map (read) xs
-- The two statements above are equivalent to : f2 xs = [read n | n <- xs] :: [Int]
-- tests
f2Test_01 = f2 ["1","2","3"]
-- [1,2,3]


-- sum is to take all the elements of the Integer array and produce a sum of them.
f3 :: (Foldable t, Num a) => t a -> a
f3 abc = sum abc
-- tests
f3Test_01 = f3 [1,2,3]
-- [1,2,3]


-- show is to convert the number (from sum) back into a string.
finalSolutionThatWillGiveTheResultAsString :: String -> String
finalSolutionThatWillGiveTheResultAsString inputStringArray = show $ f3 $ f2  $ f1 inputStringArray
-- tests
finalSolutionThatWillGiveTheResultAsStringTest_01 = finalSolutionThatWillGiveTheResultAsString "1 2 3"


finalSolutionThatWillGiveTheResultAsInt :: String -> Int
finalSolutionThatWillGiveTheResultAsInt inputStringArray = f3 $ f2  $ f1 inputStringArray
-- tests
finalSolutionThatWillGiveTheResultAsIntTest_01 = finalSolutionThatWillGiveTheResultAsInt "1 2 3"


------------------------------------------------------------

-- If the input is an integer array as opposed to a string separated by spaces,
-- we don't have to use `words` and `map read`.
-- All we would have to use is `sum`

f4 :: [Int] -> Int
f4 xs = sum xs
--tests
f4Tests_01 = f4 [1,2,3]








