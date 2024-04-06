use crate::trees::tree::BinaryTree;

/*fn append_tree2_to_the_rightmost_leaf_of_tree1(tree1: BinaryTree<T>, tree2: BinaryTree<T>) -> BinaryTree<T> {
    match tree2 {
        None => tree1,
        _ => {
            match tree1 {
                None => tree2,
                Some(root) => {
                    match root {


                    }
                }
            }
        }
    }
}*/

/*appendTree2ToTheRightMostLeafOfTree1 EmptyTree EmptyTree = EmptyTree
appendTree2ToTheRightMostLeafOfTree1 tree1 EmptyTree = tree1
appendTree2ToTheRightMostLeafOfTree1 EmptyTree tree2 = tree2
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left EmptyTree) tree2 = Node a left tree2
appendTree2ToTheRightMostLeafOfTree1 tree1@(Node a left right) tree2 = Node a left (appendTree2ToTheRightMostLeafOfTree1 right tree2)*/