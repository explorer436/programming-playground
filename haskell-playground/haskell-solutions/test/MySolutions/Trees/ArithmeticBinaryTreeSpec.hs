module MySolutions.Trees.ArithmeticBinaryTreeSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.ArithmeticBinaryTree (evaluateArithmeticBinaryTree)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do
  
  describe "evaluateArithmeticBinaryTree" $ do

    it "returns 45 for the input tree" $
      evaluateArithmeticBinaryTree (Node "*" 
                                            (Node "+"
                                                  (Node "3" EmptyTree EmptyTree)
                                                  (Node "2" EmptyTree EmptyTree)
                                            )
                                            (Node "+"
                                                  (Node "4" EmptyTree EmptyTree)
                                                  (Node "5" EmptyTree EmptyTree)
                                            )
                                      ) `shouldBe` 45
