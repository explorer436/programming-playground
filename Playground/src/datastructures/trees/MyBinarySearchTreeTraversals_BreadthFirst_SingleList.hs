import MyBinaryTree

{- |
    BREADTH-FIRST SEARCH / LEVEL ORDER
    
    Trees can also be traversed in level-order, where we visit every node on a level before going to a lower level.
    This search is referred to as breadth-first search (BFS), as the search tree is broadened as much as possible on each depth before going to the next depth.
-}

{- |

    LEVELORDERTRAVERSALOFBINARYTREE:
    
    Hi, here's your problem today. This problem was recently asked by Microsoft:
    
    Given the root of a binary tree, print its level-order traversal. For example:
    
      1
     / \
    2   3
       / \
      4   5
    
    
    The following tree should output 1, 2, 3, 4, 5.
    
    class Node:
      def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
    def print_level_order(root):
      # Fill this in.
    
    root = Node(1, Node(2), Node(3, Node(4), Node(5)))
    print_level_order(root)
    # 1 2 3 4 5

-}

traverseBreadthFirst :: Tree a -> [a]
traverseBreadthFirst tree = helper [tree]

helper :: [Tree a] -> [a]
helper [] = []
helper listOfTrees = map rootValue listOfTrees ++ helper (concat (map leftAndRightTrees listOfTrees))

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

lettersTree = Node 'F' 
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


-- tests
testTraverseBreadthFirst01 = traverseBreadthFirst lettersTree  -- "FBGADICEHJK"

{- |
    explanation:
    1. F +    B      +     G
             / \           \
            A   D           I
               / \        / \
              C   E      H   J
                              \
                               K

    2. F + B + G +     A + D +   I
                          / \   / \
                         C  E  H   J
                                    \
                                     K

    3. F + B + G + A + D + I +    C + E + H + J
                                               \
                                                K

    4. F + B + G + A + D + I + C + E + H +    J + K
-}

----------------------------------------------------------------------------------------------------
