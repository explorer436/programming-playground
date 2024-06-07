module Datastructures.Trees.CreateABalancedBinarySearchTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.CreateABalancedBinarySearchTree (createBalancedBST)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "createBalancedBST" $ do

    it "returns a balanced binary search tree when a sorted list with odd number of digits is provided as input" $
      createBalancedBST [1, 2, 3, 4, 5, 6, 7] `shouldBe` Node 4 
                                                               (Node 2 
                                                                     (Node 1 EmptyTree EmptyTree) 
                                                                     (Node 3 EmptyTree EmptyTree)) 
                                                               (Node 6 
                                                                     (Node 5 EmptyTree EmptyTree) 
                                                                     (Node 7 EmptyTree EmptyTree))
{- |
                          4
                        /  \ 
                       /    \
                      /      \
                     2        6 
                    / \      / \
                   /   \    /   \
                  1     3  5     7 
-}

    it "returns a balanced binary search tree when a sorted list with even number of digits is provided as input" $
      createBalancedBST [1, 2, 3, 4, 5, 6, 7, 8] `shouldBe` Node 4 
                                                                  (Node 2 
                                                                        (Node 1 EmptyTree EmptyTree) 
                                                                        (Node 3 EmptyTree EmptyTree)) 
                                                                  (Node 6 
                                                                        (Node 5 EmptyTree EmptyTree) 
                                                                        (Node 7 
                                                                              EmptyTree 
                                                                              (Node 8 
                                                                                    EmptyTree 
                                                                                    EmptyTree)))
   
{- |
                          4
                        /  \ 
                       /    \
                      /      \
                     2        6 
                    / \      / \
                   /   \    /   \
                  1     3  5     7 
                                  \
                                   \
                                    8

-}
