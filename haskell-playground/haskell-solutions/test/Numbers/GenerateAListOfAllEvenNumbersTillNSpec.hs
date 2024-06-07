module Numbers.GenerateAListOfAllEvenNumbersTillNSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Numbers.GenerateAListOfAllEvenNumbersTillN (evenNumbersTillN)

spec :: Spec
spec = do
  describe "evenNumbersTillN" $ do

    it "returns the original number when given a positive input" $
      evenNumbersTillN 10 `shouldBe` [2,4,6,8]

