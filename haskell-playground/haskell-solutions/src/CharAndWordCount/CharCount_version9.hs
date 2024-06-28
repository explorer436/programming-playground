module CharAndWordCount.CharCount_version9 (charCounts) where

import Data.Char

data CharacterClass
  = PrintableCharacter
  | ZeroWidthJoiner
  | VariantSelector
  | OtherUnprintableCharacter
  deriving Show

variantSelectors :: [Char]
variantSelectors =
  ['\xFE00', '\xFE01', '\xFE02', '\xFE0E', '\xFE0F']

classifyCharacter :: Char -> CharacterClass
classifyCharacter c
  | c `elem` variantSelectors = VariantSelector
  | ord c == 0x200d = ZeroWidthJoiner
  | isPrint c = PrintableCharacter
  | otherwise = OtherUnprintableCharacter

charCounts :: String -> Int
charCounts = foldr countCharacter 0
  where
    countCharacter char count =
      case classifyCharacter char of
        PrintableCharacter -> count + 1
        ZeroWidthJoiner -> count - 1
        _otherwise -> count
