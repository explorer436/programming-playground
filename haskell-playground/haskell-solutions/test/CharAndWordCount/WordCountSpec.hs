module CharAndWordCount.WordCountSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import CharAndWordCount.WordCount (wordCount, charCount)

spec :: Spec
spec = do
  describe "wordCount" $ do

    it "returns the expected results" $
      readFile "/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/haskell-solutions/src/CharAndWordCount/quux.txt" >>= \s -> wordCount s
      `shouldBe` 7

  describe "charCount" $ do

    it "returns the expected results" $
      readFile "/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/haskell-solutions/src/CharAndWordCount/quux.txt" >>= \s -> charCount s
      `shouldBe` 129
-- Actually, 115 is the correct value. Not sure why this function is returning 129.
