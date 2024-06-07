module Datastructures.Trees.FullBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.FullBinaryTree (isTreeAFullBinaryTree)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "fullBinaryTree" $ do

    it "returns True when the inputTree is a full binary tree" $
      isTreeAFullBinaryTree (Node 1
                            (Node 2
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node 5 EmptyTree EmptyTree)
                            )
                            (Node 3 
                                  EmptyTree
                                  EmptyTree
                            )
                      ) `shouldBe` True


    it "returns False when the inputTree is not a full binary tree" $
      isTreeAFullBinaryTree (Node 1
                            (Node 2
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node 5 EmptyTree EmptyTree)
                            )
                            (Node 3 
                                  (Node 5 EmptyTree EmptyTree)
                                  EmptyTree
                            )
                      ) `shouldBe` False
