module Datastructures.Trees.DepthOfAPeculiarlyRepresentedTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.DepthOfAPeculiarlyRepresentedTree (depthOfAPeculiarlyRepresentedTree)

spec :: Spec
spec = do

  describe "depthOfAPeculiarlyRepresentedTree" $ do

    it "returns 4 for a tree with depth 3" $
      depthOfAPeculiarlyRepresentedTree "(00)" "((((00)0)0)0)" "0" `shouldBe` 3  

{- |

    it "returns -1 for an EmptyTree" $
      depthOfAPeculiarlyRepresentedTree "(00)" "" "0" `shouldBe` -1

    it "returns 0 for a root node with no children" $
      depthOfAPeculiarlyRepresentedTree "(00)" "(00)" "0" `shouldBe` 0

    it "returns 1 for a tree with depth 1" $
      depthOfAPeculiarlyRepresentedTree "(00)" "((00)(00))" "0" `shouldBe` 1

    it "returns 4 for a tree with depth 3" $
      depthOfAPeculiarlyRepresentedTree "(00)" "((((00)0)0)0)" "0" `shouldBe` 3  
-}

-- stack test --test-arguments "--match=depthOfAPeculiarlyRepresentedTree"
-- stack test --profile my-tests

-- stack test --test-arguments "--match=depthOfAPeculiarlyRepresentedTree"
