module Strings.CheckIfAllCharsOfAStringAreInAnotherString where

import Data.List (foldl')

-- Check if all characters in a String are contained within another String: Use foldl' & elem

isCharacterInString :: String -> Char -> Bool
isCharacterInString str c = if (c `elem` str) then True else False

solution :: String -> String -> Bool
solution str1 str2 = and $ map (isCharacterInString str2) str1
-- tests
testSolution01 = solution "abcd" "abcefg" -- False
testSolution02 = solution "abcd" "abcdefg" -- True
