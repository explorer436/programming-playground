module Datastructures.Trees.FindIfASubreeExistsInAnotherTree (doesSubtreeExistInParentTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, areTreesEqual)

import Data.Maybe (fromJust)

doesSubtreeExistInParentTree :: Eq a => Tree a -> Tree a -> Bool
doesSubtreeExistInParentTree EmptyTree EmptyTree = True
doesSubtreeExistInParentTree t1 EmptyTree = False
doesSubtreeExistInParentTree EmptyTree t2 = False
doesSubtreeExistInParentTree t1@(Node a EmptyTree EmptyTree) t2 = t1 == t2
doesSubtreeExistInParentTree t1@(Node a l r) t2 = if a == fromJust (rootValue t2)
                                                    then areTreesEqual t1 t2
                                                  else doesSubtreeExistInParentTree l t2 || doesSubtreeExistInParentTree r t2
