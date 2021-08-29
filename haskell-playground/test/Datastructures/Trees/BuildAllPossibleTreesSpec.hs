module Datastructures.Trees.BuildAllPossibleTreesSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.BuildAllPossibleTrees (buildTreeList)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  
  describe "buildTreeList" $ do

    it "should build all possible trees from the elements in a tree" $

    {-|
          1
         / \
        2   2
       /   /
      3   3
    -}

      buildTreeList (Node 1 
                          (Node 2
                                (Node 3 EmptyTree EmptyTree)
                                EmptyTree
                          )
                          (Node 2
                                (Node 3 EmptyTree EmptyTree)
                                EmptyTree
                          )
                    ) `shouldBe` [
                                  Node 1 (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree) (Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree),
                                  Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree,
                                  Node 3 EmptyTree EmptyTree,
                                  Node 2 (Node 3 EmptyTree EmptyTree) EmptyTree,
                                  Node 3 EmptyTree EmptyTree]



    it "should build all possible trees from the elements in a tree" $

{- |
           a
          / \
         b   b
        /   /
       c   c
-}

      buildTreeList (Node 'a'
                                  (Node 'b'
                                        (Node 'c' EmptyTree EmptyTree)
                                        EmptyTree
                                  )
                                  (Node 'b'
                                        (Node 'c' EmptyTree EmptyTree)
                                        EmptyTree
                                  )
                            ) `shouldBe` [
                              Node 'a' (Node 'b' (Node 'c' EmptyTree EmptyTree) EmptyTree) (Node 'b' (Node 'c' EmptyTree EmptyTree) EmptyTree),
                              Node 'b' (Node 'c' EmptyTree EmptyTree) EmptyTree,
                              Node 'c' EmptyTree EmptyTree,
                              Node 'b' (Node 'c' EmptyTree EmptyTree) EmptyTree,
                              Node 'c' EmptyTree EmptyTree
                              ]
