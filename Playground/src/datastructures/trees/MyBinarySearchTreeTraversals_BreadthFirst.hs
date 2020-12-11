module MyBinarySearchTreeTraversals_BreadthFirst where

import MyBinarySearchTree

{- |
    BREADTH-FIRST SEARCH / LEVEL ORDER
    
    Trees can also be traversed in level-order, where we visit every node on a level before going to a lower level.
    This search is referred to as breadth-first search (BFS), as the search tree is broadened as much as possible on each depth before going to the next depth.
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

lettersTree = Node 'F' 
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


-- tests
testTraverseBreadthFirst01 = traverseBreadthFirst lettersTree  -- "FBGADICEHJK"

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
