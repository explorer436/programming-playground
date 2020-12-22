import MyBinaryTree (Tree (..), rootValue)
import Data.Maybe (fromJust)

{- |
    Hi, here's your problem today. This problem was recently asked by Facebook:
    
    You are given the root of a binary search tree. Return true if it is a valid binary search tree, and false otherwise.
    Recall that a binary search tree has the property that all values in the left subtree are less than or equal to the root, 
    and all values in the right subtree are greater than or equal to the root.
    
    Here's a starting point:
    
    class TreeNode:
      def __init__(self, key):
        self.left = None
        self.right = None
        self.key = key
    
    def is_bst(root):
      # Fill this in.
    
    a = TreeNode(5)
    a.left = TreeNode(3)
    a.right = TreeNode(7)
    a.left.left = TreeNode(1)
    a.left.right = TreeNode(4)
    a.right.left = TreeNode(6)
    print is_bst(a)
    
    #    5
    #   / \
    #  3   7
    # / \ /
    #1  4 6
-}

validate EmptyTree = False
validate (Node a EmptyTree EmptyTree) = True
validate (Node a left EmptyTree) = (fromJust (rootValue left) < a) && validate left
validate (Node a EmptyTree right) = (a < fromJust (rootValue right)) && validate right
validate (Node a left right) = (fromJust (rootValue left) < a) && (a < fromJust (rootValue right)) && validate left && validate right

test01 = validate (Node 5 
                        (Node 3
                              (Node 1 EmptyTree EmptyTree)
                              (Node 4 EmptyTree EmptyTree)
                        )
                        (Node 7
                              (Node 6 EmptyTree EmptyTree)
                              EmptyTree
                        )
                  ) -- expect True

test02 = validate (Node 5 
                        (Node 3
                              (Node 1 EmptyTree EmptyTree)
                              (Node 4 EmptyTree EmptyTree)
                        )
                        (Node 7
                              (Node 8 EmptyTree EmptyTree)
                              EmptyTree
                        )
                  ) -- expect False
