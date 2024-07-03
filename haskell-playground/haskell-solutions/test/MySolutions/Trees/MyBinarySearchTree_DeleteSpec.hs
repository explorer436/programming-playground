module MySolutions.Trees.MyBinarySearchTree_DeleteSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import MySolutions.Trees.MyBinarySearchTree_Delete (delete)
import MySolutions.Trees.MyBinaryTree (Tree (..))

spec :: Spec
spec = do

  describe "delete" $ do

    it "returns expected results" $
      delete 3 sampleTree `shouldBe` Node 2 (Node 1 EmptyTree EmptyTree) (Node 7 (Node 4 EmptyTree (Node 6 (Node 5 EmptyTree EmptyTree) EmptyTree)) (Node 8 EmptyTree EmptyTree))
{- |

                          2
                        /  \ 
                       /    \
                      1      7
                            / \
                           /   \
                          4      8
                           \
                            \
                             6
                            /
                           /
                          5
-}

    it "returns expected results" $
      delete 4 sampleTree `shouldBe` Node 2 (Node 1 EmptyTree EmptyTree) (Node 7 (Node 5 (Node 3 EmptyTree EmptyTree) (Node 6 EmptyTree EmptyTree)) (Node 8 EmptyTree EmptyTree)) 
{- |

                          2
                        /  \ 
                       /    \
                      1      7
                            / \
                           /   \
                          5      8
                         / \
                        /   \
                       3     6
-}

    it "returns expected results" $
      delete 5 sampleTree `shouldBe` Node 2 (Node 1 EmptyTree EmptyTree) (Node 7 (Node 4 (Node 3 EmptyTree EmptyTree) (Node 6 EmptyTree EmptyTree)) (Node 8 EmptyTree EmptyTree)) 
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
                            /
                           /
                          5
-}
