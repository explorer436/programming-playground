module MySolutions.Trees.MyBinarySearchTree_MaximumAndMinimumElementsSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinarySearchTree_MaximumAndMinimumElements (treeMinimum, treeMaximum)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "treeMinimum" $ do

    it "returns the minimum element in the tree" $
      treeMinimum sampleTree `shouldBe` 15

    it "returns the minimum element in the tree" $
      treeMinimum (Node 8 EmptyTree EmptyTree) `shouldBe` 8

  describe "treeMaximum" $ do

    it "returns the maximum element in the tree" $
      treeMaximum sampleTree `shouldBe` 32


sampleTree :: Tree Integer
sampleTree = Node 25 
                  (Node 20 
                        (Node 15 
                              EmptyTree 
                              (Node 17 EmptyTree EmptyTree)) 
                        (Node 22 EmptyTree EmptyTree)
                  ) 
                  (Node 27 
                        (Node 26 EmptyTree EmptyTree) 
                        (Node 30 
                              (Node 29 EmptyTree EmptyTree) 
                              (Node 32 EmptyTree EmptyTree))
                  )

