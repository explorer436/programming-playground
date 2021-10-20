module Datastructures.Trees.CompareTreesBySizeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.CompareTreesBySize (largerTreeBySize)

spec :: Spec
spec = do

  describe "largerTreeBySize" $ do

    it "returns a tree that is converted into a full binary tree" $
      largerTreeBySize (Node 4 EmptyTree EmptyTree) (Node 4 (Node 6 EmptyTree EmptyTree) EmptyTree) 
          `shouldBe` 
          (Node 4
                (Node 6 EmptyTree EmptyTree)
                EmptyTree
          )
