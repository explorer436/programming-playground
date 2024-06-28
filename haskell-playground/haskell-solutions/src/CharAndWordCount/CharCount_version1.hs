module CharAndWordCount.CharCount_version1 (charCounts) where

import Text.Printf
import Data.Char
import Debug.Trace

-- reference: https://medium.com/pragmatic-programmers/pure-print-style-debugging-in-haskell-c4c5d4f39afa

charCounts :: String -> Int
charCounts = foldr countCharacter 0
  where
    countCharacter char count
      | isPrint char = count + 1
      | otherwise = count
