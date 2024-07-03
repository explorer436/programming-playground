module MySolutions.Trees.FindAllDuplicateSubtreesSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.FindAllDuplicateSubtrees (findDuplicateSubtrees)


spec :: Spec
spec = do

  describe "findDuplicateSubtrees" $ do

    {- |
    it "returns a tree that has tree2 appended to the right of tree1" $
      findDuplicateSubtrees (Node 1
                                  (Node 2
                                        (Node 3 EmptyTree EmptyTree)
                                        EmptyTree
                                  )
                                  (Node 2 
                                        (Node 3 EmptyTree EmptyTree)
                                        EmptyTree
                                  )
                            ) `shouldBe` [(EmptyTree,2)]
    -}

{- |
           1
          / \
         2   2
        /   /
       3   3
-}

    it "returns a tree that has tree2 appended to the right of tree1" $
      findDuplicateSubtrees (Node 'a'
                                  (Node 'b'
                                        (Node 'c' EmptyTree EmptyTree)
                                        EmptyTree
                                  )
                                  (Node 'b'
                                        (Node 'c' EmptyTree EmptyTree)
                                        EmptyTree
                                  )
                            ) `shouldBe` [
                                           (Node 'b' (Node 'c' EmptyTree EmptyTree) EmptyTree,2),
                                           (Node 'c' EmptyTree EmptyTree,2)
                                         ]

{- |
           a
          / \
         b   b
        /   /
       c   c
-}
