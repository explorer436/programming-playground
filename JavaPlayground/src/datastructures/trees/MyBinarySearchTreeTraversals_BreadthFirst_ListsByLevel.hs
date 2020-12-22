module MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel) where

import MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Data.Maybe (fromJust)

listsByEachLevel :: Eq a => Tree a -> [[a]]
listsByEachLevel tree = breadthLevelLists [tree]

breadthLevelLists :: Eq a => [Tree a] -> [[a]]
breadthLevelLists [] = []
breadthLevelLists [EmptyTree] = []
breadthLevelLists listOfTrees = rootNodeValues listOfTrees ++ breadthLevelLists (concat (map leftAndRightTrees listOfTrees))   

rootNodeValues :: Eq b => [Tree b] -> [[b]]
rootNodeValues listOfTrees = [map (fromJust . rootValue) listOfTrees]

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
testTraverseBreadthFirst01 = listsByEachLevel lettersTree  -- ["F","BG","ADI","CEHJ","K"]

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

testTraverseBreadthFirst02 = listsByEachLevel (Node 1
                                                    (Node 4
                                                          (Node 3 EmptyTree EmptyTree)
                                                          (Node 2 EmptyTree EmptyTree))
                                                    (Node 5
                                                          (Node 4 EmptyTree EmptyTree)
                                                          (Node (-1) EmptyTree EmptyTree))) -- [[1],[4,5],[3,2,4,-1]]

