module Datastructures.Trees.PrintNodesInBoustrophedonOrderSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.PrintNodesInBoustrophedonOrder (printNodesInBoustrophedonOrder)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "printNodesInBoustrophedonOrder" $ do

    it "prints the nodes of a given tree in Boustrophedon order" $
      printNodesInBoustrophedonOrder testTree01 `shouldBe` expectedResult


expectedResult = [1, 3, 2, 4, 5, 6, 7]

testTree01 :: Num a => Tree a
testTree01 = Node 1
                  (Node 2
                        (Node 4 EmptyTree EmptyTree)
                        (Node 5 EmptyTree EmptyTree)
                  )
                  (Node 3
                        (Node 6 EmptyTree EmptyTree)
                        (Node 7 EmptyTree EmptyTree)
                  )
{- |
testTree
  
       1
    /     \
  2         3
 / \       / \
4   5     6   7
-}
