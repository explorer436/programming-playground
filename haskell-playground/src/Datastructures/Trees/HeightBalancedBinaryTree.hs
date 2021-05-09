{- |
    Hi, here's your problem today. This problem was recently asked by Twitter:
    
    Given a tree, find if the binary tree is height balanced or not. 
    A height balanced binary tree is a tree where every node's 2 subtrees do not differ in height by more than 1.
    
    Here's some starter code:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def is_height_balanced(tree):
      # Fill this in.
    
    #     1
    #    / \
    #   2   3
    #  /
    # 4  
    n4 = Node(4)
    n3 = Node(3)
    n2 = Node(2, n4)
    n1 = Node(1, n2, n3)
    
    print(is_height_balanced(n1))
    # True
    
    #     1
    #    / 
    #   2   
    #  /
    # 4  
    n1 = Node(1, n2)
    print(is_height_balanced(n1))
    # False
-}

{- |
   A height-balanced binary tree is defined as: a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
-}

module Datastructures.Trees.HeightBalancedBinaryTree (heightBalancedBinaryTree) where
  
import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.MyBinarySearchTree_Height (treeHeight)

-- Ideally, the depth of the tree should be used instead of "height". But at the tree level, the values for the depth and height are exactly the same. See MyBinarySearchTree_Depth.txt

heightBalancedBinaryTree :: Tree a -> Bool
heightBalancedBinaryTree EmptyTree    = True
heightBalancedBinaryTree (Node a EmptyTree EmptyTree)    = True
heightBalancedBinaryTree (Node _ l r) = if (abs(treeHeight l - treeHeight r) <= 1) then True else False

