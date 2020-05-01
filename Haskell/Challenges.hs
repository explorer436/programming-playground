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
readAListOfNumbersAsStringsAndPrintTheirSumAsString inputStringArray = show $ sum $ map read $ words inputStringArray
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


----------------------------------------------------------------

-- PATTERN MATCHING : 
-- The patterns will be checked from top to bottom and when it conforms to a pattern, the corresponding function body will be used.

-- 1. Write a function that checks if the number that is supplied to it is a seven or not.
checkIfTheNumberIsSevenOrNot :: (Integral a) => a -> String  
checkIfTheNumberIsSevenOrNot 7 = "LUCKY NUMBER SEVEN!"  
checkIfTheNumberIsSevenOrNot x = "Sorry, you're out of luck, pal!" 

checkIfTheNumberIsSevenOrNotTest1 = checkIfTheNumberIsSevenOrNot 7
checkIfTheNumberIsSevenOrNotTest2 = checkIfTheNumberIsSevenOrNot 9

-- 2. Write a function that prints the corresponding spelling if the input number is between 1 and 5.
isTheNumberBetweenOneAndFive :: (Integral a) => a -> String  
isTheNumberBetweenOneAndFive 1 = "One!"  
isTheNumberBetweenOneAndFive 2 = "Two!"  
isTheNumberBetweenOneAndFive 3 = "Three!"  
isTheNumberBetweenOneAndFive 4 = "Four!"  
isTheNumberBetweenOneAndFive 5 = "Five!"  
isTheNumberBetweenOneAndFive x = "Not between 1 and 5"

isTheNumberBetweenOneAndFiveTest1 = isTheNumberBetweenOneAndFive 4
isTheNumberBetweenOneAndFiveTest2 = isTheNumberBetweenOneAndFive 8

  -- Note that if we moved the last pattern (the catch-all one) to the top, 
  -- it would always say "Not between 1 and 5", 
  -- because it would catch all the numbers and they wouldn't have a chance to fall through and be checked for any other patterns.


-- 3. Write a factorial implementation using pattern matching
customFactorialFunction :: (Integral a) => a -> a  
customFactorialFunction 0 = 1  
customFactorialFunction n = n * customFactorialFunction (n - 1) 

customFactorialFunctionTest1 = customFactorialFunction 3  

  -- If we had written the second pattern on top of the first one, 
  -- it would catch all numbers, including 0 and our calculation would never terminate. 
  -- That's why order is important when specifying patterns and 
  -- it is always best to specify the most specific ones first and then the more general ones later. 
  -- This is used in recursive functions to specify base conditions.


-- 4. non-exhaustive pattern matching
patternMatchingWithNonExhaustivePattern :: Char -> String  
patternMatchingWithNonExhaustivePattern 'a' = "Albert"  
patternMatchingWithNonExhaustivePattern 'b' = "Broseph"  
patternMatchingWithNonExhaustivePattern 'c' = "Cecil"  

  -- if you try to call it with an input that we didn't expect, this is what happens:
  --   ghci> charName 'h'  
  --  "*** Exception: tut.hs:(53,0)-(55,21): Non-exhaustive patterns in function charName  

  -- It complains that we have non-exhaustive patterns, and rightfully so. 
  -- When making patterns, we should always include a catch-all pattern 
  -- so that our program doesn't crash if we get some unexpected input. 

-- 5. Pattern matching on tuples : 
  -- What if we wanted to make a function that takes two vectors in a 2D space 
  -- (that are in the form of pairs) and adds them together? i
  -- To add together two vectors, we add their x components separately and then their y components separately. 
  -- Here's how we would have done it if we didn't know about pattern matching:

  -- addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
  -- addVectors a b = (fst a + fst b, snd a + snd b)  

  -- Well, that works, but there's a better way to do it. 
  -- Let's modify the function so that it uses pattern matching.

addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)  

addVectorsTest = addVectors (1, 2) (3, 4)

  -- Much better. Note that this is already a catch-all pattern. 
  -- The type of addVectors (in both cases) is addVectors :: (Num a) => (a, a) -> (a, a) - > (a, a), 
  -- so we are guaranteed to get two pairs as parameters. 
