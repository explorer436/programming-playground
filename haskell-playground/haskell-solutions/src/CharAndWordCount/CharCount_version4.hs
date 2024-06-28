module CharAndWordCount.CharCount_version4 (charCounts) where

import Data.Char
import Debug.Trace
import Text.Printf

variantSelectors :: [Char]
variantSelectors =
  ['\xFE00', '\xFE01', '\xFE02', '\xFE0E', '\xFE0F']

isActualPrint :: Char -> Bool
isActualPrint c
  | isPrint c =
    if c `elem` variantSelectors
    then trace "found a variant selector!" False
    else True
  | otherwise =
    trace (printf "got a non-printing character (0x%x)" $ ord c) False

charCounts :: String -> Int
charCounts = foldr countCharacter 0
  where
    countCharacter char count
      | isActualPrint char =
          traceMessage char $ count + 1
      | otherwise = count
    traceMessage char =
      trace $ printf "Got a character: %c (0x%x)" char (ord char)
