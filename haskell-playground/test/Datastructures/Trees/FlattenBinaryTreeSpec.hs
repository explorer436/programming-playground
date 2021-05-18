module Datastructures.Trees.FlattenBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.FlattenBinaryTree (flatten)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "flatten" $ do

    it "returns expected output for the input tree" $
      flatten (Node 1
                       (Node 2 
                             (Node 5 EmptyTree EmptyTree) 
                             EmptyTree
                       )
                       (Node 3 
                             (Node 4 EmptyTree EmptyTree) 
                             EmptyTree
                       )
                 ) `shouldBe` Node 1 EmptyTree (Node 2 EmptyTree (Node 5 EmptyTree (Node 3 EmptyTree (Node 4 EmptyTree EmptyTree))))

    it "returns expected output for the input tree" $
      flatten (
                     Node 1 
                          (Node 2 
                                (Node 3 EmptyTree EmptyTree)
                                (Node 4 EmptyTree EmptyTree)
                          )
                          EmptyTree
                 ) `shouldBe` Node 1 EmptyTree (Node 2 EmptyTree (Node 3 EmptyTree (Node 4 EmptyTree EmptyTree)))
    
