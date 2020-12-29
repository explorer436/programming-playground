module Strings.Palindrome where

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
