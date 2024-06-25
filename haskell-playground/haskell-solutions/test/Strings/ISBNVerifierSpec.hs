module Strings.ISBNVerifierSpec where

import Strings.ISBNVerifier (isValidIsbn, checkSum)

import Test.Hspec

spec :: Spec
spec = do

  describe "checkSum" $ do

    it "returns expected output for the input parameters" $
        checkSum "3598215088"
        `shouldBe` 
        264

  describe "isValidIsbn" $ do

    it "returns expected output for the input parameters" $
        isValidIsbn "3598215088"
        `shouldBe` 
        True
    it "returns expected output for the input parameters" $
        isValidIsbn "123-45"
        `shouldBe` 
        False
    it "returns expected output for the input parameters" $
        isValidIsbn "0-86381-580-4"
        `shouldBe` 
        True