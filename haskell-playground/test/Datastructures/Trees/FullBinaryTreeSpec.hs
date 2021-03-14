module Datastructures.Trees.FullBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.FullBinaryTree (fullBinaryTree)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "fullBinaryTree" $ do
    it "returns a tree that has tree2 appended to the right of tree1" $
      fullBinaryTree (Node 1
                            (Node 2
                                  (Node 0 EmptyTree EmptyTree)
                                  EmptyTree
                            )
                            (Node 3 
                                  (Node 9 EmptyTree EmptyTree)
                                  (Node 4 EmptyTree EmptyTree)
                            )
                      ) `shouldBe` Node 1 (Node 0 EmptyTree EmptyTree) (Node 3 (Node 9 EmptyTree EmptyTree) (Node 4 EmptyTree EmptyTree))
