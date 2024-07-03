module MySolutions.Trees.ConvertBinaryTreeToFullBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.ConvertBinaryTreeToFullBinaryTree (convertBinaryTreeToFullBinaryTree)

spec :: Spec
spec = do

  describe "convertBinaryTreeToFullBinaryTree" $ do

    it "returns a tree that is converted into a full binary tree" $
      convertBinaryTreeToFullBinaryTree (Node 4
                                              (Node 6 EmptyTree EmptyTree)
                                              EmptyTree
                                        ) `shouldBe` (Node 6 EmptyTree EmptyTree)

    it "returns a tree that is converted into a full binary tree" $
      convertBinaryTreeToFullBinaryTree testTree01 `shouldBe` expectedResult

testTree01 :: Num a => Tree a
testTree01 = Node 0
                  (Node 1
                        (Node 3
                              EmptyTree
                              (Node 5 EmptyTree EmptyTree)
                        )
                        EmptyTree
                  )
                  (Node 2
                        EmptyTree
                        (Node 4
                              (Node 6 EmptyTree EmptyTree)
                              (Node 7 EmptyTree EmptyTree)
                        )
                  )

{- |
Input tree:
              0
           /     \
         1         2
       /            \
     3                 4
       \             /   \
         5          6     7
-}

{- |
Expectedresult:

             0
          /     \
        5         4
                /   \
               6     7
-}

expectedResult = Node 0
                      (Node 5 EmptyTree EmptyTree)
                      (Node 4
                            (Node 6 EmptyTree EmptyTree)
                            (Node 7 EmptyTree EmptyTree)
                      )
