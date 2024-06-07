module Datastructures.Trees.PrintNodesInBoustrophedonOrder (printNodesInBoustrophedonOrder) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.ZigZagBinaryTree (zigzagBinaryTree)

printNodesInBoustrophedonOrder :: Eq a => Tree a -> [a]
printNodesInBoustrophedonOrder = zigzagBinaryTree
