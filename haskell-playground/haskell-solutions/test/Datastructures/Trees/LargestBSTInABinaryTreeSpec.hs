module Datastructures.Trees.LargestBSTInABinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.LargestBSTInABinaryTree (largestBSTTree)

spec :: Spec
spec = do

  describe "largestBSTTree" $ do


{- |
      5
     / \
    6   7
   /   / \
  2   4   9
-}

    it "returns the largest binary tree from the input tree" $
      largestBSTTree (Node 5 
                        (Node 6
                              (Node 2 EmptyTree EmptyTree)
                              EmptyTree
                        )
                        (Node 7
                              (Node 4 EmptyTree EmptyTree)
                              (Node 9 EmptyTree EmptyTree)
                        )
                  ) `shouldBe` Node 7
                                     (Node 4 EmptyTree EmptyTree)
                                     (Node 9 EmptyTree EmptyTree)


    {- |
           4
         /  \
        2    5
       / \  / \
      1  3 7   5
              / \
             3   7 
            / \  /  
           1  4 6    
                     
                      
 
    -}

    it "returns the largest binary tree from the input tree" $
      largestBSTTree (Node 4 
                        (Node 2
                              (Node 1 EmptyTree EmptyTree)
                              (Node 3 EmptyTree EmptyTree)
                        )
                        (Node 5
                              (Node 7 EmptyTree EmptyTree)
                              (Node 5 
                                    (Node 3
                                          (Node 1 EmptyTree EmptyTree)
                                          (Node 4 EmptyTree EmptyTree)
                                    )
                                    (Node 7
                                          (Node 6 EmptyTree EmptyTree)
                                          EmptyTree
                                    )
                              )
                        )
                  ) `shouldBe` Node 5 
                                    (Node 3
                                          (Node 1 EmptyTree EmptyTree)
                                          (Node 4 EmptyTree EmptyTree)
                                    )
                                    (Node 7
                                          (Node 6 EmptyTree EmptyTree)
                                          EmptyTree
                                    )
                               
