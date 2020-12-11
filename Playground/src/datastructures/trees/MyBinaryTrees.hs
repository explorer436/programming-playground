import Data.List (elemIndex)
import Data.Maybe (fromJust)

----------------------------------------------------------------------------------------------------

{- |

    FIND IF A SUBTREE EXISTS IN ANOTHER TREE:

    Hi, here's your problem today. This problem was recently asked by Apple:
    
    Given 2 binary trees t and s, find if s has an equal subtree in t, where the structure and the values are the same. Return True if it exists, otherwise return False.
    
    Here's some starter code and an example:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __repr__(self):
        return f"(Value: {self.value} Left: {self.left} Right: {self.right})"
    
    def find_subtree(s, t):
      # Fill this in.
    
    t3 = Node(4, Node(3), Node(2))
    t2 = Node(5, Node(4), Node(-1))
    t = Node(1, t2, t3)
    
    s = Node(4, Node(3), Node(2))

    Tree t:
        1
       / \
      4   5 
     / \ / \
    3  2 4 -1
    
    Tree s:
      4 
     / \
    3  2 

    
    print(find_subtree(s, t))
    True

-}

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq) 

rootValue :: Tree a -> a
rootValue (Node a _ _) = a

compareTrees :: Eq a => a -> a -> Bool
compareTrees t1 t2 = t1 == t2

doesSubtreeExistInParentTree :: Eq a => Tree a -> Tree a -> Bool
doesSubtreeExistInParentTree t1@(Node a EmptyTree EmptyTree) t2 = t1 == t2
doesSubtreeExistInParentTree t1@(Node a l r) t2 = if a == rootValue t2 then compareTrees t1 t2
                              else doesSubtreeExistInParentTree l t2 || doesSubtreeExistInParentTree r t2
-- tests
testDoesSubtreeExistInParentTree01 = doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 2 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 EmptyTree EmptyTree) 
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree))
-- true

testDoesSubtreeExistInParentTree02 = doesSubtreeExistInParentTree 
            (Node 1 
               (Node 6 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 2 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 EmptyTree EmptyTree) 
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree))
-- false

testDoesSubtreeExistInParentTree03 = doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 1 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 
                        (Node 3 EmptyTree EmptyTree)
                        (Node 2 EmptyTree EmptyTree))
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree))
-- true

----------------------------------------------------------------------------------------------------


{- |

    Hi, here's your problem today. This problem was recently asked by Microsoft:

    Given a binary tree, find the level in the tree where the sum of all nodes on that level is the greatest.

    Here's an example and some starter code.

    class Node:

     def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
   
      def __repr__(self):
        return f"(Value: {self.value} Left: {self.left} Right: {self.right})"

    def tree_level_max_sum(root):
      # Fill this in.

    n3 = Node(4, Node(3), Node(2))
    n2 = Node(5, Node(4), Node(-1))
    n1 = Node(1, n2, n3)

    """
        1          Level 0 - Sum: 1
       / \
      4   5        Level 1 - Sum: 9
     / \ / \
    3  2 4 -1      Level 2 - Sum: 8
    """

    print(tree_level_max_sum(n1))
    # Should print 1 as level 1 has the highest level sum
-}

-- We can probably extract the index of the largest element of the list by creating tuples using zip list [0..] and then using a fold function
levelOfTreeWithMaximumSum tree = fromJust $ elemIndex (maxSum tree) (listWithSumsForEachLevel tree)

maxSum tree = maximum (listWithSumsForEachLevel tree)

listWithSumsForEachLevel :: Tree Integer -> [Integer]
listWithSumsForEachLevel tree = breadthLevelSums [tree]

breadthLevelSums :: [Tree Integer] -> [Integer]
breadthLevelSums [] = []
breadthLevelSums [EmptyTree] = []
breadthLevelSums listOfTrees = sumOfRootNodeValues listOfTrees ++ breadthLevelSums (concat (map leftAndRightTrees listOfTrees))

sumOfRootNodeValues :: [Tree Integer] -> [Integer]
sumOfRootNodeValues listOfTrees = [sum (map nodeValue listOfTrees)]

nodeValue :: Tree Integer -> Integer
nodeValue (Node a _ _) = a

leftAndRightTrees :: Tree a -> [Tree a]
leftAndRightTrees (Node _ EmptyTree EmptyTree) = []
leftAndRightTrees (Node _ EmptyTree b)     = [b]
leftAndRightTrees (Node _ a EmptyTree)     = [a]
leftAndRightTrees (Node _ a b)         = [a,b]

-- tests
testLevelOfTreeWithMaximumSum01 = levelOfTreeWithMaximumSum

            (Node 1

               (Node 4

                   (Node 3 EmptyTree EmptyTree)

                   (Node 2 EmptyTree EmptyTree))

               (Node 5

                   (Node 4 EmptyTree EmptyTree)

                   (Node (-1) EmptyTree EmptyTree)))

----------------------------------------------------------------------------------------------------

{- |

    Hi, here's your problem today. This problem was recently asked by Twitter:

    You are given the root of a binary tree. Find the level for the binary tree with the minimum sum, and return that value.

    For instance, in the example below, the sums of the trees are 10, 2 + 8 = 10, and 4 + 1 + 2 = 7. So, the answer here should be 7.

    class Node:

      def __init__(self, value, left=None, right=None):
        self.val = value
        self.left = left
        self.right = right

    def minimum_level_sum(root):
      # Fill this in.

    #     10
    #    /  \
    #   2    8
    #  / \    \
    # 4   1    2

    node = Node(10)
    node.left = Node(2)
    node.right = Node(8)
    node.left.left = Node(4)
    node.left.right = Node(1)
    node.right.right = Node(2)

    print minimum_level_sum(node)
-}

levelOfTreeWithMinimumSum tree = fromJust $ elemIndex (minSum tree) (listWithSumsForEachLevel tree)

minSum tree = minimum (listWithSumsForEachLevel tree)

-- tests

testMinSum01 = minSum
            (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))

testLevelOfTreeWithMinimumSum01 = levelOfTreeWithMinimumSum
            (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))

----------------------------------------------------------------------------------------------------

