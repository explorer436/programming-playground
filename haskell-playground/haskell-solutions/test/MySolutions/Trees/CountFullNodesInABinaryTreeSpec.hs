module MySolutions.Trees.CountFullNodesInABinaryTreeSpec where

import Test.Hspec
import MySolutions.Trees.CountFullNodesInABinaryTree (numberOfFullNodes)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "numberOfFullNodes" $ do

    it "returns 0 when the input is EmptyTree" $
      numberOfFullNodes EmptyTree `shouldBe` 0

    it "returns 0 when the input is a tree with only root node" $
      numberOfFullNodes (Node 2 EmptyTree EmptyTree) `shouldBe` 0

    it "returns 1 when the input is a full binary tree with 3 nodes" $
      numberOfFullNodes (Node 2 (Node 3 EmptyTree EmptyTree) (Node 4 EmptyTree EmptyTree)) `shouldBe` 1

    it "returns 2 when the input is a complete binary tree with 6 nodes" $
      numberOfFullNodes (Node 6
                              (Node 3
                                    (Node 5
                                          EmptyTree
                                          (Node 9 EmptyTree EmptyTree)
                                    )
                                    EmptyTree
                              )
                              (Node 2
                                    (Node 7 EmptyTree EmptyTree)
                                    (Node 4 EmptyTree EmptyTree)
                              )
                         ) `shouldBe` 2

   

{- |

               6
             /  \
            3    2
           /    / \
          5     7  4
           \
            9

-}


