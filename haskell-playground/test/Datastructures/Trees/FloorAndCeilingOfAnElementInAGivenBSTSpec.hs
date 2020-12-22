module Datastructures.Trees.FloorAndCeilingOfAnElementInAGivenBSTSpec where

import Test.Hspec
import Datastructures.Trees.FloorAndCeilingOfAnElementInAGivenBST
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "ceilingOfAnElement" $ do
    it "returns Nothing when input element is 1 and tree=EmptyTree" $
      ceilingOfAnElement 1 EmptyTree `shouldBe` Nothing
