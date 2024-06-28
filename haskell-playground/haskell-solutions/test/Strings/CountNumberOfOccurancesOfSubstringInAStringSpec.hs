module Strings.CountNumberOfOccurancesOfSubstringInAStringSpec where

import Strings.CountNumberOfOccurancesOfSubstringInAString (countNumberOfOccurancesOfSubstringInAString)

import Test.Hspec ( describe, it, shouldBe, Spec )

spec :: Spec
spec = do

  describe "countNumberOfOccurancesOfSubstringInAString" $ do

    it "returns expected output for the input parameters" $
        countNumberOfOccurancesOfSubstringInAString "not" "This is not good."
        `shouldBe` 
        1

    it "returns expected output for the input parameters" $
        countNumberOfOccurancesOfSubstringInAString "br" "brucebruce"
        `shouldBe` 
        2