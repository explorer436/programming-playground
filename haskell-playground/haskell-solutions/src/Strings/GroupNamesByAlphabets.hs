module Strings.GroupNamesByAlphabets (groupNamesByAlphabet, groupNamesByAllAlphabets) where

import Data.Char (toLower)
import Data.List (foldl')

groupNamesByAlphabet :: Char -> [String] -> (Char, [String])
groupNamesByAlphabet alpha names =
  foldl'

    -- the lambda
    (\ (alphabet, collectedNames) name ->
        if (length name > 0) && (toLower (head name) == (toLower alphabet))
        then (alphabet, collectedNames ++ [name])
        else (alphabet, collectedNames)
    )

    -- the initial value
    (alpha, [])

    -- the list
    names


groupNamesByAllAlphabets :: [String] -> [(Char, [String])]
-- groupNamesByAllAlphabets names = map (\alphabet -> groupNamesByAlphabet alphabet names) "abcdefghijklmnopqwxyz"
groupNamesByAllAlphabets names = map (\alphabet -> groupNamesByAlphabet alphabet names) ['a'..'z']