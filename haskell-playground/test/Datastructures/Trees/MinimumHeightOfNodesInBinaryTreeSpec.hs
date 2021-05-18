module Datastructures.Trees.MinimumHeightOfNodesInBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MinimumHeightOfNodesInBinaryTree (minimumHeight)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "minimumHeight" $ do

    it "returns -1 when the input is EmptyTree" $
      minimumHeight EmptyTree `shouldBe` -1

    it "returns 0 for the input parameters" $
      minimumHeight (Node 3 EmptyTree EmptyTree) `shouldBe` 0

    it "returns 0 for the input parameters" $
      minimumHeight (Node 3 
                                          (Node 2 EmptyTree EmptyTree)
                                          EmptyTree
                                    ) `shouldBe` 1

    it "returns 2 for the input parameters" $
      minimumHeight (Node 'F' 
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
                                        ) `shouldBe` 2

    it "returns 1 for the input parameters" $
      minimumHeight (Node 1
                                         (Node 2 EmptyTree EmptyTree) 
                                         (Node 3
                                               EmptyTree 
                                               (Node 4 EmptyTree EmptyTree)
                                         )
                                    ) `shouldBe` 1

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
