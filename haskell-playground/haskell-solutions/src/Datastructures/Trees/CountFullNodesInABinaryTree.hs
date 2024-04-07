module Datastructures.Trees.CountFullNodesInABinaryTree (numberOfFullNodes) where

import Datastructures.Trees.MyBinaryTree (Tree (..))


numberOfFullNodes :: Num p => Tree a -> p
numberOfFullNodes EmptyTree                    = 0
numberOfFullNodes (Node _ EmptyTree EmptyTree) = 0
numberOfFullNodes (Node _ l EmptyTree)         = 0
numberOfFullNodes (Node _ EmptyTree r)         = 0
numberOfFullNodes (Node _ l r)                 = 1 + numberOfFullNodes l + numberOfFullNodes r
