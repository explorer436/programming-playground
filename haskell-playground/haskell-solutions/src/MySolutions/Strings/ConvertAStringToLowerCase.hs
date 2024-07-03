module MySolutions.Strings.ConvertAStringToLowerCase where

import Data.Char

------------------------------------------------------------
-- How to convert a word to lower case in Haskell?
lowerString :: [Char] -> [Char]
lowerString str = [ toLower c | c <- str]

--tests
testLowerString01 = lowerString "Abc"

------------------------------------------------------------
