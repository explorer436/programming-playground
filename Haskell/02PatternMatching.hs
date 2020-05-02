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

{- |
  Note that if we moved the last pattern (the catch-all one) to the top, 
  it would always say "Not between 1 and 5", 
  because it would catch all the numbers and they wouldn't have a chance to fall through and be checked for any other patterns.
-}


-- 3. Write a factorial implementation using pattern matching
customFactorialFunction :: (Integral a) => a -> a  
customFactorialFunction 0 = 1  
customFactorialFunction n = n * customFactorialFunction (n - 1) 

customFactorialFunctionTest1 = customFactorialFunction 3  

{- |
  If we had written the second pattern on top of the first one, 
  it would catch all numbers, including 0 and our calculation would never terminate. 
  That's why order is important when specifying patterns and 
  it is always best to specify the most specific ones first and then the more general ones later. 
  This is used in recursive functions to specify base conditions.
-}


-- 4. non-exhaustive pattern matching
patternMatchingWithNonExhaustivePattern :: Char -> String  
patternMatchingWithNonExhaustivePattern 'a' = "Albert"  
patternMatchingWithNonExhaustivePattern 'b' = "Broseph"  
patternMatchingWithNonExhaustivePattern 'c' = "Cecil"  

  {- |
  if you try to call it with an input that we didn't expect, this is what happens:
    ghci> charName 'h'  
   "*** Exception: tut.hs:(53,0)-(55,21): Non-exhaustive patterns in function charName  

  It complains that we have non-exhaustive patterns, and rightfully so. 
  When making patterns, we should always include a catch-all pattern 
  so that our program doesn't crash if we get some unexpected input. 
  -}

-- 5. Pattern matching on tuples : 
  {- |
  What if we wanted to make a function that takes two vectors in a 2D space 
  (that are in the form of pairs) and adds them together? i
  To add together two vectors, we add their x components separately and then their y components separately. 
  Here's how we would have done it if we didn't know about pattern matching:

  addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
  addVectors a b = (fst a + fst b, snd a + snd b)  

  Well, that works, but there's a better way to do it. 
  Let's modify the function so that it uses pattern matching.
  -}

addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)  

addVectorsTest = addVectors (1, 2) (3, 4)

  {- |
  Much better. Note that this is already a catch-all pattern. 
  The type of addVectors (in both cases) is addVectors :: (Num a) => (a, a) -> (a, a) - > (a, a), 
  so we are guaranteed to get two pairs as parameters. 
  -}

{- |
fst and snd extract the components of pairs. 
But what about triples? 
Well, there are no provided functions that do that but we can make our own.
-}

firstElementFromTuple :: (a, b, c) -> a  
firstElementFromTuple (x, _, _) = x  
  
secondElementFromTuple :: (a, b, c) -> b  
secondElementFromTuple (_, y, _) = y  
  
thirdElementFromTuple :: (a, b, c) -> c  
thirdElementFromTuple (_, _, z) = z  

firstElementFromTupleTest = firstElementFromTuple(36, 37, 38)
secondElementFromTupleTest = secondElementFromTuple(36, 37, 38)
thirdElementFromTupleTest = thirdElementFromTuple(36, 37, 38)

{- |
The _ means the same thing as it does in list comprehensions. 
It means that we really don't care what that part is, so we just write a _.
-}

-- We can also pattern match in list comprehensions. Check this out:
xs = [(1,3), (4,3), (2,4), (5,3), (5,6), (3,1)]  
patternMatchingOnListComprehensions = [a+b | (a,b) <- xs]  
-- [4,7,6,8,11,4]   
-- Should a pattern match fail, it will just move on to the next element. 


{- |
Lists themselves can also be used in pattern matching. 
You can match with the empty list [] or any pattern that involves : and the empty list. 
But since [1,2,3] is just syntactic sugar for 1:2:3:[], you can also use the former pattern. 
A pattern like x:xs will bind the head of the list to x and the rest of it to xs, 
If there's only one element in the array, xs ends up being an empty list.

Note: The x:xs pattern is used a lot, especially with recursive functions. 
But patterns that have : in them only match against lists of length 1 or more.

If you want to bind, say, the first three elements to variables and the rest of the list to another variable, 
you can use something like x:y:z:zs. 
It will only match against lists that have three elements or more.
-}

