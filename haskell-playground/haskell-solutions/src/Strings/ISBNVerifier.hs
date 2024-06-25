module Strings.ISBNVerifier (isValidIsbn, checkSum) where

import Strings.RemoveSubstringFromAString (removeSubstringFromAString)
import Data.Char (digitToInt)

{- |
    ISBN Verifier

    ISBN numbers are unique numeric codes given to every book. 
    You can pickup any text-book or fiction book 
    and you should find them usually on the back cover,
    along with a bar-code. 

    ISBNs come in two flavours - 10 digit and 13 digit. 
    They are usually written with hyphens between them. For example:

    3-598-21508-8 or 0-86381-580-4 - 10 digit ISBN with separating hyphens
    9-780863-815805 - 13 digit ISBN with separating hyphens
    However, not every 10-digit (or 13-digit) number is a valid ISBN. 
    All valid ISBNs must comply with, what is known as a checksum. 
    Here is how one can verify if a 10-digit ISBN is valid or not:

    3598215088 (same ISBN as above, but without hyphens)

    (3 * 10) -- Successively multiply each digit of the number with 10, 9, 8, 7.... 1
    + (5 *  9)
    + (9 *  8)
    + (8 *  7)
    + (2 *  6)
    + (1 *  5)
    + (5 *  4)
    + (0 *  3)
    + (8 *  2)
    + (8 *  1)
    ----------
        264 -- then adding them up
    ----------

    -- Now check if the remainder of dividing by 11 is zero, or not

    264 `mod` 11 == 0 -- This is a valid ISBN.

    The first part of this exercise is to write a function 
    that checks if a given 10-digit ISBN without hyphens is valid, or not. 
    The ISBN will be provided as String, so you will need a way to conver a Char to an Int. 
    Go to your Stackage docs and search the exact signature of the function that you’ll need, 
    i.e. Char -> Int

    -- NOTE: In this part of the exercise you can assume
    -- that the ISBN will be provided without hyphens.
    --
    isValidIsbn :: String -> Bool
    isValidIsbn isbn = _todo

    isValidIsbnInternal :: String -> Int -> Int -> Bool
    isValidIsbnInternal remainingIsbn currentMultiplier total = _todo
    The second part of this exercise is to modify your solution to the first part, 
    such that it is able to “skip” hyphens anywhere in the ISBN, 
    i.e. you can’t assume that the hyphens are in fixed/known places. 
    The function signatures need not change.

    The third part of this exercise is to modify your solution to the second part, 
    such that ISBNs that are not exactly 10 digits are reported invalid. 
    For example, the following ISBN should be reported as invalid even though the checksum is a multiple of 11.

    GHCi> isValidIsbn "123-45"
    Tip

    You can get more ISBNs for testing via http://isbndb.com/ Remember to use the ISBN10, not the ISBN13.
-}

isValidIsbn :: String -> Bool
isValidIsbn isbn
    | length isbnStrippedOfHyphens /= 10           = False
    | checkSum isbnStrippedOfHyphens `mod` 11 == 0 = True
    | otherwise                                    = False
    where isbnStrippedOfHyphens = removeSubstringFromAString "-" isbn

checkSum :: [Char] -> Int
checkSum list = sum [a * digitToInt b | (a,b) <- zip [10,9..] list]
