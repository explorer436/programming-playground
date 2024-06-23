module Datastructures.Trees.FindCousinsInItsLevelSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.FindCousinsInItsLevel (cousinsInLevel)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  
  describe "cousinsInLevel" $ do

    it "returns the cousins of the input node in level order" $
      cousinsInLevel 5 (Node 1 
                                        (Node 2 
                                              (Node 4 EmptyTree EmptyTree)
                                              (Node 6 EmptyTree EmptyTree)
                                        )      
                                        (Node 3 
                                              EmptyTree
                                              (Node 5 EmptyTree EmptyTree)
                                        )      
                                  ) `shouldBe` [4,6]


    it "returns the cousins of the input node in level order" $
            cousinsInLevel 1 (Node 1 
                                          (Node 2 
                                                (Node 4 EmptyTree EmptyTree)
                                                (Node 6 EmptyTree EmptyTree)
                                          )      
                                          (Node 3 
                                                EmptyTree
                                                (Node 5 EmptyTree EmptyTree)
                                          )      
                                    ) `shouldBe` []

{- |
          1
         / \
        2   3
       / \   \
      4   6   5
-}                                    