module MySolutions.Lists.IsListSymmetric (isListSymmetric) where

import MySolutions.Strings.Palindrome (caseSensitivePalindrome, caseInsensitivePalindrome)

-- Same logic as that of Palindrome.hs
-- Strings are lists in Haskell. 
-- So, we don't need two separate files for lists and strings. 
-- Only one of them can be used for both.

isListSymmetric :: Eq a => [a] -> Bool
isListSymmetric = caseSensitivePalindrome
