import MyBinaryTree (Tree (..))

import MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

{- |
    Hi, here's your problem today. This problem was recently asked by Apple:
    
    Given a binary tree, return the list of node values in zigzag order traversal. Here's an example
    
    # Input:
    #         1
    #       /   \
    #      2     3
    #     / \   / \
    #    4   5 6   7
    #
    # Output: [1, 3, 2, 4, 5, 6, 7]
    
    
    Here's some starter code
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def zigzag_order(tree):
      # Fill this in.
    
    n4 = Node(4)
    n5 = Node(5)
    n6 = Node(6)
    n7 = Node(7)
    n2 = Node(2, n4, n5)
    n3 = Node(3, n6, n7)
    n1 = Node(1, n2, n3)
    
    print(zigzag_order(n1))
    # [1, 3, 2, 4, 5, 6, 7]
-}

zigzagBinaryTree :: Eq a => Tree a -> [a]
zigzagBinaryTree tree = concat (invertListsAtOddPositions (zip [0..] (listsByEachLevel tree)))

-- using list comprehension instead of a map
invertListsAtOddPositions xs = [if (odd (fst x)) then (reverse (snd x)) else (snd x) | x <- xs]

-- tests
test01 = zigzagBinaryTree (Node 1
                               (Node 2
                                     (Node 4 EmptyTree EmptyTree)
                                     (Node 5 EmptyTree EmptyTree))
                               (Node 3
                                     (Node 6 EmptyTree EmptyTree)
                                     (Node 7 EmptyTree EmptyTree)))
-- [1,3,2,4,5,6,7]                        
