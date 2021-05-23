module Datastructures.Lists.CountFrequencyOfElementsInAListSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Lists.CountFrequencyOfElementsInAList (countFrequencyOfAnElementUsingListComprehension, countFrequencyOfAnElementUsingRecursion, countFrequencyOfAllElements)
import qualified Data.Map as Map
import Data.Maybe (fromJust)

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

    it "returns the frequency of all the elements in the input list" $
      countFrequencyOfAllElements [1,2,3,1] `shouldBe` [(1,2),(2,1),(3,1)]
