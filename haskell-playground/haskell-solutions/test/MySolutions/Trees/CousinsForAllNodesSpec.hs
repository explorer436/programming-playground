module MySolutions.Trees.CousinsForAllNodesSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.CousinsForAllNodes (cousinsForAllNodes)

spec :: Spec
spec = do
  
  describe "cousinsForAllNodes" $ do

    it "returns the cousins of the input node in level order" $
      cousinsForAllNodes testTree `shouldBe` [(1,[]),(2,[3]),(4,[6,5]),(6,[4,5]),(3,[2]),(5,[4,6])]

{- |
          1
         / \
        2   3
       / \   \
      4   6   5
-}

testTree = (Node 1 
                                        (Node 2 
                                              (Node 4 EmptyTree EmptyTree)
                                              (Node 6 EmptyTree EmptyTree)
                                        )      
                                        (Node 3 
                                              EmptyTree
                                              (Node 5 EmptyTree EmptyTree)
                                        )      
                                  )