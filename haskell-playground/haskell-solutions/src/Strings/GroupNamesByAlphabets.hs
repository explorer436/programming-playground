module Strings.GroupNamesByAlphabets where

import Data.Char (toLower)
import Data.List (foldl')

-- The list may not necessarily be sorted alphabetically
contactsList = [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", "Ashton", "Chaman", "Charlie", "Banksky"]

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

-- tests
testGroupNamesByAlphabet01 = groupNamesByAlphabet 'a' [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", "Ashton", "Chaman", "Charlie", "Banksky"]
-- ('a',["Adam","Anurag","Ashton"])

groupNamesByAllAlphabets :: [String] -> [(Char, [String])]
-- groupNamesByAllAlphabets names = map (\alphabet -> groupNamesByAlphabet alphabet names) "abcdefghijklmnopqwxyz"
groupNamesByAllAlphabets names = map (\alphabet -> groupNamesByAlphabet alphabet names) ['a'..'z']
testGroupNamesByAllAlphabets01 = groupNamesByAllAlphabets contactsList
-- [('a',["Adam","Anurag","Ashton"]),
--  ('b',["Bhushan","Bimal","Beth","Banksky"]),
--  ('c',["Chilgoza","Chaman","Charlie"]),
--  ('d',[]), ('e',[]), ('f',[]),('g',[]),('h',[]),('i',[]),('j',[]),('k',[]),('l',[]),('m',[]),('n',[]),('o',[]),('p',[]),('q',[]),('w',[]),('x',[]),('y',[]),('z',[])]
