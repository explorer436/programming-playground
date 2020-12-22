module Datastructures.Trees.ValidateBinarySearchTreeSpec where

import Test.Hspec
import Datastructures.Trees.ValidateBinarySearchTree (validate)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "validate" $ do
    it "returns True when the input tree is a valid binary search tree" $
      validate (Node 5 
                        (Node 3
                              (Node 1 EmptyTree EmptyTree)
                              (Node 4 EmptyTree EmptyTree)
                        )
                        (Node 7
                              (Node 6 EmptyTree EmptyTree)
                              EmptyTree
                        )
                  ) `shouldBe` True
    it "returns False when the input tree is not a valid binary search tree" $
      validate (Node 5 
                        (Node 3
                              (Node 1 EmptyTree EmptyTree)
                              (Node 4 EmptyTree EmptyTree)
                        )
                        (Node 7
                              (Node 8 EmptyTree EmptyTree)
                              EmptyTree
                        )
                  ) `shouldBe` False

   
