module Datastructures.Trees.DeepestNodeInABinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.DeepestNodeInABinaryTree (deepestNodes)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "deepestNodes" $ do

    it "returns d for the input tree" $
      deepestNodes (Node 'a'
                            (Node 'b'
                                  (Node 'd' EmptyTree EmptyTree)
                                  EmptyTree
                            )
                            (Node 'c' EmptyTree EmptyTree)
                      ) `shouldBe` "d"

{- |
                         a
                       /  \ 
                      /    \
                     b      c 
                    /           
                   d                
-}


    it "returns [3,2,4,-1] for the input tree" $
      deepestNodes (Node 1
                            (Node 4
                                  (Node 3 EmptyTree EmptyTree)
                                  (Node 2 EmptyTree EmptyTree))
                            (Node 5
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node (-1) EmptyTree EmptyTree))) `shouldBe` [3,2,4,-1]

{- |
                         1
                       /  \ 
                      /    \
                     4      5 
                    / \     / \           
                   /   \   /   \         
                  3     2 4     -1            
-}