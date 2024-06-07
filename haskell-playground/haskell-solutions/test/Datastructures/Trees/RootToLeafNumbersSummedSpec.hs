module Datastructures.Trees.RootToLeafNumbersSummedSpec where

import Test.Hspec
import Datastructures.Trees.RootToLeafNumbersSummed (rootToLeavesNumbersSummed)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "rootToLeavesNumbersSummed" $ do

    it "returns the sum of all the numbers formed by combining the elements from the root to each of the leaf nodes" $
      rootToLeavesNumbersSummed (Node 1
                                         (Node 2
                                               (Node 4 EmptyTree EmptyTree)
                                               (Node 5 EmptyTree EmptyTree))
                                         (Node 3 EmptyTree EmptyTree)
                                   ) `shouldBe` 262

-- paths are [[1,2,4],[1,2,5],[1,3]] -> 124 + 125 + 13