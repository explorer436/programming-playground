module Datastructures.Trees.BottomViewSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.BottomView (bottomViewWithDistance, bottomViewWithoutDistance)
import Datastructures.Trees.MyBinaryTree (Tree (..))
import qualified Data.Map as Map

spec :: Spec
spec = do

  describe "bottomViewWithDistance" $ do

    it "returns three when there are three nodes in the tree" $
      bottomViewWithDistance (Node 5
                        (Node 3
                                  (Node 1
                                        (Node 0 EmptyTree EmptyTree )
                                        EmptyTree
                                  )
                                  (Node 4 EmptyTree EmptyTree )
                        )
                        (Node 7
                                  (Node 6 EmptyTree EmptyTree )
                                  (Node 9
                                        (Node 8 EmptyTree EmptyTree )
                                        EmptyTree
                                  )
                        )
                  ) `shouldBe` Map.fromList [(-3,0),(-2,1),(-1,3),(0,6),(1,8),(2,9)]

                 
  describe "bottomViewWithoutDistance" $ do

    it "returns three when there are three nodes in the tree" $
      bottomViewWithoutDistance (Node 5
                        (Node 3
                                  (Node 1
                                        (Node 0 EmptyTree EmptyTree )
                                        EmptyTree
                                  )
                                  (Node 4 EmptyTree EmptyTree )
                        )
                        (Node 7
                                  (Node 6 EmptyTree EmptyTree )
                                  (Node 9
                                        (Node 8 EmptyTree EmptyTree )
                                        EmptyTree
                                  )
                        )
                  ) `shouldBe` [0,1,3,6,8,9]

{- |

             5
          /     \
        3         7
      /  \      /   \
    1     4    6     9
   /                /
  0                8

-}