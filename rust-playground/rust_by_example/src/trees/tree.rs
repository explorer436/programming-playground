// type Tree<T> = Option<Box<BinaryTree<T>>>;

use std::cmp::max;

#[derive(Debug, Clone, PartialEq, PartialOrd)]
pub struct BinaryTree<T> {
    tree_root: Option<Node<T>>,
}

#[derive(Debug, Clone, PartialEq, PartialOrd)]
pub struct Node<T> {
    node_root: Option<T>,
    left: Option<Box<BinaryTree<T>>>,
    right: Option<Box<BinaryTree<T>>>,
}

impl<T> BinaryTree<T> {
    #[allow(dead_code)]
    fn root_element(&self) -> Option<&Node<T>> {
        match &self.tree_root {
            None => None,
            Some(root) => Some(root)
        }
    }

    #[allow(dead_code)]
    fn left_sub_tree(&self) -> Option<&Box<BinaryTree<T>>> {
        match &self.tree_root {
            None => None,
            Some(node) => node.left.as_ref()
        }
    }

    #[allow(dead_code)]
    fn right_sub_tree(&self) -> Option<&Box<BinaryTree<T>>> {
        match &self.tree_root {
            None => None,
            Some(node) => node.right.as_ref()
        }
    }

    #[allow(dead_code)]
    fn tree_height(&self) -> i32 {
        match &self.tree_root {
            None => -1,
            Some(root) => {
                /*Node {
                    root: None,
                    left: None,
                    right: None
                } => -1,*/

                match root {
                    Node {
                        node_root: Some(_),
                        left: None,
                        right: None
                    } => 0,

                    Node {
                        node_root: Some(_),
                        left: Some(l),
                        right: None
                    } => {
                        1 + BinaryTree::tree_height(l)
                    }

                    Node {
                        node_root: Some(_),
                        left: None,
                        right: Some(r)
                    } => {
                        1 + BinaryTree::tree_height(r)
                    }

                    Node { node_root: Some(_), left: Some(l), right: Some(r) } => {
                        let left_height = BinaryTree::tree_height(l);
                        let right_height = BinaryTree::tree_height(r);
                        1 + max(left_height, right_height)
                    }

                    Node { node_root: None, left: Some(_), right: _ } => -1,
                    Node { node_root: None, left: None, right: Some(_) } => -1,

                    Node { node_root: None, left: None, right: None } => -1
                }
            }
        }
    }

    // TODO
    // tree size
    // are two trees equal
    // left_node_value
    // right_node_value
    // left and right trees as a tuple
    // left subtree height
    // right subtree height

}

#[cfg(test)]
mod tests {
    use crate::trees::tree::{BinaryTree, Node};

    #[test]
    fn testing_root_element_for_an_empty_tree() {

        let test_tree: BinaryTree<i32> = BinaryTree {
            tree_root: None
        };

        let actual = BinaryTree::root_element(&test_tree);
        let expected = None;
        assert_eq!(actual, expected);
    }

    #[test]
    fn testing_root_element_for_non_empty_tree() {
        let l: Option<Box<BinaryTree<i32>>> = None;
        let r: Option<Box<BinaryTree<i32>>> = None;

        let an_integer = 5i32;

        let test_tree = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(an_integer),
                left: l,
                right: r,
            })
        };

        let actual = BinaryTree::root_element(&test_tree);
        let expected = Some(an_integer);
        assert_eq!(actual.unwrap().node_root, expected);
    }

    #[test]
    fn testing_left_tree_for_non_empty_tree() {
        let l: Option<Box<BinaryTree<i32>>> = Some(Box::new(BinaryTree {
            tree_root: Some(Node {
                node_root: Some(6i32),
                left: None,
                right: None,
            })
        }));

        let r: Option<Box<BinaryTree<i32>>> = None;

        let test_tree = BinaryTree {
            tree_root: Some(
                Node {
                    node_root: Some(5i32),
                    left: l,
                    right: r,
                }
            )
        };

        let expected: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(6i32),
                left: None,
                right: None,
            })
        };

        let actual = BinaryTree::left_sub_tree(&test_tree);

        assert_eq!(actual, Some(Box::new(expected)).as_ref());
    }

    #[test]
    fn testing_left_tree_for_root_only_tree() {
        let test_tree = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(5i32),
                left: None,
                right: None,
            })
        };

        let actual = BinaryTree::left_sub_tree(&test_tree);

        assert_eq!(actual, None);
    }

    #[test]
    fn testing_tree_height_for_empty_tree_1() {
        let test_tree: BinaryTree<i32> = BinaryTree {
            tree_root: None,
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, -1);
    }

    #[test]
    fn testing_tree_height_for_root_only_tree() {
        let test_tree = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(5i32),
                left: None,
                right: None,
            })
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, 0);
    }

    #[test]
    fn testing_tree_height_for_right_empty_tree_1() {
        let test_tree = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(5i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(6i32),
                        left: None,
                        right: None,
                    })
                })),
                right: None,
            })
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, 1);
    }

    #[test]
    fn testing_tree_height_for_right_empty_tree_2() {
        let test_tree = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(5i32),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(6i32),
                        left: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(7i32),
                                left: None,
                                right: None,
                            })
                        })),
                        right: None,
                    })
                })),
                right: None,
            })
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, 2);
    }
}
