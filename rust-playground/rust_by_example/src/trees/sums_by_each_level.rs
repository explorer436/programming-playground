use crate::trees::tree::{BinaryTree, Node};

#[allow(dead_code)]
fn sums_by_each_level(optional_tree: Option<Box<BinaryTree<i32>>>) -> Vec<i32> {

}

fn evaluate(optional_tree: Option<Box<BinaryTree<i32>>>) -> Vec<i32> {
    let mut expected: Vec<i32> = Vec::new();

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
                    expected.push(nr)
                }

                // left and right tree
                BinaryTree {
                    tree_root: Some(Node {
                                        node_root: Some(nr),
                                        left: Some(l),
                                        right: Some(r)
                                    })
                } => {
                    let mut e: crate::trees::evaluate_arithmetic_binary_tree::VeryVerboseEnumOfThingsToDoWithNumbers = crate::trees::evaluate_arithmetic_binary_tree::VeryVerboseEnumOfThingsToDoWithNumbers::Invalid;
                    // convert nr to enum and then call the evaluate function on it again
                    match nr {
                        '*' => { e = crate::trees::evaluate_arithmetic_binary_tree::VeryVerboseEnumOfThingsToDoWithNumbers::Multiply; }
                        '+' => { e = crate::trees::evaluate_arithmetic_binary_tree::VeryVerboseEnumOfThingsToDoWithNumbers::Add; }
                        '-' => { e = crate::trees::evaluate_arithmetic_binary_tree::VeryVerboseEnumOfThingsToDoWithNumbers::Subtract; }
                        '/' => { e = crate::trees::evaluate_arithmetic_binary_tree::VeryVerboseEnumOfThingsToDoWithNumbers::Divide; }
                        _ => {}
                    }

                    e.run(evaluate(Some(l)), evaluate(Some(r)))
                }

                _ => { 0 }
            }
        }
    }

    expected
}

#[cfg(test)]
mod tests {
    use crate::trees::sums_by_each_level::evaluate;
    use crate::trees::tree::{BinaryTree, Node};

    #[test]
    fn testing_1() {
        let tree1: BinaryTree<i32> = BinaryTree {
            tree_root: Some(Node {
                node_root: Some(1i32),
                left: None,
                right: Some(Box::new(BinaryTree {
                    tree_root: Some(Node {
                        node_root: Some(2i32),
                        left: None,
                        right: Some(Box::new(BinaryTree {
                            tree_root: Some(Node {
                                node_root: Some(5i32),
                                left: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(7i32),
                                        left: None,
                                        right: None,
                                    })
                                })),
                                right: Some(Box::new(BinaryTree {
                                    tree_root: Some(Node {
                                        node_root: Some(6i32),
                                        left: None,
                                        right: None,
                                    })
                                })),
                            })
                        }))
                    })
                })),
            })
        };

        let actual = evaluate(Some(Box::new(tree1)));
    }

}