module Datastructures.Trees.CartesianTree (listToCartesionTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Data.List (permutations, foldl')

----------------------------------------------------------------------------------------------------

cartesionTreeInsert :: (Ord a) => a -> Tree a -> Tree a

cartesionTreeInsert x EmptyTree = Node x EmptyTree EmptyTree

cartesionTreeInsert x tree@(Node a EmptyTree EmptyTree)
    | x == a = tree
    | x < a  = Node x tree EmptyTree
    | x > a  = Node a EmptyTree (Node x EmptyTree EmptyTree)

cartesionTreeInsert x tree@(Node a left EmptyTree)
    | x == a = tree
    | x < a  = Node x tree EmptyTree
    | x > a  = Node a left (Node x EmptyTree EmptyTree)

cartesionTreeInsert x tree@(Node a EmptyTree right)
    | x == a = tree
    | x < a  = Node x tree EmptyTree
    | x > a  = Node a EmptyTree (cartesionTreeInsert x right)


cartesionTreeInsert x tree@(Node a left right)
    | x == a = tree
    | x < a  = Node x tree EmptyTree
    | x > a  = Node a left (cartesionTreeInsert x right)

listToCartesionTree :: (Ord a) => [a] -> Tree a
listToCartesionTree = foldl' (\acc x -> cartesionTreeInsert x acc) EmptyTree