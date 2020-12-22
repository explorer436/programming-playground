module Datastructures.Trees.ArithmeticBinaryTree where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Data.Int

{- |
    Hi, here's your problem today. This problem was recently asked by Apple:
    
    You are given a binary tree representation of an arithmetic expression.
    In this tree, each leaf is an integer value,, and a non-leaf node is one of the four operations: '+', '-', '*', or '/'.
    
    Write a function that takes this tree and evaluates the expression.
    
    Example:
    
        *
       / \
      +    +
     / \  / \
    3  2  4  5
    
    
    This is a representation of the expression (3 + 2) * (4 + 5), and should return 45.
    
    Here's a starting point:
    
    class Node:
      def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
    PLUS = "+"
    MINUS = "-"
    TIMES = "*"
    DIVIDE = "/"
    
    def evaluate(root):
      # Fill this in.
    
    tree = Node(TIMES)
    tree.left = Node(PLUS)
    tree.left.left = Node(3)
    tree.left.right = Node(2)
    tree.right = Node(PLUS)
    tree.right.left = Node(4)
    tree.right.right = Node(5)
    print evaluate(tree)
    # 45
-}

{- |
    (Easy)

    Good morning! Here's your coding interview problem for today.

    This problem was asked by Microsoft.

    Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

    Given the root to such a tree, write a function to evaluate it.

    For example, given the following tree:

        *
    / \
    +    +
    / \  / \
    3  2  4  5

    You should return 45, as it is (3 + 2) * (4 + 5).
-}


evaluateArithmeticBinaryTree EmptyTree = 0
evaluateArithmeticBinaryTree (Node a EmptyTree EmptyTree) = read a :: Int8
evaluateArithmeticBinaryTree tree@(Node a left right) = case (a) of
                                                                    "+"   -> (evaluateArithmeticBinaryTree left) + (evaluateArithmeticBinaryTree right)
                                                                    "-"   -> (evaluateArithmeticBinaryTree left) - (evaluateArithmeticBinaryTree right)
                                                                    "*"   -> (evaluateArithmeticBinaryTree left) * (evaluateArithmeticBinaryTree right)
                                                                    "/"   -> (evaluateArithmeticBinaryTree left) `div` (evaluateArithmeticBinaryTree right)

-- Need to make them strings as opposed to chars because there may be cases when the input numbers are longer than one digit.
test01 = evaluateArithmeticBinaryTree (Node "*" 
                                            (Node "+"
                                                  (Node "3" EmptyTree EmptyTree)
                                                  (Node "2" EmptyTree EmptyTree)
                                            )
                                            (Node "+"
                                                  (Node "4" EmptyTree EmptyTree)
                                                  (Node "5" EmptyTree EmptyTree)
                                            )
                                      )
-- 45                  
