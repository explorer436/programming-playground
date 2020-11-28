import Data.List (permutations, foldl')

{- |
    WE ARE GOING TO IMPLEMENT A BINARY SEARCH TREE. 

    If you're not familiar with binary search trees from languages like C, here's what they are - 
    an element points to two elements, one on its left and one on its right. 
    The element to the left is smaller, the element to the right is bigger. 
    Each of those elements can also point to two elements (or one, or none). 
    In effect, each element has up to two sub-trees. 
    And a cool thing about binary search trees is that we know that all the elements at the left sub-tree of, say, 5 are going to be smaller than 5. 
    Elements in its right sub-tree are going to be bigger. 
    So if we need to find if 8 is in our tree, we'd start at 5 and then because 8 is greater than 5, we'd go right. 
    We're now at 7 and because 8 is greater than 7, we go right again. 
    And we've found our element in three hops! 
    Now if this were a normal list (or a tree, but really unbalanced), it would take us seven hops instead of three to see if 8 is in there.
    
    Sets and maps from Data.Set and Data.Map are implemented using trees, 
    only instead of normal binary search trees, 
    they use balanced binary search trees, 
    which are always balanced. 
    But right now, we'll just be implementing normal binary search trees.
    
    Here's what we're going to say: 
    a tree is either an empty tree or it's an element that contains some value and two trees. 
    Sounds like a perfect fit for an algebraic data type!
-}

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq) 

{- |
    HOW DO WE BUILD A TREE?

    Instead of manually building a tree, we're going to make a function that takes a tree and an element and inserts an element. 
    We do this by comparing the value we want to insert to the root node and then if it's smaller, we go left, if it's larger, we go right. 
    We do the same for every subsequent node until we reach an empty tree. 
    Once we've reached an empty tree, we just insert a node with that value instead of the empty tree.
    
    In languages like C, we'd do this by modifying the pointers and values inside the tree. 
    In Haskell, we can't really modify our tree.
    So, we have to make a new sub-tree each time we decide to go left or right 
    and in the end the insertion function returns a completely new tree, 
    because Haskell doesn't really have a concept of pointer, just values. 
    Hence, the type for our insertion function is going to be something like 
    a -> Tree a - > Tree a. 
    It takes an element and a tree and returns a new tree that has that element inside. 
    This might seem like it's inefficient but laziness takes care of that problem.
    
    So, here are two functions. 
    The first one is a utility function for making a singleton tree (a tree with just one node).
    The second one is a function to insert an element into a tree.
-}

singleton :: a -> Tree a  
singleton x = Node x EmptyTree EmptyTree  
  
treeInsert :: (Ord a) => a -> Tree a -> Tree a  
treeInsert x EmptyTree = singleton x  
treeInsert x (Node a left right)   
    | x == a = Node x left right  
    | x < a  = Node a (treeInsert x left) right  
    | x > a  = Node a left (treeInsert x right)

-- TODO
-- delete an element from a tree
-- get the minimum value from the tree
-- get the maximum value from the tree
    
