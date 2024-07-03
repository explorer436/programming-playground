module MySolutions.Trees.ZigZagBinaryTreeSpec where

import Test.Hspec
import MySolutions.Trees.IsGivenTreeBinarySearchTree (isBST)
import MySolutions.Trees.ZigZagBinaryTree (zigzagBinaryTree)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "zigzagBinaryTree" $ do

    it "returns True when the input tree is a valid binary search tree" $
      zigzagBinaryTree (Node 1
                               (Node 2
                                     (Node 4 EmptyTree EmptyTree)
                                     (Node 5 EmptyTree EmptyTree))
                               (Node 3
                                     (Node 6 EmptyTree EmptyTree)
                                     (Node 7 EmptyTree EmptyTree))) `shouldBe` [1,3,2,4,5,6,7]
{-|
      Input:
              1
            /   \
           2     3
          / \   / \
         4   5 6   7
     
      Output: [1, 3, 2, 4, 5, 6, 7]
-}
