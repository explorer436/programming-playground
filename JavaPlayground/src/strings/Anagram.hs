import Data.Char (toUpper)
import qualified RemoveSubstringFromAString as RSSFS

-- `and` takes a list of boolean values 
-- and returns True only if all the values in the list are True.

anagram :: [Char] -> [Char] -> Bool
anagram str1 str2
    | (length str1WithSpacesRemoved /= length str2WithSpacesRemoved) = False
    | (length (removeDuplicates str1WithSpacesRemoved) /= length (removeDuplicates str2WithSpacesRemoved)) = False
    | doesAllCharactersInStr1ExistInStr2 str1WithSpacesRemoved str2WithSpacesRemoved    = True
    | otherwise = False
    where str1WithSpacesRemoved = map toUpper (RSSFS.removeSubstringFromAString " " str1)
          str2WithSpacesRemoved = map toUpper (RSSFS.removeSubstringFromAString " " str2)

-- Reference: CheckIfAllCharsOfAStringAreInAnotherString.hs
doesAllCharactersInStr1ExistInStr2 str1 str2 = and $ map (doesCharacterExistInString str2) str1

doesCharacterExistInString inputString c
    | (c `elem` inputString) = True
    | otherwise = False

-- Reference: RemoveDuplicatesFromList.hs
removeDuplicates xs = foldl (\result x -> if (x `elem` result) then result else (x:result)) [] xs

-- tests
anagramTest01 = anagram "listen" "silent"                       -- True
anagramTest02 = anagram "listen" "not silent"                   -- False
anagramTest03 = anagram "anagram" "nag a ram"                   -- True
anagramTest04 = anagram "Tar" "Rat"                             -- True
anagramTest05 = anagram "Arc" "Car"                             -- True
anagramTest06 = anagram "Elbow" "Below"                         -- True
anagramTest07 = anagram "State" "Taste"                         -- True
anagramTest08 = anagram "Cider" "Cried"                         -- True
anagramTest09 = anagram "Dusty" "Study"                         -- True
anagramTest10 = anagram "Night" "Thing"                         -- True
anagramTest11 = anagram "Inch" "Chin"                           -- True
anagramTest12 = anagram "Brag" "Grab"                           -- True
anagramTest13 = anagram "Cat" "Act"                             -- True
anagramTest14 = anagram "Bored" "Robed"                         -- True
anagramTest15 = anagram "Save" "Vase"                           -- True
anagramTest16 = anagram "Angel" "Glean"                         -- True
anagramTest17 = anagram "Stressed" "Desserts"                   -- True
anagramTest18 = anagram "debit card" "bad credit"               -- True
anagramTest19 = anagram "Dormitory" "Dirty room"                -- True
anagramTest20 = anagram "School master" "The classroom"         -- True
anagramTest21 = anagram "Conversation" "Voices rant on"         -- True
anagramTest22 = anagram "Listen" "Silent"                       -- True
anagramTest23 = anagram "Astronomer" "Moon starer"              -- True
anagramTest24 = anagram "The eyes" "They see"                   -- True
anagramTest25 = anagram "A gentleman" "Elegant man"             -- True
anagramTest26 = anagram "Funeral" "Real fun"                    -- True
anagramTest27 = anagram "The Morse Code" "Here comes dots"      -- True
anagramTest28 = anagram "Eleven plus two" "Twelve plus one"     -- True
anagramTest29 = anagram "Slot machines" "Cash lost in me"       -- True
anagramTest30 = anagram "Fourth of July" "Joyful Fourth"        -- True

{- |
    Hi, here's your problem today. This problem was recently asked by Twitter:

    Given 2 strings s and t, find and return all indexes in string s where t is an anagram.

    Here's an example and some starter code:

    def find_anagrams(s, t):
    # Fill this in.

    print(find_anagrams('acdbacdacb', 'abc'))
    # [3, 7]
-}

{- |
    (Hard)

    Good morning! Here's your coding interview problem for today.

    This problem was asked by Google.

    Given a word W and a string S, find all starting indices in S which are anagrams of W.

    For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
-}

{- |
    Hi, here's your problem today. This problem was recently asked by AirBNB:

    Given a list of words, group the words that are anagrams of each other. (An anagram are words made up of the same letters).

    Example:

    Input: ['abc', 'bcd', 'cba', 'cbd', 'efg']
    Output: [['abc', 'cba'], ['bcd', 'cbd'], ['efg']]

    Here's a starting point:

    import collections

    def groupAnagramWords(strs):
    # Fill this in.

    print groupAnagramWords(['abc', 'bcd', 'cba', 'cbd', 'efg'])
    # [['efg'], ['bcd', 'cbd'], ['abc', 'cba']]

-}