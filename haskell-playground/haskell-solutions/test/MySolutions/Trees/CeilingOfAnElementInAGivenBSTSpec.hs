module MySolutions.Trees.CeilingOfAnElementInAGivenBSTSpec where

import Test.Hspec
import MySolutions.Trees.CeilingOfAnElementInAGivenBST
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "ceilingOfAnElement" $ do

    it "returns Nothing when the tree is EmptyTree" $
      ceilingOfAnElement 1 EmptyTree `shouldBe` Nothing

    it "returns root value when the tree is singleton and the input is lesser than the root" $
      ceilingOfAnElement 1 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2

    it "returns root value when the tree is singleton and the input is greater than the root" $
      ceilingOfAnElement 3 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2

    it "returns root value when the tree is singleton and the input is equal to the root" $
      ceilingOfAnElement 2 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2

    it "returns leftNodeValue when the input is equal to the left node value" $
      ceilingOfAnElement 1 (Node 2 
                                 (Node 1 EmptyTree EmptyTree) 
                                 EmptyTree
                           ) `shouldBe` Just 1
                                    {- |
                                         2
                                        /
                         input=1       1     
                                    -}

    it "returns rightNodeValue when the input is equal to the right node value" $
      ceilingOfAnElement 2 (Node 1 
                                 EmptyTree
                                 (Node 2 EmptyTree EmptyTree) 
                           ) `shouldBe` Just 2
                                    {- |
                                         1
                                          \
                                           2   input=2 
                                    -}

    it "returns root value when the input is lesser than the root and the left tree is EmptyTree" $
      ceilingOfAnElement 1 (Node 2 
                                 EmptyTree
                                 (Node 3 EmptyTree EmptyTree) 
                           ) `shouldBe` Just 2
                                    {- |
                                         2
                                input=1   \    
                                           3     
                                    -}

    it "returns root value when the input is greater than the root and the right tree is EmptyTree" $
      ceilingOfAnElement 3 (Node 2 
                                 (Node 1 EmptyTree EmptyTree)
                                 EmptyTree
                           ) `shouldBe` Just 2
                                    {- |
                                         2
                                        /   input=3 
                                       1     
                                    -}

    it "returns root value when the input is lesser than the root and greater than the left node value and the left node's right subtree is EmptyTree" $
      ceilingOfAnElement 6 (Node 8 
                                 (Node 4 EmptyTree EmptyTree)
                                 (Node 12 EmptyTree EmptyTree)
                           ) `shouldBe` Just 8
                                    {- |
                                         8
                                 input=6/ \
                                       4   12
                                    -}

    it "returns root value when the input is greater than the root and lesser than the left node value and the right node's left subtree is EmptyTree" $
      ceilingOfAnElement 11 (Node 8 
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node 12 EmptyTree EmptyTree)
                            ) `shouldBe` Just 8
                                    {- |
                                         8
                                        / \input=11
                                       4   12
                                    -}

    it "returns left node value when the input is lesser than the left node value and the left node's left subtree is EmptyTree" $
      ceilingOfAnElement 2 (Node 8 
                                 (Node 4 EmptyTree EmptyTree)
                                 (Node 12 EmptyTree EmptyTree)
                           ) `shouldBe` Just 4
                                    {- |
                                         8
                                        / \
                                       4   12
                                    input=2 
                                    -}

    it "returns right node value when the input is greater than the right node value and the right node's right subtree is EmptyTree" $
      ceilingOfAnElement 13 (Node 8 
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node 12 EmptyTree EmptyTree)
                            ) `shouldBe` Just 12
                                    {- |
                                         8
                                        / \
                                       4   12
                                          input=13
                                    -}

    it "customTreeTests01" $
      ceilingOfAnElement 1 testTree `shouldBe` Just 2

    it "customTreeTests03" $
      ceilingOfAnElement 3 testTree `shouldBe` Just 4

    it "customTreeTests04" $
      ceilingOfAnElement 4 testTree `shouldBe` Just 4

    it "customTreeTests05" $
      ceilingOfAnElement 5 testTree `shouldBe` Just 4

    it "customTreeTests06" $
      ceilingOfAnElement 6 testTree `shouldBe` Just 6

    it "customTreeTests07" $
      ceilingOfAnElement 7 testTree `shouldBe` Just 6

    it "customTreeTests09" $
      ceilingOfAnElement 9 testTree `shouldBe` Just 10

    it "customTreeTests12" $
      ceilingOfAnElement 12 testTree `shouldBe` Just 12

    it "customTreeTests14" $
      ceilingOfAnElement 14 testTree `shouldBe` Just 14

    it "customTreeTests15" $
      ceilingOfAnElement 15 testTree `shouldBe` Just 14

{- |
         8
        / \
       4   12
      / \ /  \
     2  6 10  14
-}

testTree = Node 8
                (Node 4
                      (Node 2 EmptyTree EmptyTree)
                      (Node 6 EmptyTree EmptyTree)
                )
                (Node 12
                      (Node 10 EmptyTree EmptyTree)
                      (Node 14 EmptyTree EmptyTree)
                )
