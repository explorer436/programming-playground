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

---------------------------------------------------------------------------

{- |
Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix is shown below:

1 2 3
4 5 6
9 8 9  

The left-to-right diagonal = 1 + 5 + 9 = 15.
The right to left diagonal = 3 + 5 + 9 = 17. 
Their absolute difference is |15 - 17| = 2.

Function description 

Complete the "diagonalDifference" function in the editor below. 
It must return an integer representing the absolute diagonal difference.

diagonalDifference takes the following parameter:
    arr: an array of integers .

Input Format

The first line contains a single integer, n, the number of rows and columns in the matrix .
Each of the next n lines describes a row, arr[i], and consists of n space-separated integers arr[i][j].

Constraints
-100 <= arr[i][j] <= 100.

Output Format
Print the absolute difference between the sums of the matrix's two diagonals as a single integer.

Sample Input

3
11 2 4
4 5 6
10 8 -12

Sample Output

15

Explanation

The primary diagonal is:

11
   5
     -12

Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

     4
   5
10

Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15

Note: |x| is the absolute value of x-
-
-}

------------------------------------------------------------
-- notice the differences in signature between caseSensitivePalindrome and caseInsensitivePalindrome.
-- caseInsensitivePalindrome works only with strings.
-- caseSensitivePalindddrom works with any TypeClass that satisfies Eq.
caseSensitivePalindrome :: Eq t => [t] -> Bool
caseSensitivePalindrome [] = False
caseSensitivePalindrome [x] = True
caseSensitivePalindrome xs 
    | xs == reverse xs = True
    | otherwise        = False
caseSensitivePalindromeTest1 = caseSensitivePalindrome ""
caseSensitivePalindromeTest2 = caseSensitivePalindrome "a"
caseSensitivePalindromeTest3 = caseSensitivePalindrome "abc"
caseSensitivePalindromeTest4 = caseSensitivePalindrome "deleveled"
caseSensitivePalindromeTest5 = caseSensitivePalindrome "Deleveled"

------------------------------------------------------------
-- notice the differences in signature between caseSensitivePalindrome and caseInsensitivePalindrome.
-- caseInsensitivePalindrome works only with strings.
-- caseSensitivePalindddrom works with any TypeClass that satisfies Eq.
caseInsensitivePalindrome :: [Char] -> Bool
caseInsensitivePalindrome [] = False
caseInsensitivePalindrome [x] = True
caseInsensitivePalindrome xs 
    | lowerCasedString == reverse lowerCasedString = True
    | otherwise                                      = False
    where lowerCasedString = map toLower xs
--    where lowerCasedString = [ toLower c | c <- xs ]
caseInsensitivePalindromeTest1 = caseInsensitivePalindrome ""
caseInsensitivePalindromeTest2 = caseInsensitivePalindrome "a"
caseInsensitivePalindromeTest3 = caseInsensitivePalindrome "abc"
caseInsensitivePalindromeTest4 = caseInsensitivePalindrome "deleveled"
caseInsensitivePalindromeTest5 = caseInsensitivePalindrome "Deleveled"

------------------------------------------------------------
-- How to convert a word to lower case in Haskell?
lowerString :: [Char] -> [Char]
lowerString str = [ toLower c | c <- str]
lowerStringTest1 = lowerString "Abc"

------------------------------------------------------------
