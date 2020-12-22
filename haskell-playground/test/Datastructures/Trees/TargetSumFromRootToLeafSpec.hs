module Datastructures.Trees.TargetSumFromRootToLeafSpec where

import Test.Hspec
import Datastructures.Trees.TargetSumFromRootToLeaf (pathWithMatchingSum)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "pathWithMatchingSum" $ do

    it "returns an array with single element when the input matches the sum of the path" $
      pathWithMatchingSum 2 (Node 2 EmptyTree EmptyTree) `shouldBe` [[2]]

    it "returns an array with left and right elements when the input has left and right subtrees" $
      pathWithMatchingSum 3 (Node 1
                                  (Node 2 EmptyTree EmptyTree)
                                  (Node 3 
                                        (Node 4 EmptyTree EmptyTree)
                                        (Node 5 EmptyTree EmptyTree)
                                  )
                            ) `shouldBe` [[1,2]]

    it "returns an array with left and right elements when the input has left and right subtrees" $
      pathWithMatchingSum 9 (Node 1
                                  (Node 2
                                        EmptyTree
                                        (Node 6 EmptyTree EmptyTree))
                                  (Node 3 
                                        EmptyTree
                                        (Node 4 EmptyTree EmptyTree))
                            ) `shouldBe` [[1,2,6]]

