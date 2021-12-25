module Datastructures.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversalsSpec where

import Test.Hspec
import Datastructures.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversals (reconstruct, leftHalfInOrder, leftHalfPreOrder, rightHalfInOrder, rightHalfPreOrder)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "leftHalfInOrder" $ do

    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      leftHalfInOrder "DBEAFCG" "ABDECFG" `shouldBe` "DBE"  

  describe "leftHalfPreOrder" $ do

    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      leftHalfPreOrder "DBEAFCG" "ABDECFG" `shouldBe` "BDE"  

  describe "rightHalfInOrder" $ do

    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      rightHalfInOrder "DBEAFCG" "ABDECFG" `shouldBe` "FCG"  

  describe "rightHalfPreOrder" $ do

    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      rightHalfPreOrder "DBEAFCG" "ABDECFG" `shouldBe` "CFG"  


  describe "reconstruct" $ do

    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      reconstruct "ABCDEFGHIJK" "FBADCEGIHJK" `shouldBe` Node 'F' 
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
{- |
                    f
                   / \
                  b   g
                 / \   \
                a  d    i
                  / \  / \
                 c  e h   j
                           \
                            k
-}

    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      reconstruct "DBEAFCG" "ABDECFG" `shouldBe` Node 'A' 
                                                      (Node 'B' 
                                                            (Node 'D' EmptyTree EmptyTree)
                                                            (Node 'E' EmptyTree EmptyTree) 
                                                      )
                                                      (Node 'C' 
                                                            (Node 'F' EmptyTree EmptyTree) 
                                                            (Node 'G' EmptyTree EmptyTree)
                                                      )

{- |
        a
       / \
      b   c
     / \ / \
    d  e f  g
-}
