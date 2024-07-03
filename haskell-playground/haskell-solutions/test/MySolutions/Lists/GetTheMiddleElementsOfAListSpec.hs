module MySolutions.Lists.GetTheMiddleElementsOfAListSpec where

import MySolutions.Lists.GetTheMiddleElementsOfAList (getMiddleElementsOfAList)

import Test.Hspec ( describe, it, shouldBe, Spec )

spec :: Spec
spec = do
  describe "getMiddleElementsOfAList" $ do

    it "returns the middle characters of the input string" $
      getMiddleElementsOfAList "hello" `shouldBe` "l"

    it "returns the middle characters of the input string" $
      getMiddleElementsOfAList "hell" `shouldBe` "el"

    it "returns the middle characters of the input string" $
      getMiddleElementsOfAList [1,2,3,4,5] `shouldBe` [3]

    it "returns the middle characters of the input string" $
      getMiddleElementsOfAList [1,2,3,4] `shouldBe` [2,3]
