module Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

appendTree2ToTheRightMostLeafOfTree1 :: Tree a -> Tree a -> Tree a 
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left EmptyTree) EmptyTree = tree1
appendTree2ToTheRightMostLeafOfTree1 EmptyTree tree2 = tree2
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left EmptyTree) tree2 = Node a left tree2
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left right) tree2 = Node a left (appendTree2ToTheRightMostLeafOfTree1 right tree2)
