module MySolutions.Trees.MyBinarySearchTree_InsertSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.BottomView (bottomViewWithDistance, bottomViewWithoutDistance)
import MySolutions.Trees.MyBinaryTree (Tree (..))
import qualified Data.Map as Map

import MySolutions.Trees.MyBinarySearchTree_Insert (listToTreeFromRight, listToTreeFromLeft)


spec :: Spec
spec = do

  describe "listToTreeFromRight" $ do

    it "returns the expected results" $
      listToTreeFromRight [8,6,4,1,7,3,5] `shouldBe` 
                          Node 5
                            (Node 3
                              (Node 1 EmptyTree EmptyTree)
                              (Node 4 EmptyTree EmptyTree)
                            )
                            (Node 7
                              (Node 6 EmptyTree EmptyTree)
                              (Node 8 EmptyTree EmptyTree)
                            )  

                 
{- |

      5
    /   \   
  3       7
 / \     / \
1   4   6   8

-}

  describe "listToTreeFromLeft" $ do

    it "returns the expected results" $
      listToTreeFromLeft [25, 20, 15, 27, 30, 29, 26, 22, 32, 17] `shouldBe` 
                          Node 25
                            (Node 20
                              (Node 15 EmptyTree (Node 17 EmptyTree EmptyTree))
                              (Node 22 EmptyTree EmptyTree)
                            )
                            (Node 27
                              (Node 26 EmptyTree EmptyTree)
                              (Node 30 (Node 29 EmptyTree EmptyTree) (Node 32 EmptyTree EmptyTree))
                            )  

{- |
                         25
                        /  \ 
                       /    \
                      /      \
                     20       27
                    /  \     /  \
                   /    \   /    \
                 15    22 26     30
                  \             /  \
                  17          29   32
-}
