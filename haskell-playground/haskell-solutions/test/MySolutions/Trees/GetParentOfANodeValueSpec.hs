module MySolutions.Trees.GetParentOfANodeValueSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.GetParentOfANodeValue (getParent)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "getParent" $ do

    it "returns the parent node of a given node in the tree" $
      getParent testTree01 5 `shouldBe` 2

testTree01 = Node 1
                  EmptyTree
                  (Node 2
                        EmptyTree
                        (
                            Node 5
                                 (Node 7 EmptyTree EmptyTree)
                                 (Node 6 EmptyTree EmptyTree)
                        )
                  )

{- |
      1
       \
        2
         \
          5
         / \
        7   6
-}
