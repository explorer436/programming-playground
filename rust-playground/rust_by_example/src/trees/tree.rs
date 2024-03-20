// type Tree<T> = Option<Box<BinaryTree<T>>>;

use std::cmp::max;

#[derive(Debug, PartialEq, PartialOrd)]
pub struct BinaryTree<T> {
    root: Option<T>,
    left: Option<Box<BinaryTree<T>>>,
    right: Option<Box<BinaryTree<T>>>,
}

impl<T> BinaryTree<T> {
    #[allow(dead_code)]
    fn root_element(&self) -> Option<&T> {
        match &self.root {
            None => None,
            Some(x) => Some(x),
        }
    }

    #[allow(dead_code)]
    fn left_tree(&self) -> Option<&Box<BinaryTree<T>>> {
        match &self.left {
            None => None,
            Some(x) => Some(x),
        }
    }

    #[allow(dead_code)]
    fn right_tree(&self) -> Option<&Box<BinaryTree<T>>> {
        match &self.right {
            None => None,
            Some(x) => Some(x),
        }
    }

    #[allow(dead_code)]
    fn tree_height(&self) -> i32 {
        match &self {
            BinaryTree {
                root: None,
                left: None,
                right: None
            } => -1,

            BinaryTree {
                root: Some(_),
                left: None,
                right: None
            } => 0,

            BinaryTree {
                root: Some(_),
                left: Some(l),
                right: None
            } => {
                1 + BinaryTree::tree_height(l)
            }

            BinaryTree {
                root: Some(_),
                left: None,
                right: Some(r)
            } => {
                1 + BinaryTree::tree_height(r)
            }

            BinaryTree { root: Some(_), left: Some(l), right: Some(r) } => {
                let left_height = BinaryTree::tree_height(l);
                let right_height = BinaryTree::tree_height(r);
                1 + max(left_height, right_height)
            }

            BinaryTree { root: None, left: Some(_), right: _ } => -1,
            BinaryTree { root: None, left: None, right: Some(_) } => -1
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::trees::tree::BinaryTree;

    #[test]
    fn testing_root_element_for_an_empty_tree() {
        let x: Option<Box<BinaryTree<i32>>> = None;
        let y: Option<Box<BinaryTree<i32>>> = None;

        let test_tree = BinaryTree {
            root: None,
            left: x,
            right: y,
        };

        let actual = BinaryTree::root_element(&test_tree);
        let expected = None;
        assert_eq!(actual, expected);
    }

    #[test]
    fn testing_root_element_for_non_empty_tree() {
        let x: Option<Box<BinaryTree<i32>>> = None;
        let y: Option<Box<BinaryTree<i32>>> = None;


        let an_integer = 5i32;

        let test_tree = BinaryTree {
            root: Some(an_integer),
            left: x,
            right: y,
        };

        let actual = BinaryTree::root_element(&test_tree);
        let expected = Some(an_integer);
        assert_eq!(actual, expected.as_ref());
    }

    #[test]
    fn testing_left_tree_for_non_empty_tree() {
        let x: Option<Box<BinaryTree<i32>>> = Some(Box::new(BinaryTree {
            root: Some(6i32),
            left: None,
            right: None,
        }));

        // let expected = Some(an_integer);
        let expected: Option<Box<BinaryTree<i32>>> = Some(Box::new(BinaryTree {
            root: Some(6i32),
            left: None,
            right: None,
        }));

        let y: Option<Box<BinaryTree<i32>>> = None;

        let an_integer = 5i32;

        let test_tree = BinaryTree {
            root: Some(an_integer),
            left: x,
            right: y,
        };

        let actual = BinaryTree::left_tree(&test_tree);
        // let expected = Some(an_integer);
        assert_eq!(actual, expected.as_ref());
    }

    #[test]
    fn testing_tree_height_for_empty_tree_1() {
        let test_tree: BinaryTree<i32> = BinaryTree {
            root: None,
            left: None,
            right: None,
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, -1);
    }

    #[test]
    fn testing_tree_height_for_non_empty_tree_0() {
        let test_tree = BinaryTree {
            root: Some(5i32),
            left: None,
            right: None,
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, 0);
    }

    #[test]
    fn testing_tree_height_for_non_empty_tree_1() {
        let test_tree = BinaryTree {
            root: Some(5i32),
            left: Some(Box::new(BinaryTree {
                root: Some(6i32),
                left: None,
                right: None,
            })),
            right: None,
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, 1);
    }

    #[test]
    fn testing_tree_height_for_non_empty_tree_2() {
        let test_tree = BinaryTree {
            root: Some(5i32),
            left: Some(Box::new(BinaryTree {
                root: Some(6i32),
                left: Some(Box::new(BinaryTree {
                    root: Some(7i32),
                    left: None,
                    right: None,
                })),
                right: None,
            })),
            right: None,
        };

        let actual = BinaryTree::tree_height(&test_tree);
        assert_eq!(actual, 2);
    }
}
