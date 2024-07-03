module MySolutions.Trees.AppendOneTreeToAnotherTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "appendTree2ToTheRightMostLeafOfTree1" $ do

    it "returns a tree that has tree2 appended to the right of tree1" $
      appendTree2ToTheRightMostLeafOfTree1 testTree01 testTree02 `shouldBe` expectedResult

    it "returns the first tree when EmptyTree is appended to it" $
      appendTree2ToTheRightMostLeafOfTree1 testTree01 EmptyTree `shouldBe` testTree01

    it "returns the second tree when it is appended to an EmptyTree" $
      appendTree2ToTheRightMostLeafOfTree1 EmptyTree testTree02 `shouldBe` testTree02

    {- |
    TODO FIXME - why is this not working?
    it "returns an EmptyTree when an EmptyTree is appended to another EmptyTree" $
      appendTree2ToTheRightMostLeafOfTree1 EmptyTree EmptyTree `shouldBe` EmptyTree
    -}

expectedResult = Node 1 EmptyTree (Node 2 EmptyTree (Node 5 (Node 7 EmptyTree EmptyTree) (Node 6 EmptyTree (Node 3 (Node 4 EmptyTree EmptyTree) EmptyTree))))
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

testTree02 :: Num a => Tree a
testTree02 = Node 3
                  (Node 4 EmptyTree EmptyTree)
                  EmptyTree

{- |
          3
         /  
        4    
-}
