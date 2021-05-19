{- |
      Count full nodes in a Binary tree (Iterative and Recursive)
      
      Difficulty Level : Easy
      
      Given A binary Tree, how do you count all the full nodes (Nodes which have both children as not NULL) without using recursion and with recursion? Note leaves should not be touched as they have both children as NULL.
      
              6
             / \
            3    2
           /    / \
          5     7  4
           \
            9
      
      Nodes 2 and 6 are full nodes has both child’s. So count of full nodes in the above tree is 2
-}

module Datastructures.Trees.CountFullNodesInABinaryTree (numberOfFullNodes) where

import Datastructures.Trees.MyBinaryTree (Tree (..))


numberOfFullNodes :: Num p => Tree a -> p
numberOfFullNodes EmptyTree                    = 0
numberOfFullNodes (Node _ EmptyTree EmptyTree) = 0
numberOfFullNodes (Node _ l EmptyTree)         = 0
numberOfFullNodes (Node _ EmptyTree r)         = 0
numberOfFullNodes (Node _ l r)                 = 1 + numberOfFullNodes l + numberOfFullNodes r
