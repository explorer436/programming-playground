module MySolutions.Strings.StringPalindromeSpec where

import MySolutions.Strings.StringPalindrome (caseSensitivePalindrome, caseInsensitivePalindrome)

import Test.Hspec

spec :: Spec
spec = do

  describe "caseSensitivePalindrome" $ do

    it "returns true when the input is a caseSensitivePalindrome" $
      caseSensitivePalindrome "" `shouldBe` False

    it "returns true when the input is a caseSensitivePalindrome" $
      caseSensitivePalindrome "a" `shouldBe` True

    it "returns true when the input is a caseSensitivePalindrome" $
      caseSensitivePalindrome "abc" `shouldBe` False

    it "returns true when the input is a caseSensitivePalindrome" $
      caseSensitivePalindrome "deleveled" `shouldBe` True

    it "returns true when the input is a caseSensitivePalindrome" $
      caseSensitivePalindrome "Deleveled" `shouldBe` False

  describe "caseInsensitivePalindrome" $ do

    it "returns true when the input is a caseInsensitivePalindrome" $
      caseInsensitivePalindrome "" `shouldBe` False

    it "returns true when the input is a caseInsensitivePalindrome" $
      caseInsensitivePalindrome "a" `shouldBe` True

    it "returns true when the input is a caseInsensitivePalindrome" $
      caseInsensitivePalindrome "abc" `shouldBe` False

    it "returns true when the input is a caseInsensitivePalindrome" $
      caseInsensitivePalindrome "deleveled" `shouldBe` True

    it "returns true when the input is a caseInsensitivePalindrome" $
      caseInsensitivePalindrome "Deleveled" `shouldBe` True
