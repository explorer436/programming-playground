module Datastructures.Lists.RemoveDuplicatesFromListSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Lists.RemoveDuplicatesFromList (removeDuplicateFromListLeftFold, removeDuplicateFromListRightFold)

spec :: Spec
spec = do
  describe "removeDuplicateFromListLeftFold" $ do

    it "returns the list after removing all the duplicate entries from it" $
      removeDuplicateFromListLeftFold [1, 2, 3, 3, 2, 4] `shouldBe` [4,3,2,1] -- notice the order of the elements in the result. This is because, left fold is used in the function

  describe "removeDuplicateFromListRightFold" $ do

    it "returns the list after removing all the duplicate entries from it" $
      removeDuplicateFromListRightFold [1, 2, 3, 3, 2, 4] `shouldBe` [1,3,2,4] -- notice the order of the elements in the result. This is because, right fold is used in the function   
