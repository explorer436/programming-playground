module Datastructures.Trees.CousinsForAllNodes (cousinsForAllNodes) where

import Data.Maybe (fromJust)
import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Data.List (delete)
import Datastructures.Trees.FindCousinsInItsLevel (cousinsInLevel)
import Debug.Trace ( trace )

cousinsForAllNodes EmptyTree = []
cousinsForAllNodes tree@(Node a left right) = trace ("DEBUG: cousinsForAllNodes - " ++ "actual tree:" ++ show tree) 
                                           helper tree tree

helper EmptyTree _ = []
helper tree@(Node a left right) actualTree = trace ("DEBUG: helper - " ++ "current tree:" ++ show tree ++ ", actualTree:" ++ show actualTree) 
                                             ([(a, cousinsInLevel a actualTree)] ++ helper left actualTree ++ helper right actualTree)


                                         
