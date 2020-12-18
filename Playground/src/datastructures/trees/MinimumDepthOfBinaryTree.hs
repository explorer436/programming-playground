import MyBinaryTree

{-|
    Hi, here's your problem today. This problem was recently asked by LinkedIn:
    
    Given a binary tree, find the minimum depth of the binary tree. The minimum depth is the shortest distance from the root to a leaf.
    
    Here's an example and some starter code.
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def min_depth_bst(root):
      # Fill this in.
      
    n3 = Node(3, None, Node(4))
    n2 = Node(2, Node(3))
    n1 = Node(1, n2, n3)
    
    #     1
    #    / \
    #   2   3
    #        \
    #         4
    print(min_depth_bst(n1))
    # 1
-}

-- By definition, the values for the minimum height and the minimum depth will be the same. The reason for this is, the distance of the leaf that is the least farthest from the root is the same whether that distance is measured from the root or from the leaf. 

minimumHeight :: (Num p, Ord p) => Tree a -> p
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

testMinimumHeight04 = minimumHeight Node 'F' 
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

