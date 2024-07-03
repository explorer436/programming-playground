module MySolutions.Trees.PrintNodesInBoustrophedonOrder (printNodesInBoustrophedonOrder) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.ZigZagBinaryTree (zigzagBinaryTree)

printNodesInBoustrophedonOrder :: Eq a => Tree a -> [a]
printNodesInBoustrophedonOrder = zigzagBinaryTree
