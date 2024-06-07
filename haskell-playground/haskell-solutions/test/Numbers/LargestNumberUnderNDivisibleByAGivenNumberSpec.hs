module Numbers.LargestNumberUnderNDivisibleByAGivenNumberSpec where

import Test.Hspec
import Numbers.LargestNumberUnderNDivisibleByAGivenNumber (largestDivisible)

spec :: Spec
spec = do
  describe "largestDivisible" $ do

    it "returns 99554 when N is 100000 and D is 3829" $
      largestDivisible 100000 3829 `shouldBe` 99554

    it "returns 99 when N is 100 and D is 3" $
          largestDivisible 100 3 `shouldBe` 99