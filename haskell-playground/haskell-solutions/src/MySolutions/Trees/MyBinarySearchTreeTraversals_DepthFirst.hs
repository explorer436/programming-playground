module MySolutions.Trees.MyBinarySearchTreeTraversals_DepthFirst where
    
import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.MyBinarySearchTree_Insert (treeInsert, listToTreeFromLeft)

traverseInOrder :: Tree a -> [a]
traverseInOrder EmptyTree = []
traverseInOrder (Node a l r) = traverseInOrder l ++ [a] ++ traverseInOrder r
--tests
testInOrder01 = traverseInOrder (listToTreeFromLeft [15,17,20,22,25,26,27,29,30,32])

traversePreOrder :: Tree a -> [a]
traversePreOrder EmptyTree = []
traversePreOrder (Node a l r) = a : traversePreOrder l ++ traversePreOrder r
--tests
testPreOrder01 = traversePreOrder (listToTreeFromLeft [25,20,15,17,22,27,26,30,29,32])

traversePostOrder :: Tree a -> [a]
traversePostOrder EmptyTree = []
traversePostOrder (Node a l r) = traversePostOrder l ++ traversePostOrder r ++ [a]
--tests
testPostOrder01 = traversePostOrder (listToTreeFromLeft [17,15,22,20,26,29,32,30,27,25])

traverseReverseInOrder :: Tree a -> [a]
traverseReverseInOrder EmptyTree = []
traverseReverseInOrder (Node a l r) = traverseReverseInOrder r ++ [a] ++ traverseReverseInOrder l
--tests
testReverseInOrder01 = traverseReverseInOrder (listToTreeFromLeft [32,30,29,27,26,25,22,20,17,15])

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

