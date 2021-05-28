module Datastructures.Trees.BuildAllPossibleTreesSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.BuildAllPossibleTrees (buildTreeList)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  
  describe "buildTreeList" $ do

    it "returns 45 for the input tree" $
      buildTreeList (Node 1 
                          (Node 2
                                (Node 3 EmptyTree EmptyTree)
                                EmptyTree
                          )
                          (Node 2
                                (Node 3 EmptyTree EmptyTree)
                                EmptyTree
                          )
                    ) `shouldBe` [
                                  Node 1 (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree) (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree),
                                  Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree,
                                  Node 3 EmptyTree EmptyTree,
                                  Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree,
                                  Node 3 EmptyTree EmptyTree]


    {-|
          1
         / \
        2   2
       /   /
      3   3
    -}
