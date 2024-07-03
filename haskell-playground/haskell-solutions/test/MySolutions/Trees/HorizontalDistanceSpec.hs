module MySolutions.Trees.HorizontalDistanceSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.HorizontalDistance (horizontalDistance)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "horizontalDistance" $ do

    it "returns three when there are three nodes in the tree" $
      horizontalDistance (Node 5
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
                  ) `shouldBe` [(5,0),(3,-1),(1,-2),(0,-3),(4,0),(7,1),(6,0),(9,2),(8,1)]
