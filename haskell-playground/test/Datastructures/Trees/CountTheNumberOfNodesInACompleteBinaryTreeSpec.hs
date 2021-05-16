module Datastructures.Trees.CountTheNumberOfNodesInACompleteBinaryTreeSpec where

import Test.Hspec
import Datastructures.Trees.CountTheNumberOfNodesInACompleteBinaryTree (numberOfNodesInCompleteBinaryTree)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "numberOfNodesInCompleteBinaryTree" $ do

    it "returns 0 when the input is EmptyTree" $
      numberOfNodesInCompleteBinaryTree EmptyTree `shouldBe` 0

    it "returns 1 when the input is a tree with only root node" $
      numberOfNodesInCompleteBinaryTree (Node 2 EmptyTree EmptyTree) `shouldBe` 1

    it "returns 3 when the input is a complete binary tree with 3 nodes" $
      numberOfNodesInCompleteBinaryTree (Node 1
                                              (Node 2
                                                    (Node 4
                                                          (Node 8
                                                                (Node 16 EmptyTree EmptyTree)
                                                                (Node 17 EmptyTree EmptyTree)
                                                          )
                                                          (Node 9
                                                                (Node 18 EmptyTree EmptyTree)
                                                                (Node 19 EmptyTree EmptyTree)
                                                          )
                                                    )
                                                    (Node 5
                                                          (Node 10
                                                                (Node 20 EmptyTree EmptyTree)
                                                                (Node 21 EmptyTree EmptyTree)
                                                          )
                                                          (Node 11
                                                                (Node 22 EmptyTree EmptyTree)
                                                                (Node 23 EmptyTree EmptyTree)
                                                          )
                                                    )
                                              )
                                              (Node 3
                                                    (Node 6
                                                          (Node 12
                                                                (Node 24 EmptyTree EmptyTree)
                                                                (Node 25 EmptyTree EmptyTree)
                                                          )
                                                          (Node 13
                                                                (Node 26 EmptyTree EmptyTree)
                                                                EmptyTree
                                                          )
                                                    )
                                                    (Node 7
                                                          (Node 14
                                                                EmptyTree
                                                                EmptyTree
                                                          )
                                                          (Node 15
                                                                EmptyTree
                                                                EmptyTree
                                                          )
                                                    )
                                              )
                                        ) `shouldBe` 26

   

{- |

                         N
                        /\
                       /  \
                      /    \
                     /      \
                    /        \
                   /          \
                  /            \
                 /              \
                /                \
               /                  \
              /                    \
             /                      \
            N                        N
           / \                      / \
          /   \                    /   \
         /     \                  /     \
        /       \                /       \
       /         \              /         \
      /           \            /           \
      N            N           N           N
     /  \         / \         / \         / \
    /    \       /   \       /   \       /   \
    N     N     N     N     N     N     N     N
   / \   / \   / \   / \   / \   /
  N   N N   N N   N N   N N   N N

-}

