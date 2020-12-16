import MyBinaryTree

import Data.List (elemIndex)
import Data.Maybe (fromJust)

import BinaryTreeSumsForEachLevel (listWithSumsForEachLevel)

{- |

    Hi, here's your problem today. This problem was recently asked by Twitter:

    You are given the root of a binary tree. Find the level for the binary tree with the minimum sum, and return that value.

    For instance, in the example below, the sums of the trees are 10, 2 + 8 = 10, and 4 + 1 + 2 = 7. So, the answer here should be 7.

    class Node:

      def __init__(self, value, left=None, right=None):
        self.val = value
        self.left = left
        self.right = right

    def minimum_level_sum(root):
      # Fill this in.

    #     10
    #    /  \
    #   2    8
    #  / \    \
    # 4   1    2

    node = Node(10)
    node.left = Node(2)
    node.right = Node(8)
    node.left.left = Node(4)
    node.left.right = Node(1)
    node.right.right = Node(2)

    print minimum_level_sum(node)
-}

levelOfTreeWithMinimumSum tree = fromJust $ elemIndex (minSum tree) (listWithSumsForEachLevel tree)

minSum tree = minimum (listWithSumsForEachLevel tree)

-- tests

testMinSum01 = minSum
            (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))
-- 7

testLevelOfTreeWithMinimumSum01 = levelOfTreeWithMinimumSum
            (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))
-- 2
