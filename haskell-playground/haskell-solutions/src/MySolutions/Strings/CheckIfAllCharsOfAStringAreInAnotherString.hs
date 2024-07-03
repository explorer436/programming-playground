module MySolutions.Strings.CheckIfAllCharsOfAStringAreInAnotherString (areAllCharactersInAnotherString) where

import Data.List (foldl')

-- Check if all characters in a String are contained within another String: Use foldl' & elem

areAllCharactersInAnotherString :: String -> String -> Bool
-- areAllCharactersInAnotherString str1 str2 = and $ map (isCharacterInString str2) str1
areAllCharactersInAnotherString str1 str2 = all (isCharacterInString str2) str1


isCharacterInString :: String -> Char -> Bool
isCharacterInString str c = c `elem` str
