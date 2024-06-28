module Strings.CountNumberOfOccurancesOfSubstringInAString (countNumberOfOccurancesOfSubstringInAString) where

import Data.List (isPrefixOf)
import Strings.RemoveSubstringFromAString (removeSubstringFromAString)

import Debug.Trace ( trace )
import Text.Printf

-- The returned string should contain the second string, stripped of the first string.

-- Reference : `as patterns` in Haskell.

countNumberOfOccurancesOfSubstringInAString :: Num p => [Char] -> [Char] -> p
countNumberOfOccurancesOfSubstringInAString sb "" = 0
countNumberOfOccurancesOfSubstringInAString sb entireWord@(x:xs) = 
    trace ("countNumberOfOccurancesOfSubstringInAString - " ++ "sb:" ++ show sb ++ ", entireWord:" ++ show entireWord) 
    (if sb `isPrefixOf` entireWord  
        then trace "sb is prefix of entireWord! So, increment the count value" $ 1 + countNumberOfOccurancesOfSubstringInAString sb (drop (length sb) entireWord)
    else countNumberOfOccurancesOfSubstringInAString sb xs)

