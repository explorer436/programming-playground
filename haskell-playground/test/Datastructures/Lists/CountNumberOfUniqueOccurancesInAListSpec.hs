module Datastructures.Lists.CountNumberOfUniqueOccurancesInAListSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Lists.CountNumberOfOccurancesInAList (countOccurancesInAnArrayUsingListComprehension, countOccurancesInAnArrayUsingRecursion)

spec :: Spec
spec = do

  describe "countOccurancesInAnArrayUsingListComprehension" $ do

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingListComprehension [1,2,3,1] 2 `shouldBe` 1

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingListComprehension [1,2,3,1] 5 `shouldBe` 0

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingListComprehension [1,2,3,1] 1 `shouldBe` 2

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingListComprehension "bruce" 'b' `shouldBe` 1


  describe "countOccurancesInAnArrayUsingRecursion" $ do

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingRecursion [1,2,3,1] 2 `shouldBe` 1

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingRecursion [1,2,3,1] 5 `shouldBe` 0

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingRecursion [1,2,3,1] 1 `shouldBe` 2

    it "returns the frequency of the input parameter in the input list" $
      countOccurancesInAnArrayUsingRecursion "bruce" 'b' `shouldBe` 1

