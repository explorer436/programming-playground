module Datastructures.Trees.CartesianTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.BottomView (bottomViewWithDistance, bottomViewWithoutDistance)
import Datastructures.Trees.MyBinaryTree (Tree (..))
import qualified Data.Map as Map
import Datastructures.Trees.CartesianTree (listToCartesionTree)

spec :: Spec
spec = do

  describe "listToCartesionTree" $ do

    it "returns the expected results" $
      listToCartesionTree [3, 2, 6, 1, 9] `shouldBe` 
                          Node 1 
                          (Node 2
                                (Node 3 EmptyTree EmptyTree)
                                (Node 6 EmptyTree EmptyTree)
                          )
                          (Node 9
                                EmptyTree
                                EmptyTree
                          )

                 
{- |

      1
    /   \   
  2       9
 / \
3   6


-}