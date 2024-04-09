use crate::trees::tree::{BinaryTree, Node};

enum VeryVerboseEnumOfThingsToDoWithNumbers {
    Add,
    Subtract,
    Multiply,
    Divide,
    Invalid,
}

impl VeryVerboseEnumOfThingsToDoWithNumbers {
    fn run(&self, x: u32, y: u32) -> u32 {
        match self {
            Self::Add => x + y,
            Self::Subtract => x - y,
            Self::Multiply => x * y,
            Self::Divide => x / y,
            Self::Invalid => 0,
        }
    }
}

#[allow(dead_code)]
fn evaluate(optional_tree: Option<Box<BinaryTree<char>>>) -> u32 {
    match optional_tree {
        None => 0,
        Some(tree) => {
            match *tree {

                // root-element only tree
                BinaryTree {
                    tree_root: Some(Node {
                                        node_root: Some(nr),
                                        left: None,
                                        right: None
                                    })
                } => {
                    nr.to_digit(10).unwrap()
                }

                // left and right tree
                BinaryTree {
                    tree_root: Some(Node {
                                        node_root: Some(nr),
                                        left: Some(l),
                                        right: Some(r)
                                    })
                } => {
                    let mut e: VeryVerboseEnumOfThingsToDoWithNumbers = VeryVerboseEnumOfThingsToDoWithNumbers::Invalid;
                    // convert nr to enum and then call the evaluate function on it again
                    match nr {
                        '*' => { e = VeryVerboseEnumOfThingsToDoWithNumbers::Multiply; }
                        '+' => { e = VeryVerboseEnumOfThingsToDoWithNumbers::Add; }
                        '-' => { e = VeryVerboseEnumOfThingsToDoWithNumbers::Subtract; }
                        '/' => { e = VeryVerboseEnumOfThingsToDoWithNumbers::Divide; }
                        _ => {}
                    }

                    e.run(evaluate(Some(l)), evaluate(Some(r)))
                }

                _ => { 0 }
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::trees::evaluate_arithmetic_binary_tree::evaluate;
    use crate::trees::tree::{BinaryTree, Node};

    #[test]
    fn testing_append_tree2_to_the_rightmost_leaf_of_tree1_for_two_empty_trees() {
        let tree1: BinaryTree<char> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some('*'),
                left: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some('+'),
                        left: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some('3'),
                                left: None,
                                right: None,
                            })
                        })),
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some('2'),
                                left: None,
                                right: None,
                            })
                        })),
                    })
                })),
                right: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some('+'),
                        left: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some('4'),
                                left: None,
                                right: None,
                            })
                        })),
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some('5'),
                                left: None,
                                right: None,
                            })
                        })),
                    })
                })),
            })
        };

        let actual = evaluate(Some(Box::new(tree1)));
        let expected = 45;
        assert_eq!(actual, expected);
    }
}