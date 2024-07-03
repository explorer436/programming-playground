module MySolutions.Trees.ArithmeticBinaryTree (evaluateArithmeticBinaryTree) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import Data.Int ( Int8 )

-- Need to make them strings as opposed to chars because there may be cases when the input numbers are longer than one digit.

evaluateArithmeticBinaryTree :: Tree String -> Int8
evaluateArithmeticBinaryTree EmptyTree = 0
evaluateArithmeticBinaryTree (Node a EmptyTree EmptyTree) = read a :: Int8
evaluateArithmeticBinaryTree tree@(Node a left right) = case (a) of
                                                                    "+"   -> (evaluateArithmeticBinaryTree left) + (evaluateArithmeticBinaryTree right)
                                                                    "-"   -> (evaluateArithmeticBinaryTree left) - (evaluateArithmeticBinaryTree right)
                                                                    "*"   -> (evaluateArithmeticBinaryTree left) * (evaluateArithmeticBinaryTree right)
                                                                    "/"   -> (evaluateArithmeticBinaryTree left) `div` (evaluateArithmeticBinaryTree right)
