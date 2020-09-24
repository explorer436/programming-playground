import Data.Char

------------------------------------------------------------
-- How to convert a word to lower case in Haskell?
lowerString :: [Char] -> [Char]
lowerString str = [ toLower c | c <- str]
lowerStringTest1 = lowerString "Abc"

------------------------------------------------------------
