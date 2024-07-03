module MySolutions.Trees.BinaryTreeSumsByEachLevelSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.BinaryTreeSumsByEachLevel (listWithSumsForEachLevel)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "listWithSumsForEachLevel" $ do

    it "returns [1,9,8] for the input tree" $
      listWithSumsForEachLevel
            (Node 1
               (Node 4
                   (Node 3 EmptyTree EmptyTree)
                   (Node 2 EmptyTree EmptyTree))
               (Node 5
                   (Node 4 EmptyTree EmptyTree)
                   (Node (-1) EmptyTree EmptyTree))) `shouldBe` [1,9,8]
