module Datastructures.Trees.UnivalSubtreesSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.UnivalSubtrees (isUnival, countUnivalSubtrees)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "isUnival" $ do
    it "returns the expected results" $
      isUnival (Node 3 EmptyTree EmptyTree) `shouldBe` True
    it "returns the expected results" $
      isUnival (Node 1
                                (Node 4
                                      (Node 3 EmptyTree EmptyTree)
                                      (Node 2 EmptyTree EmptyTree))
                                (Node 5
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node (-1) EmptyTree EmptyTree)
                                )
               ) `shouldBe` False
    it "returns the expected results" $
      isUnival (Node 4
                                (Node 4
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node 4 EmptyTree EmptyTree))
                                (Node 4
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node 4 EmptyTree EmptyTree))) `shouldBe` True
    it "returns the expected results" $
      isUnival (Node 1
                                (Node 1 EmptyTree EmptyTree)
                                EmptyTree
                          ) `shouldBe` True                                

      
-- testIsUnival01 = isUnival EmptyTree -- False. This seems to be working when tested from the ghci interpreter.

  describe "countUnivalSubtrees" $ do
    it "returns the expected results" $
      countUnivalSubtrees (Node 4 EmptyTree EmptyTree) `shouldBe` 1
    it "returns the expected results" $
      countUnivalSubtrees (Node 4
                                                       (Node 4
                                                             (Node 4 EmptyTree EmptyTree)
                                                             (Node 4 EmptyTree EmptyTree))
                                                       (Node 4
                                                             (Node 4 EmptyTree EmptyTree)
                                                             (Node 4 EmptyTree EmptyTree))) `shouldBe` 7
    it "returns the expected results" $
      countUnivalSubtrees (Node 1
                                                       (Node 4
                                                             (Node 3 EmptyTree EmptyTree)
                                                             (Node 2 EmptyTree EmptyTree))
                                                       (Node 5
                                                             (Node 4 EmptyTree EmptyTree)
                                                             (Node (-1) EmptyTree EmptyTree))) `shouldBe` 4
    it "returns the expected results" $
      countUnivalSubtrees (Node 0
                                                        (Node 1 EmptyTree EmptyTree)
                                                        (Node 0
                                                              (Node 1 
                                                                    (Node 1 EmptyTree EmptyTree)
                                                                    (Node 1 EmptyTree EmptyTree) 
                                                              )
                                                              (Node 0 EmptyTree EmptyTree)
                                                        )
                                                ) `shouldBe` 5
      

