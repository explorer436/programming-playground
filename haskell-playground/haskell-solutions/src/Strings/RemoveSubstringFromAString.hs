module Strings.RemoveSubstringFromAString (removeSubstringFromAString, changeSubstringInAString) where

import Data.List (isPrefixOf)

import Debug.Trace ( trace )
import Text.Printf

-- The returned string should contain the second string, stripped of the first string.

-- Reference : `as patterns` in Haskell.

removeSubstringFromAString :: String -> String -> String
removeSubstringFromAString sb "" = ""
removeSubstringFromAString sb entireWord@(x:xs)
    | sb `isPrefixOf` entireWord = removeSubstringFromAString sb (drop (length sb) entireWord)
    | otherwise = x : removeSubstringFromAString sb xs


changeSubstringInAString :: String -> String -> String -> String
changeSubstringInAString sb "" changeTo = ""
changeSubstringInAString sb entireWord@(x:xs) changeTo = 
    -- trace ("DEBUG: changeSubstringInAString - " ++ "sb:" ++ show sb ++ ", entireWord:" ++ show entireWord) 
    (if sb `isPrefixOf` entireWord 
        then traceMessage sb entireWord changeTo $
             changeSubstringInAString sb (changeTo ++ drop (length sb) entireWord) changeTo
    else traceMessage sb xs changeTo $
         x : changeSubstringInAString sb xs changeTo)


traceMessage sb xs changeTo = trace $ printf "changeSubstringInAString - sb: %s in xs: %s is expected to be changed to: %s" sb xs changeTo
