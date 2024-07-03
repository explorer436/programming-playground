module MySolutions.Numbers.AbsoluteSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Numbers.Absolute (absolute)

spec :: Spec
spec = do
  describe "absolute" $ do

    it "returns the original number when given a positive input" $
      absolute 1 `shouldBe` 1

    it "returns a positive number when given a negative input" $
      absolute (-1) `shouldBe` 1

    it "returns zero when given zero" $
      absolute 0 `shouldBe` 0
