module MySolutions.Trees.MyBinarySearchTree_RightHeightSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinaryTree (Tree (..), treeRightHeight)

spec :: Spec
spec = do

  describe "treeRightHeight" $ do

    it "returns 3 when the right height of the input tree is 3" $
      treeRightHeight numbersTree `shouldBe` 3

    it "returns 4 when the right height of the input tree is 4" $
      treeRightHeight lettersTree `shouldBe` 4

    it "returns -1 when the input is EmptyTree" $
      treeRightHeight EmptyTree `shouldBe` -1

    it "returns 0 when the input tree has only one node" $
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
