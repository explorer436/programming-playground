module MyBinaryTree (Tree (..), rootValue, compareTrees, leftAndRightTrees, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue) where

{- |

    Why do we need Binary Search Trees in the first place?

    Because there is a need for data structures that allow both fast search and flexible updates - not just fast search or flexible updates.
    Unsorted double-linked lists support insertion and deletion in O(1) time but search takes linear time in worst case.
    Sorted arrays support binary search and logarithmic query times but at the cost of linear-time update.

    Binary search requires that we have fast access to two elements - the median elements above and below the given node.
    To combine these ideas, we need a "linked list" with two pointers per node.
    And this is the basic idea behind binary search trees.

    A rooted binary tree is recursively defined as either being
    1. empty, or
    2. consisting of a node called the root, together with two rooted binary trees called the left and right subtrees, respectively.
    A binary search tree labels each node in a binary tree with a single key such that for any node labeled x, 
    all nodes in the left of the subtree of x have keys < x while 
    all nodes in the right subtree of x have keys > x.
    This search tree labeling scheme is very special.
    For any binary tree on n nodes, and any set of n keys, there is exactly one labeling that makes it a binary search tree.

    Each of the nodes can also point to two rooted binary trees called the left and right subtrees (or one, or none). 
    A cool thing about binary search trees is that we know that all the elements at the left sub-tree of, say, 5 are going to be smaller than 5. 
    Elements in its right sub-tree are going to be bigger. 
    So if we need to find if 8 is in our tree, we'd start at 5 and then because 8 is greater than 5, we'd go right. 
    We're now at 7 and because 8 is greater than 7, we go right again. 
    And we've found our element in three hops! 
    Now if this were a normal list (or a tree, but really unbalanced), it would take us seven hops instead of three to see if 8 is in there.
    
    In Haskell, Sets and maps from Data.Set and Data.Map are implemented using trees, 
    only instead of normal binary search trees, 
    they use balanced binary search trees, 
    which are always balanced. 
    
    Here's what we're going to say: 
    a tree is either an empty tree or it's an element that contains some value and two trees. 
    This is a perfect fit for an algebraic data type in Haskell!
-}

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq) 

rootValue :: Tree a -> Maybe a
rootValue (Node a _ _) = Just a
rootValue EmptyTree    = Nothing

compareTrees :: Eq a => a -> a -> Bool
compareTrees t1 t2 = t1 == t2

leftAndRightTrees :: Tree a -> [Tree a]
leftAndRightTrees (Node _ EmptyTree EmptyTree) = []
leftAndRightTrees (Node _ EmptyTree b)     = [b]
leftAndRightTrees (Node _ a EmptyTree)     = [a]
leftAndRightTrees (Node _ a b)         = [a,b]

leftSubtree :: Tree a -> Maybe (Tree a)
leftSubtree EmptyTree = Nothing
leftSubtree (Node _ left _) = Just left

rightSubtree :: Tree a -> Maybe (Tree a)
rightSubtree EmptyTree = Nothing
rightSubtree (Node _ _ right) = Just right

leftNodeValue :: Tree a -> Maybe a
leftNodeValue EmptyTree = Nothing
leftNodeValue (Node a EmptyTree _) = Nothing
leftNodeValue (Node a left _) = rootValue left

rightNodeValue :: Tree a -> Maybe a
rightNodeValue EmptyTree = Nothing
rightNodeValue (Node a _ EmptyTree) = Nothing
rightNodeValue (Node a _ right) = rootValue right
