module MySolutions.CharAndWordCount.CharCountSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.BitwiseOperations.SwapElements (swapElements)

spec :: Spec
spec = do
  describe "swapElements" $ do

    it "returns the expected results" $
      swapElements 3 5
      `shouldBe` (5,3)