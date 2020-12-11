module MyBinarySearchTree_IsElement where
  
import MyBinarySearchTree

----------------------------------------------------------------------------------------------------

{- |
    
    Write a function that checks if some element is in the tree. 
    First, let's define the edge condition. 
    If we're looking for an element in an empty tree, then it's certainly not there. 
    Notice how this is the same as the edge condition when searching for elements in lists. 
    If we're looking for an element in an empty list, it's not there. 
    Anyway, if we're not looking for an element in an empty tree, then we check some things. 
    If the element in the root node is what we're looking for, great! 
    If it's not, what then? 
    Well, we can take advantage of knowing that all the left elements are smaller than the root node. 
    So if the element we're looking for is smaller than the root node, 
    check to see if it's in the left sub-tree. 
    If it's bigger, check to see if it's in the right sub-tree.
-}

treeElem :: (Ord a) => a -> Tree a -> Bool  
treeElem x EmptyTree = False  
treeElem x (Node a left right)  
    | x == a = True  
    | x < a  = treeElem x left  
    | x > a  = treeElem x right 

----------------------------------------------------------------------------------------------------