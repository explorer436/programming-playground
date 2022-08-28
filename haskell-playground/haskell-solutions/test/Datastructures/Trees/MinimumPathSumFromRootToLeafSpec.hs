module Datastructures.Trees.MinimumPathSumFromRootToLeafSpec where

import Test.Hspec
import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.MinimumPathSumFromRootToLeaf (minimumPathSumFromRootToLeaf)

spec :: Spec
spec = do

  describe "minimumPathSumFromRootToLeaf" $ do


    {- |
           10
          /  \
         5    5
          \     \
            2    1
                /
              -1
    -}

    it "returns the path with the minimum sum when the input tree is a valid binary tree" $
      minimumPathSumFromRootToLeaf (Node 10 
                                         (Node 5
                                               EmptyTree
                                               (Node 2 EmptyTree EmptyTree)
                                         )
                                         (Node 5
                                               EmptyTree
                                               (Node 1
                                                     (Node (-1) EmptyTree EmptyTree)
                                                     EmptyTree
                                               )
                                         )
                                   ) `shouldBe` [10,5,1,-1]

    it "returns a list with the root node when the input tree is a tree with only a root node" $
      minimumPathSumFromRootToLeaf (Node 10 EmptyTree EmptyTree) `shouldBe` [10]

    it "returns empty list when the input tree is an empty tree" $
      minimumPathSumFromRootToLeaf EmptyTree `shouldBe` []