{- |
    The singleton function is just a shortcut for making a node 
    that has something and then two empty sub-trees. 
    In the insertion function, 
    we first have the edge condition as a pattern. 
    If we've reached an empty sub-tree, 
    that means we are where we want and instead of the empty tree, 
    we put a singleton tree with our element. 
    If we're not inserting into an empty tree, 
    then we have to check some things. 
    First off, if the element we're inserting is equal to the root element, 
    just return a tree that's the same. 
    If it's smaller, return a tree that has the same root value, 
    the same right sub-tree but instead of its left sub-tree, 
    put a tree that has our value inserted into it. 
    Same (but the other way around) goes if our value is bigger than the root element.
    
    Next up, we're going to make a function that checks if some element is in the tree. 
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
    
{- |
    All we had to do was write up the previous paragraph in code. 
    Let's have some fun with our trees! 
    Instead of manually building one (although we could), 
    we'll use a fold to build up a tree from a list. 
    Remember, 
    pretty much everything that traverses a list one by one and 
    then returns some sort of value can be implemented with a fold! 
    We're going to start with the empty tree and 
    then approach a list from the right and 
    just insert element after element into our accumulator tree.
-}

-- using a right fold here.
treeFromRight :: (Foldable t, Ord a) => t a -> Tree a
treeFromRight xs = foldr treeInsert EmptyTree xs

nums = [8,6,4,1,7,3,5]  
numsTreeFromRight = treeFromRight nums
-- Node 5 (Node 3 (Node 1 EmptyTree EmptyTree) (Node 4 EmptyTree EmptyTree)) (Node 7 (Node 6 EmptyTree EmptyTree) (Node 8 EmptyTree EmptyTree))  

{- |
		 			     5
		 			   /  \ 
					  /    \
					 /      \
					3        7 
  				   /  \     /  \
  				  /    \   /    \
				 1      4 6      8 

-}

{- |
    In that foldr for treeFromRight, 
    treeInsert was the folding function 
    (it takes a tree and a list element and produces a new tree) and 
    EmptyTree was the starting accumulator. 
    nums, of course, was the list we were folding over.
    
    When we print our tree to the console, 
    it's not very readable, but if we try, we can make out its structure. 
    We see that the root node is 5 and then it has two sub-trees, 
    one of which has the root node of 3 and the other a 7, etc.
-}

-- Checking for membership also works nicely.
testTreeFromRightElement01 =  8 `treeElem` numsTreeFromRight   -- True  
testTreeFromRightElement02 =  100 `treeElem` numsTreeFromRight -- False  
testTreeFromRightElement03 =  1 `treeElem` numsTreeFromRight   -- True  
testTreeFromRightElement04 =  10 `treeElem` numsTreeFromRight  --  False  

----------------------------------------------------------------------------------------------------

-- building a tree starting from the first element of a list:
-- Using a left fold here.
-- For left fold, the order of the accumulator and the variable x in the lambda is important. The accumulator has to be on the left side of the variable.
treeFromLeft :: (Foldable t, Ord a) => t a -> Tree a
treeFromLeft xs = foldl (\acc x -> treeInsert x acc) EmptyTree xs

nums2 = [25, 20, 15, 27, 30, 29, 26, 22, 32, 17]
numsTreeFromLeft = treeFromLeft nums2

{- |
		 			    25
		 			   /  \ 
					  /    \
					 /      \
					20       27
  				   /  \     /  \
  				  /    \   /    \
				 15    22 26   30
				  \	           / \
				  17	     29  32
-}

----------------------------------------------------------------------------------------------------

-- TREE TRAVERSALS

{- |
    DEPTH-FIRST SEARCH

    Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. 
    The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.

    Depth-first search of binary tree: These searches are referred to as depth-first search (DFS), since the search tree is deepened as much as possible on each child before going to the next sibling. 
     	Pre-order (NLR)
     	In-order (LNR)
     	Reverse in-order (RNL)
     	Post-order (LRN)

    What do L, R and N stand for?
    (L)	Recursively traverse N's left subtree.
    (R)	Recursively traverse N's right subtree.
    (N)	Process the current node N itself.
-}

traversePreOrder :: Tree a -> [a]
traversePreOrder EmptyTree = []
traversePreOrder (Node a l r) = a : (traversePreOrder l) ++ (traversePreOrder r)
--tests
testPreOrder01 = traversePreOrder numsTreeFromLeft -- [25,20,15,17,22,27,26,30,29,32]

traverseInOrder :: Tree a -> [a]
traverseInOrder EmptyTree = []
traverseInOrder (Node a l r) = (traverseInOrder l) ++ [a] ++ (traverseInOrder r)
--tests
testInOrder01 = traverseInOrder numsTreeFromLeft -- [15,17,20,22,25,26,27,29,30,32] 

traverseReverseInOrder :: Tree a -> [a]
traverseReverseInOrder EmptyTree = []
traverseReverseInOrder (Node a l r) = (traverseReverseInOrder r) ++ [a] ++ (traverseReverseInOrder l)
--tests
testReverseInOrder01 = traverseReverseInOrder numsTreeFromLeft -- [32,30,29,27,26,25,22,20,17,15]

traversePostOrder :: Tree a -> [a]
traversePostOrder EmptyTree = []
traversePostOrder (Node a l r) = (traversePostOrder l) ++ (traversePostOrder r) ++ [a]
--tests
testPostOrder01 = traversePostOrder numsTreeFromLeft -- [17,15,22,20,26,29,32,30,27,25]

{- |
		 			     F
		 			   /  \ 
					  /    \
					 /      \
			 		B         G 
  				   / \        \
  				  /   \        \
				 A     D       I
				   	  / \     / \ 
				   	/    \   /   \ 
				   C	  E H     J
                                   \
                                    K
-}

nums3 = ['F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H', 'J', 'K']
-- Node 'F' (Node 'B' (Node 'A' EmptyTree EmptyTree) (Node 'D' (Node 'C' EmptyTree EmptyTree) (Node 'E' EmptyTree EmptyTree))) (Node 'G' EmptyTree (Node 'I' (Node 'H' EmptyTree EmptyTree) EmptyTree)) 
numsTree3 = foldl (\acc x -> treeInsert x acc) EmptyTree nums3
testPreOrder03 = traversePreOrder numsTree3 -- "FBADCEGIHJK"
testInOrder03 = traverseInOrder numsTree3 -- "ABCDEFGHIJK"
testReverseInOrder03 = traverseReverseInOrder numsTree3 -- "KJIHGFEDCBA"
testPostOrder03 = traversePostOrder numsTree3 -- "ACEDBHKJIGF"


----------------------------------------------------------------------------------------------------

{- |
    BREADTH-FIRST SEARCH / LEVEL ORDER
    
    Trees can also be traversed in level-order, where we visit every node on a level before going to a lower level. This search is referred to as breadth-first search (BFS), as the search tree is broadened as much as possible on each depth before going to the next depth.
-}

traverseBreadthFirst :: Tree a -> [a]
traverseBreadthFirst tree = tbf [tree]

tbf :: [Tree a] -> [a]
tbf [] = []
tbf listOfTrees = map nodeValue listOfTrees ++ tbf (concat (map leftAndRightTrees listOfTrees))

nodeValue :: Tree a -> a
nodeValue (Node a _ _) = a

leftAndRightTrees :: Tree a -> [Tree a]
leftAndRightTrees (Node _ EmptyTree EmptyTree) = []
leftAndRightTrees (Node _ EmptyTree b)     = [b]
leftAndRightTrees (Node _ a EmptyTree)     = [a]
leftAndRightTrees (Node _ a b)         = [a,b]

-- tests
testTraverseBreadthFirst01 = traverseBreadthFirst numsTree3  -- "FBGADICEHJK"

{- |
    explanation:
    1. F +    B      +     G
             / \           \
            A   D           I
               / \        / \
              C   E      H   J
                              \
                               K

    2. F + B + G +     A + D +   I
                          / \   / \
                         C  E  H   J
                                    \
                                     K

    3. F + B + G + A + D + I +    C + E + H + J
                                               \
                                                K

    4. F + B + G + A + D + I + C + E + H +    J + K
-}

----------------------------------------------------------------------------------------------------

{- |
   GenerateBinarySearchTrees
  
    Hi, here's your problem today. This problem was recently asked by Amazon:
    
    Given a number n, generate all binary search trees that can be constructed with nodes 1 to n.
    
    Here's some code to start with:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __str__(self):
        result = str(self.value)
        if self.left:
          result = result + str(self.left)
        if self.right:
          result = result + str(self.right)
        return result
    
    def generate_bst(n):
      # Fill this in.
    
    for tree in generate_bst(3):
      print tree
    
    # Pre-order traversals of binary trees from 1 to n.
    # 123
    # 132
    # 213
    # 312
    # 321
    
    #   1      1      2      3      3
    #    \      \    / \    /      /
    #     2      3  1   3  1      2
    #      \    /           \    /
    #       3  2             2  1
-}

-- Using Data.List.permutations here. TODO : write your own implementation for permutations.
perms n = permutations [1..n]
testGenerateBinarySearchTrees = map treeFromLeft (perms 3)
-- [
-- Node 1 EmptyTree (Node 2 EmptyTree (Node 3 EmptyTree EmptyTree)),
-- Node 1 EmptyTree (Node 3 (Node 2 EmptyTree EmptyTree) EmptyTree),
-- Node 2 (Node 1 EmptyTree EmptyTree) (Node 3 EmptyTree EmptyTree),   [2,3,1] and [2,1,3] are going to give the same Binary Search Tree.
-- Node 2 (Node 1 EmptyTree EmptyTree) (Node 3 EmptyTree EmptyTree),
-- Node 3 (Node 1 EmptyTree (Node 2 EmptyTree EmptyTree)) EmptyTree,
-- Node 3 (Node 2 (Node 1 EmptyTree EmptyTree) EmptyTree) EmptyTree
-- ]
----------------------------------------------------------------------------------------------------

-- The height of a node is the length of the longest downward path to a leaf from that node. 
-- The height of the root is the height of the tree. 
-- The depth of a node is the length of the path to its root (i.e., its root path). 

{- |
    
    Level : Painless
    
    Compute the height of a binary tree.
    
    		 			     5
    		 			   /  \ 
    					  /    \
    					 /      \
    					3       10
      				   / \     /
      				  /   \   /
    				 20    21 1
    
    In this problem we consider binary trees, represented by pointer data structures.
    
    A binary tree is either an empty tree or a node (called the root) consisting of a single integer value and two further binary trees, called the left subtree and the right subtree.
    
    For example, the figure below shows a binary tree consisting of six nodes. Its root contains the value 5, and the roots of its left and right subtrees have the values 3 and 10, respectively. The right subtree of the node containing the value 10, as well as the left and right subtrees of the nodes containing the values 20, 21 and 1, are empty trees.
    
    A path in a binary tree is a non-empty sequence of nodes that one can traverse by following the pointers. The length of a path is the number of pointers it traverses. More formally, a path of length K is a sequence of nodes P[0], P[1], ..., P[K], such that node P[I + 1] is the root of the left or right subtree of P[I], for 0 ≤ I < K. For example, the sequence of nodes with values 5, 3, 21 is a path of length 2 in the tree from the above figure. The sequence of nodes with values 10, 1 is a path of length 1. The sequence of nodes with values 21, 3, 20 is not a valid path.
    
    The height of a binary tree is defined as the length of the longest possible path in the tree. In particular, a tree consisting of only one node has height 0 and, conventionally, an empty tree has height −1. For example, the tree shown in the above figure is of height 2.
    
    Problem
    
    Write a function:
    
        class Solution { public int solution(Tree T); }
    
    that, given a non-empty binary tree T consisting of N nodes, returns its height. For example, given tree T shown in the figure above, the function should return 2, as explained above. Note that the values contained in the nodes are not relevant in this task.
    
    Technical details
    
    A binary tree can be given using a pointer data structure. Assume that the following declarations are given:
    
        class Tree {
          public int x;
          public Tree l;
          public Tree r;
        }
    
    An empty tree is represented by an empty pointer (denoted by null). A non-empty tree is represented by a pointer to an object representing its root. The attribute x holds the integer contained in the root, whereas attributes l and r hold the left and right subtrees of the binary tree, respectively.
    
    For the purpose of entering your own test cases, you can denote a tree recursively in the following way. An empty binary tree is denoted by None. A non-empty tree is denoted as (X, L, R), where X is the value contained in the root and L and R denote the left and right subtrees, respectively. The tree from the above figure can be denoted as:
      (5, (3, (20, None, None), (21, None, None)), (10, (1, None, None), None))
    
    Assumptions
    
    Write an efficient algorithm for the following assumptions:
    
            N is an integer within the range [1..1,000];
            the height of tree T (number of edges on the longest path from root to leaf) is within the range [0..500].

-}

treeHeight EmptyTree    = -1
treeHeight (Node _ l r) = 1 + max (treeHeight l) (treeHeight r)
-- tests
testTreeHeight01 = treeHeight numsTreeFromLeft -- 3
testTreeHeight02 = treeHeight numsTreeFromRight -- 2

----------------------------------------------------------------------------------------------------
