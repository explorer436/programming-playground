module Numbers.SumOfAllOddSquaresSmallerThanNSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Numbers.SumOfAllOddSquaresSmallerThanN (sumOfAllOddSquaresSmallerThanN)

spec :: Spec
spec = do
  describe "sumOfAllOddSquaresSmallerThanN" $ do

    it "returns 166650 when input is 10000" $
      sumOfAllOddSquaresSmallerThanN 10000 `shouldBe` 166650

    it "returns 166650 when input is 10" $
      sumOfAllOddSquaresSmallerThanN 10 `shouldBe` 10
      -- 1 + 9
