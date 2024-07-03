module MySolutions.Trees.MyBinarySearchTree_SearchSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinarySearchTree_Search (treeElem)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "treeElem" $ do

    it "returns expected results" $
      treeElem 8 sampleTree `shouldBe` True
    it "returns expected results" $
      treeElem 100 sampleTree `shouldBe` False
    it "returns expected results" $
      treeElem 1 sampleTree `shouldBe` True
    it "returns expected results" $
      treeElem 10 sampleTree `shouldBe` False

{- |

                          2
                        /  \ 
                       /    \
                      1      7
                            / \
                           /   \
                          4      8
                         / \
                        /   \
                       3     6
-}



sampleTree :: Tree Integer
sampleTree = Node 2
             (Node 1 EmptyTree EmptyTree)
             (Node 7 
                 (Node 4
                     (Node 3 EmptyTree EmptyTree) 
                     (Node 6 
                          (Node 5 EmptyTree EmptyTree) 
                          EmptyTree) 
                 ) 
                 (Node 8 EmptyTree EmptyTree)
             )

