module Datastructures.Trees.FloorAndCeilingOfAnElementInAGivenBSTSpec where

import Test.Hspec
import Datastructures.Trees.FloorAndCeilingOfAnElementInAGivenBST
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "ceilingOfAnElement" $ do
    it "returns Nothing when the tree is EmptyTree" $
      ceilingOfAnElement 1 EmptyTree `shouldBe` Nothing
    it "returns root when input element matches the tree root" $
      ceilingOfAnElement 1 (Node 1 EmptyTree EmptyTree) `shouldBe` Just 1
    it "returns root when the tree is singleton and the input is smaller than the root" $
      ceilingOfAnElement 1 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2
    it "returns Nothing when the tree is singleton and the input is greater than the root" $
      ceilingOfAnElement 3 (Node 2 EmptyTree EmptyTree) `shouldBe` Nothing
    it "returns rightNodeValue when the input is equal to the right node value" $
      ceilingOfAnElement 2 (Node 1 
                                           EmptyTree
                                           (Node 2 EmptyTree EmptyTree) 
                                    ) `shouldBe` Just 2
    it "returns leftNodeValue when the input is equal to the right node value" $
      ceilingOfAnElement 1 (Node 2 
                                           (Node 1 EmptyTree EmptyTree) 
                                           EmptyTree
                                    ) `shouldBe` Just 1
