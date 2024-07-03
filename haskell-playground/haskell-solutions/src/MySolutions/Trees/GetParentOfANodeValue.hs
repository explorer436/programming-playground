module MySolutions.Trees.GetParentOfANodeValue (getParent) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)

getParent :: (Num t, Eq t) => Tree t -> t -> t

getParent EmptyTree searchValue = 0

getParent tree@(Node a EmptyTree EmptyTree) searchValue = 0

getParent tree@(Node a l@(Node a_l l_l r_l) EmptyTree) searchValue
  | a_l == searchValue = a
  | otherwise          = getParent l searchValue

getParent tree@(Node a EmptyTree r@(Node a_r l_r r_r)) searchValue
  | a_r == searchValue = a
  | otherwise          = getParent r searchValue

getParent tree@(Node a l@(Node a_l l_l r_l) r@(Node a_r l_r r_r)) searchValue
  | a_l == searchValue || a_r == searchValue = a
  | otherwise                                = getParent l searchValue + getParent r searchValue
