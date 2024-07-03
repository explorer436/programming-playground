module MySolutions.Strings.ChangeSubstringInAString (changeSubstringInAString) where

import Data.List (isPrefixOf)

import Debug.Trace ( trace )
import Text.Printf ()


changeSubstringInAString :: String -> String -> String -> String
changeSubstringInAString sb "" changeTo = ""
changeSubstringInAString sb entireWord@(x:xs) changeTo = 
    trace ("DEBUG: changeSubstringInAString - " ++ "sb:" ++ show sb ++ ", entireWord:" ++ show entireWord) 
    (if sb `isPrefixOf` entireWord 
        then changeSubstringInAString sb (changeTo ++ drop (length sb) entireWord) changeTo
    else x : changeSubstringInAString sb xs changeTo)


-- traceMessage sb xs changeTo = trace $ printf "changeSubstringInAString - sb: %s in xs: %s is expected to be changed to: %s" sb xs changeTo
