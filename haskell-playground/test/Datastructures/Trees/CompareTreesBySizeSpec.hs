module Datastructures.Trees.CompareTreesBySizeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.CompareTreesBySize (compareTreeBySize)

spec :: Spec
spec = do

  describe "compareTreeBySize" $ do

    it "returns a tree that is converted into a full binary tree" $
      compareTreeBySize (Node 4 EmptyTree EmptyTree) (Node 4 (Node 6 EmptyTree EmptyTree) EmptyTree) 
          `shouldBe` 
          (Node 4
                (Node 6 EmptyTree EmptyTree)
                EmptyTree
          )
