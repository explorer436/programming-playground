module MySolutions.CharAndWordCount.CharCount_version2 (charCounts) where

import Data.Char
import Debug.Trace
import Text.Printf

charCounts :: String -> Int
charCounts = foldr countCharacter 0
  where
    countCharacter char count
      | isPrint char =
          traceMessage char $ count + 1
      | otherwise = count

traceMessage char = trace $ printf "Got a character: %c (0x%x)" char (ord char)
