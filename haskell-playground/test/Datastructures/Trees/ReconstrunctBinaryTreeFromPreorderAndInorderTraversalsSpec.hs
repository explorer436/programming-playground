module Datastructures.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversalsSpec where

import Test.Hspec
import Datastructures.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversals (reconstruct)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "reconstruct" $ do
    it "returns the correct tree structure when inorder and preorder lists are provided as input" $
      reconstruct "ABCDEFGHIJK" "FBADCEGIHJK" `shouldBe` Node 'F' 
         (Node 'B' 
               (Node 'A' EmptyTree EmptyTree) 
               (Node 'D' 
                     (Node 'C' EmptyTree EmptyTree) 
                     (Node 'E' EmptyTree EmptyTree))) 
         (Node 'G' 
               EmptyTree 
               (Node 'I' 
                     (Node 'H' EmptyTree EmptyTree) 
                     (Node 'J' 
                           EmptyTree 
                           (Node 'K' EmptyTree EmptyTree)))
         )
