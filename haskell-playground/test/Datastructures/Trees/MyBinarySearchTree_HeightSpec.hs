module Datastructures.Trees.MyBinarySearchTree_HeightSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinarySearchTree_Height (treeHeight)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "treeHeight" $ do
    it "returns expected results" $
      treeHeight numbersTree `shouldBe` 3
    it "returns expected results" $
      treeHeight lettersTree `shouldBe` 4
    it "returns expected results" $
      treeHeight EmptyTree `shouldBe` -1
    it "returns expected results" $
      treeHeight (Node 3 EmptyTree EmptyTree) `shouldBe` 0

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
