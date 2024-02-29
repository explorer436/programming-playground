// pub says we want people outside this module to be able to use List

// type Tree<T> = Option<Box<BinaryTree<T>>>;

#[derive(Debug, PartialEq, PartialOrd)]
pub struct BinaryTree<T> {
    root: Option<T>,
    left: Option<Box<BinaryTree<T>>>,
    right: Option<Box<BinaryTree<T>>>,
}

impl<T> BinaryTree<T> {
    #[allow(dead_code)]
    fn root_element(&self) -> Option<&T> {
        let e = &self.root;

        match e {
            None => None,
            Some(x) => Some(x),
        }
    }

    #[allow(dead_code)]
    fn left_tree(&self) -> Option<&Box<BinaryTree<T>>> {
        let e = &self.left;

        match e {
            None => None,
            Some(x) => Some(x),
        }
    }

    #[allow(dead_code)]
    fn right_tree(&self) -> Option<&Box<BinaryTree<T>>> {
        let e = &self.right;

        match e {
            None => None,
            Some(x) => Some(x),
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
            right: y
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
            right: y
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
            right: None
        }));

        // let expected = Some(an_integer);
        let expected: Option<Box<BinaryTree<i32>>> = Some(Box::new(BinaryTree {
            root: Some(6i32),
            left: None,
            right: None
        }));

        let y: Option<Box<BinaryTree<i32>>> = None;

        let an_integer = 5i32;

        let test_tree = BinaryTree {
            root: Some(an_integer),
            left: x,
            right: y
        };

        let actual = BinaryTree::left_tree(&test_tree);
        // let expected = Some(an_integer);
        assert_eq!(actual, expected.as_ref());
    }
}
