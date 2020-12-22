import MyBinaryTree (Tree (..))

import AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

{- |
    Hi, here's your problem today. This problem was recently asked by Amazon:
    
    Given a binary tree, flatten the binary tree using inorder traversal. 
    Instead of creating a new list, reuse the nodes, where the list is represented by following each right child. 
    As such the root should always be the first element in the list so you do not need to return anything in the implementation, 
    just rearrange the nodes such that following the right child will give us the list.
    
    Here's an example and some starter code.
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __repr__(self):
        return f"({self.value}, {self.left}, {self.right})"
    
    def flatten_bst(root):
      # Fill this in.
    
    n5 = Node(5)
    n4 = Node(4)
    n3 = Node(3, n4)
    n2 = Node(2, n5)
    n1 = Node(1, n2, n3)
    
    #      1
    #    /   \
    #   2     3
    #  /     /
    # 5     4
    
    flatten_bst(n1)
    print(n1)
    
    # n1 should now look like
    #   1
    #    \
    #     2
    #      \
    #       5
    #        \
    #         3
    #          \
    #           4
-}

flatten EmptyTree = EmptyTree
flatten tree@(Node a EmptyTree EmptyTree) = tree
flatten tree@(Node a left right) = Node a EmptyTree (appendTree2ToTheRightMostLeafOfTree1 (flatten left) (flatten right))


test01 = flatten (Node 1
                       (Node 2 
                             (Node 5 EmptyTree EmptyTree) 
                             EmptyTree
                       )
                       (Node 3 
                             (Node 4 EmptyTree EmptyTree) 
                             EmptyTree
                       )
                 )
-- Node 1 
--      EmptyTree 
--      (Node 2 
--            EmptyTree 
--            (Node 5 
--                  EmptyTree 
--                  (Node 3 
--                        EmptyTree 
--                        (Node 4 EmptyTree EmptyTree))))
test02 = flatten (
                     Node 1 
                          (Node 2 
                                (Node 3 EmptyTree EmptyTree)
                                (Node 4 EmptyTree EmptyTree)
                          )
                          EmptyTree
                 )
-- Node 1 
--      EmptyTree 
--      (Node 2 
--            EmptyTree 
--            (Node 3 
--                  EmptyTree 
--                  (Node 4 EmptyTree EmptyTree)))