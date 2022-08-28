
module Datastructures.Trees.LargestPathSumFromRootToLeaf (largestPathSum) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Data.List (foldl')

{- |
    Hi, here's your problem today. This problem was recently asked by Google:
    
    Given a binary tree, find and return the largest path from root to leaf.
    
    Here's an example and some starter code:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def largest_path_sum(tree):
      # Fill this in.
    
    tree = Node(1)
    tree.left = Node(3)
    tree.right = Node(2)
    tree.right.left = Node(4)
    tree.left.right = Node(5)
    #    1
    #  /   \
    # 3     2
    #  \   /
    #   5 4
    print(largest_path_sum(tree))
    # [1, 3, 5]
-}

largestPathSum :: (Ord a, Num a) => Tree a -> [a]
largestPathSum tree = (foldl' (\acc x -> if (sum acc < sum x) then x else acc) (head xs) xs)
                                  where xs = paths tree

{- |
findFirstMaximumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) < (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then x 
                                                                  else acc) 
                                                        else acc) (head xs) xs)                                  
-}                                                        