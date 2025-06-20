module MySolutions.Strings.StringPalindrome (caseSensitivePalindrome, caseInsensitivePalindrome) where

import Data.Char (toLower)


-- notice the differences in signature between caseSensitivePalindrome and caseInsensitivePalindrome.
-- caseInsensitivePalindrome works only with strings.
-- caseSensitivePalindrome works with any TypeClass that satisfies Eq.



caseSensitivePalindrome :: Eq t => [t] -> Bool
caseSensitivePalindrome [] = False
caseSensitivePalindrome [x] = True
caseSensitivePalindrome xs 
    | xs == reverse xs = True
    | otherwise        = False



caseInsensitivePalindrome :: [Char] -> Bool
caseInsensitivePalindrome [] = False
caseInsensitivePalindrome [x] = True
caseInsensitivePalindrome xs 
    | lowerCasedString == reverse lowerCasedString = True
    | otherwise                                      = False
    where lowerCasedString = map toLower xs
--    where lowerCasedString = [ toLower c | c <- xs ]

