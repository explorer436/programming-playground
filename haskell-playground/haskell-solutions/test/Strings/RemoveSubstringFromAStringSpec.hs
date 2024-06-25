module Strings.RemoveSubstringFromAStringSpec where

import Strings.RemoveSubstringFromAString (removeSubstringFromAString)

import Test.Hspec

spec :: Spec
spec = do

  describe "removeSubstringFromAString" $ do

    it "returns expected output for the input parameters" $
        removeSubstringFromAString "not" "This is not good."
        `shouldBe` 
        "This is  good."

    it "returns expected output for the input parameters" $
        removeSubstringFromAString "abc" ""
        `shouldBe` 
        ""

    it "returns expected output for the input parameters" $
        removeSubstringFromAString "abc" "ab"
        `shouldBe` 
        "ab"

    it "returns expected output for the input parameters" $
        removeSubstringFromAString "-" "123-45"
        `shouldBe` 
        "12345"

    it "returns expected output for the input parameters" $
        removeSubstringFromAString "not" "This is not good."
        `shouldBe` 
        "This is  good."