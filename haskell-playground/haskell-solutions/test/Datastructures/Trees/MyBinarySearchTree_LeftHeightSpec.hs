module Datastructures.Trees.MyBinarySearchTree_LeftHeightSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinaryTree (Tree (..), treeLeftHeight)

spec :: Spec
spec = do
  describe "treeLeftHeight" $ do

    it "returns expected results" $
      treeLeftHeight numbersTree `shouldBe` 0

    it "returns expected results" $
      treeLeftHeight lettersTree `shouldBe` 2

    it "returns expected results" $
      treeLeftHeight EmptyTree `shouldBe` -1

    it "returns expected results" $
      treeLeftHeight (Node 3 EmptyTree EmptyTree) `shouldBe` 0

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
