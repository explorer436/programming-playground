module MySolutions.Trees.CreateABalancedBinarySearchTree (createBalancedBST) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import Debug.Trace ( trace )

-- From BinarySearch.java, int mid = lo + (hi - lo) / 2;

createBalancedBST :: Show a => [a] -> Tree a
createBalancedBST [] = EmptyTree 
createBalancedBST [x] = Node x EmptyTree EmptyTree 
createBalancedBST xs = trace ("DEBUG: createBalancedBST - xs:" ++ show xs) 
                       (Node (middleElement xs) (createBalancedBST firstHalf) (createBalancedBST secondHalf))
                       where indexOfMiddleElement = (length xs - 1 ) `div` 2
                             firstHalf = take indexOfMiddleElement xs
                             secondHalf = drop (indexOfMiddleElement + 1) xs

middleElement :: [a] -> a
middleElement xs = xs !! middle 
            where middle = (length xs - 1 ) `div` 2