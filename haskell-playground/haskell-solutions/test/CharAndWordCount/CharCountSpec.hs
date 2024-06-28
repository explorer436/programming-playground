module CharAndWordCount.CharCountSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import CharAndWordCount.CharCount_version9 (charCounts)

spec :: Spec
spec = do
  describe "charCounts" $ do

    it "returns the expected results" $
      readFile "/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/haskell-solutions/test/CharAndWordCount/unicode-text-demo" >>= \s -> charCounts s
      `shouldBe` 4

    it "returns the expected results" $
      readFile "/home/explorer436/Downloads/GitRepositories/programming-playground/haskell-playground/haskell-solutions/src/CharAndWordCount/quux.txt" >>= \s -> charCounts s
      `shouldBe` 115

-- stack test --test-arguments "--match=charCounts"
