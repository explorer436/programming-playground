module Datastructures.Trees.IsGivenTreeBinarySearchTreeSpec where

import Test.Hspec
import Datastructures.Trees.IsGivenTreeBinarySearchTree (isBST)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "isBST" $ do

    it "returns True when the input tree is a valid binary search tree" $
      isBST (Node 5 
                  (Node 3
                        (Node 1 EmptyTree EmptyTree)
                        (Node 4 EmptyTree EmptyTree)
                  )
                  (Node 7
                        (Node 6 EmptyTree EmptyTree)
                        EmptyTree
                  )
            ) `shouldBe` True

    it "returns False when the input tree is not a valid binary search tree" $
      isBST (Node 5 
                        (Node 3
                              (Node 1 EmptyTree EmptyTree)
                              (Node 4 EmptyTree EmptyTree)
                        )
                        (Node 7
                              (Node 8 EmptyTree EmptyTree)
                              EmptyTree
                        )
                  ) `shouldBe` False
  
    it "returns False when the input tree is not a valid binary search tree" $
      isBST (Node 6
                  (Node 4
                        (Node 2
                              (Node 1 EmptyTree EmptyTree)
                              EmptyTree
                        )
                        (Node 3 EmptyTree EmptyTree)
                  )
                  (Node 5
                        EmptyTree
                        (Node 6
                              (Node 7 EmptyTree EmptyTree)
                              (Node 8 EmptyTree EmptyTree)
                        )
                  )
            ) `shouldBe` False

   
