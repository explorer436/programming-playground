module MySolutions.Trees.IsGivenTreeBinarySearchTree (isBST) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue)
import Data.Maybe (fromJust)

isBST :: Ord a => Tree a -> Bool
isBST EmptyTree = False
isBST (Node a EmptyTree EmptyTree) = True
isBST (Node a left EmptyTree) = (fromJust (rootValue left) < a) && isBST left
isBST (Node a EmptyTree right) = (a < fromJust (rootValue right)) && isBST right
isBST (Node a left right) = (fromJust (rootValue left) < a) && (a < fromJust (rootValue right)) && isBST left && isBST right
