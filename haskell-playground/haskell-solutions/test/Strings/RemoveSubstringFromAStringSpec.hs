module Strings.RemoveSubstringFromAStringSpec where

import Strings.RemoveSubstringFromAString (removeSubstringFromAString, changeSubstringInAString)

import Test.Hspec ( describe, it, shouldBe, Spec )

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

    it "returns expected output for the input parameters" $
        removeSubstringFromAString "(00)" "((((00)0)0)0)"
        `shouldBe` 
        "(((0)0)0)"

  describe "changeSubstringInAString" $ do

    it "returns expected output for the input parameters" $
        changeSubstringInAString "(00)" "((((00)0)0)0)" "0"
        `shouldBe` 
        "(((00)0)0)"

    it "returns expected output for the input parameters" $
        changeSubstringInAString "(00)" "(((00)0)0)" "0"
        `shouldBe` 
        "((00)0)"

    it "returns expected output for the input parameters" $
        changeSubstringInAString "(00)" "((00)0)" "0"
        `shouldBe` 
        "(00)"

    it "returns expected output for the input parameters" $
        changeSubstringInAString "(00)" "((00)(00))" "0"
        `shouldBe` 
        "(00)"

-- stack test --test-arguments "--match=changeSubstringInAString"