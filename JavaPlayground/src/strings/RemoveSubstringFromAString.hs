

module RemoveSubstringFromAString where

import Data.List (isPrefixOf)

-- The returned string should contain the second string, stripped of the first string.

-- Reference : `as patterns` in Haskell.

remove :: String -> String -> String
remove sb "" = ""
remove sb entireWord@(x:xs)
    | (sb `isPrefixOf` entireWord) = remove sb (drop (length sb) entireWord)
    | otherwise = x : remove sb xs


removeTest01 = remove "not" "This is not good."
-- "This is  good."

removeTest02 = remove "abc" ""
-- ""

removeTest03 = remove "abc" "ab"
-- "ab"