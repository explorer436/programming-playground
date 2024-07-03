module MySolutions.Strings.ChangeSubstringInAStringSpec where

import MySolutions.Strings.ChangeSubstringInAString (changeSubstringInAString)

import Test.Hspec ( describe, it, shouldBe, Spec )

spec :: Spec
spec = do

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