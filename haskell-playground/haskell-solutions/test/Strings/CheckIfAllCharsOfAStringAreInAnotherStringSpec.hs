module Strings.CheckIfAllCharsOfAStringAreInAnotherStringSpec where

import Strings.CheckIfAllCharsOfAStringAreInAnotherString (areAllCharactersInAnotherString)

import Test.Hspec

spec :: Spec
spec = do

  describe "areAllCharactersInAnotherString" $ do

    it "returns True when the input is a pangram" $
        areAllCharactersInAnotherString "abcd" "abcefg"
        `shouldBe` 
        False

    it "returns True when the input is a pangram" $
        areAllCharactersInAnotherString "abcd" "abcdefg"
        `shouldBe` 
        True