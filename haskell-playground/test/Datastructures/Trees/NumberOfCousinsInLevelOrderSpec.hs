module Datastructures.Trees.NumberOfCousinsInLevelOrderSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.NumberOfCousinsInLevelOrder (numberOfCousinsInLevelOrder)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  
  describe "numberOfCousinsInLevelOrder" $ do

    it "returns the cousins of the input node in level order" $
      numberOfCousinsInLevelOrder 5 (Node 1 
                                        (Node 2 
                                              (Node 4 EmptyTree EmptyTree)
                                              (Node 6 EmptyTree EmptyTree)
                                        )      
                                        (Node 3 
                                              EmptyTree
                                              (Node 5 EmptyTree EmptyTree)
                                        )      
                                  ) `shouldBe` [4,6]

{- |
          1
         / \
        2   3
       / \   \
      4   6   5
-}
