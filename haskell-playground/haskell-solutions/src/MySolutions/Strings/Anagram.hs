module MySolutions.Strings.Anagram (anagram) where

import Data.Char (toUpper)
import qualified MySolutions.Strings.RemoveSubstringFromAString as RSSFS

anagram :: [Char] -> [Char] -> Bool
anagram str1 str2
    | length str1WithSpacesRemoved_DuplicatesRemoved_Uppercase /= length str2WithSpacesRemoved_DuplicatesRemoved_Uppercase                   = False
    | doesAllCharactersInStr1ExistInStr2 str1WithSpacesRemoved_DuplicatesRemoved_Uppercase str2WithSpacesRemoved_DuplicatesRemoved_Uppercase = True
    | otherwise                                                                                                                              = False
    where str1WithSpacesRemoved_DuplicatesRemoved_Uppercase = removeDuplicates (map toUpper (RSSFS.removeSubstringFromAString " " str1))
          str2WithSpacesRemoved_DuplicatesRemoved_Uppercase = removeDuplicates (map toUpper (RSSFS.removeSubstringFromAString " " str2))

-- Reference: CheckIfAllCharsOfAStringAreInAnotherString.hs
-- Module:	Prelude, Function:	all, returns True if all items in the list fulfill the condition
doesAllCharactersInStr1ExistInStr2 str1 str2 = all (doesCharacterExistInString str2) str1

doesCharacterExistInString inputString c
    | c `elem` inputString = True
    | otherwise = False

-- Reference: RemoveDuplicatesFromList.hs. Using ETA reduce here.
removeDuplicates :: [Char] -> [Char]
removeDuplicates = foldl (\result x -> if x `elem` result then result else x:result) []

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

getGroupsOfNCharacters :: [a] -> Int -> [[a]]
getGroupsOfNCharacters [] _ = []
getGroupsOfNCharacters str n = first : getGroupsOfNCharacters rest n
                        where first = take n str 
                              rest  = drop 1 str

getGroupsOfNCharactersTest01 = getGroupsOfNCharacters "acdbacdacb" 3
-- ["acd","cdb","dba","bac","acd","cda","dac","acb","cb","b"]
getGroupsOfNCharactersTest02 = getGroupsOfNCharacters "abxaba" 2
-- ["ab","bx","xa","ab","ba","a"]

possibleTuples01 = zip (getGroupsOfNCharacters "acdbacdacb" 3) [0,1..]
solution01 = [ snd x | x <- possibleTuples01, anagram (fst x) "abc"]
-- [3,7]

possibleTuples02 = zip (getGroupsOfNCharacters "abxaba" 2) [0,1..]
solution02 = [ snd x | x <- possibleTuples02, anagram (fst x) "ab"]
-- [0,3,4]

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

getListWithHeadAndItsAnagrams :: [String] -> [String]
getListWithHeadAndItsAnagrams [] = []
getListWithHeadAndItsAnagrams xs = [ abc | abc <- xs, anagram (head xs) abc]
getListWithHeadAndItsAnagramsTest01 = getListWithHeadAndItsAnagrams ["abc", "bcd", "cba", "cbd", "efg"]
-- ["abc","cba"]

solution04 :: [String] -> [[String]]
solution04 [] = []
solution04 xs = first : solution04 rest
                        where
                            first = getListWithHeadAndItsAnagrams xs
                            rest  = getListWithHeadAndItsAnagrams (drop 1 xs)
solution04Test01 = solution04 ["abc", "bcd", "cba", "cbd", "efg"]    
-- [["abc","cba"],["bcd","cbd"],["cbd"]]                        
