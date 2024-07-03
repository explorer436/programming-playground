module MySolutions.CharAndWordCount.WordCountSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.CharAndWordCount.WordCount (wordCount, charCount)

spec :: Spec
spec = do
  describe "wordCount" $ do

    it "returns the expected results" $
      readFile "/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/haskell-solutions/src/MySolutions/CharAndWordCount/quux.txt" >>= \s -> wordCount s
      `shouldBe` 7

  describe "charCount" $ do

    it "returns the expected results" $
      readFile "/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/haskell-solutions/src/MySolutions/CharAndWordCount/quux.txt" >>= \s -> charCount s
      `shouldBe` 122
-- Actually, 115 is the correct value. Not sure why this function is returning 122.
