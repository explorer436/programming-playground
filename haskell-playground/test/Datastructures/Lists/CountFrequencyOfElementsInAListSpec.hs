module Datastructures.Lists.CountFrequencyOfElementsInAListSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Lists.CountFrequencyOfElementsInAList (countFrequencyOfAnElementUsingListComprehension, countFrequencyOfAnElementUsingRecursion, countFrequencyOfAllElements)
import qualified Data.Map as Map
import Data.Maybe (fromJust)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "countFrequencyOfAnElementUsingListComprehension" $ do

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingListComprehension [1,2,3,1] 2 `shouldBe` 1

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingListComprehension [1,2,3,1] 5 `shouldBe` 0

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingListComprehension [1,2,3,1] 1 `shouldBe` 2

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingListComprehension "bruce" 'b' `shouldBe` 1


  describe "countFrequencyOfAnElementUsingRecursion" $ do

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingRecursion [1,2,3,1] 2 `shouldBe` 1

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingRecursion [1,2,3,1] 5 `shouldBe` 0

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingRecursion [1,2,3,1] 1 `shouldBe` 2

    it "returns the frequency of the input parameter in the input list" $
      countFrequencyOfAnElementUsingRecursion "bruce" 'b' `shouldBe` 1

  describe "countFrequencyOfAllElements" $ do

    it "returns the frequency of all the elements in the input list when the input list has integers" $
      countFrequencyOfAllElements [1,2,3,1] `shouldBe` [(1,2),(2,1),(3,1)]

    it "returns the frequency of all the elements in the input list when the input list has characters" $
      countFrequencyOfAllElements ['a','b','c','d','a'] `shouldBe` [('a',2),('b',1),('c',1),('d',1)]

    -- FIXME why is this not working?
    {- |
    it "returns the frequency of all the elements in the input list when the input is a list of trees" $
      countFrequencyOfAllElements [
                                  Node 1 (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree) (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree),
                                  Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree,
                                  Node 3 EmptyTree EmptyTree,
                                  Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree,
                                  Node 3 EmptyTree EmptyTree] `shouldBe` [(EmptyTree,2)]
    -}

    {- |
    it "returns the frequency of all the elements in the input list when the input list has trees" $
      countFrequencyOfAllElements [EmptyTree,(Node (5) EmptyTree EmptyTree)] `shouldBe` [(EmptyTree,2),((Node (5) EmptyTree EmptyTree),1)]
    -}
