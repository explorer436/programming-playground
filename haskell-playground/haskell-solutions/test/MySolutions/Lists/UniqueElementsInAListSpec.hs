module MySolutions.Lists.UniqueElementsInAListSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Lists.UniqueElementsInAList (removeElementsWithMultipleFrequency)

spec :: Spec
spec = do

  describe "removeElementsWithMultipleFrequency" $ do

    it "returns a list with the duplicates removed" $
      removeElementsWithMultipleFrequency [1,2,3,4,5,1,2] `shouldBe` [3,4,5]

    it "returns a list with the duplicates removed" $
      removeElementsWithMultipleFrequency ['a','b','c','a'] `shouldBe` ['b','c']

