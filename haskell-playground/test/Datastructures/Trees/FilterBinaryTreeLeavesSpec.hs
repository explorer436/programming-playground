module Datastructures.Trees.FilterBinaryTreeLeavesSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.FilterBinaryTreeLeaves (filterBinaryTreeLeaves)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "filterBinaryTreeLeaves" $ do
    it "returns expected output for the input parameters" $
      filterBinaryTreeLeaves 1 (Node 1
                                              (Node 1 
                                                    (Node 2 EmptyTree EmptyTree)
                                                    EmptyTree
                                              )
                                              (Node 1 
                                                    (Node 1 EmptyTree EmptyTree)
                                                    EmptyTree
                                              )
                                        ) `shouldBe` Node 1 (Node 1 (Node 2 EmptyTree EmptyTree) EmptyTree) EmptyTree
    it "returns EmptyTree for the input parameters" $
      filterBinaryTreeLeaves 1 EmptyTree `shouldBe` EmptyTree
    it "returns expected output for the input parameters" $
      filterBinaryTreeLeaves 1 (Node 1 (Node 2 EmptyTree EmptyTree) EmptyTree) `shouldBe` Node 1 (Node 2 EmptyTree EmptyTree) EmptyTree
    it "returns expected output for the input parameters" $
      filterBinaryTreeLeaves 2 (Node 1 (Node 2 EmptyTree EmptyTree) EmptyTree) `shouldBe` Node 1 EmptyTree EmptyTree
