module BinarySearchTreeTraversals_DepthFirst05 where
    
import BinarySearchTrees01
import BinarySearchTree_Insert02


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
