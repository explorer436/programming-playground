module Strings.AnglesOfAClockSpec where

import Strings.AnglesOfAClock (minutesAngle, hoursAngle, calcAngle)

import Test.Hspec

spec :: Spec
spec = do

  describe "minutesAngle" $ do
    it "returns 90 when minutes value is 15" $
      minutesAngle 15 `shouldBe` 90
    it "returns 162 when minutes value is 27" $
      minutesAngle 27 `shouldBe` 162
    it "returns 330 when minutes value is 15" $
      minutesAngle 55 `shouldBe` 330

  describe "hoursAngle" $ do
    it "returns 90 when hours value is 3 and minutes value is 0" $
      hoursAngle 3 0 `shouldBe` 90
    it "returns 105 when hours value is 3 and minutes value is 30" $
      hoursAngle 3 30 `shouldBe` 105
    it "returns 90 when hours value is 15 and minutes value is 0" $
      hoursAngle 15 0 `shouldBe` 90

  describe "calcAngle" $ do
    it "returns 75 when hours value is 3 and minutes value is 30" $
      calcAngle (3,30) `shouldBe` 75
    it "returns 165 when hours value is 12 and minutes value is 30" $
      calcAngle (12,30) `shouldBe` 165
