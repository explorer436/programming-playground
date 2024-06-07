module Datastructures.Trees.FloorOfAnElementInAGivenBSTSpec where

import Test.Hspec
import Datastructures.Trees.FloorOfAnElementInAGivenBST
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "floorOfAnElement" $ do

    it "returns Nothing when the tree is EmptyTree" $
      floorOfAnElement 1 EmptyTree `shouldBe` Nothing

    it "returns root value when the tree is singleton and the input is lesser than the root" $
      floorOfAnElement 1 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2

    it "returns root value when the tree is singleton and the input is greater than the root" $
      floorOfAnElement 3 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2

    it "returns root value when the tree is singleton and the input is equal to the root" $
      floorOfAnElement 2 (Node 2 EmptyTree EmptyTree) `shouldBe` Just 2

    it "returns leftNodeValue when the input is equal to the left node value" $
      floorOfAnElement 1 (Node 2 
                                 (Node 1 EmptyTree EmptyTree) 
                                 EmptyTree
                           ) `shouldBe` Just 1

{- |
     2
    /
   1      input=1
-}

    it "returns rightNodeValue when the input is equal to the right node value" $
      floorOfAnElement 2 (Node 1 
                                 EmptyTree
                                 (Node 2 EmptyTree EmptyTree) 
                           ) `shouldBe` Just 2
                                    {- |
                                         1
                                          \
                                           2   input=2 
                                    -}

    it "returns Nothing when the input is lesser than the root and the left tree is EmptyTree" $
      floorOfAnElement 1 (Node 2 
                                 EmptyTree
                                 (Node 3 EmptyTree EmptyTree) 
                           ) `shouldBe` Nothing
                                    {- |
                                         2
                                input=1   \    
                                           3     
                                    -}

    it "returns Nothing when the input is greater than the root and the right tree is EmptyTree" $
      floorOfAnElement 3 (Node 2 
                                 (Node 1 EmptyTree EmptyTree)
                                 EmptyTree
                           ) `shouldBe` Nothing
                                    {- |
                                         2
                                        /   input=3 
                                       1     
                                    -}

    it "returns left node value when the input is lesser than the root and greater than the left node value and the left node's right subtree is EmptyTree" $
      floorOfAnElement 6 (Node 8 
                                 (Node 4 EmptyTree EmptyTree)
                                 (Node 12 EmptyTree EmptyTree)
                           ) `shouldBe` Just 4
                                    {- |
                                         8
                                 input=6/ \
                                       4   12
                                    -}

    it "returns right node value when the input is greater than the root and lesser than the right node value and the right node's left subtree is EmptyTree" $
      floorOfAnElement 11 (Node 8 
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node 12 EmptyTree EmptyTree)
                            ) `shouldBe` Just 12
                                    {- |
                                         8
                                        / \input=11
                                       4   12
                                    -}

    it "returns Nothing value when the input is lesser than the left node value and the left node's left subtree is EmptyTree" $
      floorOfAnElement 2 (Node 8 
                                 (Node 4 EmptyTree EmptyTree)
                                 (Node 12 EmptyTree EmptyTree)
                           ) `shouldBe` Nothing
                                    {- |
                                         8
                                        / \
                                       4   12
                                    input=2 
                                    -}

    it "returns Nothing value when the input is greater than the right node value and the right node's right subtree is EmptyTree" $
      floorOfAnElement 13 (Node 8 
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node 12 EmptyTree EmptyTree)
                            ) `shouldBe` Nothing
                                    {- |
                                         8
                                        / \
                                       4   12
                                          input=13
                                    -}

    it "customTreeTests01" $
      floorOfAnElement 1 testTree `shouldBe` Nothing

    it "customTreeTests03" $
      floorOfAnElement 3 testTree `shouldBe` Just 2

    it "customTreeTests04" $
      floorOfAnElement 4 testTree `shouldBe` Just 4

    it "customTreeTests05" $
      floorOfAnElement 5 testTree `shouldBe` Just 6

    it "customTreeTests06" $
      floorOfAnElement 6 testTree `shouldBe` Just 6

    it "customTreeTests07" $
      floorOfAnElement 7 testTree `shouldBe` Nothing

    it "customTreeTests09" $
      floorOfAnElement 9 testTree `shouldBe` Nothing

    it "customTreeTests12" $
      floorOfAnElement 12 testTree `shouldBe` Just 12

    it "customTreeTests14" $
      floorOfAnElement 14 testTree `shouldBe` Just 14

    it "customTreeTests15" $
      floorOfAnElement 15 testTree `shouldBe` Nothing

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
