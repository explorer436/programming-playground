module FloorAndCeilingOfAnElementInAGivenBSTSpec where

import Test.Hspec
import FloorAndCeilingOfAnElementInAGivenBST

main :: IO ()
main = hspec $ do
  describe "ceilingOfAnElement" $ do
    it "returns Nothing when x=1 and tree=EmptyTree" $
      ceilingOfAnElement 1 EmptyTree `shouldBe` Nothing
