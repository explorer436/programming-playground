import Data.Char

-- The problem we need to solve here is : read two numbers from standard input and print their sum on standard output.

-- Helpful operators for this function: 
-- Use prelude to get info on all of them.
-- :t ($)
-- :t (.)

-- what is a $  operator? In Prelude, type :t ($)
-- Applying a bunch of functions one after the other on a parameter x : f1 (f2 (f3 (f4 x)))
-- In Haskell, applying a function f on parameter x can be written as f $ x = f x
-- So, appying f1, f2, f3 and f4 on x can be written as f1 $ f2 $ f3 $ f4 x

-- We will use the $ operator to separate "interact" with it's parameters.

-- what is the . (dor) operator? In Prelude, type :t (.)
-- it is the functional composition for Math. see wikipedia for more details.

-- what is Haskell's interact function: In Prelude, type :t interact
-- interact :: (String -> String) -> IO ()
-- The first string is the standard input to the program.
-- The second string is the standard output from the program.

-- firstFunction abc = show $ sum $ ((map read $ words abc) :: [Int])
--  since sum returns an Integer, we don't have to specify that the output of the map should be an Integer array. It is automatically inferred.
readAListOfNumbersAsStringsAndPrintTheirSumAsString :: String -> String
readAListOfNumbersAsStringsAndPrintTheirSumAsString inputStringArray = show $ sum $ map read $ words inputStringArray
-- This can also be written as follows
-- readAListOfNumbersAsStringsAndPrintTheirSumAsString inputStringArray = show $ sum $ map (read) $ words inputStringArray

{- |
f1 :: String -> [String]
f1 inputStringArray = words inputStringArray

f2 :: [String] -> [Int]
f2 input = [read n | n <- input] :: [Int]

f3 :: (Foldable t, Num a) => t a -> a
f3 abc = sum abc

readAListOfNumbersAsStringsAndPrintTheirSumAsString :: String -> String
readAListOfNumbersAsStringsAndPrintTheirSumAsString inputStringArray = show $ f3 $ f2  $ f1 inputStringArray
-}


-- words is to split the incoming strings into separate parts and insert them in an array
-- read is to convert an element into a specifid Datatype - in this scenario, we want to convert the elements into integers.
--     Usually, it's syntax is like this : read "5" :: Int
--     If we just try to read something and not specify a DataType for it (e.g. read "5"), ghci will throw an error. 
--     This is because, ghci will not know how to determine the Type of the parameter that it is reading.
--     If we are using the result of the "read" operator for something else, we don't have to specify the Type because GHCI will infer the Type of the result that we want out of our read using the rest of the parameters.
--     e.g. read "5" -2 (The result will be 3)
-- map is to do it for all the elements of the list (similar to map in javascript). so, the result of (map read $ words inputStringArray) :: [Int] will be an array of Integers.
-- sum is to take all the elements of the Integer array and produce a sum of them.
-- show is to convert the number (from sum) back into a string.

-- how to invoke this from Prelude - load the file into ghci - :l Challenges.hs - readAListOfNumbersAsStringsAndPrintTheirSumAsString "1 2"

-- or call this variable from Prelude to see the result : 
readAListOfNumbersAsStringsAndPrintTheirSumAsStringTest1 = readAListOfNumbersAsStringsAndPrintTheirSumAsString "1 2 3"

------------------------------------------------------------
