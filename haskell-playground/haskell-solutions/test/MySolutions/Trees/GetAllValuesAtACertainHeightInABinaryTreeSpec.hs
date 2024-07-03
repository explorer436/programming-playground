module MySolutions.Trees.GetAllValuesAtACertainHeightInABinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, shouldThrow, Spec )
import MySolutions.Trees.GetAllValuesAtACertainHeightInABinaryTree (elementsAtLevelN)
import MySolutions.Trees.MyBinaryTree (Tree (..))
import Control.Exception (evaluate,ErrorCall (ErrorCall), Exception)

spec :: Spec
spec = do

  describe "elementsAtLevelN" $ do

    it "returns [1] for the inputs 0 and the test tree" $
      elementsAtLevelN 0 testTree `shouldBe` [1]

    it "returns [2,3] for the inputs 1 and the test tree" $
      elementsAtLevelN 1 testTree `shouldBe` [2,3]

    it "returns [4,5,7] for the inputs 2 and the test tree" $
      elementsAtLevelN 2 testTree `shouldBe` [4,5,7]

--  it "throws an exception for the inputs 3 and the test tree" $
--    evaluate (elementsAtLevelN 3 testTree) `shouldThrow` ThisException
-- *** Exception: Prelude.!!: index too large
-- The last case can be handled by changing the signature to use Maybe.


testTree :: Tree Integer
testTree = Node 1
                 (Node 2
                       (Node 4 EmptyTree EmptyTree)
                       (Node 5 EmptyTree EmptyTree))
                 (Node 3
                       EmptyTree
                       (Node 7 EmptyTree EmptyTree))

{- |
          1
         / \
        2   3
       / \   \
      4   5   7
-}
