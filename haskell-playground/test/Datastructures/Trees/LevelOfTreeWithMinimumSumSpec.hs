module Datastructures.Trees.LevelOfTreeWithMinimumSumSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.LevelOfTreeWithMinimumSum (tupleWithMinimumSum, levelWithMinimumSum, minimumSum)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "levelWithMaximumSum" $ do

    it "returns 2 when the input is testTree01" $
      levelWithMinimumSum testTree01 `shouldBe` 2

    it "returns 1 when the input is testTree02" $
      levelWithMinimumSum testTree02 `shouldBe` 1

  describe "levelWithMaximumSum" $ do

    it "returns 7 when the input is testTree01" $
      minimumSum testTree01 `shouldBe` 7

    it "returns 7 when the input is testTree01" $
      minimumSum testTree02 `shouldBe` 7

-- describe "levelWithMaximumSum" $ do
--  it "returns (7,2) when the input is testTree01" $
--    fromJust $ findFirstMinimumElementInTheListAndIndex (zip (listWithSumsForEachLevel testTree01)[0..])  `shouldBe` (7,2)
--  it "returns (7,1) when the input is testTree02" $
--    fromJust $ findFirstMinimumElementInTheListAndIndex (zip (listWithSumsForEachLevel testTree02)[0..])  `shouldBe` (7,1)


testTree01 = Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   EmptyTree
                   (Node 2 EmptyTree EmptyTree))

testTree02 = Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 5
                   EmptyTree
                   (Node 2 EmptyTree EmptyTree))
