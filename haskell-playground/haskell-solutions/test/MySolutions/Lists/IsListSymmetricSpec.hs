module MySolutions.Lists.IsListSymmetricSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Lists.IsListSymmetric (isListSymmetric)

spec :: Spec
spec = do

  describe "isListSymmetric" $ do

    it "returns a boolean indicator indicating if the list is symmetric or not" $
      isListSymmetric [1,2,3,4,3,2,1] `shouldBe` True

    it "returns a boolean indicator indicating if the list is symmetric or not" $
      isListSymmetric [1,2,3,4,5,2,1] `shouldBe` False

    it "returns a boolean indicator indicating if the list is symmetric or not" $
      isListSymmetric [1,2,3,4,4,3,2,1] `shouldBe` True

    it "returns a boolean indicator indicating if the list is symmetric or not" $
      isListSymmetric "testing" `shouldBe` False

    it "returns a boolean indicator indicating if the list is symmetric or not" $
      isListSymmetric "deleveled" `shouldBe` True
