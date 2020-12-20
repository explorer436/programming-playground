import MyBinaryTree (Tree (..))

import Data.Int
import Data.List (maximumBy, foldl')
import Data.Maybe (fromJust)
import BinaryTreeSumsByEachLevel (listWithSumsForEachLevel)

{- |

    Hi, here's your problem today. This problem was recently asked by Microsoft:

    Given a binary tree, find the level in the tree where the sum of all nodes on that level is the greatest.

    Here's an example and some starter code.

    class Node:

     def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
   
      def __repr__(self):
        return f"(Value: {self.value} Left: {self.left} Right: {self.right})"

    def tree_level_max_sum(root):
      -- Fill this in.

    n3 = Node(4, Node(3), Node(2))
    n2 = Node(5, Node(4), Node(-1))
    n1 = Node(1, n2, n3)

        1          Level 0 - Sum: 1
       / \
      4   5        Level 1 - Sum: 9
     / \ / \
    3  2 4 -1      Level 2 - Sum: 8

    print(tree_level_max_sum(n1))
    -- Should print 1 as level 1 has the highest level sum
-}

-- For reference, see MaxElementInAListAndItsIndex.hs
findFirstMaximumElementInTheListAndIndex :: (Integral a, Integral b) => [(a, b)] -> Maybe (a, b)
findFirstMaximumElementInTheListAndIndex [] = Nothing
findFirstMaximumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) < (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then x 
                                                                  else acc) 
                                                        else acc) (head xs) xs)

greatestTupleOfAllNodesInALevel tree = fromJust $ findFirstMaximumElementInTheListAndIndex (zip (listWithSumsForEachLevel tree)[0..])
greatestSumOfAllNodesInALevel tree = fst $ greatestTupleOfAllNodesInALevel tree
levelOfTreeWhereSumOfAllNodesIsTheGreatest tree = snd $ greatestTupleOfAllNodesInALevel tree

-- tests
testLevelOfTreeWithMaximumSum01 = levelOfTreeWhereSumOfAllNodesIsTheGreatest testTree -- 1
testGreatestSumOfAllNodesInALevel01 = greatestSumOfAllNodesInALevel testTree -- 9

testTree = (Node 1
               (Node 4
                   (Node 3 EmptyTree EmptyTree)
                   (Node 2 EmptyTree EmptyTree))
               (Node 5
                   (Node 4 EmptyTree EmptyTree)
                   (Node (-1) EmptyTree EmptyTree)))
