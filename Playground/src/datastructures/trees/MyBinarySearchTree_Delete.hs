module MyBinarySearchTree_Delete where

import MyBinarySearchTree
import MyBinarySearchTree_MaximumAndMinimumElements (treeMinimum)

{- |
    DELETE AN ELEMENT FROM A TREE

    Removing a node means appropriately linking its two descendent subtrees back into the tree somewhere else. 
    There are three cases.
    1. Leaf nodes have no children, and so may be deleted by simply clearing the pointer to the given node.
    2. The node that is to be deleted has one child - this is also straightforward. There is one parent and one grandchild, and we can link the grandchild directly to the parent without violating the in-order labeling property of the tree.
    3. The node that is to be deleted has two children. The solution is to re-label this node with the immediate successor in the sorted order. This successor must be the smallest value in the right subtree, specifically the leftmost descendent in the right subtree. Moving this to the point of deletion results in a properly-labeled balanced binary search tree, and reduces the deletion problem to physically removing a node with at most one child.

    The worst-case complexity analysis is: Every deletion requires the cost of at most two search operations, each taking O(h) time where h is the height of the tree, plus a constant amount of pointer manipulation.
-}

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

delete _ EmptyTree = EmptyTree
delete x (Node a left right)
    | x < a  = Node a (delete x left) right
    | x > a  = Node a left (delete x right)
    | x == a = helper x left right

helper x EmptyTree EmptyTree = EmptyTree
helper x left EmptyTree = left
helper x EmptyTree right = right
helper x left right = Node minimumElementFromRightSubtree left (rightSubtreeWithMinimumElementRemoved)
    where
    rightSubtreeWithMinimumElementRemoved = delete minimumElementFromRightSubtree right
    minimumElementFromRightSubtree = treeMinimum right

testDelete_3 = delete 3 sampleTree
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

testDelete_5 = delete 5 sampleTree
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
                       3     5
-}

testDelete_4 = delete 4 sampleTree
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
