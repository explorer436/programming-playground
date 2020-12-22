module Datastructures.Trees.AppendOneTreeToAnotherTreeSpec where

import Test.Hspec
import Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "appendTree2ToTheRightMostLeafOfTree1" $ do
    it "returns a tree that has tree2 appended to the right of tree1" $
      appendTree2ToTheRightMostLeafOfTree1 testTree01 testTree02 `shouldBe` expectedResult

expectedResult = (Node 1 EmptyTree (Node 2 EmptyTree (Node 5 (Node 7 EmptyTree EmptyTree) (Node 6 EmptyTree (Node 3 (Node 4 EmptyTree EmptyTree) EmptyTree)))))
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

testTree01 :: Num a => Tree a
testTree01 = (Node 1 
                  EmptyTree
                  (Node 2 
                        EmptyTree
                        (
                            Node 5
                                 (Node 7 EmptyTree EmptyTree)
                                 (Node 6 EmptyTree EmptyTree)
                        )
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

testTree02 :: Num a => Tree a
testTree02 = (Node 3 
                  (Node 4 EmptyTree EmptyTree)
                  EmptyTree
             )

{- |
          3
         /  
        4    
-}      
