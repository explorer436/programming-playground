module Datastructures.Trees.CountTheNumberOfNodesInAFullBinaryTreeSpec where

import Test.Hspec
import Datastructures.Trees.CountTheNumberOfNodesInAFullBinaryTree (numberOfNodesInFullBinaryTree)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "numberOfNodesInFullBinaryTree" $ do

    it "returns 0 when the input is EmptyTree" $
      numberOfNodesInFullBinaryTree EmptyTree `shouldBe` 0

    it "returns 1 when the input is a tree with only root node" $
      numberOfNodesInFullBinaryTree (Node 2 EmptyTree EmptyTree) `shouldBe` 1

    it "returns 3 when the input is a full binary tree with 3 nodes" $
      numberOfNodesInFullBinaryTree (Node 2 (Node 3 EmptyTree EmptyTree) (Node 4 EmptyTree EmptyTree)) `shouldBe` 3

   
