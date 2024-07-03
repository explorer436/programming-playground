module MySolutions.Strings.LongestCommonSubsequenceBetweenTwoStringsSpec where

import MySolutions.Strings.LongestCommonSubsequenceBetweenTwoStrings (lcssUsingSimpleRecursion, lcssUsingRecursionOnIndices, lcssUsingArrays, lcssUsingArraysStringsAsArrays)

import Test.Hspec

spec :: Spec
spec = do
  describe "lcssUsingSimpleRecursion" $ do
    it "returns 3 when the length of the common subsequence between the two strings is 3" $
      lcssUsingSimpleRecursion "agcat" "gact" `shouldBe` 3
    it "returns 6 when the length of the common subsequence between the two strings is 6" $
      lcssUsingSimpleRecursion "abracadabra" "bacara" `shouldBe` 6

  describe "lcssUsingRecursionOnIndices" $ do
    it "returns 3 when the length of the common subsequence between the two strings is 3" $
      lcssUsingRecursionOnIndices "agcat" "gact" `shouldBe` 3
    it "returns 6 when the length of the common subsequence between the two strings is 6" $
      lcssUsingRecursionOnIndices "abracadabra" "bacara" `shouldBe` 6

  describe "lcssUsingArrays" $ do
    it "returns 3 when the length of the common subsequence between the two strings is 3" $
      lcssUsingArrays "agcat" "gact" `shouldBe` 3
    it "returns 6 when the length of the common subsequence between the two strings is 6" $
      lcssUsingArrays "abracadabra" "bacara" `shouldBe` 6

  describe "lcssUsingArraysStringsAsArrays" $ do
    it "returns 3 when the length of the common subsequence between the two strings is 3" $
      lcssUsingArraysStringsAsArrays "agcat" "gact" `shouldBe` 3
    it "returns 6 when the length of the common subsequence between the two strings is 6" $
      lcssUsingArraysStringsAsArrays "abracadabra" "bacara" `shouldBe` 6
