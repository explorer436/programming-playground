
-- what is a $  operator? In Prelude, type :t ($)
-- Applying a bunch of functions one after the other on a parameter x : f1 (f2 (f3 (f4 x)))
-- In Haskell, applying a function f on parameter x can be written as f $ x = f x
-- So, appying f1, f2, f3 and f4 on x can be written as f1 $ f2 $ f3 $ f4 $ x

-- We will use the $ operator to separate "interact" with it's parameters.

-- what is the . (dor) operator? In Prelude, type :t (.)
-- it is the functional composition for Math.

-- what is Haskell's interact function: In Prelude, type :t interact
-- interact :: (String -> String) -> IO ()
-- The first string is the standard input to the program.
-- The second string is the standard output from the program.

-- firstFunction abc = show $ sum $ ((map read $ words abc) :: [Int])
--  since sum returns an Integer, we don't have to specify that the output of the map should be an Integer array. It is automatically inferred.
readAListOfNumbersAsStringsAndPrintTheirSumAsString abc = show $ sum $ map read $ words abc
-- words is to convert incoming string into an array of strings
-- read is to convert an element into integer
-- map is to do it for all the elements of the list (similar to map in javascript). so, the result of (map read $ words abc) :: [Int] will be an array of Integers.
--  sum is to take all the elements of the Integer array and produce a sum of them.
-- show is to convert the number (from sum) back into an integer.

-- how to invoke this from Prelude - load the file into ghci - :l Challenges.hs - readAListOfNumbersAsStringsAndPrintTheirSumAsString "1 2"
