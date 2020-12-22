

module RemoveSubstringFromAString where

import Data.List (isPrefixOf)

-- The returned string should contain the second string, stripped of the first string.

-- Reference : `as patterns` in Haskell.

removeSubstringFromAString :: String -> String -> String
removeSubstringFromAString sb "" = ""
removeSubstringFromAString sb entireWord@(x:xs)
    | (sb `isPrefixOf` entireWord) = removeSubstringFromAString sb (drop (length sb) entireWord)
    | otherwise = x : removeSubstringFromAString sb xs


removeSubstringFromAStringTest01 = removeSubstringFromAString "not" "This is not good."
-- "This is  good."

removeSubstringFromAStringTest02 = removeSubstringFromAString "abc" ""
-- ""

removeSubstringFromAStringTest03 = removeSubstringFromAString "abc" "ab"
-- "ab"

removeSubstringFromAStringTest04 = removeSubstringFromAString "-" "123-45"
-- 12345

removeSubstringFromAStringTest05 = removeSubstringFromAString "not" "This is not good."
-- "This is  gd."