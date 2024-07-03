module MySolutions.Trees.InvertABinaryTree (invertTree) where
  
import MySolutions.Trees.MyBinaryTree (Tree (..))

invertTree :: Tree a -> Tree a
invertTree EmptyTree = EmptyTree
invertTree tree@(Node a EmptyTree EmptyTree) = tree
invertTree (Node a left right) = Node a (invertTree right) (invertTree left)
