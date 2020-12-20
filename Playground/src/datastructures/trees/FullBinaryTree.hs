import MyBinaryTree (Tree (..), rootValue)

import Data.Maybe (fromJust)

{- |
    Hi, here's your problem today. This problem was recently asked by Google:
    
    Given a binary tree, remove the nodes in which there is only 1 child, so that the binary tree is a full binary tree.
    
    So leaf nodes with no children should be kept, and nodes with 2 children should be kept as well.
    
    Here's a starting point:
    
    from collections import deque
    
    class Node(object):
      def __init__(self, value, left=None, right=None):
        self.left = left
        self.right = right
        self.value = value
      def __str__(self):
        q = deque()
        q.append(self)
        result = ''
        while len(q):
          num = len(q)
          while num > 0:
            n = q.popleft()
            result += str(n.value)
            if n.left:
              q.append(n.left)
            if n.right:
              q.append(n.right)
            num = num - 1
          if len(q):
            result += "\n"
    
        return result
    
    def fullBinaryTree(node):
      # Fill this in.
    
    # Given this tree:
    #     1
    #    / \ 
    #   2   3
    #  /   / \
    # 0   9   4
    
    # We want a tree like:
    #     1
    #    / \ 
    #   0   3
    #      / \
    #     9   4
    
    tree = Node(1)
    tree.left = Node(2)
    tree.right = Node(3)
    tree.right.right = Node(4)
    tree.right.left = Node(9)
    tree.left.left = Node(0)
    print fullBinaryTree(tree)
    # 1
    # 03
    # 94
-}

fullBinaryTree EmptyTree = EmptyTree
fullBinaryTree tree@(Node a EmptyTree EmptyTree) = tree
fullBinaryTree tree@(Node a left EmptyTree) = fullBinaryTree left
fullBinaryTree tree@(Node a EmptyTree right) = fullBinaryTree right
fullBinaryTree tree@(Node a left right) = Node a (fullBinaryTree left) (fullBinaryTree right)


test01 = fullBinaryTree (Node 1
                            (Node 2
                                  (Node 0 EmptyTree EmptyTree)
                                  EmptyTree
                            )
                            (Node 3 
                                  (Node 9 EmptyTree EmptyTree)
                                  (Node 4 EmptyTree EmptyTree)
                            )
                      )
-- Node 1 
--      (Node 0 EmptyTree EmptyTree)
--      (Node 3 
--            (Node 9 EmptyTree EmptyTree) 
--            (Node 4 EmptyTree EmptyTree))                      
