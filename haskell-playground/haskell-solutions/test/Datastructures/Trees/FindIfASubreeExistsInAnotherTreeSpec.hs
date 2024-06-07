module Datastructures.Trees.FindIfASubreeExistsInAnotherTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.FindIfASubreeExistsInAnotherTree (doesSubtreeExistInParentTree)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "doesSubtreeExistInParentTree" $ do

    it "returns True for the two input trees" $
      doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 2 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 EmptyTree EmptyTree) 
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree)) `shouldBe` True

    it "returns False for the two input trees" $
      doesSubtreeExistInParentTree 
            (Node 1 
               (Node 6 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 2 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 EmptyTree EmptyTree) 
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree)) `shouldBe` False

    it "returns True for the two input trees" $
      doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 1 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 
                        (Node 3 EmptyTree EmptyTree)
                        (Node 2 EmptyTree EmptyTree))
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree)) `shouldBe` True

    it "returns False for the two input trees" $
      doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 1 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 
                        (Node 3 EmptyTree EmptyTree)
                        (Node 2 EmptyTree EmptyTree))
                   (Node (-1) EmptyTree EmptyTree)))
            EmptyTree `shouldBe` False

    it "returns False for the two input trees" $
      doesSubtreeExistInParentTree EmptyTree 
      (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree)) `shouldBe` False
