module MySolutions.Trees.HeightBalancedBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.HeightBalancedBinaryTree (isTreeHeightBalanced)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "isTreeHeightBalanced" $ do

    it "returns True when the input is EmptyTree" $
      isTreeHeightBalanced EmptyTree `shouldBe` True

    it "returns True when the input is a tree with just a root node" $
      isTreeHeightBalanced (Node 3 EmptyTree EmptyTree) `shouldBe` True

    it "returns True when the height of left tree is 0 and height of right tree is -1" $
      isTreeHeightBalanced (Node 3 (Node 4 EmptyTree EmptyTree) EmptyTree) `shouldBe` True

    it "returns True when the height of left tree is -1 and height of right tree is 0" $
      isTreeHeightBalanced (Node 3 EmptyTree  (Node 5 EmptyTree EmptyTree)) `shouldBe` True

    it "returns True when the height of left tree is 0 and height of right tree is 0" $
      isTreeHeightBalanced (Node 3 (Node 4 EmptyTree EmptyTree)  (Node 5 EmptyTree EmptyTree)) `shouldBe` True

    it "returns True when the height of left tree is 1 and height of right tree is 0" $
      isTreeHeightBalanced (Node 3 (Node 4 (Node 2 EmptyTree EmptyTree) EmptyTree)  (Node 5 EmptyTree EmptyTree)) `shouldBe` True

    it "returns False when the height of left tree is 2 and height of right tree is 0" $
      isTreeHeightBalanced (Node 3 (Node 4 (Node 2 (Node 1 EmptyTree EmptyTree) EmptyTree) EmptyTree)  (Node 5 EmptyTree EmptyTree)) `shouldBe` False

