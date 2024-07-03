module MySolutions.CharAndWordCount.CharCount_version3 (charCounts) where

import Data.Char
import Debug.Trace

variantSelectors :: [Char]
variantSelectors =
  ['\xFE00', '\xFE01', '\xFE02', '\xFE0E', '\xFE0F']

isActualPrint :: Char -> Bool
isActualPrint c
  | isPrint c =
    if c `elem` variantSelectors
    then trace "found a variant selector!" False
    else True
  | otherwise = False

charCounts :: String -> Int
charCounts = foldr countCharacter 0
  where
    countCharacter char count
      | isActualPrint char =
          trace ("Got a character: " <> [char]) $
            count + 1
      | otherwise = count
