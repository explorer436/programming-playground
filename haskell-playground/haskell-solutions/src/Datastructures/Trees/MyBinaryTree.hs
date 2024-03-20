module Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, areTreesEqual, leftAndRightTrees, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue, treeHeight, treeLeftHeight, treeRightHeight, treeSize) where

{- |
    In Haskell, Sets and maps from Data.Set and Data.Map are implemented using trees, 
    only instead of normal binary search trees, 
    they use balanced binary search trees, 
    which are always balanced. 
    
    Here's what we're going to say: 
    a tree is either an empty tree or it's an element that contains some value and two trees. 
    This is a perfect fit for an algebraic data type in Haskell!
-}

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq, Ord) 

rootValue :: Tree a -> Maybe a
rootValue (Node a _ _) = Just a
rootValue EmptyTree    = Nothing

areTreesEqual :: Eq a => a -> a -> Bool
areTreesEqual t1 t2 = t1 == t2

leftAndRightTrees :: Tree a -> [Tree a]
leftAndRightTrees (Node _ EmptyTree EmptyTree) = []
leftAndRightTrees (Node _ EmptyTree b)         = [b]
leftAndRightTrees (Node _ a EmptyTree)         = [a]
leftAndRightTrees (Node _ a b)                 = [a,b]

leftSubtree :: Tree a -> Maybe (Tree a)
leftSubtree EmptyTree       = Nothing
leftSubtree (Node _ left _) = Just left

rightSubtree :: Tree a -> Maybe (Tree a)
rightSubtree EmptyTree        = Nothing
rightSubtree (Node _ _ right) = Just right

leftNodeValue :: Tree a -> Maybe a
leftNodeValue EmptyTree            = Nothing
leftNodeValue (Node a EmptyTree _) = Nothing
leftNodeValue (Node a left _)      = rootValue left

rightNodeValue :: Tree a -> Maybe a
rightNodeValue EmptyTree            = Nothing
rightNodeValue (Node a _ EmptyTree) = Nothing
rightNodeValue (Node a _ right)     = rootValue right

treeHeight :: (Num p, Ord p) => Tree a -> p
treeHeight EmptyTree                    = -1
treeHeight (Node a EmptyTree EmptyTree) = 0
treeHeight (Node _ l r)                 = 1 + max (treeHeight l) (treeHeight r)

treeLeftHeight :: (Num p, Ord p) => Tree a -> p
treeLeftHeight EmptyTree                    = -1
treeLeftHeight (Node a EmptyTree EmptyTree) = 0
treeLeftHeight (Node _ l r)                 = 1 + treeLeftHeight l

treeRightHeight :: (Num p, Ord p) => Tree a -> p
treeRightHeight EmptyTree                    = -1
treeRightHeight (Node a EmptyTree EmptyTree) = 0
treeRightHeight (Node _ l r)                 = 1 + treeRightHeight r


-- From Wikipedia:
-- Size of a tree = Number of nodes in the tree.
treeSize :: Num p => Tree a -> p
treeSize EmptyTree = 0
treeSize (Node a EmptyTree EmptyTree ) = 1
treeSize tree@(Node a left right) = 1 + treeSize left + treeSize right
