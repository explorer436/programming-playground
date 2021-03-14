module Datastructures.Trees.LevelOfTreeWithMaximumSumSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.LevelOfTreeWithMaximumSum (levelWithMaximumSum, maximumSum) 
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "levelWithMaximumSum" $ do
    it "returns three when there are three nodes in the tree" $
      levelWithMaximumSum testTree `shouldBe` 1
  describe "levelWithMaximumSum" $ do
    it "returns three when there are three nodes in the tree" $
      maximumSum testTree `shouldBe` 9

testTree = (Node 1
               (Node 4
                   (Node 3 EmptyTree EmptyTree)
                   (Node 2 EmptyTree EmptyTree))
               (Node 5
                   (Node 4 EmptyTree EmptyTree)
                   (Node (-1) EmptyTree EmptyTree)))      