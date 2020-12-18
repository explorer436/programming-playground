module AppendOneTreeToAnotherTree where

import MyBinaryTree

appendTree2ToTheRightMostLeafOfTree1 :: Tree a -> Tree a -> Tree a 
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left EmptyTree) EmptyTree = tree1
appendTree2ToTheRightMostLeafOfTree1 EmptyTree tree2 = tree2
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left EmptyTree) tree2 = Node a left tree2
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left right) tree2 = Node a left (appendTree2ToTheRightMostLeafOfTree1 right tree2)

test = appendTree2ToTheRightMostLeafOfTree1 testTree01 testTree02
{- |
      1
       \
        2
         \
          5
         / \
        7   6
             \
              3
             /  
            4
-}

testTree01 = Node 1 
                     EmptyTree
                     (Node 2 
                          EmptyTree
                          (
                              Node 5
                                  (Node 7 EmptyTree EmptyTree)
                                  (Node 6 EmptyTree EmptyTree)
                          )
                     )
{- |
      1
       \
        2
         \
          5
         / \
        7   6
-}

testTree02 = Node 3 
                  (Node 4 EmptyTree EmptyTree)
                  EmptyTree

{- |
          3
         /  
        4    
-}
