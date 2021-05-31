module Strings.Palindrome (caseSensitivePalindrome, caseInsensitivePalindrome) where

import Data.Char

---------------------------------------------------------------------------
-- notice the differences in signature between caseSensitivePalindrome and caseInsensitivePalindrome.
-- caseInsensitivePalindrome works only with strings.
-- caseSensitivePalindddrom works with any TypeClass that satisfies Eq.
caseSensitivePalindrome :: Eq t => [t] -> Bool
caseSensitivePalindrome [] = False
caseSensitivePalindrome [x] = True
caseSensitivePalindrome xs 
    | xs == reverse xs = True
    | otherwise        = False

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

------------------------------------------------------------