-- Now that we know how to pattern match against list, let's make our own implementation of the head function.
customImplementationForHeadUsingPatternMatching :: [a] -> a  
customImplementationForHeadUsingPatternMatching [] = error "Can't call head on an empty list, dummy!"  
customImplementationForHeadUsingPatternMatching (x:_) = x  
customImplementationForHeadUsingPatternMatchingTest1 = customImplementationForHeadUsingPatternMatching [4,5,6]  
customImplementationForHeadUsingPatternMatchingTest2 = customImplementationForHeadUsingPatternMatching "Hello"  
customImplementationForHeadUsingPatternMatchingTest3 = customImplementationForHeadUsingPatternMatching []
customImplementationForHeadUsingPatternMatchingTest4 = customImplementationForHeadUsingPatternMatching ""  
customImplementationForHeadUsingPatternMatchingTest5 = customImplementationForHeadUsingPatternMatching "h"  
{- |
customImplementationForHeadUsingPatternMatchingTest6 = customImplementationForHeadUsingPatternMatching 'h'  
Notice that if you want to bind to several variables (even if one of them is just _ and doesn't actually bind at all), 
we have to surround them in parentheses. 
Also notice the error function that we used. 
It takes a string and generates a runtime error, using that string as information about what kind of error occurred. 
It causes the program to crash, so it's not good to use it too much. 
But calling head on an empty list doesn't make sense.
-}

-- Let's make a function that tells us some of the first elements of the list in English form.
tell :: (Show a) => [a] -> String  
tell [] = "The list is empty"  
tell (x:[]) = "The list has one element: " ++ show x  -- x:[] = [x]
tell (x:y:[]) = "The list has two elements: " ++ show x ++ " and " ++ show y  -- x:y:[] = [x,y]
tell (x:y:_) = "This list is long. The first two elements are: " ++ show x ++ " and " ++ show y  
tellTest0 = tell ""
tellTest1 = tell "h"
tellTest2 = tell "he"
tellTest3 = tell "hel"
tellTest4 = tell "hell"
tellTest5 = tell "hello"
{- |
This function is safe because it takes care of the empty list, a singleton list, a list with two elements 
and a list with more than two elements. 
Note that (x:[]) and (x:y:[]) could be rewriten as [x] and [x,y] (because its syntatic sugar, we don't need the parentheses). 
We can't rewrite (x:y:_) with square brackets because it matches any list of length 2 or more.
-}

-- We already implemented our own length function using list comprehension. 
-- Now we'll do it by using pattern matching and a little recursion:
customLengthImplementationUsingPatternMatchingAndRecursion :: (Num b) => [a] -> b  
customLengthImplementationUsingPatternMatchingAndRecursion [] = 0  
customLengthImplementationUsingPatternMatchingAndRecursion (_:xs) = 1 + customLengthImplementationUsingPatternMatchingAndRecursion xs  
customLengthImplementationUsingPatternMatchingAndRecursionTest0  = customLengthImplementationUsingPatternMatchingAndRecursion ""
customLengthImplementationUsingPatternMatchingAndRecursionTest1  = customLengthImplementationUsingPatternMatchingAndRecursion "h"
customLengthImplementationUsingPatternMatchingAndRecursionTest2  = customLengthImplementationUsingPatternMatchingAndRecursion "he"
customLengthImplementationUsingPatternMatchingAndRecursionTest3  = customLengthImplementationUsingPatternMatchingAndRecursion "hel"
customLengthImplementationUsingPatternMatchingAndRecursionTest4  = customLengthImplementationUsingPatternMatchingAndRecursion "hell"
customLengthImplementationUsingPatternMatchingAndRecursionTest5  = customLengthImplementationUsingPatternMatchingAndRecursion "hello"
-- First we defined the result of a known input — the empty list. This is also known as the edge condition. Then in the second pattern we take the list apart by splitting it into a head and a tail. We say that the length is equal to 1 plus the length of the tail. We use _ to match the head because we don't actually care what it is. Also note that we've taken care of all possible patterns of a list. The first pattern matches an empty list and the second one matches anything that isn't an empty list.

{- |
Let's implement sum. 
We know that the sum of an empty list is 0. 
We write that down as a pattern. 
And we also know that the sum of a list is the head plus the sum of the rest of the list. 
So if we write that down, we get:
-}
customSumImplementation :: (Num a) => [a] -> a  
customSumImplementation [] = 0  
customSumImplementation (x:xs) = x + customSumImplementation xs  
customSumImplementationTest0 = customSumImplementation []
customSumImplementationTest1 = customSumImplementation [2]
customSumImplementationTest2 = customSumImplementation [2, 3]
customSumImplementationTest3 = customSumImplementation [2, 3, 5]


{- |
There's also a thing called as patterns. 
Those are a handy way of breaking something up according to a pattern and 
binding it to names whilst still keeping a reference to the whole thing. 
You do that by putting a name and an @ in front of a pattern. 
For instance, the pattern xs@(x:y:ys). 
This pattern will match exactly the same thing as x:y:ys but you can easily get the whole list via xs 
instead of repeating yourself by typing out x:y:ys in the function body again. 
Here's a quick and dirty example:
-}
capital :: String -> String  
capital "" = "Empty string, whoops!"  
capital entireWord@(x:xs) = "The first letter of " ++ entireWord ++ " is " ++ [x] ++ " and the rest is " ++ xs 
capitalTest1 = capital "Dracula"  
{- |
Normally we use as patterns to avoid repeating ourselves when matching against a bigger pattern 
when we have to use the whole thing again in the function body.
-}


{- |
One more thing — you can't use ++ in pattern matches. 
If you tried to pattern match against (xs ++ ys), what would be in the first and what would be in the second list? 
It doesn't make much sense. 
It would make sense to match stuff against (xs ++ [x,y,z]) or just (xs ++ [x]), 
but because of the nature of lists, you can't do that.
-}
