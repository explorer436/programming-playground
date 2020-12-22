module Datastructures.Trees.PathsFromRootToAllLeavesSpec where

import Test.Hspec
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Datastructures.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  describe "paths" $ do
{- |
    TODO FIXME - why is this not working?
    it "returns Nothing when the input tree is EmptyTree" $
      paths (EmptyTree) `shouldBe` [[]]
-}
    it "returns an array with single element when the input is a singleton tree" $
      paths (Node 2 EmptyTree EmptyTree) `shouldBe` [[2]]

    it "returns an array with single element when the input is a singleton tree" $
      paths (Node 'a' EmptyTree EmptyTree) `shouldBe` [['a']]

    it "returns an array with left and right elements when the input has left and right subtrees" $
      paths (Node 'a' 
                  (Node 'b' EmptyTree EmptyTree)
                  (Node 'c' EmptyTree EmptyTree)
            ) `shouldBe` ["ab", "ac"]

    it "returns an array with left and right elements when the input has left and right subtrees" $
      paths (Node 1
                  (Node 2 EmptyTree EmptyTree)
                  (Node 3 
                        (Node 4 EmptyTree EmptyTree)
                        (Node 5 EmptyTree EmptyTree)
                  )
            ) `shouldBe` [[1,2],[1,3,4],[1,3,5]]

