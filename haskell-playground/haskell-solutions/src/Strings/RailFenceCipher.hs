module Strings.RailFenceCipher where

import qualified Strings.RemoveSubstringFromAString as RSSFS

{- |
    Rail Fence Cipher
    The Rail Fence cipher is a form of transposition cipher 
    that gets its name from the way in which it is encoded. 
    It was used by the ancient Greeks. 
    In the Rail Fence cipher, 
    the message is written downwards on successive “rails” of an imaginary fence, 
    then moving up when we get to the bottom (like a zig-zag). 
    Finally the message is then read off in rows.

    For example, using three “rails” and the message “WE ARE DISCOVERED FLEE AT ONCE”, the cipherer writes out:

    1 | W . . . E . . . C . . . R . . . L . . . T . . . E  --> Reads off as "WECRLTE"
    2 | . E . R . D . S . O . E . E . F . E . A . O . C .  --> Reads off as "ERDSOEEFEAOC"
    3 | . . A . . . I . . . V . . . D . . . E . . . N . .  --> Reads off as "AIVDEN"

    The final encoded message is:
    WECRLTEERDSOEEFEAOCAIVDEN

    Write a function that encodes a given string using the Rails Fence Cipher.
-}

-- test01 = encodeMessage "hello world" [] [] [] 1 1
-- "holelwrdlo"

-- GHCi> encodeMessage (withoutSpaces "WE ARE DISCOVERED FLEE AT ONCE" "") [] [] [] 1 -1
-- "WECRLTEERDSOEEFEAOCAIVDEN"

positionsList :: (Integral a) => Int -> a -> [a]
positionsList lengthOfInput totalNumberOfRails
   | lengthOfInput > 0 && totalNumberOfRails > 0 = take lengthOfInput (cycle combinedList)
   | otherwise                                     = []
   where railsList = [1..totalNumberOfRails]
         middleList = reverse (init (tail railsList))
         combinedList = railsList ++ middleList

testPositionsList01 = positionsList 14 3 -- [1,2,3,2,1,2,3,2,1,2,3,2,1,2]
testPositionsList02 = positionsList 14 4 -- [1,2,3,4,3,2,1,2,3,4,3,2,1,2]

zippedTuples :: Integral b => [a] -> b -> [(a, b)]
zippedTuples inputString numberOfRails = zip inputString (positionsList (length inputString) numberOfRails)
testZippedTuples01 = zippedTuples "helloworld" 3 -- [('h',1),('e',2),('l',3),('l',2),('o',1),('w',2),('o',3),('r',2),('l',1),('d',2)]

filterListByRailNumber :: Eq a1 => [(a2, a1)] -> a1 -> [(a2, a1)]
filterListByRailNumber xs railNumber = [x | x <- xs, snd(x) == railNumber]
testFilterListByRailNumber01 = filterListByRailNumber testZippedTuples01 1 -- [('h',1),('o',1),('l',1)]

elementsOnRail :: Integral b1 => [b2] -> b1 -> b1 -> [b2]
elementsOnRail inputString totalNumberOfRails railNumber = map (fst) (filterListByRailNumber (zippedTuples inputString totalNumberOfRails) railNumber)
testElementsOnRail01 = elementsOnRail "helloworld" 3 1 -- "hol"
testElementsOnRail02 = elementsOnRail "helloworld" 3 2 -- "elwrd"
testElementsOnRail03 = elementsOnRail "helloworld" 3 3 -- "lo"

solution :: Integral b => [Char] -> b -> [Char]
solution inputString numberOfRails = concat [elementsOnRail (RSSFS.removeSubstringFromAString " " inputString) numberOfRails railNumber | railNumber <- [1..numberOfRails]]
testSolution01 = solution "helloworld" 3 -- "holelwrdlo"
testSolution02 = solution "" 3 -- ""
testSolution03 = solution "WE ARE DISCOVERED FLEE AT ONCE" 3 -- "WECRLTEERDSOEEFEAOCAIVDEN" 
testSolution04 = solution "WE ARE DISCOVERED FLEE AT ONCE" 4 -- "WIREEEDSEEEACAECVDLTNROFO"
