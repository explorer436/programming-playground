module Datastructures.Trees.InvertABinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.InvertABinaryTree (invertTree)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "invertTree" $ do
    it "returns expected output for the input tree" $
      invertTree (Node 'a'
                            (Node 'b'
                                  (Node 'd' EmptyTree EmptyTree)
                                  (Node 'e' EmptyTree EmptyTree))
                            (Node 'c'
                                  (Node 'f' EmptyTree EmptyTree)
                                  EmptyTree)) `shouldBe` Node 'a' (Node 'c' EmptyTree (Node 'f' EmptyTree EmptyTree)) (Node 'b' (Node 'e' EmptyTree EmptyTree) (Node 'd' EmptyTree EmptyTree))
    
