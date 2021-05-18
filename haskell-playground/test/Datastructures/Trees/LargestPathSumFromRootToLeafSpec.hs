module Datastructures.Trees.LargestPathSumFromRootToLeafSpec where

import Test.Hspec
import Datastructures.Trees.LargestPathSumFromRootToLeaf (largestPathSum)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "largestPathSum" $ do

    it "returns an array with left and right elements when the input has left and right subtrees" $
      largestPathSum (Node 1
                           (Node 3
                                 EmptyTree
                                 (Node 5 EmptyTree EmptyTree))
                           (Node 2 
                                 (Node 4 EmptyTree EmptyTree)
                                 EmptyTree)
                     ) `shouldBe` [1,3,5]

