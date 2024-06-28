module Datastructures.Trees.MyBinarySearchTree_PermutationsFromListSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.BottomView (bottomViewWithDistance, bottomViewWithoutDistance)
import Datastructures.Trees.MyBinaryTree (Tree (..))
import qualified Data.Map as Map

import Datastructures.Trees.MyBinarySearchTree_PermutationsFromList (permuationsOfTreesFromAList)


spec :: Spec
spec = do

  describe "permuationsOfTreesFromAList" $ do

    it "returns the expected results" $
      permuationsOfTreesFromAList 3 `shouldBe` 
                          [
                            Node 1 EmptyTree (Node 2 EmptyTree (Node 3 EmptyTree EmptyTree)),
                            Node 2 (Node 1 EmptyTree EmptyTree) (Node 3 EmptyTree EmptyTree),
                            Node 3 (Node 2 (Node 1 EmptyTree EmptyTree) EmptyTree) EmptyTree,
                            Node 2 (Node 1 EmptyTree EmptyTree) (Node 3 EmptyTree EmptyTree),
                            Node 3 (Node 1 EmptyTree (Node 2 EmptyTree EmptyTree)) EmptyTree,
                            Node 1 EmptyTree (Node 3 (Node 2 EmptyTree EmptyTree) EmptyTree)
                          ]
