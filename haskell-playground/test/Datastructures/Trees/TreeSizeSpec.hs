module Datastructures.Trees.TreeSizeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.TreeSize (treeSize)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "treeSize" $ do
    it "returns three when there are three nodes in the tree" $
      treeSize (Node 3 
                        (Node 2 EmptyTree EmptyTree )  
                        (Node 1 EmptyTree EmptyTree )  
                  ) `shouldBe` 3
    it "returns two when there are two nodes in the tree" $
      treeSize (Node 3 
                        (Node 2 EmptyTree EmptyTree )  
                        EmptyTree ) `shouldBe` 2
    it "returns one when there is one node in the tree" $
      treeSize (Node 3 EmptyTree  EmptyTree) `shouldBe` 1
    it "returns zero when the input in an EmptyTree" $
      treeSize EmptyTree `shouldBe` 0