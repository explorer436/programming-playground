module MySolutions.Trees.MaximumPathSumFromRootToLeafSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.MaximumPathSumFromRootToLeaf (maximumPathSumFromRootToLeaf)

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
      maximumPathSumFromRootToLeaf (Node 10 
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
                                   ) `shouldBe` [10,5,2]

    it "returns a list with the root node when the input tree is a tree with only a root node" $
      maximumPathSumFromRootToLeaf (Node 10 EmptyTree EmptyTree) `shouldBe` [10]

    it "returns empty list when the input tree is an empty tree" $
      maximumPathSumFromRootToLeaf EmptyTree `shouldBe` []
