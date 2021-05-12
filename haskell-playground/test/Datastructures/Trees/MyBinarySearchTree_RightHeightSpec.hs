module Datastructures.Trees.MyBinarySearchTree_RightHeightSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinaryTree (Tree (..), treeRightHeight)

spec :: Spec
spec = do
  describe "treeRightHeight" $ do

    it "returns expected results" $
      treeRightHeight numbersTree `shouldBe` 3

    it "returns expected results" $
      treeRightHeight lettersTree `shouldBe` 4

    it "returns expected results" $
      treeRightHeight EmptyTree `shouldBe` -1

    it "returns expected results" $
      treeRightHeight (Node 3 EmptyTree EmptyTree) `shouldBe` 0

numbersTree = Node 1 
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



lettersTree = Node 'F' 
                (Node 'B' 
                  (Node 'A' EmptyTree EmptyTree) 
                  (Node 'D' 
                    (Node 'C' EmptyTree EmptyTree) 
                    (Node 'E' EmptyTree EmptyTree)
                  )
                ) 
                (Node 'G' 
                  EmptyTree 
                  (Node 'I' 
                    (Node 'H' EmptyTree EmptyTree) 
                    (Node 'J' 
                      EmptyTree 
                      (Node 'K' EmptyTree EmptyTree)
                    )
                  )
                )
{- |
                          F
                        /  \ 
                       /    \
                      /      \
                     B         G 
                    / \        \
                   /   \        \
                  A     D        I
                       / \      / \ 
                     /    \    /   \ 
                    C      E  H     J
                                     \
                                      K
-}
