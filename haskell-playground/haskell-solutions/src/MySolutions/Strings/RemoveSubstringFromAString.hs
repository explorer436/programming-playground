module MySolutions.Strings.RemoveSubstringFromAString (removeSubstringFromAString) where

import Data.List (isPrefixOf)

import Debug.Trace ( trace )
import Text.Printf ()

-- The returned string should contain the second string, stripped of the first string.

-- Reference : `as patterns` in Haskell.

removeSubstringFromAString :: String -> String -> String
removeSubstringFromAString sb "" = ""
removeSubstringFromAString sb entireWord@(x:xs)
    | sb `isPrefixOf` entireWord = removeSubstringFromAString sb (drop (length sb) entireWord)
    | otherwise = x : removeSubstringFromAString sb xs