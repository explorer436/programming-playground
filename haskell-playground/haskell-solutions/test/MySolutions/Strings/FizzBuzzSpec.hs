module MySolutions.Strings.FizzBuzzSpec where

import MySolutions.Strings.FizzBuzz (fizzBuzz)

import Test.Hspec

spec :: Spec
spec = do

  describe "fizzBuzz" $ do

    it "returns expected output for the input parameters" $
        fizzBuzz 5
        `shouldBe` 
        ["1","2","Fizz","4","Buzz"]

    it "returns expected output for the input parameters" $
        fizzBuzz 20
        `shouldBe` 
        ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz","16","17","Fizz","19","Buzz"]
