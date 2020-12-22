import MyBinaryTree (Tree (..))

-- minimumHeight :: (Num p, Ord p) => Tree a -> p
minimumHeight EmptyTree                    = -1
minimumHeight (Node a EmptyTree EmptyTree) = 0
minimumHeight (Node a l EmptyTree)         = 1 + (minimumHeight l)
minimumHeight (Node a EmptyTree r)         = 1 + (minimumHeight r)
minimumHeight (Node _ l r)                 = 1 + min (minimumHeight l) (minimumHeight r)

-- tests

testMinimumHeight01 = minimumHeight EmptyTree -- expect -1
testMinimumHeight02 = minimumHeight (Node 3 EmptyTree EmptyTree) -- expect 0
testMinimumHeight03 = minimumHeight (Node 3 
                                          (Node 2 EmptyTree EmptyTree)
                                          EmptyTree
                                    ) -- expect 1

testMinimumHeight04 = minimumHeight (Node 'F' 
                                         (Node 'B' 
                                           (Node 'A' EmptyTree EmptyTree) 
                                           (Node 'D' 
                                             (Node 'C' EmptyTree EmptyTree) 
                                             (Node 'E' EmptyTree EmptyTree)
                                           )
                                         ) 
                                         (Node 'G' 
                                           EmptyTree 
                                           (Node 'I' 
                                             (Node 'H' EmptyTree EmptyTree) 
                                             (Node 'J' 
                                               EmptyTree 
                                               (Node 'K' EmptyTree EmptyTree)
                                             )
                                           )
                                         )
                                        ) -- expect 2
{- |
                          F
                        /  \ 
                       /    \
                      /      \
                     B         G 
                    / \        \
                   /   \        \
                  A     D        I
                       / \      / \ 
                     /    \    /   \ 
                    C      E  H     J
                                     \
                                      K
-}

testMinimumHeight05 = minimumHeight (Node 1
                                         (Node 2 EmptyTree EmptyTree) 
                                         (Node 3
                                               EmptyTree 
                                               (Node 4 EmptyTree EmptyTree)
                                         )
                                    ) -- expect 1

