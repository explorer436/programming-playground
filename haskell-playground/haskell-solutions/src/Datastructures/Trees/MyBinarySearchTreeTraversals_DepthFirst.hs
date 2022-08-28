module Datastructures.Trees.MyBinarySearchTreeTraversals_DepthFirst where
    
import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.MyBinarySearchTree_Insert (treeInsert, numsTreeFromLeft)


-- TREE TRAVERSALS

{- |
    DEPTH-FIRST SEARCH

    Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. 
    The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.

    Depth-first search of binary tree: These searches are referred to as depth-first search (DFS), since the search tree is deepened as much as possible on each child before going to the next sibling. 

    Binary search trees make it easy to report the labels in sorted order. By definition, all the keys smaller than the root must lie in the left subtree of the root, and all the keys bigger than the root in the right subtree. Thus, visiting the nodes recursively in accord with such a policy produces an in-order traversal of the search tree.

    Each item is processed once during the course of the traversal, which runs in O(n) time, where n denotes the number of nodes in the tree.

    Alternate traversal orders come from changing the position of process_item relative to the traversals of the left and right subtrees.
    Processing the item first yields a pre-order traversal, while processing it last gives a post-order traversal.
    These make relatively little sense with search trees, but prove useful when the rooted tree represents arithmetic or logical expressions.

     	Pre-order (NLR)
     	In-order (LNR)
     	Reverse in-order (RNL)
     	Post-order (LRN)

    What do L, R and N stand for?
    (L)	Recursively traverse N's left subtree.
    (R)	Recursively traverse N's right subtree.
    (N)	Process the current node N itself.
-}

traverseInOrder :: Tree a -> [a]
traverseInOrder EmptyTree = []
traverseInOrder (Node a l r) = (traverseInOrder l) ++ [a] ++ (traverseInOrder r)
--tests
testInOrder01 = traverseInOrder numsTreeFromLeft -- [15,17,20,22,25,26,27,29,30,32] 

traversePreOrder :: Tree a -> [a]
traversePreOrder EmptyTree = []
traversePreOrder (Node a l r) = a : (traversePreOrder l) ++ (traversePreOrder r)
--tests
testPreOrder01 = traversePreOrder numsTreeFromLeft -- [25,20,15,17,22,27,26,30,29,32]

traversePostOrder :: Tree a -> [a]
traversePostOrder EmptyTree = []
traversePostOrder (Node a l r) = (traversePostOrder l) ++ (traversePostOrder r) ++ [a]
--tests
testPostOrder01 = traversePostOrder numsTreeFromLeft -- [17,15,22,20,26,29,32,30,27,25]

traverseReverseInOrder :: Tree a -> [a]
traverseReverseInOrder EmptyTree = []
traverseReverseInOrder (Node a l r) = (traverseReverseInOrder r) ++ [a] ++ (traverseReverseInOrder l)
--tests
testReverseInOrder01 = traverseReverseInOrder numsTreeFromLeft -- [32,30,29,27,26,25,22,20,17,15]

{- |
                          F
                        /  \ 
                       /    \
                      /      \
                     B         G 
                    / \        \
                   /   \        \
                  A     D        I
                       / \      / \ 
                     /    \    /   \ 
                    C      E  H     J
                                     \
                                      K
-}

lettersList :: [Char]
lettersList = ['F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H', 'J', 'K']
{- |
    Node 'F' 
      (Node 'B' 
        (Node 'A' EmptyTree EmptyTree) 
        (Node 'D' 
          (Node 'C' EmptyTree EmptyTree) 
          (Node 'E' EmptyTree EmptyTree)
        )
      ) 
      (Node 'G' 
        EmptyTree 
        (Node 'I' 
          (Node 'H' EmptyTree EmptyTree) 
          (Node 'J' 
            EmptyTree 
            (Node 'K' EmptyTree EmptyTree)
          )
        )
      )
-}
lettersTree :: Tree Char
lettersTree = foldl (\acc x -> treeInsert x acc) EmptyTree lettersList
testInOrder03 :: [Char]
testInOrder03 = traverseInOrder lettersTree -- "ABCDEFGHIJK"
testPreOrder03 :: [Char]
testPreOrder03 = traversePreOrder lettersTree -- "FBADCEGIHJK"
testPostOrder03 :: [Char]
testPostOrder03 = traversePostOrder lettersTree -- "ACEDBHKJIGF"
testReverseInOrder03 :: [Char]
testReverseInOrder03 = traverseReverseInOrder lettersTree -- "KJIHGFEDCBA"

